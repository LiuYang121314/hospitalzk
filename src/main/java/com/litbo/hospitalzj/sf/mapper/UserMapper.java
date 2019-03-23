package com.litbo.hospitalzj.sf.mapper;

import com.litbo.hospitalzj.sf.entity.User;
import com.litbo.hospitalzj.sf.vo.UserRoleVo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
    //插入用户
    @Insert(" insert into s_user (user_id, user_name, user_pwd, \n" +
            "      phone, bumen, address, \n" +
            "      status, role_id, bz\n" +
            "      )\n" +
            "    values (#{userId,jdbcType=VARCHAR}, #{userName,jdbcType=VARCHAR}, #{userPwd,jdbcType=VARCHAR}, \n" +
            "      #{phone,jdbcType=VARCHAR}, #{bumen,jdbcType=VARCHAR}, #{address,jdbcType=VARCHAR}, \n" +
            "      #{status,jdbcType=INTEGER}, #{roleId,jdbcType=VARCHAR}, #{bz,jdbcType=LONGVARCHAR}\n" +
            "      )")
    int insert(User user);
    //删除用户
    @Update("update s_user set is_delete=#{isDelete} where user_id = #{userId,jdbcType=VARCHAR}")
    int delete(@Param("userId")String userId,@Param("isDelete")Integer isDelete);
    //查找用户信息通过用户ID
    @Select("select s.*,r.role_name from s_user s left join s_role r on s.role_id=r.role_id where s.user_id=#{userId}")
    UserRoleVo select(String userId);
    //查询用户信息通过用户名
    @Select("select s.*,r.role_name from s_user s left join s_role r on s.role_id=r.role_id where s.user_name=#{userName}")
    UserRoleVo findByName(String userName);
    //查找全部用户信息
    @Select("select s.*,r.role_name from " +
            "s_user s left join s_role r on s.role_id=r.role_id where is_delete=0 ORDER BY user_id ASC\n" +
            "LIMIT #{offset}, #{count}")
    List<UserRoleVo> findAll(@Param("offset")Integer offset, @Param("count") Integer count);
    //模糊查询用户信息
    @Select("select s.*,r.role_name from s_user s left join s_role r on s.role_id=r.role_id where s.user_name LIKE '%#{userName}%' where is_delete=0")
    List<UserRoleVo> findByNameLike(String userName);

    @Select("select s_user.user_name from s_user where role_name=#{roleName}")
    List<String> findRoleName(String roleName);
    //修改用户信息
    @Update(" update s_user\n" +
            " set user_id = #{userId,jdbcType=VARCHAR},"+
            "     user_name = #{userName,jdbcType=VARCHAR},\n" +
            "      user_pwd = #{userPwd,jdbcType=VARCHAR},\n" +
            "      phone = #{phone,jdbcType=VARCHAR},\n" +
            "      bumen = #{bumen,jdbcType=VARCHAR},\n" +
            "      address = #{address,jdbcType=VARCHAR},\n" +
            "      is_delete = #{isDelete,jdbcType=INTEGER},\n" +
            "      status = #{status,jdbcType=INTEGER},\n" +
            "      bz = #{bz,jdbcType=LONGVARCHAR}\n" +
            "    where user_id = #{userId,jdbcType=VARCHAR}")
    int update(User user);
    //修改用户角色
    @Update("update s_user set role_id=#{role_id} where user_id")
    int updateRole(@Param("roleId")String roleId,@Param("userId")String userId);
}
