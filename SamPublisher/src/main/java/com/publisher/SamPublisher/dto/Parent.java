package com.publisher.SamPublisher.dto;

import com.publisher.SamPublisher.dto.Address;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Parent {
   // @JsonProperty("Parent")
    public String parent;
    public String name;
    public String email;
    public Address address;
    public String phone;
    public String registeredAt;
}
