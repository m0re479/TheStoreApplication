package ru.webapps.ElectronicsStore.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import ru.webapps.ElectronicsStore.models.Product;
import ru.webapps.ElectronicsStore.repository.ProductRepository;

@Service
@AllArgsConstructor
public class ProductService {
    private static Long ID = 0L;
    private ProductRepository productRepository;

    public List<Product> allProducts(){
        return this.productRepository.findAll();
    }

    public  Optional<Product> productById(Long id){
        return productRepository.findById(id);
    }

    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    public boolean byIdExist(Long id) {
        return !productRepository.existsById(id);
    }

    public void deleteProd(Product product) {
        productRepository.delete(product);
    }
}
