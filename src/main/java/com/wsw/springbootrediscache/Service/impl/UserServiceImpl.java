package com.wsw.springbootrediscache.Service.impl;

import com.wsw.springbootrediscache.Service.UserService;
import com.wsw.springbootrediscache.entity.User;
import com.wsw.springbootrediscache.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

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
    @Cacheable(key = "#username")
    public User findUserByUserName(String username) {
        User user = userRepository.findUserByUsername(username);
        return user;
    }

    @Override
    @Cacheable(key = "#password")
    public List<User> findUserByPassword(String password) {
        List<User> users = userRepository.findUserByPassword(password);
        return users;
    }

    @Override
    @CacheEvict(key = "#username")
    public void deleteItByUsername(String username) {
        userRepository.deleteItByUsername(username);
    }

    @Override
    @CachePut(key = "#user.id")
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    @CachePut(key = "#username")
    public int updateUserByid(String username, Integer id) {
        int i = userRepository.updateUserByid(username, id);
        return i;
    }

}
