package com.litbo.hospitalzj.zk.service;

import com.litbo.hospitalzj.zk.domian.YqJxjl;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface YqJxjlService {
    List<YqJxjl> selectAll();
    void insert(YqJxjl yqJxjl);
    void update(YqJxjl yqJxjl);
    void updateState(@Param("state") Integer state, @Param("id")Integer id);
    List<YqJxjl> selectNew();
}
