package com.sst.product_service.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
// Default constructor with no arguments
@NoArgsConstructor

public class Product {
    private Long id;
    private String title;
    private String description;
    private Double price;
    private Category category;
    private String image_url;
}
