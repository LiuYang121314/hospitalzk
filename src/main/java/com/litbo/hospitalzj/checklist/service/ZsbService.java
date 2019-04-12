package com.litbo.hospitalzj.checklist.service;

import com.litbo.hospitalzj.checklist.dao.ZsbMapper;
import com.litbo.hospitalzj.checklist.domain.StzsM;
import com.litbo.hospitalzj.checklist.domain.StzsMTemplate;
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
 * 注射泵Service层
 */
public interface ZsbService {
    //查询模板数据（成人，幼儿）
    SybCTemplate findTemplate(String tableName);
    //查询双通道模板数据，最后一条记录
    StzsMTemplate findStZsTemplate();
    //修改模板表数据
    //幼儿
    int updateC(SybCTemplate sybCTemplate);
    //成人
    int updateM(SybCTemplate sybCTemplate);
    //双通道
    int updateS(StzsMTemplate stzsMTemplate);
    //插入模板表数据
    //幼儿
    int insertChildTemplate(SybCTemplate template);
    //成人
    int insertManTemplate(SybCTemplate template);
    //双通道
    int insertStzsTemplate(StzsMTemplate template);
    //保存信息
    //输液泵检测信息录入（幼儿）
    void saveChild(SybC sybC);
    void updateChild(SybC sybC);
    //输液泵检测信息录入（成人）
    void saveMan(SybC sybC);
    void updateMan(SybC sybC);
    //插入双通道注射泵检测数据
    void saveStzs(StzsM stzsM);
    void updateStzs(StzsM stzsM);

    //根据设备Id,检测仪器Id以及状态查询电器表查询最后一条记录
    SybC findByEqIdandJcyqIdLast1C(@Param("eqId")String eqId, @Param("jcyqId")String jcyqId);

    //根据设备Id,检测仪器Id以及状态查询电器表
    List<SybC> findByEqIdandJcyqIdC(@Param("eqId")String eqId,@Param("jcyqId")String jcyqId);

    //根据设备Id,检测仪器Id以及状态查询电器表查询最后一条记录
    SybC findByEqIdandJcyqIdLast1M(@Param("eqId")String eqId, @Param("jcyqId")String jcyqId);
    //根据设备Id,检测仪器Id以及状态查询电器表
    List<SybC> findByEqIdandJcyqIdM(@Param("eqId")String eqId,@Param("jcyqId")String jcyqId);
    //根据设备Id,检测仪器Id以及状态查询电器表查询最后一条记录
    StzsM findByEqIdandJcyqIdLast1S(@Param("eqId")String eqId, @Param("jcyqId")String jcyqId);
    //根据设备Id,检测仪器Id以及状态查询电器表
    List<StzsM> findByEqIdandJcyqIdS(@Param("eqId")String eqId,@Param("jcyqId")String jcyqId);

    //查询所有检测表数据信息
    List<SybC> findAll(String tableName);
    List<StzsM> findAllS();

    /**
     * 根据iD状态查询
     */
    SybC findByid(@Param("id")Integer id,@Param("tableName")String tableName);
    StzsM findByidS(@Param("id")Integer id);
    //修改审核人意见
    void updateShrJcjyC(@Param("dqjcid")Integer dqjcid, @Param("shrJcjl")String shrJcjl, @Param("auditor")String auditor);
    void updateShrJcjyM(@Param("dqjcid")Integer dqjcid, @Param("shrJcjl")String shrJcjl, @Param("auditor")String auditor);
    void updateShrJcjyS(@Param("dqjcid")Integer dqjcid, @Param("shrJcjl")String shrJcjl, @Param("auditor")String auditor);

}

