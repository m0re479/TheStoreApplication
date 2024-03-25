package ru.webapps.ElectronicsStore.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import ru.webapps.ElectronicsStore.models.Product;
import ru.webapps.ElectronicsStore.repository.ProductRepository;

@Service
@AllArgsConstructor
public class ProductService {
    private static Long ID = 0L;
    private List<Product> products = new ArrayList<Product>();
    private ProductRepository productRepository;

//    @PostConstruct
//    public void loadProductInDB(){
//       products.add(new Product(++ID, "ff"));
//       products.add(new Product(++ID, "ll"));
//       products.add(new Product(++ID, "pp"));
//    }

    public List<Product> allProducts(){
        return this.productRepository.findAll();
    }

    public Product productById(Long id){
        return products.stream()
        .filter(p -> p.getId()==id)
        .findFirst()
        .orElse(null);
    }

    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    public void delPers(Long id){
        productRepository.deleteById(id);
    }
}
