package com.happinesindex.demo.service.impl;

import com.happinesindex.demo.controller.entity.User;
import com.happinesindex.demo.controller.response.UserResponse;
import com.happinesindex.demo.exceptions.GlobalExceptionHandler;
import com.happinesindex.demo.repository.UserRepository;
import com.happinesindex.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserImpl implements UserService {


    private final UserRepository userRepository;

    private final static String USER_IS_EMPTY = "users.is.empty";



    @Override
    public UserResponse saveUser(User user) throws GlobalExceptionHandler {
        try{
         this.userRepository.save(user);
        return new UserResponse(user.getName(),user.getLastName(),user.getDni(),user.getEmail());
        }catch (GlobalExceptionHandler globalExceptionHandler){
            throw  new GlobalExceptionHandler();
        }
    }

    @Override
    public List<User> getAllUser() {
    List<User> userList = this.userRepository.findAll();
    if(userList.isEmpty()){
        throw  new GlobalExceptionHandler(USER_IS_EMPTY);
    }
      return userList;
    }
}
