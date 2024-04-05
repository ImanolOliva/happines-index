package com.happinesindex.demo.strategy;

import com.happinesindex.demo.controller.enums.Roles;
import com.happinesindex.demo.exceptions.GlobalExceptionHandler;

public abstract class RoleStrategy {
    private final static String USER_NOT_PROMISE = "user.not.promise";


    protected boolean PermissionRol(Roles role){
            if(role.name().equals("ADMINISTRATOR")){
                return true;
            }
        throw  new GlobalExceptionHandler(USER_NOT_PROMISE);
    }
}
