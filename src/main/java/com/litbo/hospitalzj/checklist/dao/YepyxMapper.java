package com.litbo.hospitalzj.checklist.dao;

import com.litbo.hospitalzj.checklist.domain.Dqjc;
import com.litbo.hospitalzj.checklist.domain.DqjcTemplate;
import com.litbo.hospitalzj.checklist.domain.Yepyx;
import com.litbo.hospitalzj.checklist.domain.YepyxTemplate;
import com.litbo.hospitalzj.checklist.vo.DqjcUser;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface YepyxMapper {
    //查询婴儿培养箱检测模板表
    @Select("select * from yepyx_template order by pyx_template_id desc limit 1")
    public YepyxTemplate findTemplate();
    //修改模板表数据
    @Update(" update yepyx_template\n" +
            "    set wdpc_wc = #{wdpcWc,jdbcType=DOUBLE},\n" +
            "      jyx_wc = #{jyxWc,jdbcType=DOUBLE},\n" +
            "      bdd_wc = #{bddWc,jdbcType=DOUBLE},\n" +
            "      wkpc_wc = #{wkpcWc,jdbcType=DOUBLE},\n" +
            "      ctl_wc = #{ctlWc,jdbcType=DOUBLE},\n" +
            "      kqls_wc = #{kqlsWc,jdbcType=DOUBLE},\n" +
            "      zsbj_wc = #{zsbjWc,jdbcType=DOUBLE},\n" +
            "      zszc_wc = #{zszcWc,jdbcType=DOUBLE},\n" +
            "      jsbf_wc = #{jsbfWc,jdbcType=DOUBLE},\n" +
            "      cdbf_wc = #{cdbfWc,jdbcType=DOUBLE},\n" +
            "      sd_wc = #{sdWc,jdbcType=DOUBLE}\n" +
            "    where pyx_template_id = #{pyxTemplateId,jdbcType=INTEGER}")
    public YepyxTemplate updateTemplate(YepyxTemplate yepyxTemplate);
    //插入模板表数据
    @Insert(" insert into yepyx_template (pyx_template_id, wdpc_wc, jyx_wc, \n" +
            "      bdd_wc, wkpc_wc, ctl_wc, \n" +
            "      kqls_wc, zsbj_wc, zszc_wc, \n" +
            "      jsbf_wc, cdbf_wc, sd_wc)\n" +
            "    values (#{pyxTemplateId,jdbcType=INTEGER}, #{wdpcWc,jdbcType=DOUBLE}, #{jyxWc,jdbcType=DOUBLE}, \n" +
            "      #{bddWc,jdbcType=DOUBLE}, #{wkpcWc,jdbcType=DOUBLE}, #{ctlWc,jdbcType=DOUBLE}, \n" +
            "      #{kqlsWc,jdbcType=DOUBLE}, #{zsbjWc,jdbcType=DOUBLE}, #{zszcWc,jdbcType=DOUBLE}, \n" +
            "      #{jsbfWc,jdbcType=DOUBLE}, #{cdbfWc,jdbcType=DOUBLE}, #{sdWc,jdbcType=DOUBLE})")
    void insertTemplate(YepyxTemplate yepyxTemplate);

    //保存婴儿培养箱检测数据
    @Insert(" insert into yepyx (pyx_id, jcyq_id, eq_id, \n" +
            "      tester, auditor, shr_jcjl, \n" +
            "      test_time, jcjl, jcsm, \n" +
            "      tx_wd1, tx_wd2, tx_wd3, tx_wd4, \n" +
            "      tx_wd5, tx_wd6, tx_wd7, tx_wd8, \n" +
            "      tx_wd9, tx_wd10, tx_wd11, \n" +
            "      tx_wd12, tx_wd13, tx_wd14, \n" +
            "      tx_wd15, t5s_wd1, t5s_wd2, \n" +
            "      t5s_wd3, t5s_wd4, t5s_wd5, \n" +
            "      t5s_wd6, t5s_wd7, t5s_wd8, \n" +
            "      t5s_wd9, t5s_wd10, t5s_wd11, \n" +
            "      t5s_wd12, t5s_wd13, t5s_wd14, \n" +
            "      t5s_wd15, kzwd, wdt1, wdt2, \n" +
            "      wdt3, wdtxa, wdt4, wdt5, \n" +
            "      wdpc, wdpc_wc, wdpc_result, \n" +
            "      jyx, jyx_wc, jyx_result, \n" +
            "      bdd, bdd_wc, bdd_result, \n" +
            "      wkpc, wkpc_wc, wkpc_result, \n" +
            "      ctl, ctl_wc, ctl_result, \n" +
            "      kqls, kqls_wc, kqls_result, \n" +
            "      zsbj, zsbj_wc, zsbj_result, \n" +
            "      zszc, zszc_wc, zszc_result, \n" +
            "      jsbf, jsbf_wc, jsbf_result, \n" +
            "      cdbf, cdbf_wc, cdbf_result, \n" +
            "      sdszz, sdcsz, sdpc, sd_wc, \n" +
            "      sd_result, ddbj_result, cwbj_result, \n" +
            "      fjbj_result)\n" +
            "    values (#{pyxId,jdbcType=INTEGER}, #{jcyqId,jdbcType=INTEGER}, #{eqId,jdbcType=INTEGER}, \n" +
            "      #{tester,jdbcType=VARCHAR}, #{auditor,jdbcType=VARCHAR}, #{shrJcjl,jdbcType=VARCHAR}, \n" +
            "      #{testTime,jdbcType=TIMESTAMP}, #{jcjl,jdbcType=VARCHAR}, #{jcsm,jdbcType=VARCHAR}, \n" +
            "      #{txWd1,jdbcType=DOUBLE}, #{txWd2,jdbcType=DOUBLE}, #{txWd3,jdbcType=DOUBLE}, #{txWd4,jdbcType=DOUBLE}, \n" +
            "      #{txWd5,jdbcType=DOUBLE}, #{txWd6,jdbcType=DOUBLE}, #{txWd7,jdbcType=DOUBLE}, #{txWd8,jdbcType=DOUBLE}, \n" +
            "      #{txWd9,jdbcType=DOUBLE}, #{txWd10,jdbcType=DOUBLE}, #{txWd11,jdbcType=DOUBLE}, \n" +
            "      #{txWd12,jdbcType=DOUBLE}, #{txWd13,jdbcType=DOUBLE}, #{txWd14,jdbcType=DOUBLE}, \n" +
            "      #{txWd15,jdbcType=DOUBLE}, #{t5sWd1,jdbcType=DOUBLE}, #{t5sWd2,jdbcType=DOUBLE}, \n" +
            "      #{t5sWd3,jdbcType=DOUBLE}, #{t5sWd4,jdbcType=DOUBLE}, #{t5sWd5,jdbcType=DOUBLE}, \n" +
            "      #{t5sWd6,jdbcType=DOUBLE}, #{t5sWd7,jdbcType=DOUBLE}, #{t5sWd8,jdbcType=DOUBLE}, \n" +
            "      #{t5sWd9,jdbcType=DOUBLE}, #{t5sWd10,jdbcType=DOUBLE}, #{t5sWd11,jdbcType=DOUBLE}, \n" +
            "      #{t5sWd12,jdbcType=DOUBLE}, #{t5sWd13,jdbcType=DOUBLE}, #{t5sWd14,jdbcType=DOUBLE}, \n" +
            "      #{t5sWd15,jdbcType=DOUBLE}, #{kzwd,jdbcType=DOUBLE}, #{wdt1,jdbcType=DOUBLE}, #{wdt2,jdbcType=DOUBLE}, \n" +
            "      #{wdt3,jdbcType=DOUBLE}, #{wdtxa,jdbcType=DOUBLE}, #{wdt4,jdbcType=DOUBLE}, #{wdt5,jdbcType=DOUBLE}, \n" +
            "      #{wdpc,jdbcType=DOUBLE}, #{wdpcWc,jdbcType=DOUBLE}, #{wdpcResult,jdbcType=DOUBLE}, \n" +
            "      #{jyx,jdbcType=DOUBLE}, #{jyxWc,jdbcType=DOUBLE}, #{jyxResult,jdbcType=TINYINT}, \n" +
            "      #{bdd,jdbcType=DOUBLE}, #{bddWc,jdbcType=DOUBLE}, #{bddResult,jdbcType=TINYINT}, \n" +
            "      #{wkpc,jdbcType=DOUBLE}, #{wkpcWc,jdbcType=DOUBLE}, #{wkpcResult,jdbcType=TINYINT}, \n" +
            "      #{ctl,jdbcType=DOUBLE}, #{ctlWc,jdbcType=DOUBLE}, #{ctlResult,jdbcType=TINYINT}, \n" +
            "      #{kqls,jdbcType=DOUBLE}, #{kqlsWc,jdbcType=DOUBLE}, #{kqlsResult,jdbcType=TINYINT}, \n" +
            "      #{zsbj,jdbcType=DOUBLE}, #{zsbjWc,jdbcType=DOUBLE}, #{zsbjResult,jdbcType=TINYINT}, \n" +
            "      #{zszc,jdbcType=DOUBLE}, #{zszcWc,jdbcType=DOUBLE}, #{zszcResult,jdbcType=TINYINT}, \n" +
            "      #{jsbf,jdbcType=DOUBLE}, #{jsbfWc,jdbcType=DOUBLE}, #{jsbfResult,jdbcType=TINYINT}, \n" +
            "      #{cdbf,jdbcType=DOUBLE}, #{cdbfWc,jdbcType=DOUBLE}, #{cdbfResult,jdbcType=TINYINT}, \n" +
            "      #{sdszz,jdbcType=DOUBLE}, #{sdcsz,jdbcType=DOUBLE}, #{sdpc,jdbcType=DOUBLE}, #{sdWc,jdbcType=DOUBLE}, \n" +
            "      #{sdResult,jdbcType=TINYINT}, #{ddbjResult,jdbcType=TINYINT}, #{cwbjResult,jdbcType=TINYINT}, \n" +
            "      #{fjbjResult,jdbcType=TINYINT})")
    @Options(useGeneratedKeys = true, keyProperty = "pyxId", keyColumn = "dqjcid")
    public void save(Yepyx yepyx);

    //根据电气检测设备id查询设备检测表
    @Select("select pyx_id, jcyq_id, eq_id, tester, auditor, shr_jcjl, test_time, jcjl, jcsm, tx_wd1, \n" +
            "    tx_wd2, tx_wd3, tx_wd4, tx_wd5, tx_wd6, tx_wd7, tx_wd8, tx_wd9, tx_wd10, tx_wd11, \n" +
            "    tx_wd12, tx_wd13, tx_wd14, tx_wd15, t5s_wd1, t5s_wd2, t5s_wd3, t5s_wd4, t5s_wd5, \n" +
            "    t5s_wd6, t5s_wd7, t5s_wd8, t5s_wd9, t5s_wd10, t5s_wd11, t5s_wd12, t5s_wd13, t5s_wd14, \n" +
            "    t5s_wd15, kzwd, wdt1, wdt2, wdt3, wdtxa, wdt4, wdt5, wdpc, wdpc_wc, wdpc_result, \n" +
            "    jyx, jyx_wc, jyx_result, bdd, bdd_wc, bdd_result, wkpc, wkpc_wc, wkpc_result, ctl, \n" +
            "    ctl_wc, ctl_result, kqls, kqls_wc, kqls_result, zsbj, zsbj_wc, zsbj_result, zszc, \n" +
            "    zszc_wc, zszc_result, jsbf, jsbf_wc, jsbf_result, cdbf, cdbf_wc, cdbf_result, sdszz, \n" +
            "    sdcsz, sdpc, sd_wc, sd_result, ddbj_result, cwbj_result, fjbj_result from yepyx order by pyx_id desc limit 1 where eq_id = '#{eqId}'")
    public Yepyx findYepyx(String eqId);

    //以id排序，查询最后一条记录
    @Select("select * from dqjc order by dqjcid desc limit 1")
    Dqjc find();

    //根据设备Id,检测仪器Id以及状态查询电器表查询最后一条记录
    @Select("select dqjc.* from dqjc where dqjc.eq_id=#{eqId} and dqjc.jcyq_id=#{jcyqId} order by dqjcid desc limit 1" )
    Dqjc findByEqIdandJcyqIdLast1(@Param("eqId")String eqId,@Param("jcyqId")String jcyqId);

    //根据设备Id,检测仪器Id以及状态查询电器表
    @Select("select dqjc.* from dqjc where dqjc.eq_id=#{eqId} and dqjc.jcyq_id=#{jcyqId}" )
    List<Dqjc> findByEqIdandJcyqId(@Param("eqId")String eqId, @Param("jcyqId")String jcyqId);

    //根据设备Id,检测仪器Id以及状态查询电器表
    @Select("select d.*,s.user_name,u.date from " +
            "dqjc d left join user_eq u on u.jc_eqid=d.eq_id " +
            "left join s_user s on u.user_id=s.user_id where " +
            "d.eq_id=#{eqId} and d.jcyq_id=#{jcyqId} and d.state=#{state}")
    DqjcUser findShrAndShrjcjl(@Param("eqId")String eqId, @Param("jcyqId")String jcyqId, @Param("state")Integer state);

    //查询所有检测表数据信息
    @Select("select * from dqjc")
    List<Dqjc> findAll();

    /**
     * 删除电器数据
     */
    @Delete("delete from dqjc where eq_id=#{eqId} and jcyq_id=#{jcyqId}")
    void delete(@Param("eqId")String eqId,@Param("jcyqId")String jcyqId);

    /**
     * 根据iD状态查询
     */
    @Select("select * from dqjc where dqjcid=#{dqjcid} and state=#{state}")
    Dqjc findByDqjcid(@Param("dqjcid")Integer dqjcid,@Param("state")Integer state);
    /*
    修改状态
     */
    @Update("update dqjc set state=#{state} where dqjcid=#{dqjcid}")
    void updateState(@Param("dqjcid")Integer dqjcid,@Param("state")Integer state);
    //修改审核人意见
    @Update("update dqjc set shr_jcjl=#{shrJcjl},auditor=#{auditor} where dqjcid=#{dqjcid}")
    void updateShrJcjy(@Param("dqjcid")Integer dqjcid,@Param("shrJcjl")String shrJcjl,@Param("auditor")String auditor);

}
