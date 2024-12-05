package com.example.lab5.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.lab5.entity.UserEntity;
import com.example.lab5.exception.UserAlreadyExistException;
import com.example.lab5.exception.UserNotFoundException;
import com.example.lab5.repository.UserRepository;
import com.example.lab5.service.UserService;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    public UserService userService;
    @PostMapping("register")
    public ResponseEntity registerUser(@RequestBody UserEntity user) {
        //TODO: process POST request
        try{
            userService.registration(user);
            return ResponseEntity.ok("user saved");
        } catch (UserAlreadyExistException e) {
            return ResponseEntity.internalServerError().body("failed to create\n" + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("failed to create\n" + e);
        }    
    }

    /*@GetMapping("/")
    public ResponseEntity getByUsername(@RequestParam String username) {
        try{
            return ResponseEntity.ok(userService.getByUsername(username));
        } catch (UserNotFoundException e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }*/

    @GetMapping
    public ResponseEntity getById(@RequestParam String id) {
        try{
            return ResponseEntity.ok(userService.getById(id));
        } catch (UserNotFoundException e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
    
    

    @GetMapping("/")
    public ResponseEntity getAll(){
        try{
            return ResponseEntity.ok(userService.getAll());
        } catch (Exception e){
            return ResponseEntity.badRequest().body("error " + e);
        }
    }
}
