package com.litbo.hospitalzj.sf.service;

import com.litbo.hospitalzj.sf.entity.UserRole;
import org.apache.ibatis.annotations.Param;

//用户角色业务层接口
public interface UserRoleService {
    //插入用户角色
    void insert(UserRole userRole);
    //删除用户角色
    void delete(@Param("userId") String userId, @Param("roleId") String roleId);
}
