package com.sst.product_service.controller;

import com.sst.product_service.dtos.Exceptiondto;
import com.sst.product_service.dtos.FakestoreProduct_dto;

import com.sst.product_service.models.Product;
import com.sst.product_service.services.FakestoreProductservice;
import com.sst.product_service.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// This controller is capable to host HTTP API
//localhost:8000/products --> Product_controller
@RestController
@RequestMapping("/products")
public class Product_controller {
    private ProductService productService;

    Product_controller(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") Long id) {
        //      throw new RuntimeException("Something went wrong");
//        ResponseEntity<Product> responseEntity = null;
//        Product product = null;
//        try {
//            product = productService.getProductById(id);
//            responseEntity = new ResponseEntity<>(product, HttpStatus.OK);
//            System.out.println("Hello");
//            return responseEntity;
//        } catch (RuntimeException exception) {
//            Exceptiondto sto = new Exceptiondto();
//            sto.setMessage("Something went wrong");
//            ResponseEntity<Exceptiondto> response = new ResponseEntity<>(sto,HttpStatus.BAD_REQUEST);
//            return response;
//        }
            return productService.getProductById(id);
    }
    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }
}
