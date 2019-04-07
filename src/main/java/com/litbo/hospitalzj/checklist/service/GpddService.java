package com.litbo.hospitalzj.checklist.service;

import com.litbo.hospitalzj.checklist.dao.GpddMapper;
import com.litbo.hospitalzj.checklist.domain.Gpdd;
import com.litbo.hospitalzj.checklist.utils.commons.CommonUtils;
import com.litbo.hospitalzj.zk.domian.GpddTemplate;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("gpddSerivce")
@Transactional
public class GpddService {

    @Autowired
    private GpddMapper gpddMapper;

    //查询模板值
    public GpddTemplate findTemplate(){
        return gpddMapper.findTemplate();
    }
    //修改模板值
    public void update(GpddTemplate gpddTemplate){
        gpddMapper.update(gpddTemplate);
    }
    //插入模板值
    public void insert(GpddTemplate gpddTemplate){
        gpddMapper.insert(gpddTemplate);
    }
    //查询一条
    public Gpdd find(){
        return gpddMapper.find();
    }
    //根据设备Id,检测仪器Id以及状态查询电切表查询最后一条记录
    public Gpdd findByEqIdandJcyqIdLast1(String eqId, String jcyqId){
        return gpddMapper.findByEqIdandJcyqIdLast1(eqId, jcyqId);
    }
    //根据设备Id,检测仪器Id以及状态查询电切表
    public List<Gpdd> findByEqIdandJcyqId(String eqId,String jcyqId){
        return gpddMapper.findByEqIdandJcyqId(eqId, jcyqId);
    }
    //查询所有
    public List<Gpdd> findAll(){
        return gpddMapper.findAll();
    }
    //保存
    public void save(Gpdd gpdd){
        BeanUtils.copyProperties(gpddMapper.findTemplate(), gpdd);
        gpddMapper.save(gpdd);
    }

}
