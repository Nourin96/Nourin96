package com.publisher.SamPublisher.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "productData")
@TypeAlias("ProductData")
public class ProductData {
    @Id
    private String _id;
    private String productId;
    private String name;
    private String description;
    private double price;
    private String category;
    private String manufacturer;
    private int stock;
}
