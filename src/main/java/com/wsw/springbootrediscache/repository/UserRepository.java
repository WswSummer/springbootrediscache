package com.wsw.springbootrediscache.repository;

import com.wsw.springbootrediscache.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @Author WangSongWen
 * @Date: Created in 16:35 2020/9/14
 * @Description:
 */
public interface UserRepository extends JpaRepository<User, Integer> {
    User findUserByUsername(String username);

    @Query(value = "select * from user where password = ?1", nativeQuery = true)
    List<User> findUserByPassword(String password);

    @Transactional
    @Modifying
    @Query(value = "delete from user where username = ?1", nativeQuery = true)
    void deleteItByUsername(String username);

    @Transactional
    @Modifying
    @Query(value = "update user set username = ?1 where id = ?2", nativeQuery = true)
    int updateUserByid(String username, Integer id);
}
