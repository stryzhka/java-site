package com.example.lab5.entity;


import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.NonNull;
import lombok.Setter;
import lombok.Data;
import lombok.Getter;

//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;

//@Entity
@Data
@Getter
@Setter
public class UserEntity { 
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id private String id;
    @NonNull private String username;
    @NonNull private String password;
    @NonNull private String role;
    
    

    
}
