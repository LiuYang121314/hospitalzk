package com.litbo.hospitalzj.sf.controller;

import com.litbo.hospitalzj.controller.BaseController;
import com.litbo.hospitalzj.sf.entity.User;
import com.litbo.hospitalzj.sf.service.UserService;
import com.litbo.hospitalzj.util.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController extends BaseController {
    @Autowired
    private UserService userService;
    @RequestMapping("/login")
    public ResponseResult<User> login
            (@RequestParam("userName") String userName,
             @RequestParam("userPwd") String userPwd,
             HttpSession session) {
        User data=userService.login(userName,userPwd);
        // 将相关信息存入到Session
        session.setAttribute("uid", data.getUserId());
        session.setAttribute("userName", data.getUserName());
        return new ResponseResult<User>(SUCCESS,data.getRoleName());
    }
    @RequestMapping("/{userId}")
    public ResponseResult<User> getByCode(@PathVariable("userId") String userId) {
        User data=userService.select(userId);
        return new ResponseResult<User>(SUCCESS,data);
    }
    @RequestMapping("all")
    public ResponseResult<List<User>> getAll() {
        List<User> data=userService.findAll();
        return new ResponseResult<List<User>>(SUCCESS,data);
    }
    @RequestMapping("/insert")
    public ResponseResult<Void> insert(User user) {
        userService.insert(user);
        return new ResponseResult<Void>(SUCCESS);
    }
    @RequestMapping("/delete")
    public ResponseResult<Void> delete(String userId) {
        userService.delete(userId);
        return new ResponseResult<Void>(SUCCESS);
    }
    @RequestMapping("/update")
    public ResponseResult<User> update(User user) {
        userService.update(user);
        return new ResponseResult<User>(SUCCESS);
    }

}
