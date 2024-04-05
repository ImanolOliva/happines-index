package com.happinesindex.demo.controller;


import com.happinesindex.demo.controller.entity.User;
import com.happinesindex.demo.controller.enums.Roles;
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
    public UserResponse createUser(@Valid
                                       @RequestParam(value = "role", required = true) Roles rol,
                                   @RequestBody User user) {
        return this.userImpl.save(user, rol);
    }



    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<User> getAllUser(
            @RequestParam(value = "role",required = true) Roles rol
    ){
        return this.userImpl.getAllUser(rol);
    }


    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserResponse getUserById(
            @RequestParam(value = "role", required = true) Roles rol,
            @PathVariable("id") Long id){
        return  this.userImpl.getById(id,rol);
    }

}
