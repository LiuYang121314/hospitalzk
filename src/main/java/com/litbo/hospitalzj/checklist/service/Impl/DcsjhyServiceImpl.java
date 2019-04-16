package com.litbo.hospitalzj.checklist.service.Impl;

import com.litbo.hospitalzj.checklist.dao.DcsjhyMapper;
import com.litbo.hospitalzj.checklist.domain.Dcsjhy;
import com.litbo.hospitalzj.checklist.domain.DcsjhyTemplate;
import com.litbo.hospitalzj.checklist.domain.SybC;
import com.litbo.hospitalzj.checklist.service.DcsjhyService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DcsjhyServiceImpl implements DcsjhyService {
    @Autowired
    private DcsjhyMapper dcsjhyMapper;

    @Override
    public DcsjhyTemplate findTemplate_m() {
        return dcsjhyMapper.findTemplate_m();
    }

    @Override
    public DcsjhyTemplate findTemplate_c() {
        return dcsjhyMapper.findTemplate_c();
    }

    @Override
    public DcsjhyTemplate findTemplateById(Integer dcTemplateid, String tableName) {
        return dcsjhyMapper.findTemplateById(dcTemplateid,tableName);
    }

    @Override
    public void updateM(DcsjhyTemplate dcsjhyTemplate) {
        dcsjhyMapper.updateM(dcsjhyTemplate);
    }

    @Override
    public void updateC(DcsjhyTemplate dcsjhyTemplate) {
        dcsjhyMapper.updateC(dcsjhyTemplate);
    }

    @Override
    public void insertM(DcsjhyTemplate dcsjhyTemplate) {
        dcsjhyMapper.insertM(dcsjhyTemplate);
    }

    @Override
    public void insertC(DcsjhyTemplate dcsjhyTemplate) {
        dcsjhyMapper.insertC(dcsjhyTemplate);
    }

    @Override
    public void saveMan(Dcsjhy dcsjhy) {
        DcsjhyTemplate template = dcsjhyMapper.findTemplate_m();
        BeanUtils.copyProperties(template, dcsjhy);
        dcsjhyMapper.saveMan(dcsjhy);
    }

    @Override
    public void updateMen(Dcsjhy dcsjhy) {
        dcsjhyMapper.updateMen(dcsjhy);
    }

    @Override
    public void saveChild(Dcsjhy dcsjhy) {
        DcsjhyTemplate template = dcsjhyMapper.findTemplate_c();
        BeanUtils.copyProperties(template, dcsjhy);
        dcsjhyMapper.saveChild(dcsjhy);
    }

    @Override
    public void updateChild(Dcsjhy dcsjhy) {
        dcsjhyMapper.updateChild(dcsjhy);
    }
    @Override
    public Dcsjhy findByEqIdandJcyqIdLast(String tableName, String eqId, String jcyqId) {
        return dcsjhyMapper.findByEqIdandJcyqIdLast(tableName,eqId,jcyqId);
    }

    @Override
    public List<Dcsjhy> findByEqIdandJcyqId(String tableName, String eqId, String jcyqId) {
        return dcsjhyMapper.findByEqIdandJcyqId(tableName, eqId, jcyqId);
    }


    @Override
    public List<Dcsjhy> findDcsjhyMans() {
        return dcsjhyMapper.findDcsjhyMans();
    }

    @Override
    public List<Dcsjhy> findDcsjhyChilds() {
        return dcsjhyMapper.findDcsjhyChilds();
    }

    @Override
    public Dcsjhy findByDcidM(Integer dcid) {
        return dcsjhyMapper.findByDcidM(dcid);
    }

    @Override
    public Dcsjhy findByDcidC(Integer dcid) {
        return dcsjhyMapper.findByDcidC(dcid);

    }
    @Override
    public void updateShrJcjyM(Integer dcid, String shrJcjl, String auditor) {
        dcsjhyMapper.updateShrJcjyM(dcid, shrJcjl, auditor, new Date());
    }

    @Override
    public void updateShrJcjyC(Integer dcid, String shrJcjl, String auditor) {
        dcsjhyMapper.updateShrJcjyC(dcid, shrJcjl, auditor, new Date());
    }
}
