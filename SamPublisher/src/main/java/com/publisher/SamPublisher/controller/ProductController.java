package com.publisher.SamPublisher.controller;

import com.publisher.SamPublisher.model.ProductData;
import com.publisher.SamPublisher.service.ProductServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@Slf4j
public class ProductController {
    @Autowired
    ProductServiceImpl productDataService;

    @GetMapping("/getProductData")
    public List<ProductData> getAllProducts() {
        List<ProductData> products = productDataService.getAllProducts();
        log.info("Retrieved {} products", products.size());
        for (ProductData product : products) {
            log.info("Product ID: {}", product.getProductId());
            log.info("Name: {}", product.getName());
            log.info("----------------------------------");
        }
        return products;
    }

    @GetMapping("getProductDetails/{id}")
    public Optional<ProductData> getProductById(@PathVariable String id) {
        return Optional.ofNullable(productDataService.getProductById(id));
    }

    @PostMapping("/getProductById")
    public ProductData getProductByIdPost(@RequestBody ProductData productIdRequest){
        String productId = productIdRequest.getProductId();
        return productDataService.getProductById(productId);
    }
}
