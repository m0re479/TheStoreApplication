package ru.webapps.ElectronicsStore.controllers;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import lombok.AllArgsConstructor;
import ru.webapps.ElectronicsStore.models.Product;
import ru.webapps.ElectronicsStore.services.ProductService;

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

    @GetMapping("/findById/{ID}")
    @ResponseBody
    public Product productById(@PathVariable("ID") Long id) {
        return productService.productById(id);
    }

    @PostMapping("/new_prod")
    @ResponseBody
	public String addUser(@RequestBody Product product) {
		productService.saveProduct(product);
		return "Product is saved";
	}

    @PostMapping("/delProd/{ID}")
    @ResponseBody
    public void deletePers(@PathVariable("ID") Long id){
        productService.delPers(id);
    }
}
