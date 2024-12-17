package com.example.lab5.model;

import org.springframework.http.ResponseEntity;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class LoginResponse{
    private final String accessToken;
}
