package com.wsw.springbootrediscache.controller;

import com.wsw.springbootrediscache.Service.UserService;
import com.wsw.springbootrediscache.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

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

    @GetMapping("/get2")
    public List<User> getbypass(String password){
        List<User> users = userService.findUserByPassword(password);
        return users;
    }

    @GetMapping("/get3")
    public void delete(String username){
        userService.deleteItByUsername(username);
    }

    /*@PostMapping("/save")
    public void save(User user){
        userService.save(user);
    }*/

    @PostMapping("/update")
    public int update(String username, Integer id){
        return userService.updateUserByid(username, id);
    }
}
