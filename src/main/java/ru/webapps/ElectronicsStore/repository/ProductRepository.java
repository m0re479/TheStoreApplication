package ru.webapps.ElectronicsStore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ru.webapps.ElectronicsStore.models.Product;

@RepositoryRestResource
public interface ProductRepository extends JpaRepository<Product, Long>{
    List<Product> findByName (String prodname);
}
