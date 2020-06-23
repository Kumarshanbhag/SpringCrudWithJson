package com.springcrudwithjson.controller;

import com.springcrudwithjson.model.User;
import com.springcrudwithjson.service.IHelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HelloController {
    @Autowired
    IHelloService helloService;

    @GetMapping ("/getallusers")
    public List<User> getUsers() {
        return helloService.getAllUser();
    }

    @GetMapping ("/getuserbyid/{id}")
    public User getUserById(@PathVariable int id) {
        return helloService.getUserById(id);
    }

    @PostMapping ("/add")
    public User addUser(@RequestBody User user) {
        return helloService.addUser(user);
    }
}
