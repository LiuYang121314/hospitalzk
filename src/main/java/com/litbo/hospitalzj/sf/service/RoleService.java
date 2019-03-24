package com.litbo.hospitalzj.sf.service;

import com.litbo.hospitalzj.sf.entity.Role;

import java.util.List;

/**
 * 角色业务层接口
 */
public interface RoleService {
    //查询所有角色
    List<Role> findAll();
}
