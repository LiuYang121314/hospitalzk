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
        return null;
    }

    @Override
    public StzsMTemplate findStZsTemplate() {
        return null;
    }

    @Override
    public int updateC(SybCTemplate sybCTemplate) {
        return 0;
    }

    @Override
    public int updateM(SybCTemplate sybCTemplate) {
        return 0;
    }

    @Override
    public int updateS(StzsMTemplate stzsMTemplate) {
        return 0;
    }

    @Override
    public int insertChildTemplate(SybCTemplate template) {
        return 0;
    }

    @Override
    public int insertManTemplate(SybCTemplate template) {
        return 0;
    }

    @Override
    public int insertStzsTemplate(StzsMTemplate template) {
        return 0;
    }

    @Override
    public void saveChild(SybC sybC) {

    }

    @Override
    public void updateChild(SybC sybC) {

    }

    @Override
    public void saveMan(SybC sybC) {

    }

    @Override
    public void updateMan(SybC sybC) {

    }

    @Override
    public void saveStzs(StzsM stzsM) {

    }

    @Override
    public void updateStzs(StzsM stzsM) {

    }

    @Override
    public SybC findByEqIdandJcyqIdLast1C(String eqId, String jcyqId) {
        return null;
    }

    @Override
    public List<SybC> findByEqIdandJcyqIdC(String eqId, String jcyqId) {
        return null;
    }

    @Override
    public SybC findByEqIdandJcyqIdLast1M(String eqId, String jcyqId) {
        return null;
    }

    @Override
    public List<SybC> findByEqIdandJcyqIdM(String eqId, String jcyqId) {
        return null;
    }

    @Override
    public StzsM findByEqIdandJcyqIdLast1S(String eqId, String jcyqId) {
        return null;
    }

    @Override
    public List<StzsM> findByEqIdandJcyqIdS(String eqId, String jcyqId) {
        return null;
    }

    @Override
    public List<SybC> findAll(String tableName) {
        return null;
    }

    @Override
    public List<StzsM> findAllS() {
        return null;
    }

    @Override
    public SybC findByidC(Integer id, String tableName) {
        return zsbMapper.findByidC(id, tableName);
    }

    @Override
    public StzsM findByidS(Integer id) {
        return null;
    }

    @Override
    public void updateShrJcjyC(Integer dqjcid, String shrJcjl, String auditor, Date shsjTime) {

    }

    @Override
    public void updateShrJcjyM(Integer dqjcid, String shrJcjl, String auditor, Date shsjTime) {

    }

    @Override
    public void updateShrJcjyS(Integer dqjcid, String shrJcjl, String auditor, Date shsjTime) {

    }
}
