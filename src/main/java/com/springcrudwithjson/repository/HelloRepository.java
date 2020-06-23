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

    public void loadJSONData() {
        try {
            InputStream inputStream = new FileInputStream(new File("src/main/resources/JSONData/User.json"));
            TypeReference<List<User>> typeReference = new TypeReference<List<User>>() {
            };
            userList = objectMapper.readValue(inputStream, typeReference);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getAllUser() {
        loadJSONData();
        return userList;
    }

    @Override
    public User addUser(User user) {
        loadJSONData();
        try {
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
        loadJSONData();
        for (User user : userList) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    @Override
    public User updateUser(int id, User user) {
        User userById = getUserById(id);
        userById.setUserName((user.getUserName() == null) ? userById.getUserName() : user.getUserName());
        userById.setLastName((user.getLastName() == null) ? userById.getLastName() : user.getLastName());
        userList.set(userList.indexOf(userById), userById);
        try {
            objectMapper.writeValue(new File("src/main/resources/JSONData/User.json"), userList);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return userById;
    }

}
