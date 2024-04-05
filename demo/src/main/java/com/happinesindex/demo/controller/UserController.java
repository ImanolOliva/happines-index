package com.happinesindex.demo.controller;


import com.happinesindex.demo.controller.entity.User;
import com.happinesindex.demo.controller.response.UserResponse;
import com.happinesindex.demo.service.impl.UserImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
@RestController
@RequiredArgsConstructor
public class UserController{


    private final UserImpl userImpl;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse createUser(@Valid @RequestBody User user){
            return this.userImpl.saveUser(user);
    }


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<User> getAllUser( ){
        return this.userImpl.getAllUser();
    }
}
