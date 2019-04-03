package com.litbo.hospitalzj.supplier.service;

import com.litbo.hospitalzj.supplier.entity.SuInfo;
import com.litbo.hospitalzj.supplier.entity.ZzInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ZzInfoService {
    void insert(ZzInfo zzInfo);
    void update(ZzInfo zzInfo);
    ZzInfo findZzById(Integer suId);
}
