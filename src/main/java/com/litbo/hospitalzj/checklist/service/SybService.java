package com.litbo.hospitalzj.checklist.service;

import com.litbo.hospitalzj.checklist.dao.SybMapper;
import com.litbo.hospitalzj.checklist.domain.SybC;
import com.litbo.hospitalzj.checklist.domain.SybCTemplate;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * 输液泵Service层
 */
public interface SybService {
    //查询模板数据
    SybCTemplate findTemplate(String tableName);
    //修改模板表数据
    //幼儿
    void updateC(SybCTemplate sybCTemplate);
    //成人
    void updateM(SybCTemplate sybCTemplate);
    //插入模板表数据
    //幼儿
    void insertChildTemplate(SybCTemplate template);
    //成人
    void insertManTemplate(SybCTemplate template);
    //保存信息
    //输液泵检测信息录入（幼儿）
    void saveChild(SybC sybC);
    void updateChild(SybC sybC);
    //输液泵检测信息录入（成人）
    void saveMan(SybC sybC);
    void updateMan(SybC sybC);

    //根据设备Id,检测仪器Id以及状态查询电器表查询最后一条记录
    SybC findByEqIdandJcyqIdLast1C(@Param("eqId")String eqId, @Param("jcyqId")String jcyqId);

    //根据设备Id,检测仪器Id以及状态查询电器表
    List<SybC> findByEqIdandJcyqIdC(@Param("eqId")String eqId,@Param("jcyqId")String jcyqId);

    //根据设备Id,检测仪器Id以及状态查询电器表查询最后一条记录
    SybC findByEqIdandJcyqIdLast1M(@Param("eqId")String eqId, @Param("jcyqId")String jcyqId);

    //根据设备Id,检测仪器Id以及状态查询电器表
    List<SybC> findByEqIdandJcyqIdM(@Param("eqId")String eqId,@Param("jcyqId")String jcyqId);

    /**
     * 根据iD状态查询
     */
    SybC findByid(@Param("id")Integer id,@Param("tableName")String tableName);
    //查询所有数据信息
    List<SybC> findAll(String tableName);

    //修改审核人意见
    void updateShrJcjyC(@Param("id")Integer id, @Param("shrJcjl")String shrJcjl, @Param("auditor")String auditor);
    void updateShrJcjyM(@Param("id")Integer id, @Param("shrJcjl")String shrJcjl, @Param("auditor")String auditor);



}
