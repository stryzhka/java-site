package com.example.lab5.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.lab5.entity.PostEntity;
import com.example.lab5.entity.UserEntity;

public interface PostRepository extends MongoRepository<PostEntity, String> {
    public PostEntity findByHeader(String header);
}
