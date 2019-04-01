package com.litbo.hospitalzj.user.service;

import com.litbo.hospitalzj.user.bean.EqZjls;
import com.litbo.hospitalzj.user.bean.MonCount;

import java.util.List;

public interface EqZjlsService {
    int delete(Integer dzId);
    int insert(EqZjls eqZjls);
    List<EqZjls> selectAll();
    EqZjls select(Integer dzId);
    List<MonCount> count(String tester);
    List<EqZjls> selectEq(Integer eqId);
}
