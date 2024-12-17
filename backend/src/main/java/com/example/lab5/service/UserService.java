package com.example.lab5.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.lab5.entity.UserEntity;
import com.example.lab5.entity.LoginEntity;
import com.example.lab5.exception.UserAlreadyExistException;
import com.example.lab5.exception.UserNotFoundException;
import com.example.lab5.repository.UserRepository;
import com.example.lab5.model.User;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;
    public UserEntity registration(UserEntity user) throws UserAlreadyExistException{
        user.setRole("user");
        if (repository.findByUsername(user.getUsername()) != null){
                throw new UserAlreadyExistException("user already exists");
            }
        return repository.save(user); 
    }

    public List<UserEntity> getAll(){
        return repository.findAll();
    }

    public UserEntity findByUsername(String username) {
        //if (repository.findByUsername(username) == null){
        //    throw new UserNotFoundException(username + " not found");
        //}
        return repository.findByUsername(username);
    }

    public UserEntity getById(String id) throws UserNotFoundException{
        if (repository.findById(id).get() == null){
            throw new UserNotFoundException(id + " not found");
        }
        return repository.findById(id).get();
    }

    public boolean isPasswordCorrect(LoginEntity loginData) throws UserNotFoundException{
        UserEntity user = repository.findByUsername(loginData.getUsername());
        if (repository.findByUsername(loginData.getUsername()) == null){
            throw new UserNotFoundException(loginData.getUsername() + " not found");
        }
        return user.getPassword().equals(loginData.getPassword());
    }

    public UserEntity editUser(UserEntity userEntity) throws UserNotFoundException{
        if (repository.findByUsername(userEntity.getUsername()) == null){
            throw new UserNotFoundException("user not found");
        }
        UserEntity updated = repository.findByUsername(userEntity.getUsername());
        updated.setRole(userEntity.getRole());
        return repository.save(updated);
    }
}
