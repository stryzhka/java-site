package com.example.lab5.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lab5.entity.PostEntity;
import com.example.lab5.entity.UserEntity;
import com.example.lab5.exception.PostAlreadyExistException;
import com.example.lab5.exception.PostNotFoundException;
import com.example.lab5.exception.UserAlreadyExistException;
import com.example.lab5.exception.UserNotFoundException;
import com.example.lab5.repository.PostRepository;

@Service
public class PostService {
    @Autowired
    private PostRepository repository;

    public PostEntity createPost(PostEntity post) throws PostAlreadyExistException {
        if (repository.findByHeader(post.getHeader()) != null){
                throw new PostAlreadyExistException("post already exists");
            }
        return repository.save(post); 
    }

    public List<PostEntity> getAll(){
        return repository.findAll();
    }
    public PostEntity getById(String id) throws PostNotFoundException{
        if (repository.findById(id).get() == null){
            throw new PostNotFoundException(id + " not found");
        }
        return repository.findById(id).get();
    }
    public PostEntity editPost(PostEntity postEntity) throws PostNotFoundException{
        if (repository.findByHeader(postEntity.getHeader()) == null){
            throw new PostNotFoundException("post not found");
        }
        PostEntity updated = repository.findByHeader(postEntity.getHeader());
        updated.setHeader(postEntity.getHeader());
        updated.setContent(postEntity.getContent());
        return repository.save(updated);
    }
}
