package com.springcrudwithjson.service;

import com.springcrudwithjson.model.User;

import java.util.List;

public interface IHelloService {
    List<User> getAllUser();

    User addUser(User user);

    User getUserById(int id);

    User updateUser(int id, User user);

    User deleteUser(int id);
}
