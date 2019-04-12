package com.litbo.hospitalzj.checklist.service;

import com.litbo.hospitalzj.checklist.domain.Yepyx;
import com.litbo.hospitalzj.checklist.domain.YepyxTemplate;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

public interface YepyxService {
    //查询婴儿培养箱检测模板表
    public YepyxTemplate findTemplate();
    //修改模板表数据
    public YepyxTemplate updateTemplate(YepyxTemplate yepyxTemplate);
    //插入模板表数据
    void insertTemplate(YepyxTemplate yepyxTemplate);

    //修改数据
    void update(Yepyx yepyx);
    //保存婴儿培养箱检测数据

    public void save(Yepyx yepyx);

    //根据婴儿培养箱id查询设备检测表

    public Yepyx findYepyx(String eqId);

    //以id排序，查询最后一条记录
    Yepyx find();

    //根据设备Id,检测仪器Id以及状态查询电器表查询最后一条记录
    Yepyx findByEqIdandJcyqIdLast1(@Param("eqId")String eqId, @Param("jcyqId")String jcyqId);

    //根据设备Id,检测仪器Id以及状态查询电器表
    List<Yepyx> findByEqIdandJcyqId(@Param("eqId")String eqId, @Param("jcyqId")String jcyqId);

    //查询所有检测表数据信息
    List<Yepyx> findAll();

    //根据iD状态查询
    Yepyx findByPyxId(@Param("pyxId")Integer pyxId);

    //修改状态
   /* void updateState(@Param("pyxId")Integer pyxId,@Param("state")Integer state);*/

    //修改审核人意见
    void updateShrJcjy(@Param("pyxId")Integer pyxId,@Param("shrJcjl")String shrJcjl,@Param("auditor")String auditor);

}
