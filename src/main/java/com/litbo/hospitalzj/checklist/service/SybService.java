package com.litbo.hospitalzj.checklist.service;

import com.litbo.hospitalzj.checklist.dao.SybMapper;
import com.litbo.hospitalzj.checklist.domain.SybC;
import com.litbo.hospitalzj.checklist.domain.SybCTemplate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 输液泵Service层
 */
@Service
@Transactional
public class SybService {

    @Autowired
    private SybMapper sybMapper;
    //查询模板数据(幼儿)
    public SybCTemplate findChildTemplate(){
        String template = "syb_c_template";
        return sybMapper.findTemplate(template);
    }
    //查询模板数据(成人)
    public SybCTemplate findManTemplate(){
        String template = "syb_m_template";
        return sybMapper.findTemplate(template);
    }
    //插入模板数据
    //幼儿
    public void insertChildTemplate(SybCTemplate template) {
        sybMapper.insertChildTemplate(template);
    }
    //成人
    public void insertManTemplate(SybCTemplate template) {
        sybMapper.insertManTemplate(template);
    }
    //修改模板数据
    //幼儿
    public void updateC(SybCTemplate sybCTemplate){
        sybMapper.updateC(sybCTemplate);
    }
    //成人
    public void updateM(SybCTemplate sybCTemplate){
        sybMapper.updateM(sybCTemplate);
    }
    //保存信息
    //儿童输液泵数据录入
    public void saveChild(SybC sybC) {
        String template = "syb_c_template";
        String tableName = "syb_c";
        SybCTemplate sybCTemplate = sybMapper.findTemplate(template);
        BeanUtils.copyProperties(sybCTemplate, sybC);
        sybMapper.saveChild(sybC);
    }

    public void saveMan(SybC sybC) {
        String template = "syb_m_template";
        String tableName = "syb_m";
        SybCTemplate sybCTemplate = sybMapper.findTemplate(template);
        BeanUtils.copyProperties(sybCTemplate,sybC);
        sybMapper.saveMan(sybC);
    }

    //查询所有录入信息(幼儿)
    public List<SybC> findAllChild(){
        String tableName = "syb_m";
        return sybMapper.findAll(tableName);
    }
    //查询所有录入信息（成人）
    public List<SybC> findAllMan(){
        String tableName = "syb_m";
        return sybMapper.findAll(tableName);
    }
    //查询最后录入的一条检测信息（幼儿）
    public SybC findChild(){
        String tableName = "syb_m";
        return sybMapper.find(tableName);
    }
    //查询最后录入的一条检测信息(成人)
    public SybC findMan(){
        String tableName = "syb_m";
        return sybMapper.find(tableName);
    }


}
