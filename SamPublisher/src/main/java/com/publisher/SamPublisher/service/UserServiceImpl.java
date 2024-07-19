package com.publisher.SamPublisher.service;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.publisher.SamPublisher.dto.Parent;
import com.publisher.SamPublisher.model.UserData;
import com.publisher.SamPublisher.repo.UserDataRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService{
    @Autowired
    UserDataRepo userDataRepo;
    @Autowired
    KafkaConsumerServiceImpl kafkaConsumerService;

    public List<UserData> getAllUsers() {
        log.info("--User Details--");
        return userDataRepo.findAll();
    }

    public UserData getUserById(String id) {
        log.info("--Inside Service: Fetching User Details--");
        return userDataRepo.findById(id).orElse(null);
    }

    public UserData createUser(UserData userData) {
        return userDataRepo.save(userData);
    }

    //method to publish final json to kafka
    public Parent getParentDetailsByUserId(String message) throws JsonProcessingException {
        UserData userData;
        String userIdKafka = kafkaConsumerService.listen(message);
        log.info("Id Received from Kafka: " + userIdKafka);
       // List<UserData> userDataList = getAllUsers();
        userData=getUserById(userIdKafka);
       // for (UserData user : userDataList) {
            log.info("Id :" + userData.get_id()); //U001
            if (userIdKafka.equals(userData.get_id())) {
                //userData = getUserById(user.get_id());
                String parentId = userData.getParentId(); //P1
                userData = userDataRepo.findByParentId(parentId);
                if (userData != null) {
                    return userData.getParent();
                }
            }
        //}
        return null;
    }
}