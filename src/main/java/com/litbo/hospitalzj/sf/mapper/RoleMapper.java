package com.litbo.hospitalzj.sf.mapper;

import com.litbo.hospitalzj.sf.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 角色持久层
 */
@Mapper
public interface RoleMapper {
    //查询所有角色
    @Select("select * from s_role")
    List<Role> findAll();
}
