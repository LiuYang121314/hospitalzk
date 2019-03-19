package com.litbo.hospitalzj.quality.mapper;

import com.litbo.hospitalzj.quality.entity.UserPm;
import com.litbo.hospitalzj.quality.vo.UserPmVo;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 用户设备名关联
 */
@Mapper
public interface UserPmMapper {
    @Insert(" insert into user_pm (id, user_id,eq_pm_id,shr_id,state\n" +
            "      )\n" +
            "    values (#{id,jdbcType=INTEGER}, #{userId,jdbcType=VARCHAR}, #{eqPmId,jdbcType=VARCHAR},\n" +
            "      #{shrId},#{state})")
    int insert(UserPm userSb);
    @Delete("delete from user_pm where user_id = #{userId} AND eq_pm_id = #{eqPmId}")
    void delete(@Param("userId") String userId, @Param("eqPmId") String eqPmId);

    @Select("select count(*) from user_pm where user_id = #{userId} AND eq_pm_id = #{eqPmId}")
    int findNum(@Param("userId") String userId, @Param("eqPmId") String eqPmId);
    //查询状态设备品名名称
    @Select("select u.state,u.user_id,u.shr_id ,e.* from user_pm u left join eq_pm e on u.eq_pm_id=e.eq_pm_id where user_id=#{userId} and state=#{state}")
    List<UserPmVo> findByUserIdandState(@Param("userId") String userId, @Param("state")String state);
    //修改状态为待审核
    @Update("update user_pm set state=#{state} where user_id=#{userId} and eq_pm_id=#{eqPmId}")
    void setuserPmState(@Param("userId") String userId, @Param("eqPmId") String eqPmId, @Param("state") String state);
    //查询审核人
    @Select("select shr_id from user_pm where user_id=#{userId} and eq_pm_id=#{eqPmId}")
    String selectShrId(@Param("userId") String userId, @Param("eqPmId") String eqPmId);
    //查询待上报数量
    @Select("select count(*) from user_pm where user_id = #{userId} and state=#{state}")
    int dsbNum(@Param("userId") String userId, @Param("state") String state);
}
