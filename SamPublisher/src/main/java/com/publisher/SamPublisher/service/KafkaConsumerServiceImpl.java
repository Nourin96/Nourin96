package com.publisher.SamPublisher.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.publisher.SamPublisher.dto.Input;
import com.publisher.SamPublisher.repo.ProductDataRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerServiceImpl {

  @KafkaListener(topics = "publisher", groupId = "my-group")
    public String listen(String message) throws JsonProcessingException {
    ObjectMapper mapper=new ObjectMapper();
    Input json=mapper.readValue(message, Input.class);
    System.out.println("Received Message: " + message);
    System.out.println("UserId: "+json.getUserId());
    return json.getUserId();
  }

}
