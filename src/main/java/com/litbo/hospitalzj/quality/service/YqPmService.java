package com.litbo.hospitalzj.quality.service;

import com.litbo.hospitalzj.quality.entity.YqPm;
import org.apache.ibatis.annotations.Param;

/**
 * 设备品名服务层接口
 */

public interface YqPmService {
    void insert(YqPm yqPm);
    void delete(@Param("yqId") String yqId, @Param("eqPmId") String eqPmId);
}
