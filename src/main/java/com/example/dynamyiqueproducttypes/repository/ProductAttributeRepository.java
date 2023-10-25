package com.example.dynamyiqueproducttypes.repository;

import com.example.dynamyiqueproducttypes.models.ProductAttribute;
import com.example.dynamyiqueproducttypes.models.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductAttributeRepository extends JpaRepository<ProductAttribute, Long> {
    List<ProductAttribute> findByProductType(ProductType productType);
}