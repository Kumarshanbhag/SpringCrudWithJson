package com.springcrudwithjson.repository;

import com.springcrudwithjson.model.User;

import java.util.List;

public interface IHelloRepository {
    List<User> getAllUser();
}
