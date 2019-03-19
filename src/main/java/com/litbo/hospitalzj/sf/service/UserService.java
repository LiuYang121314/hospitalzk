package com.litbo.hospitalzj.sf.service;

import com.litbo.hospitalzj.sf.entity.User;

import java.util.List;

public interface UserService {
    void delete(String userId);
    User insert(User user);
    User select(String userId);
    void update(User user);
    User login(String userName, String userPwd);
    List<User> findAll();
    List<String> findRoleName();
}
