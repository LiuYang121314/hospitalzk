package com.litbo.hospitalzj.checklist.service.Impl;

import com.litbo.hospitalzj.checklist.dao.ZsbMapper;
import com.litbo.hospitalzj.checklist.domain.StzsM;
import com.litbo.hospitalzj.checklist.domain.StzsMTemplate;
import com.litbo.hospitalzj.checklist.domain.SybC;
import com.litbo.hospitalzj.checklist.domain.SybCTemplate;
import com.litbo.hospitalzj.checklist.service.ZsbService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ZsbServiceImpl implements ZsbService {
    @Autowired
    private ZsbMapper zsbMapper;

    @Override
    public SybCTemplate findTemplate(String tableName) {
        return zsbMapper.findTemplate(tableName);
    }

    @Override
    public StzsMTemplate findStZsTemplate() {
        return zsbMapper.findStZsTemplate();
    }

    @Override
    public int updateC(SybCTemplate sybCTemplate) {
        return zsbMapper.updateC(sybCTemplate);
    }

    @Override
    public int updateM(SybCTemplate sybCTemplate) {
        return zsbMapper.updateM(sybCTemplate);
    }

    @Override
    public int updateS(StzsMTemplate stzsMTemplate) {
        return zsbMapper.updateS(stzsMTemplate);
    }

    @Override
    public int insertChildTemplate(SybCTemplate template) {
        return zsbMapper.insertChildTemplate(template);
    }

    @Override
    public int insertManTemplate(SybCTemplate template) {
        return zsbMapper.insertManTemplate(template);
    }

    @Override
    public int insertStzsTemplate(StzsMTemplate template) {
        return zsbMapper.insertStzsTemplate(template);
    }

    @Override
    public void saveChild(SybC sybC) {
        String tableName = "zsb_c_template";
        SybCTemplate sybCTemplate = zsbMapper.findTemplate(tableName);
        BeanUtils.copyProperties(sybCTemplate, sybC);
        zsbMapper.saveChild(sybC);
    }

    @Override
    public void updateChild(SybC sybC) {
        zsbMapper.updateChild(sybC);
    }

    @Override
    public void saveMan(SybC sybC) {
        String tableName = "zsb_m_template";
        SybCTemplate sybCTemplate = zsbMapper.findTemplate(tableName);
        BeanUtils.copyProperties(sybCTemplate, sybC);
        zsbMapper.saveMan(sybC);
    }

    @Override
    public void updateMan(SybC sybC) {
        zsbMapper.updateMan(sybC);
    }

    @Override
    public void saveStzs(StzsM stzsM) {
        StzsMTemplate stzsMTemplate = zsbMapper.findStZsTemplate();
        BeanUtils.copyProperties(stzsMTemplate, stzsM);
        zsbMapper.saveStzs(stzsM);
    }

    @Override
    public void updateStzs(StzsM stzsM) {
        zsbMapper.updateStzs(stzsM);
    }

    @Override
    public SybC findByEqIdandJcyqIdLast1C(String eqId, String jcyqId) {
        return zsbMapper.findByEqIdandJcyqIdLast1C(eqId, jcyqId);
    }

    @Override
    public List<SybC> findByEqIdandJcyqIdC(String eqId, String jcyqId) {
        return zsbMapper.findByEqIdandJcyqIdC(eqId, jcyqId);
    }

    @Override
    public SybC findByEqIdandJcyqIdLast1M(String eqId, String jcyqId) {
        return zsbMapper.findByEqIdandJcyqIdLast1M(eqId, jcyqId);
    }

    @Override
    public List<SybC> findByEqIdandJcyqIdM(String eqId, String jcyqId) {
        return zsbMapper.findByEqIdandJcyqIdM(eqId, jcyqId);
    }

    @Override
    public StzsM findByEqIdandJcyqIdLast1S(String eqId, String jcyqId) {
        return zsbMapper.findByEqIdandJcyqIdLast1S(eqId, jcyqId);
    }

    @Override
    public List<StzsM> findByEqIdandJcyqIdS(String eqId, String jcyqId) {
        return zsbMapper.findByEqIdandJcyqIdS(eqId, jcyqId);
    }

    @Override
    public List<SybC> findAll(String tableName) {
        return zsbMapper.findAll(tableName);
    }

    @Override
    public List<StzsM> findAllS() {
        return zsbMapper.findAllS();
    }

    @Override
    public SybC findByid(Integer id, String tableName) {
        return zsbMapper.findByid(id, tableName);
    }

    @Override
    public StzsM findByidS(Integer id) {
        return zsbMapper.findByidS(id);
    }

    @Override
    public void updateShrJcjyC(Integer dqjcid, String shrJcjl, String auditor, Date shsjTime) {
        zsbMapper.updateShrJcjyC(dqjcid, shrJcjl, auditor, new Date());
    }

    @Override
    public void updateShrJcjyM(Integer dqjcid, String shrJcjl, String auditor, Date shsjTime) {
        zsbMapper.updateShrJcjyM(dqjcid, shrJcjl, auditor, new Date());
    }

    @Override
    public void updateShrJcjyS(Integer dqjcid, String shrJcjl, String auditor, Date shsjTime) {
        zsbMapper.updateShrJcjyS(dqjcid, shrJcjl, auditor, new Date());
    }
}
