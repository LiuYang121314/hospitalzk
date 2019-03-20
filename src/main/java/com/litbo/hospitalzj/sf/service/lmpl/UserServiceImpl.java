package com.litbo.hospitalzj.sf.service.lmpl;

import com.litbo.hospitalzj.sf.entity.User;
import com.litbo.hospitalzj.sf.mapper.UserMapper;
import com.litbo.hospitalzj.sf.service.UserService;
import com.litbo.hospitalzj.supplier.service.exception.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
@Autowired
private UserMapper userMapper;
    @Override
    public void delete(String userId) {
        User data=userMapper.select(userId);
        if(data==null){
            throw new DeleteException("用户不存在");
        }
        userMapper.delete(userId);
    }

    @Override
    public User insert(User user) {
        User data=userMapper.select(user.getUserId());
        if(data!=null){
            throw new InsertException("用户已存在");
        }
        user.setStatus(0);
        userMapper.insert(user);
        return user;
    }

    @Override
    public User select(String userId) {
        return userMapper.select(userId);
    }

    @Override
    public void update(User user) {
        User data=userMapper.select(user.getUserId());
        if(data==null){
            throw new UpdateException("用户不存在");
        }
        userMapper.update(user);
    }

    @Override
    public User login(String userName, String userPwd) {
        // 根据参数username查询用户数据
        User data = userMapper.findByName(userName);
        // 判断用户数据是否为null
        if (data == null) {
            // 是：为null，用户名不存在，则抛出UserNotFoundException
            throw new UserNotFoundException(
                    "登录失败！您尝试登录的用户名不存在！");}
        if(userPwd.equals(data.getUserPwd())){
            return data;
        }else {
            // 否：不匹配，密码错误，则抛出PasswordNotMatchException
            throw new PasswordNotMatchException(
                    "登录失败！密码错误！");
        }

    }
    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }

    @Override
    public List<String> findRoleName() {
        return userMapper.findRoleName("超级管理员");
    }
}
