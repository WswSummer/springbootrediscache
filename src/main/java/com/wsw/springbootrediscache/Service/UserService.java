package com.wsw.springbootrediscache.Service;

import com.wsw.springbootrediscache.entity.User;

/**
 * @Author WangSongWen
 * @Date: Created in 16:35 2020/9/14
 * @Description:
 */
public interface UserService {
    User findUserByUserName(String username);
}
