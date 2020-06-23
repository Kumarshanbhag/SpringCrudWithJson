package com.springcrudwithjson.service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springcrudwithjson.model.User;
import com.springcrudwithjson.repository.IHelloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.Collections;
import java.util.List;

@Service
public class HelloService implements IHelloService{
    @Autowired
    IHelloRepository helloRepository;

    @Override
    public List<User> getAllUser() {
        return helloRepository.getAllUser();
    }

    @Override
    public User addUser(User user) {
        return helloRepository.addUser(user);
    }

    @Override
    public User getUserById(int id) {
        return helloRepository.getUserById(id);
    }
}
