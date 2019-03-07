package com.wccwin.financial.controller;

import com.wccwin.financial.entity.User;
import com.wccwin.financial.model.RespModel;
import com.wccwin.financial.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    @ResponseBody
    public RespModel<User> getUser(@PathVariable("id") int id){
        try {
            return RespModel.success(userService.getUser(id));
        } catch (Exception e){
            logger.error("用户注册异常", e);
            return RespModel.error(null , e);
        }
    }

    @PostMapping("/register")
    @ResponseBody
    public RespModel<User> register(@Valid User user, BindingResult bindingResult){
        try {
            if(bindingResult.hasErrors()){
                for (ObjectError objectError : bindingResult.getAllErrors()) {
                    return RespModel.error(objectError.getDefaultMessage());
                }
            }
            return RespModel.success(userService.register(user));
        } catch (Exception e){
            logger.error("用户注册异常", e);
            return RespModel.error(null , e);
        }
    }

    @PostMapping("/login")
    @ResponseBody
    public RespModel<User> login(@Valid User user, BindingResult bindingResult){
        try {
            if(bindingResult.hasErrors()){
                for (ObjectError objectError : bindingResult.getAllErrors()) {
                    return RespModel.error(objectError.getDefaultMessage());
                }
            }
            return RespModel.success(userService.login(user));
        } catch (Exception e){
            logger.error("用户登入异常", e);
            return RespModel.error(null , e);
        }
    }



}
