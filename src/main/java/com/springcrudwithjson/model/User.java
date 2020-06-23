package com.springcrudwithjson.model;

public class User {
    public int id;
    public String userName;
    public String lastName;

    public User() {
    }

    public User(int id, String userName, String lastName) {
        this.id = id;
        this.userName = userName;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
