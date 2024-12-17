package com.example.lab5.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BackendResponse {
    private final String message;
}
