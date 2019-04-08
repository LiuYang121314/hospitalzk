package com.litbo.hospitalzj.checklist.service;

import com.litbo.hospitalzj.checklist.dao.HxjMapper;
import com.litbo.hospitalzj.checklist.domain.Hxj;
import com.litbo.hospitalzj.checklist.domain.HxjTemplate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Service("hxjService")
@RequestMapping("/hxj")
public class HxjService {

    @Autowired
    private HxjMapper hxjMapper;

    //查询模板值
    public HxjTemplate findTemplate(){
        return hxjMapper.findTemplate();
    }
    //修改模板值
    public void update(HxjTemplate hxjTemplate){
        hxjMapper.update(hxjTemplate);
    }
    //插入模板值
    public void insert(HxjTemplate hxjTemplate){
        hxjMapper.insert(hxjTemplate);
    }
    //查询一条检测数据
    public Hxj find(){
        return hxjMapper.find();
    }

    //查询所有呼吸机检测数据
    public List<Hxj> findAll(){
        return hxjMapper.findAll();
    }

    //保存呼吸机检测数据
    public void save(Hxj hxj){
        BeanUtils.copyProperties(hxjMapper.findTemplate(), hxj);
        hxjMapper.save(hxj);
    }

}
