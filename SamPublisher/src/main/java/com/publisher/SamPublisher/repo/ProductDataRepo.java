package com.publisher.SamPublisher.repo;

import com.mongodb.client.MongoDatabase;
import com.publisher.SamPublisher.model.ProductData;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDataRepo extends MongoRepository<ProductData,String> {
}
