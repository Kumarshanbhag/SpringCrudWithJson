package com.springcrudwithjson.service;

import com.springcrudwithjson.model.User;

import java.util.List;

public interface IHelloService {
    List<User> getAllUser();

    User addUser(User user);
}
