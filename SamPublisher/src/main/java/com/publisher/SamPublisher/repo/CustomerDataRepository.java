package com.publisher.SamPublisher.repo;

import com.publisher.SamPublisher.model.CustomerData;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerDataRepository extends MongoRepository<CustomerData,String> {
}
