package com.example.retailers.controller;

import com.example.retailers.bean.RetailersUser;
import com.example.retailers.result.BaseResult;
import com.example.retailers.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/manage")
public class LoginController {

    @Autowired
    UserService userService;

    @GetMapping("/login")
    @ApiOperation(value = "系统登录管理")
    public BaseResult login(RetailersUser retailersUser){
        return userService.login(retailersUser);
    }

}
