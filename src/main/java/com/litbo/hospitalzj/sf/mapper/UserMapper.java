package com.litbo.hospitalzj.sf.mapper;

import com.litbo.hospitalzj.sf.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
    @Delete("  delete from s_user\n" +
            "    where user_id = #{userId,jdbcType=VARCHAR}")
    int delete(String userId);

    @Insert(" insert into s_user (user_id, user_name, user_pwd, \n" +
            "      status, role_name, bz\n" +
            "      )\n" +
            "    values (#{userId,jdbcType=VARCHAR}, #{userName,jdbcType=VARCHAR}, #{userPwd,jdbcType=VARCHAR}, \n" +
            "      #{status,jdbcType=INTEGER}, #{roleName,jdbcType=VARCHAR}, #{bz,jdbcType=LONGVARCHAR}\n" +
            "      )")
    int insert(User user);

    @Select("select * from s_user where user_id=#{userId}")
    User select(String userId);

    @Select("select * from s_user where user_name=#{userName}")
    User findByName(String userName);

    @Select("select * from s_user")
    List<User> findAll();

    @Update("update s_user\n" +
            "    set user_name = #{userName,jdbcType=VARCHAR},\n" +
            "      user_pwd = #{userPwd,jdbcType=VARCHAR},\n" +
            "      status = #{status,jdbcType=INTEGER},\n" +
            "      role_name = #{roleName,jdbcType=VARCHAR},\n" +
            "    where user_id = #{userId,jdbcType=VARCHAR}")
    int update(User user);
    @Select("select s_user.user_name from s_user where role_name=#{roleName}")
    List<String> findRoleName(String roleName);
}
