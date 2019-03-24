package com.litbo.hospitalzj.sf.mapper;

import com.litbo.hospitalzj.sf.entity.UserRole;
import org.apache.ibatis.annotations.*;

//用户角色持久层
@Mapper
public interface UserRoleMapper {
    //删除用户角色
    @Delete("delete from s_user_role\n" +
            "    where user_id = #{userId,jdbcType=VARCHAR}\n" +
            "    and role_id = #{roleId,jdbcType=VARCHAR}")
    int delete(@Param("userId") String userId,@Param("roleId") String roleId);
    //插入用户角色
    @Insert(" insert into s_user_role (user_id, role_id)\n" +
            "    values (#{userId,jdbcType=VARCHAR}, #{roleId,jdbcType=VARCHAR})")
    int insert(UserRole userRole);
    /*//修改角色
    @Update("update s_user_role\n" +
            "set role_id = #{roleId,jdbcType=VARCHAR}" +
            "where user_id=#{userId}")
    int update(@Param("userId") String userId,@Param("roleId") String roleId);*/
}
