package com.example.lab5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lab5.entity.PostEntity;
import com.example.lab5.entity.UserEntity;
import com.example.lab5.exception.PostAlreadyExistException;
import com.example.lab5.exception.PostNotFoundException;
import com.example.lab5.exception.UserNotFoundException;
import com.example.lab5.model.BackendError;
import com.example.lab5.model.BackendResponse;
import com.example.lab5.security.JwtIssuer;
import com.example.lab5.security.UserPrincipal;
import com.example.lab5.service.PostService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/posts")
public class PostController {
    @Autowired
    private JwtIssuer jwtIssuer;
    @Autowired
    private PostService postService;
    @PostMapping("create")
    public ResponseEntity createPost(@RequestBody @Valid PostEntity post, @AuthenticationPrincipal UserPrincipal principal) {
        try{
            post.setModeratorName(principal.getUsername());
            postService.createPost(post);
            return ResponseEntity.ok(
                BackendResponse
                .builder()
                .message("post created")
                .build()
            );
        } catch (PostAlreadyExistException e){
            return ResponseEntity.internalServerError().body(
                BackendError
                .builder()
                .errorMessage(e.getMessage())
                .build()
            );
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(
                BackendError
                .builder()
                .errorMessage(e.getMessage())
                .build()
            );
        } 
    }
    
    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @GetMapping("/")
    public ResponseEntity getAll(){
        try{
            return ResponseEntity.ok(postService.getAll());
        } catch (Exception e){
            return ResponseEntity.badRequest().body("error " + e);
        }
    }

    @PostMapping("edit")
    public ResponseEntity editPost(@RequestBody PostEntity postEntity) {
        try{
            postService.editPost(postEntity);
        } catch (PostNotFoundException e){
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
            .message("post updated")
            .build()
        );
    }
    
    
}
