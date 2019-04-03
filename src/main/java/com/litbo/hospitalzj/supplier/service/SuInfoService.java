package com.litbo.hospitalzj.supplier.service;

import com.litbo.hospitalzj.supplier.entity.SuInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SuInfoService {
    void insert(SuInfo suInfo);
    void delete(@Param("suId") Integer suId, @Param("isDelete") Integer isDelete);
    void update(SuInfo suInfo);
    List<SuInfo> selectAll(@Param("offset")Integer offset, @Param("count") Integer count);
    SuInfo findSuById(Integer suId);
    List<SuInfo> findBySuMcLike(@Param("suMc") String suMc);
}
