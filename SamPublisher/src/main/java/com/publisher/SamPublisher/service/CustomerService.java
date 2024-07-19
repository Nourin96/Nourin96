package com.publisher.SamPublisher.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.publisher.SamPublisher.model.CustomerData;

public interface CustomerService {
    public CustomerData addCustomerData(String message) throws JsonProcessingException;

}
