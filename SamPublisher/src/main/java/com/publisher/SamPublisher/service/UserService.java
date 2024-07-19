package com.publisher.SamPublisher.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.publisher.SamPublisher.dto.Parent;
import com.publisher.SamPublisher.model.UserData;

import java.util.List;

public interface UserService {
    public List<UserData> getAllUsers();
    public UserData getUserById(String id);
    public UserData createUser(UserData userData);
    public Parent getParentDetailsByUserId(String message) throws JsonProcessingException;
}
