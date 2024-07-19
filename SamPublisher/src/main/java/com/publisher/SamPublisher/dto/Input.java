package com.publisher.SamPublisher.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Input {
    private String userId;
    private String registeredAt;
}
