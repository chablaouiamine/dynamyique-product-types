package com.example.dynamyiqueproducttypes.service;

import com.example.dynamyiqueproducttypes.models.ProductAttribute;
import com.example.dynamyiqueproducttypes.models.ProductType;
import com.example.dynamyiqueproducttypes.repository.ProductAttributeRepository;
import com.example.dynamyiqueproducttypes.repository.ProductTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductTypeService {
    private final ProductTypeRepository productTypeRepository;
    private final ProductAttributeRepository productAttributeRepository;

    @Autowired
    public ProductTypeService(
            ProductTypeRepository productTypeRepository,
            ProductAttributeRepository productAttributeRepository
    ) {
        this.productTypeRepository = productTypeRepository;
        this.productAttributeRepository = productAttributeRepository;
    }

    public ProductType createProductType(ProductType productType) {
        return productTypeRepository.save(productType);
    }

    public List<ProductType> getAllProductTypes() {
        return productTypeRepository.findAll();
    }

    public List<ProductAttribute> getAttributesForProductType(Long productTypeId) {
        ProductType productType = productTypeRepository.findById(productTypeId).orElse(null);
        if (productType != null) {
            return productAttributeRepository.findByProductType(productType);
        }
        return null;
    }

    public ProductAttribute addAttributeToProductType(Long productTypeId, String attributeName) {
        ProductType productType = productTypeRepository.findById(productTypeId).orElse(null);
        if (productType != null) {
            ProductAttribute attribute = new ProductAttribute();
            attribute.setProductType(productType);
            attribute.setAttributeName(attributeName);
            return productAttributeRepository.save(attribute);
        }
        return null;
    }
}