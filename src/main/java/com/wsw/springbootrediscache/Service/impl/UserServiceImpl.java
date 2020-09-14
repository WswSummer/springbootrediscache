package com.wsw.springbootrediscache.Service.impl;

import com.wsw.springbootrediscache.Service.UserService;
import com.wsw.springbootrediscache.entity.User;
import com.wsw.springbootrediscache.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @Author WangSongWen
 * @Date: Created in 16:40 2020/9/14
 * @Description:
 */
@Service
@CacheConfig(cacheNames = "user")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    @Cacheable
    public User findUserByUserName(String username) {
        User user = userRepository.findUserByUsername(username);
        return user;
    }
}
