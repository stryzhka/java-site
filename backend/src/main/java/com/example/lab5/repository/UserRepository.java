package com.example.lab5.repository;

//import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.lab5.entity.UserEntity;

public interface UserRepository extends MongoRepository<UserEntity, String> {
  public UserEntity findByUsername(String username);
  //public UserEntity findById(String id);
  //public List<UserEntity> findById(String id);

}