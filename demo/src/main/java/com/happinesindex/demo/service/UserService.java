package com.happinesindex.demo.service;

import com.happinesindex.demo.controller.entity.User;
import com.happinesindex.demo.controller.response.UserResponse;
import com.happinesindex.demo.exceptions.GlobalExceptionHandler;

import java.util.List;

public interface UserService {


    UserResponse saveUser(User user) throws GlobalExceptionHandler;

    List<User> getAllUser();

}
