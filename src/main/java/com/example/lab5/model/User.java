package com.example.lab5.model;

import com.example.lab5.entity.UserEntity;

public class User {
    private String id;
    private String username;
    
    public static User toModel(UserEntity entity){
        User model = new User();
        model.setId(entity.getId());
        model.setUsername(entity.getUsername());
        return model;
    }

    public User(){

    }

    public void setId(String id) {
        this.id = id;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getId() {
        return id;
    }
    public String getUsername() {
        return username;
    }

    
}
