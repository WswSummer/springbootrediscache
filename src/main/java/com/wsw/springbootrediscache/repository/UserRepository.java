package com.wsw.springbootrediscache.repository;

import com.wsw.springbootrediscache.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author WangSongWen
 * @Date: Created in 16:35 2020/9/14
 * @Description:
 */
public interface UserRepository extends JpaRepository<User, Integer> {
    User findUserByUsername(String username);
}
