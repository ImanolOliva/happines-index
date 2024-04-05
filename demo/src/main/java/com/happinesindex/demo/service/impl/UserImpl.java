package com.happinesindex.demo.service.impl;

import com.happinesindex.demo.controller.entity.User;
import com.happinesindex.demo.controller.enums.Roles;
import com.happinesindex.demo.controller.response.UserResponse;
import com.happinesindex.demo.exceptions.GlobalExceptionHandler;
import com.happinesindex.demo.repository.UserRepository;
import com.happinesindex.demo.service.UserService;
import com.happinesindex.demo.strategy.RoleStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserImpl extends RoleStrategy implements UserService {


    private final UserRepository userRepository;

    private final static String USER_IS_EMPTY = "users.is.empty";
    private final static String USER_NOT_PROMISE = "user.not.promise";


    @Override
    public UserResponse save(User user, Roles rol){
        try{
            if(PermissionRol(rol)){
                this.userRepository.save(user);
                return new UserResponse(user.getName(),user.getLastName(),user.getDni(),user.getEmail());
            }
            throw  new GlobalExceptionHandler();

        }catch (GlobalExceptionHandler globalExceptionHandler){
            throw  new GlobalExceptionHandler();
        }
    }

    @Override
    public List<User> getAllUser(Roles rol) {
            List<User> userList = this.userRepository.findAll();
            if(PermissionRol(rol)){
                return userList;
        }
            throw  new GlobalExceptionHandler(USER_IS_EMPTY);
    }

    @Override
    public UserResponse getById(Long id,Roles roles) {
        if(PermissionRol(roles) ){
            User user = this.userRepository.findById(id).orElse(null);
            if(user != null){
                return new UserResponse(user.getName(),user.getLastName(),user.getDni(),user.getEmail());
            }
        }
        throw  new RuntimeException(USER_IS_EMPTY);
    }

}
