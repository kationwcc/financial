package com.wccwin.financial.entity;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "f_user")
public class User implements Serializable{


    @Id
    @GeneratedValue
    private int id;

    @Size(min = 1, max = 20, message = "用户名应该设置长度在1-20之间")
    @Column(name = "name")
    private String name;

    @Size(min = 4, max = 20, message = "账号应该设置长度在1-20之间")
    @Column(name = "username", nullable = false)
    private String username;

    @Size(min = 6, max = 32, message = "密码长度在6-16位之间")
    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "token", nullable = false)
    private String token;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
