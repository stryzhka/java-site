package com.example.lab5.controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import com.example.lab5.entity.LoginEntity;
import com.example.lab5.entity.UserEntity;
import com.example.lab5.exception.UserNotFoundException;
import com.example.lab5.security.JwtIssuer;
import com.example.lab5.security.UserPrincipal;
import com.example.lab5.service.UserService;



@RestController
public class AuthController {
    @Autowired
    private JwtIssuer jwtIssuer;

    @Autowired
    private UserService userService;
    @PostMapping("/auth/login")
    public ResponseEntity login (@RequestBody LoginEntity request, @AuthenticationPrincipal UserPrincipal principal){
        try{
            UserEntity user = userService.findByUsername(request.getUsername());
            
                if (userService.isPasswordCorrect(request)){

                    var token = jwtIssuer.issue(request.getUsername(), Arrays.asList(user.getRole()));
                    return ResponseEntity.ok("user: " + user.getId() + "\n" + token);
                }
                else{
                    return ResponseEntity.badRequest().body("incorrect password");
                }
        } catch (UserNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        
        
        
    }

    @GetMapping("/secured")
    public ResponseEntity login (@AuthenticationPrincipal UserPrincipal principal){
        return ResponseEntity.ok(principal.getUsername());
    }

    @GetMapping("/admin")
    public ResponseEntity admin (@AuthenticationPrincipal UserPrincipal principal){
        return ResponseEntity.ok("admin");
    }
}