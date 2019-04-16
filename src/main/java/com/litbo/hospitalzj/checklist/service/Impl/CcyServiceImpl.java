package com.litbo.hospitalzj.checklist.service.Impl;

import com.litbo.hospitalzj.checklist.dao.CcyMapper;
import com.litbo.hospitalzj.checklist.domain.Ccy;
import com.litbo.hospitalzj.checklist.domain.CcyTemplate;
import com.litbo.hospitalzj.checklist.service.CcyService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CcyServiceImpl implements CcyService {
    @Autowired
    private CcyMapper ccyMapper;
    @Override
    public CcyTemplate findTemplate() {
        return ccyMapper.findTemplate();
    }

    @Override
    public CcyTemplate findTemplateById(Integer ccYtemplateId) {
        return ccyMapper.findTemplateById(ccYtemplateId);
    }

    @Override
    public void updateTemplate(CcyTemplate ccyTemplate) {
        ccyMapper.updateTemplate(ccyTemplate);
    }

    @Override
    public void insertTemplate(CcyTemplate ccyTemplate) {
        ccyMapper.insertTemplate(ccyTemplate);
    }

    @Override
    public void save(Ccy ccy) {
        CcyTemplate ccyTemplate = ccyMapper.findTemplate();
        BeanUtils.copyProperties(ccyTemplate, ccy);
        ccyMapper.save(ccy);
    }

    @Override
    public Ccy findCcy(String eqId) {
        return ccyMapper.findCcy(eqId);
    }

    @Override
    public Ccy findByEqIdandJcyqIdLast1(String eqId, String jcyqId) {
        return ccyMapper.findByEqIdandJcyqIdLast1(eqId, jcyqId);
    }

    @Override
    public List<Ccy> findByEqIdandJcyqId(String eqId, String jcyqId) {
        return ccyMapper.findByEqIdandJcyqId(eqId, jcyqId);
    }

    @Override
    public List<Ccy> findAll() {
        return ccyMapper.findAll();
    }

    @Override
    public Ccy findByCcyId(Integer ccyId) {
        return ccyMapper.findByCcyId(ccyId);
    }

    @Override
    public void updateShrJcjy(Integer ccyId, String shrJcjl, String auditor) {
        ccyMapper.updateShrJcjy(ccyId, shrJcjl, auditor, new Date());
    }
}
