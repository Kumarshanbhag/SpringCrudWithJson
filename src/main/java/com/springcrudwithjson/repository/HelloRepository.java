package com.springcrudwithjson.repository;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springcrudwithjson.model.User;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.util.Collections;
import java.util.List;

@Repository
public class HelloRepository implements IHelloRepository {
    ObjectMapper objectMapper = new ObjectMapper();
    List<User> userList = null;

    @Override
    public List<User> getAllUser() {
        try {
            InputStream inputStream = new FileInputStream(new File("src/main/resources/JSONData/User.json"));
            TypeReference<List<User>> typeReference = new TypeReference<List<User>>() {
            };
            userList = objectMapper.readValue(inputStream, typeReference);
            return userList;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User addUser(User user) {
        try {
            userList = getAllUser();
            Collections.addAll(userList, user);
            objectMapper.writeValue(new File("src/main/resources/JSONData/User.json"), userList);
            return user;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User getUserById(int id) {
        userList = getAllUser();
        for(User user: userList) {
            if(user.getId() == id){
                return user;
            }
        }
        return null;
    }
}
