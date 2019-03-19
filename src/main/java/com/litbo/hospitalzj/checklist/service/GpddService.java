package com.litbo.hospitalzj.checklist.service;

import com.litbo.hospitalzj.checklist.dao.GpddMapper;
import com.litbo.hospitalzj.checklist.domain.Gpdd;
import com.litbo.hospitalzj.checklist.utils.commons.CommonUtils;
import com.litbo.hospitalzj.zk.domian.GpddTemplate;
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
    //查询一条
    public Gpdd find(){
        return gpddMapper.find();
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
