package com.example.lab5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.lab5.entity.UserEntity;
import com.example.lab5.repository.UserRepository;

@SpringBootApplication
public class Lab5Application {
	public static void main(String[] args) {
		SpringApplication.run(Lab5Application.class, args);
	}
}
