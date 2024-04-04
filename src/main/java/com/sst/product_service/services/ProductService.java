package com.sst.product_service.services;

import com.sst.product_service.models.Product;

import java.util.List;

public interface ProductService {
    Product getProductById(Long id);
    List<Product> getAllProducts();
}
