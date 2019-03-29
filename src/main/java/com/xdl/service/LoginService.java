package com.xdl.service;

import com.xdl.bean.User;
import com.xdl.mapper.ShiroMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@MapperScan(basePackages = {"com.xdl.mapper"})
public class LoginService {

    @Autowired
    private ShiroMapper shiroMapper;


    public List<User> findAllUser(){

        List<User> users = shiroMapper.findAllUser();
        return users;

    }

    public User findByName(String name){
        User user = shiroMapper.findByName(name);
        return user;

    }

    public Set<String> findPermission(String name){

        Set<String> permissions = shiroMapper.findPermission(name);
        return permissions;

    }

    public Set<String> findRoles(String name){
        Set<String> roles = shiroMapper.findRoles(name);
        return roles;

    }


}































