package com.example.dynamyiqueproducttypes.service;

import com.example.dynamyiqueproducttypes.models.Product;
import com.example.dynamyiqueproducttypes.models.ProductType;
import com.example.dynamyiqueproducttypes.repository.ProductRepository;
import com.example.dynamyiqueproducttypes.repository.ProductTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductTypeRepository productTypeRepository;

    public Product create(Product product){
        return productRepository.save(product);
    }

    public Product getById(Long id){
        return  productRepository.findProductById(id);
    }

    public List<Product> getList(){
        return productRepository.findAll();
    }

    public List<Product> getProductByType(Long id){
        ProductType productType = productTypeRepository.findProductTypeById(id);
        return  productRepository.findAllByProductType(productType);
    }
}
