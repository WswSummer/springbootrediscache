package com.wsw.springbootrediscache.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @Author WangSongWen
 * @Date: Created in 16:34 2020/9/14
 * @Description:
 */
@Data
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private Date createtime;
}
