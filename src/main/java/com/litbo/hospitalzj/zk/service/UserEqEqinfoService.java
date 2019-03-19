package com.litbo.hospitalzj.zk.service;

import com.litbo.hospitalzj.zk.vo.UserEqAndEqInfo;
import com.litbo.hospitalzj.zk.vo.UserEqVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserEqEqinfoService {
    List<UserEqAndEqInfo> select(@Param("shrId") String shrId);

    //根据审核人id查询待审核
    List<UserEqVo> findUserEqVo(@Param("shrId")String shrId, @Param("state")String state);
    //根据审核人id查询待审核数量
    int findByShrIdEqDshCount(@Param("shrId")String shrId, @Param("state")String state);
    //根据用户id查询待审核
    List<UserEqVo> findUserEqVoY(@Param("userId")String userId, @Param("state")String state);
}
