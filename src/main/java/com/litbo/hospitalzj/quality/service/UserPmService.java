package com.litbo.hospitalzj.quality.service;

import com.litbo.hospitalzj.quality.entity.UserPm;
import com.litbo.hospitalzj.quality.vo.UserPmVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户设备名关联
 */
public interface UserPmService {
    void delete(@Param("userId") String userId, @Param("eqPmId") String eqPmId);
    void insert(UserPm userSb);
    List<UserPmVo> findByUserIdandState(@Param("userId") String userId, @Param("state")String state);
    void setuserPmState(@Param("userId") String userId, @Param("eqPmId") String eqPmId, @Param("state") String state);
    String selectShrId(@Param("userId") String userId, @Param("eqPmId") String eqPmId);
    //查询待上报数量
    int dsbNum(@Param("userId") String userId, @Param("state") String state);
}