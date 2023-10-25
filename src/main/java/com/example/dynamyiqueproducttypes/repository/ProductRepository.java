package com.example.dynamyiqueproducttypes.repository;

import com.example.dynamyiqueproducttypes.models.Product;
import com.example.dynamyiqueproducttypes.models.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product , Long> {
    public Product findProductById(Long id);
    public List<Product> findAllByProductType(ProductType productType);
}
