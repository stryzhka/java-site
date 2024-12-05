package com.example.lab5.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.lab5.entity.UserEntity;
import com.example.lab5.exception.UserAlreadyExistException;
import com.example.lab5.exception.UserNotFoundException;
import com.example.lab5.repository.UserRepository;
import com.example.lab5.model.User;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;
    public UserEntity registration(UserEntity user) throws UserAlreadyExistException{
        if (repository.findByUsername(user.getUsername()) != null){
                throw new UserAlreadyExistException("user already exists");
            }
        return repository.save(user); 
    }

    public List<UserEntity> getAll(){
        return repository.findAll();
    }

    /*public UserEntity findByUsername(String username){

    }*/

    public User getById(String id) throws UserNotFoundException{
        if (repository.findById(id).get() == null){
            throw new UserNotFoundException(id + " not found");
        }
        return User.toModel(repository.findById(id).get());
    }
}
