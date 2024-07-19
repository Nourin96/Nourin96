package com.publisher.SamPublisher.model;

import com.publisher.SamPublisher.dto.Address;
import com.publisher.SamPublisher.dto.Purchase;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "customerData")
public class CustomerData {
    @Id
    public String _id;
    public String userId;
    public String name;
    public String email;
    public String country;
    //@JsonProperty("ParentId")
    public String parentId;
    public Address address;
    public String phone;
    public String registeredAt;
    public ArrayList<Purchase> purchases;
}
