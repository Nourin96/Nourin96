package com.publisher.SamPublisher.service;

import com.publisher.SamPublisher.model.ProductData;
import com.publisher.SamPublisher.repo.ProductDataRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService{

    private final ProductDataRepo productDataRepository;

    @Autowired
    public ProductServiceImpl(ProductDataRepo productDataRepository) {
        this.productDataRepository = productDataRepository;
    }

    public List<ProductData> getAllProducts() {
        log.info("--Product Data--");
        return productDataRepository.findAll();
    }

    public ProductData getProductById(String id) {
        log.info("--Inside Service: Fetching Product Details--");
        return productDataRepository.findById(id).orElse(null);
    }

}
