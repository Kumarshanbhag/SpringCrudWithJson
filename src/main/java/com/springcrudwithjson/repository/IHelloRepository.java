package com.springcrudwithjson.repository;

import com.springcrudwithjson.model.User;

import java.util.List;

public interface IHelloRepository {
    List<User> getAllUser();

    User addUser(User user);

    User getUserById(int id);

    User updateUser(int id, User user);

    User deleteUser(int id);
}
