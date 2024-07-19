package com.publisher.SamPublisher.service;

import com.publisher.SamPublisher.model.ProductData;
import com.publisher.SamPublisher.repo.ProductDataRepo;

import java.util.List;

public interface ProductService {
    public List<ProductData> getAllProducts();
    public ProductData getProductById(String id);
}
