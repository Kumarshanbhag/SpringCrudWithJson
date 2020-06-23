package com.springcrudwithjson.controller;

import com.springcrudwithjson.model.User;
import com.springcrudwithjson.service.IHelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {
    @Autowired
    IHelloService helloService;

    @GetMapping ("/getallusers")
    public List<User> getUsers() {
        return helloService.getAllUser();
    }
}
