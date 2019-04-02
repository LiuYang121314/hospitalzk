package com.litbo.hospitalzj.zk.service;

import com.litbo.hospitalzj.zk.domian.Ndjh;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 上报检测业务
 */
public interface NdjhService {
    Ndjh selectNdjh(Integer ndjhId);
    void insertNdjh(Ndjh ndjh);
    void deletENdjh(Integer ndjhId);
    List<Ndjh> selectByShrId(@Param("shrId")String shrId,@Param("state")String state);
    List<Ndjh> selectByUserId(String userId);
    void update(@Param("ndjhId")Integer ndjhId, @Param("state") String state);
    List<Ndjh> selectByUserIdAndState(@Param("userId")String userId,@Param("state")String state);
    void updateMonth(Integer ndjhId);
    //用户查询年度计划中各状态数量
    Integer jhCount(@Param("userId")String userId,@Param("state")String state);
    //管理员根据用户品名关联表和年度计划表查询待审核数量
    Integer dshCount(@Param("shrId")String shrId,@Param("state")String state);
    void updateNdjh(Ndjh ndjh);
}
