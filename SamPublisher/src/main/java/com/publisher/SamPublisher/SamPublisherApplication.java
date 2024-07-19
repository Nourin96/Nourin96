package com.publisher.SamPublisher;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SamPublisherApplication {

	public static void main(String[] args) throws JsonProcessingException {

		SpringApplication.run(SamPublisherApplication.class, args);

		ObjectMapper mapper = new ObjectMapper();
	}


}
