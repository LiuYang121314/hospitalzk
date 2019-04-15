package com.litbo.hospitalzj.checklist.service.Impl;

import com.litbo.hospitalzj.checklist.dao.SybMapper;
import com.litbo.hospitalzj.checklist.domain.SybC;
import com.litbo.hospitalzj.checklist.domain.SybCTemplate;
import com.litbo.hospitalzj.checklist.service.SybService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SybServiceImpl implements SybService {
    @Autowired
    private SybMapper sybMapper;
    //查询模板数据
    @Override
    public SybCTemplate findTemplate(String tableName) {
        return sybMapper.findTemplate(tableName);
    }
    //插入模板数据
    //幼儿
    @Override
    public void insertChildTemplate(SybCTemplate template) {
        sybMapper.insertChildTemplate(template);
    }
    //成人
    @Override
    public void insertManTemplate(SybCTemplate template) {
        sybMapper.insertManTemplate(template);
    }
    //修改模板数据
    //幼儿
    @Override
    public void updateC(SybCTemplate sybCTemplate){
        sybMapper.updateC(sybCTemplate);
    }
    //成人
    @Override
    public void updateM(SybCTemplate sybCTemplate){
        sybMapper.updateM(sybCTemplate);
    }
    //保存信息
    //儿童输液泵数据录入
    @Override
    public void saveChild(SybC sybC) {
        String tableName = "syb_c_template";
        SybCTemplate sybCTemplate = sybMapper.findTemplate(tableName);
        BeanUtils.copyProperties(sybCTemplate, sybC);
        sybMapper.saveChild(sybC);
    }

    @Override
    public void updateChild(SybC sybC) {
        sybMapper.updateChild(sybC);
    }

    @Override
    public void saveMan(SybC sybC) {
        String tableName = "syb_m_template";
        SybCTemplate sybCTemplate = sybMapper.findTemplate(tableName);
        BeanUtils.copyProperties(sybCTemplate,sybC);
        sybMapper.saveMan(sybC);
    }

    @Override
    public void updateMan(SybC sybC) {
        sybMapper.updateMan(sybC);
    }

    @Override
    public SybC findByEqIdandJcyqIdLast1C(String eqId, String jcyqId) {
        return sybMapper.findByEqIdandJcyqIdLast1C(eqId, jcyqId);
    }

    @Override
    public SybC findByEqIdandJcyqIdLast(String tableName, String eqId, String jcyqId) {
        return sybMapper.findByEqIdandJcyqIdLast(tableName,eqId,jcyqId);
    }

    @Override
    public List<SybC> findByEqIdandJcyqId(String tableName, String eqId, String jcyqId) {
        return sybMapper.findByEqIdandJcyqId(tableName, eqId, jcyqId);
    }

    @Override
    public List<SybC> findByEqIdandJcyqIdC(String eqId, String jcyqId) {
        return sybMapper.findByEqIdandJcyqIdC(eqId, jcyqId);
    }

    @Override
    public SybC findByEqIdandJcyqIdLast1M(String eqId, String jcyqId) {
        return sybMapper.findByEqIdandJcyqIdLast1M(eqId, jcyqId);
    }

    @Override
    public List<SybC> findByEqIdandJcyqIdM(String eqId, String jcyqId) {
        return sybMapper.findByEqIdandJcyqIdM(eqId, jcyqId);
    }

    @Override
    public SybC findByid(Integer id,String tableName) {
        return sybMapper.findByid(id,tableName);
    }

    @Override
    public List<SybC> findAll(String tableName) {
        return sybMapper.findAll(tableName);
    }

    @Override
    public void updateShrJcjyC(Integer id, String shrJcjl, String auditor) {
        sybMapper.updateShrJcjyC(id, shrJcjl, auditor, new Date());
    }

    @Override
    public void updateShrJcjyM(Integer id, String shrJcjl, String auditor) {
        sybMapper.updateShrJcjyM(id, shrJcjl, auditor, new Date());
    }


}
