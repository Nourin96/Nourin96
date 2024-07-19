package com.publisher.SamPublisher.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.publisher.SamPublisher.dto.Purchase;
import com.publisher.SamPublisher.model.CustomerData;
import com.publisher.SamPublisher.model.ProductData;
import com.publisher.SamPublisher.model.UserData;
import com.publisher.SamPublisher.repo.CustomerDataRepository;
import com.publisher.SamPublisher.repo.ProductDataRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    KafkaConsumerServiceImpl kafkaConsumerService;
    @Autowired
    UserServiceImpl userService;
    @Autowired
    ProductServiceImpl productServiceImpl;

    @Autowired
    ProductDataRepo productDataRepo;

    @Autowired
    CustomerDataRepository customerDataRepository;

    public CustomerData addCustomerData(String message) throws JsonProcessingException {
        UserData userData;

        String userIdKafka = kafkaConsumerService.listen(message);
        log.info("Id Received from Kafka: " + userIdKafka);

        userData=userService.getUserById(userIdKafka);
        List<String> productIds=new ArrayList<>();
        List<ProductData> productData= productServiceImpl.getAllProducts();
        CustomerData customerData=new CustomerData();
        Purchase purchase=new Purchase();
            if (userIdKafka.equals(userData.get_id())) {

                customerData.set_id(userData.get_id());
                customerData.setUserId(userData.get_id());
                customerData.setName(userData.getName());
                customerData.setEmail(userData.getEmail());
                customerData.setCountry(userData.getCountry());
                customerData.setParentId(userData.getParentId());
                //Address
                customerData.setAddress(userData.getAddress());
                //user
                customerData.setPhone(userData.getPhone());
                customerData.setRegisteredAt(userData.getRegisteredAt());
             log.info("Project ids"+productIds);//P001,P003
                ArrayList<Purchase> userPurchase = userData.getPurchases();
                for(Purchase pur:userPurchase){
                    //productIds.add(pur.getProductId());
                    ProductData product=productDataRepo.findById(pur.getProductId()).get();
                    pur.setName(product.getName());
                    pur.setDescription(product.getDescription());
                    pur.setPrice(product.getPrice());
                    pur.setCategory(product.getCategory());
                    pur.setManufacturer(product.getManufacturer());
                }
                customerData.setPurchases(userPurchase);
                customerDataRepository.save(customerData);
            }
                return customerData;
    }
}
