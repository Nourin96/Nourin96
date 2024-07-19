package com.publisher.SamPublisher.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.publisher.SamPublisher.model.CustomerData;
import com.publisher.SamPublisher.dto.Parent;
import com.publisher.SamPublisher.model.UserData;
import com.publisher.SamPublisher.service.CustomerServiceImpl;
import com.publisher.SamPublisher.service.KafkaConsumerServiceImpl;
import com.publisher.SamPublisher.service.KafkaProducerServiceImpl;
import com.publisher.SamPublisher.service.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class UserController {
    @Autowired
    UserServiceImpl userService;

    @Autowired
    KafkaProducerServiceImpl producerService;
    @Autowired
    KafkaConsumerServiceImpl consumerService;

    @Autowired
    CustomerServiceImpl customerService;
    @PostMapping("/getUserById")
    public UserData getUserByIdPost(@RequestBody UserData userIdRequest){
        String userId = userIdRequest.get_id();
        return userService.getUserById(userId);
    }

    @GetMapping("/getUserData")
    public List<UserData> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/createNewUser")
    public UserData createUser(@RequestBody UserData userDetails){
        return userService.createUser(userDetails);
    }

    @PostMapping("/retrieveParent")
    public Parent retrieveParentDetails(@RequestBody String input) throws JsonProcessingException {
        return userService.getParentDetailsByUserId(input);
    }

    @PostMapping("/customerData")
    public CustomerData retrievePurchaseDetails(@RequestBody String input) throws JsonProcessingException {
        return customerService.addCustomerData(input);


    }
}

