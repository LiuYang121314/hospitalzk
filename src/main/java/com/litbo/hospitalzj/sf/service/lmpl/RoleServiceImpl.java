package com.litbo.hospitalzj.sf.service.lmpl;

import com.litbo.hospitalzj.sf.entity.Role;
import com.litbo.hospitalzj.sf.mapper.RoleMapper;
import com.litbo.hospitalzj.sf.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 角色业务层
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;
    @Override
    public List<Role> findAll() {
        return roleMapper.findAll();
    }
}
