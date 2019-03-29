package com.xdl.mapper;

import com.xdl.bean.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface ShiroMapper {

    public List<User> findAllUser();

    public User findByName(String name);

    public Set<String> findRoles(String name);

    public Set<String> findPermission(String name);


}
