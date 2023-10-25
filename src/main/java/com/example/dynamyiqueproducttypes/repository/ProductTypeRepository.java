package com.example.dynamyiqueproducttypes.repository;


import com.example.dynamyiqueproducttypes.models.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductTypeRepository extends JpaRepository<ProductType , Long> {
    public ProductType findProductTypeById(Long id);
}
