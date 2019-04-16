package com.litbo.hospitalzj.checklist.service;

import com.litbo.hospitalzj.checklist.domain.Ccy;
import com.litbo.hospitalzj.checklist.domain.CcyTemplate;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

public interface CcyService {
    //查询除颤仪检测模板表
    public CcyTemplate findTemplate();
    public CcyTemplate findTemplateById(Integer ccYtemplateId);
    //修改模板表数据
    public void updateTemplate(CcyTemplate ccyTemplate);
    //插入模板表数据
    void insertTemplate(CcyTemplate ccyTemplate);

    //保存除颤仪检测数据
    public void save(Ccy ccy);

    //根据设备id查询设备检测表
    public Ccy findCcy(String eqId);

    //以id排序，查询最后一条记录
   /* Ccy find();*/

    //根据设备Id,检测仪器Id以及状态查询查询最后一条记录
    Ccy findByEqIdandJcyqIdLast1(@Param("eqId")String eqId, @Param("jcyqId")String jcyqId);

    //根据设备Id,检测仪器Id以及状态查询电器表
    List<Ccy> findByEqIdandJcyqId(@Param("eqId")String eqId, @Param("jcyqId")String jcyqId);

    //查询所有检测表数据信息
    List<Ccy> findAll();

    /**
     * 删除电器数据
     */
   /* @Delete("delete from Ccy where eq_id=#{eqId} and jcyq_id=#{jcyqId}")
    void delete(@Param("eqId")String eqId,@Param("jcyqId")String jcyqId);*/

    /**
     * 根据iD状态查询
     */
     Ccy findByCcyId(@Param("ccyId")Integer ccyId);
    /*
    修改状态
     */
  /*  @Update("update dqjc set state=#{state} where dqjcid=#{dqjcid}")
    void updateState(@Param("dqjcid")Integer dqjcid,@Param("state")Integer state);*/
    //修改审核人意见
    void updateShrJcjy(@Param("ccyId")Integer ccyId, @Param("shrJcjl")String shrJcjl, @Param("auditor")String auditor);
}
