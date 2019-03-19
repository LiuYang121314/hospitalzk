package com.litbo.hospitalzj.zk.mapper;

import com.litbo.hospitalzj.zk.domian.EqInfo;
import com.litbo.hospitalzj.zk.vo.UserEqAndEqInfo;
import com.litbo.hospitalzj.zk.vo.UserEqVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * vo持久层
 */
@Mapper
public interface UserEqEqInfoMapper {
    @Select("SELECT ue.jc_eqid,ue.user_id,su.user_name,ei.* from " +
            " user_eq ue left join s_user su on su.user_id=ue.user_id left " +
            "join eq_info ei on ei.eq_id=ue.jc_eqid left join yq_eq on ue.jc_eqid=yq_eq.eq_id " +
            " where ue.state='待审核' and shr_id=#{shrId} and yq_eq.state=#{state}")
    List<UserEqAndEqInfo> select(@Param("shrId") String shrId);

    //根据审核人id查询待审核
    @Select("SELECT e.*,u.state,u.jc_eqid,s.user_name,u.user_id FROM user_eq u left join eq_info e on u.jc_eqid =e.eq_id left join s_user s on s.user_id=u.user_id where u.shr_id=#{shrId} and u.state=#{state}")
    List<UserEqVo> findUserEqVo(@Param("shrId")String shrId, @Param("state")String state);

    //根据审核人id查询待审核数量
    @Select("SELECT count(*) FROM user_eq u left join eq_info e on u.jc_eqid =e.eq_id left join s_user s on s.user_id=u.user_id where u.shr_id=#{shrId} and u.state=#{state}")
    int findByShrIdEqDshCount(@Param("shrId")String shrId, @Param("state")String state);

    //根据用户id查询待审核
    @Select("SELECT e.*,u.state,u.jc_eqid,s.user_name FROM user_eq u left join eq_info e on u.jc_eqid =e.eq_id left join s_user s on s.user_id=u.user_id where u.user_id=#{userId} and u.state=#{state}")
    List<UserEqVo> findUserEqVoY(@Param("userId")String userId, @Param("state")String state);


}
