package com.publisher.SamPublisher.controller;

import com.publisher.SamPublisher.service.KafkaProducerServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class KafkaController {

    private final KafkaProducerServiceImpl producerService;
    @Autowired
    public KafkaController(KafkaProducerServiceImpl producerService) {
        this.producerService = producerService;
    }

    @PostMapping("/published")
    public ResponseEntity<String> publishedMessage(@RequestBody String input) {
        producerService.sendMessage("publisher", input);
        return ResponseEntity.ok("Published to Kafka topic "+input);
    }




}