package com.example.lab5.controller;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lab5.entity.UserEntity;
import com.example.lab5.exception.UserNotFoundException;
import com.example.lab5.model.BackendError;
import com.example.lab5.model.BackendResponse;
import com.example.lab5.model.User;
import com.example.lab5.repository.UserRepository;
import com.example.lab5.security.UserPrincipal;
import com.example.lab5.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/admin")
public class AdminController {
    
    @Autowired
    private UserService userService;

    /*@GetMapping("/admin")
    public ResponseEntity getAllUsers (@AuthenticationPrincipal UserPrincipal principal){
        return ResponseEntity.ok("admin");
    }*/
    @GetMapping("/users")
    public ResponseEntity getAllUsers (@AuthenticationPrincipal UserPrincipal principal){
        return ResponseEntity.ok(userService.getAll());
    }

    @PostMapping("/users/edit")
    public ResponseEntity editUser(@RequestBody UserEntity userEntity) {
        try{
            userService.editUser(userEntity);
        } catch (UserNotFoundException e){
            return ResponseEntity.internalServerError().body(
                BackendError
                .builder()
                .errorMessage(e.getMessage())
                .build()
            );
        }
        catch (Exception e){
            return ResponseEntity.internalServerError().body(
                BackendError
                .builder()
                .errorMessage(e.getMessage())
                .build()
            );
        }
        
        return ResponseEntity.ok(
            BackendResponse
            .builder()
            .message("user updated")
            .build()
        );
    }
    
}
