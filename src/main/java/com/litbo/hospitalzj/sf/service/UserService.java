package com.litbo.hospitalzj.sf.service;

import com.litbo.hospitalzj.sf.entity.User;
import com.litbo.hospitalzj.sf.vo.UserRoleVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService {
    //插入用户信息
    User insert(User user);
    //删除用户信息
    void delete(@Param("userId")String userId,@Param("isDelete")Integer isDelete);
    //通过用户Id查找用户信息
    UserRoleVo select(String userId);
    //用户登录
    UserRoleVo login(String userName, String userPwd);
    //查找全部用户信息
    List<UserRoleVo> findAll(@Param("offset")Integer offset, @Param("count") Integer count);
    //模糊查询用户信息
    List<UserRoleVo> findByNameLike(String userName);
    List<String> findRoleName();
    //修改用户信息
    void update(User user);
    //修改用户角色
    void updateRole(@Param("roleId")String roleId, @Param("userId")String userId);
    String findNameById(String userId);
}
