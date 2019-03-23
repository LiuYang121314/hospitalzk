package com.litbo.hospitalzj.sf.service.lmpl;

import com.litbo.hospitalzj.sf.entity.UserRole;
import com.litbo.hospitalzj.sf.mapper.UserRoleMapper;
import com.litbo.hospitalzj.sf.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户角色业务类
 */
@Service
public class UserRoleServiceImpl implements UserRoleService {
    @Autowired
    private UserRoleMapper userRoleMapper;
    //插入用户角色
    @Override
    public void insert(UserRole userRole) {
        userRoleMapper.insert(userRole);
    }
    //删除用户角色
    @Override
    public void delete(String userId, String roleId) {
        userRoleMapper.delete(userId,roleId);
    }
}
