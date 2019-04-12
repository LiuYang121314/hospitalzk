package com.litbo.hospitalzj.checklist.service.Impl;

import com.litbo.hospitalzj.checklist.dao.YepyxMapper;
import com.litbo.hospitalzj.checklist.domain.Yepyx;
import com.litbo.hospitalzj.checklist.domain.YepyxTemplate;
import com.litbo.hospitalzj.checklist.service.YepyxService;
import com.litbo.hospitalzj.zk.mapper.YqJxjlMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class YepyxServiceImpl implements YepyxService {

    @Autowired
    private YepyxMapper yepyxMapper;
    //查询最后一条模板表数据
    @Override
    public YepyxTemplate findTemplate() {
        return yepyxMapper.findTemplate();
    }
    //修改模板表数据
    @Override
    public YepyxTemplate updateTemplate(YepyxTemplate yepyxTemplate) {
        return yepyxMapper.updateTemplate(yepyxTemplate);
    }
    //插入模板表数据
    @Override
    public void insertTemplate(YepyxTemplate yepyxTemplate) {
        yepyxMapper.insertTemplate(yepyxTemplate);
    }



    //保存婴儿培养箱数据
    @Override
    public void save(Yepyx yepyx) {
        YepyxTemplate yepyxTemplate= yepyxMapper.findTemplate();
        BeanUtils.copyProperties(yepyxTemplate, yepyx);
        System.out.println(yepyx);
        yepyxMapper.save(yepyx);
    }
    //数据修改
    @Override
    public void update(Yepyx yepyx) {
        yepyxMapper.update(yepyx);
    }
    //根据设备id查询检测表婴儿培养箱
    @Override
    public Yepyx findYepyx(String eqId) {
        return yepyxMapper.findYepyx(eqId);
    }
    //以id排序，查询最后一条记录
    @Override
    public Yepyx find() {
        return yepyxMapper.find();
    }
    //根据设备Id,检测仪器Id以及状态查询婴儿培养箱最后一条记录
    @Override
    public Yepyx findByEqIdandJcyqIdLast1(String eqId, String jcyqId) {
        return yepyxMapper.findByEqIdandJcyqIdLast1(eqId, jcyqId);
    }
    //根据设备Id,检测仪器Id以及状态查询婴儿培养箱
    @Override
    public List<Yepyx> findByEqIdandJcyqId(String eqId, String jcyqId) {
        return yepyxMapper.findByEqIdandJcyqId(eqId, jcyqId);
    }
    //查询所有检测表数据信息
    @Override
    public List<Yepyx> findAll() {
        return yepyxMapper.findAll();
    }
    //
    @Override
    public Yepyx findByPyxId(Integer pyxId) {
        return yepyxMapper.findByPyxId(pyxId);
    }

  /*  @Override
    public void updateState(Integer pyxId, Integer state) {

    }*/

    @Override
    public void updateShrJcjy(Integer pyxId, String shrJcjl, String auditor) {
        yepyxMapper.updateShrJcjy(pyxId, shrJcjl, auditor, new Date());
    }
}
