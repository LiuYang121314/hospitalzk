package com.litbo.hospitalzj.supplier.service;

import com.litbo.hospitalzj.supplier.entity.SuInfo;
import com.litbo.hospitalzj.supplier.vo.SuInfoAndZzInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SuInfoService {
    void insert(SuInfo suInfo);
    void delete(@Param("suId") Integer suId, @Param("isDelete") Integer isDelete);
    void update(SuInfo suInfo);
    void updateState(@Param("suId") Integer suId,@Param("state") Integer state);
    List<SuInfo> selectAll();
    SuInfoAndZzInfo findSuById(Integer suId);
    List<SuInfo> findBySuMcLike(@Param("suMc") String suMc);
    Integer count(Integer state);
    List<SuInfo> findSuByState(Integer state);
}
