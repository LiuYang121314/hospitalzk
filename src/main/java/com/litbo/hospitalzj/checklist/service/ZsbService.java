package com.litbo.hospitalzj.checklist.service;

import com.litbo.hospitalzj.checklist.dao.ZsbMapper;
import com.litbo.hospitalzj.checklist.domain.StzsM;
import com.litbo.hospitalzj.checklist.domain.StzsMTemplate;
import com.litbo.hospitalzj.checklist.domain.SybC;
import com.litbo.hospitalzj.checklist.domain.SybCTemplate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 注射泵Service层
 */
@Service
@Transactional
public class ZsbService {

    @Autowired
    private ZsbMapper zsbMapper;

    //儿童输液泵数据录入
    public void saveChild(SybC sybC) {
        String tableName = "zsb_c";
        SybCTemplate sybCTemplate = findChildsTemplate();
        BeanUtils.copyProperties(sybCTemplate, sybC);
        zsbMapper.saveChild(sybC);
    }

    public void saveMan(SybC sybC) {
        String tableName = "zsb_m";
        SybCTemplate sybCTemplate = findManTemplate();
        BeanUtils.copyProperties(sybCTemplate,sybC);
        zsbMapper.saveMan(sybC);
    }

    //保存双通道注射泵检测信息
    public void saveStZs(StzsM stzsM) {
        StzsMTemplate stzsMTemplate = findStzsMTemplate();
        BeanUtils.copyProperties(stzsMTemplate, stzsM);
        zsbMapper.saveStzs(stzsM);
    }

    //查询双通道注射泵模板值
    public StzsMTemplate findStzsMTemplate(){
        return zsbMapper.findStZsTemplate();
    }
    //查询模板数据(幼儿)
    public SybCTemplate findChildsTemplate(){
        String template = "zsb_c_template";
        return zsbMapper.findTemplate(template);
    }
    //查询模板数据(成人)
    public SybCTemplate findManTemplate(){
        String template = "zsb_m_template";
        return zsbMapper.findTemplate(template);
    }
    //插入模板数据

    //查询所有录入信息(幼儿)
    public List<SybC> findAllChild(){
        String tableName = "zsb_m";
        return zsbMapper.findAll(tableName);
    }
    //查询所有录入信息（成人）
    public List<SybC> findAllMan(){
        String tableName = "zsb_m";
        return zsbMapper.findAll(tableName);
    }
    //查询所有双通道注射泵录入数据
    public List<StzsM> findAllStzsMan(){
        return zsbMapper.findAllStzsM();
    }
    //查询最后录入的一条检测信息（幼儿）
    public SybC findChild(){
        String tableName = "zsb_m";
        return zsbMapper.find(tableName);
    }
    //查询最后录入的一条检测信息(成人)
    public SybC findMan(){
        String tableName = "zsb_m";
        return zsbMapper.find(tableName);
    }
    //查询最后录入的一条双通道注射泵检测信息(成人)
    public StzsM findStzsMan(){
        return zsbMapper.findStzsM();
    }

    public void insertStzsTemplate(StzsMTemplate template) {
        zsbMapper.insertStzsTemplate(template);
    }

    public void insertManTemplate(SybCTemplate template) {
        zsbMapper.insertManTemplate(template);
    }

    public void insertChildTemplate(SybCTemplate template) {
        zsbMapper.insertChildTemplate(template);
    }
}
