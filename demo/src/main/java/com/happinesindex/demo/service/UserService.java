package com.happinesindex.demo.service;

import com.happinesindex.demo.controller.entity.User;
import com.happinesindex.demo.controller.enums.Roles;
import com.happinesindex.demo.controller.response.UserResponse;

import java.util.List;

public interface UserService {


    UserResponse save(User user,Roles rol);

    List<User> getAllUser(Roles rol);

    UserResponse getById(Long id,Roles roles);

}
