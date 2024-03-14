package ru.webapps.ElectronicsStore.controllers;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import ru.webapps.ElectronicsStore.models.Product;
import ru.webapps.ElectronicsStore.services.ProductService;

@RestController
@RequestMapping("api/v1/products")
@AllArgsConstructor
public class ProductController {
    private ProductService productService;

    @GetMapping("/welcome")
    public String welcome() {
        return "WELCOME";
    }

    @GetMapping("/allProd")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public List<Product> allProd() {
       return productService.allProducts();
    }

    @GetMapping("/findById/{ID}")
    @PreAuthorize("hasAuthority('ROLE_USER') && hasAuthority('ROLE_ADMIN')")
    public Product productById(@PathVariable("ID") Long id) {
        return productService.productById(id);
    }

    @PostMapping("/new_prod")
	public String addUser(@RequestBody Product product) {
		productService.saveProduct(product);
		return "Product is saved";
	}

    @PostMapping("/delProd/{ID}")
    public void deletePers(@PathVariable("ID") Long id){
        productService.delPers(id);
    }
}
