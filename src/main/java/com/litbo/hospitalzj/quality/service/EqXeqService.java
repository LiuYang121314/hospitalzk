package com.litbo.hospitalzj.quality.service;

import com.litbo.hospitalzj.quality.entity.EqPm;
import com.litbo.hospitalzj.quality.entity.EqXeq;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface EqXeqService {

    void update(EqXeq eqXeq);


    void insert(EqXeq eqXeq);


    void delete(Integer id);

    List<EqXeq> all();

    List<EqXeq> findEqXeqLike(@Param("data")String data);


}
