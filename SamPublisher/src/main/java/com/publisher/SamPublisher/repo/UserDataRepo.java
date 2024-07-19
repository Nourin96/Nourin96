package com.publisher.SamPublisher.repo;

import com.publisher.SamPublisher.model.UserData;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserDataRepo extends MongoRepository<UserData,String> {
    UserData findByParentId(String parentId);

}
