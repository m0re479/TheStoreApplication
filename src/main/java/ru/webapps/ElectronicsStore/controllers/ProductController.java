package ru.webapps.ElectronicsStore.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import lombok.AllArgsConstructor;
import ru.webapps.ElectronicsStore.models.Product;
import ru.webapps.ElectronicsStore.services.ProductService;

import java.util.ArrayList;
import java.util.Optional;

@Controller
@RequestMapping("api/v1/products")
@AllArgsConstructor
public class ProductController {
    private ProductService productService;

    @GetMapping("/welcome")
    public String welcome() {
        System.out.println("Application Startup Welcome Page");
        return "welcome";
    }

    @GetMapping("/allProd")
    public String allProd(Model model) {
        Iterable<Product> products = productService.allProducts();
        model.addAttribute("products", products);
        return "allProd";
    }

    @GetMapping("/newProd")
    public String newProd(Model model) {
        return "newProd";
    }

    @PostMapping("/newProd")
    public String newProdPost(@RequestParam String name, @RequestParam Integer quantity, @RequestParam String description,  Model model) {
        productService.saveProduct(new Product(name, quantity, description));
        return "redirect:/api/v1/products/allProd";
    }

    @GetMapping("/allProd/{ID}")
    public String productById(@PathVariable(value = "ID") Long id, Model model) {
        if (productService.byIdExist(id)){
            return "redirect:/api/v1/products/allProd";
        }
        Optional<Product> product = productService.productById(id);
        ArrayList<Product> prod = new ArrayList<>();
        product.ifPresent(prod::add);
        model.addAttribute("product", prod);
        return "prodInfo";
    }

    @GetMapping("/allProd/{ID}/edit")
    public String productEdit(@PathVariable(value = "ID") Long id, Model model) {
        if (productService.byIdExist(id)){
            return "redirect:/api/v1/products/allProd";
        }
        Optional<Product> product = productService.productById(id);
        ArrayList<Product> prod = new ArrayList<>();
        product.ifPresent(prod::add);
        model.addAttribute("product", prod);
        return "prodEdit";
    }

    @PostMapping("/allProd/{ID}/edit")
    public String productEditPost(@PathVariable(value = "ID") Long id, @RequestParam String name, @RequestParam Integer quantity, @RequestParam String description,  Model model) {
        Product product = productService.productById(id).orElseThrow();
        product.setName(name);
        product.setQuantity(quantity);
        product.setDescription(description);
        productService.saveProduct(product);
        return "redirect:/api/v1/products/allProd";
    }

    @PostMapping("/allProd/{ID}/remove")
    public String productRemovePost(@PathVariable(value = "ID") Long id,  Model model) {
        Product product = productService.productById(id).orElseThrow();
        productService.deleteProd(product);
        return "redirect:/api/v1/products/allProd";
    }
}
