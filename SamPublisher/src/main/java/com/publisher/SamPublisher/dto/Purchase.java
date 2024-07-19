package com.publisher.SamPublisher.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Purchase {
    public String productId;
    private String name;
    private String description;
    private double price;
    private String category;
    private String manufacturer;
    public String purchaseDate;
    public int quantity;
    public double totalPrice;






}