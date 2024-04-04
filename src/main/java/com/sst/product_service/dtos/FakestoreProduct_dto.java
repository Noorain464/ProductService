package com.sst.product_service.dtos;

import com.sst.product_service.models.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakestoreProduct_dto {
    private Long id;
    private String title;
    private Double price;
    private String category;
    private String description;
    private String image;

}
