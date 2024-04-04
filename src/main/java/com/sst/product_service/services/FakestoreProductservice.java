package com.sst.product_service.services;

import com.sst.product_service.Exceptions.ProductnotFoundException;
import com.sst.product_service.dtos.FakestoreProduct_dto;
import com.sst.product_service.models.Category;
import com.sst.product_service.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.ArrayList;
import java.util.List;

@Service
public class FakestoreProductservice implements ProductService {
    @Override
    public Product getProductById(Long id) {
//        throw new RuntimeException("Something went wrong in service");
//        throw new RuntimeException();
//        int x = 1/0;
        RestTemplate restTemplate = new RestTemplate();
        FakestoreProduct_dto fakestoreProductDto = restTemplate.getForObject("https://fakestoreapi.com/products/" + id , FakestoreProduct_dto.class);
        // convert fakestoredto to product
        if(fakestoreProductDto == null){
            throw new ProductnotFoundException(id,"Please pass valid productid");
        }
        return conversion(fakestoreProductDto);
    }

    @Override
    public List<Product> getAllProducts() {
        RestTemplate restTemplate = new RestTemplate();
        FakestoreProduct_dto[] fakestoreProductDtos = restTemplate.getForObject("https://fakestoreapi.com/products/",FakestoreProduct_dto[].class);
        List<Product> products = new ArrayList<>();
        for(FakestoreProduct_dto fakestoreProductDto : fakestoreProductDtos){
            products.add(conversion(fakestoreProductDto));
        }
        return products;
    }
    private Product conversion(FakestoreProduct_dto fakestoreProductDto){
        Product product = new Product();
        product.setId(fakestoreProductDto.getId());
        product.setTitle(fakestoreProductDto.getTitle());
        product.setPrice(fakestoreProductDto.getPrice());
        product.setDescription(fakestoreProductDto.getDescription());
        product.setImage_url(fakestoreProductDto.getImage());
        Category category = new Category();
        category.setDescription(fakestoreProductDto.getCategory());
        product.setCategory(category);
        return product;
    }
}
