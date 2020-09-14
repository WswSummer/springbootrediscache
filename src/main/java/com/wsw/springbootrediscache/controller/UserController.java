package com.wsw.springbootrediscache.controller;

import com.wsw.springbootrediscache.Service.UserService;
import com.wsw.springbootrediscache.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author WangSongWen
 * @Date: Created in 16:33 2020/9/14
 * @Description:
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/get")
    public User get(String username){
        User user = userService.findUserByUserName(username);
        return user;
    }
}
