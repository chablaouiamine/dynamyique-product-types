package com.example.dynamyiqueproducttypes.models;

import jakarta.persistence.*;

import java.util.HashMap;
import java.util.Map;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;
    private double price ;
    private String description ;
    private String name;


    @ElementCollection
    @CollectionTable(name = "product_attributes_values", joinColumns = @JoinColumn(name = "id"))
    @MapKeyColumn(name = "attribute_name")
    @Column(name = "attribute_value")
    private Map<String, String> attributes = new HashMap<>();


    @ManyToOne
    private ProductType productType;


    public Product(){

    }

    public Product(Long id, double price, String description, ProductType productType , String name) {
        this.id = id;
        this.price = price;
        this.description = description;
        this.productType = productType;
        this.name = name ;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, String> attributes) {
        this.attributes = attributes;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
