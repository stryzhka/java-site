package com.example.lab5.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lab5.entity.UserEntity;
import com.example.lab5.entity.LoginEntity;
import com.example.lab5.exception.UserNotFoundException;
import com.example.lab5.repository.UserRepository;
import com.example.lab5.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping()
public class SessionController {
    @Autowired
    private UserRepository repository;
    @Autowired private UserService userService;
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginEntity loginData) {
        try{
            if (userService.isPasswordCorrect(loginData)){
                return ResponseEntity.ok("ok");
            }
            else{
                return ResponseEntity.internalServerError().body("incorrect password");
            }
        } catch (UserNotFoundException e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
    

}
