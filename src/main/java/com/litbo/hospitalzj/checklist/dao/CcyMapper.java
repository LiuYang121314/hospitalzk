package com.litbo.hospitalzj.checklist.dao;

import com.litbo.hospitalzj.checklist.domain.Ccy;
import com.litbo.hospitalzj.checklist.domain.CcyTemplate;
import com.litbo.hospitalzj.checklist.domain.Dqjc;
import com.litbo.hospitalzj.checklist.domain.DqjcTemplate;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

@Mapper
public interface CcyMapper {

    //查询电气检测模板表
    @Select("select ccy_template_id, sfnl_test1, sfnl_test2, sfnl_test3, sfnl_test4, sfnl_test5, sfnl_test6, \n" +
            "    sfnl_wc, cdsj_test, cdsj_wc, tbms_wc, xlsz_test1, xlsz_test2, xlsz_test3, xlsz_test4, \n" +
            "    xlsz_test5, xlsz_wc from ccy_template order by ccy_template_id desc limit 1")
    public CcyTemplate findTemplate();
    //修改模板表数据
    @Update(" update ccy_template\n" +
            "    set sfnl_test1 = #{sfnlTest1,jdbcType=DOUBLE},\n" +
            "      sfnl_test2 = #{sfnlTest2,jdbcType=DOUBLE},\n" +
            "      sfnl_test3 = #{sfnlTest3,jdbcType=DOUBLE},\n" +
            "      sfnl_test4 = #{sfnlTest4,jdbcType=DOUBLE},\n" +
            "      sfnl_test5 = #{sfnlTest5,jdbcType=DOUBLE},\n" +
            "      sfnl_test6 = #{sfnlTest6,jdbcType=DOUBLE},\n" +
            "      sfnl_wc = #{sfnlWc,jdbcType=TINYINT},\n" +
            "      cdsj_test = #{cdsjTest,jdbcType=VARCHAR},\n" +
            "      cdsj_wc = #{cdsjWc,jdbcType=INTEGER},\n" +
            "      tbms_wc = #{tbmsWc,jdbcType=INTEGER},\n" +
            "      xlsz_test1 = #{xlszTest1,jdbcType=DOUBLE},\n" +
            "      xlsz_test2 = #{xlszTest2,jdbcType=DOUBLE},\n" +
            "      xlsz_test3 = #{xlszTest3,jdbcType=DOUBLE},\n" +
            "      xlsz_test4 = #{xlszTest4,jdbcType=DOUBLE},\n" +
            "      xlsz_test5 = #{xlszTest5,jdbcType=DOUBLE},\n" +
            "      xlsz_wc = #{xlszWc,jdbcType=INTEGER}\n" +
            "    where ccy_template_id = #{ccyTemplateId,jdbcType=INTEGER}")
    public void updateTemplate(CcyTemplate ccyTemplate);
    //插入模板表数据
    @Insert("  insert into ccy_template (ccy_template_id, sfnl_test1, sfnl_test2, \n" +
            "      sfnl_test3, sfnl_test4, sfnl_test5, \n" +
            "      sfnl_test6, sfnl_wc, cdsj_test, \n" +
            "      cdsj_wc, tbms_wc, xlsz_test1, \n" +
            "      xlsz_test2, xlsz_test3, xlsz_test4, \n" +
            "      xlsz_test5, xlsz_wc)\n" +
            "    values (#{ccyTemplateId,jdbcType=INTEGER}, #{sfnlTest1,jdbcType=DOUBLE}, #{sfnlTest2,jdbcType=DOUBLE}, \n" +
            "      #{sfnlTest3,jdbcType=DOUBLE}, #{sfnlTest4,jdbcType=DOUBLE}, #{sfnlTest5,jdbcType=DOUBLE}, \n" +
            "      #{sfnlTest6,jdbcType=DOUBLE}, #{sfnlWc,jdbcType=TINYINT}, #{cdsjTest,jdbcType=VARCHAR}, \n" +
            "      #{cdsjWc,jdbcType=INTEGER}, #{tbmsWc,jdbcType=INTEGER}, #{xlszTest1,jdbcType=DOUBLE}, \n" +
            "      #{xlszTest2,jdbcType=DOUBLE}, #{xlszTest3,jdbcType=DOUBLE}, #{xlszTest4,jdbcType=DOUBLE}, \n" +
            "      #{xlszTest5,jdbcType=DOUBLE}, #{xlszWc,jdbcType=INTEGER})")
    void insertTemplate(CcyTemplate ccyTemplate);

    //保存除颤仪检测数据
    @Insert("insert into ccy (ccy_id, jcyq_id, eq_id, \n" +
            "      tester, auditor, test_time, \n" +
            "      shr_jcjl, shsj_time, jcjl, \n" +
            "      jcsm, sfnl_test1, sfnl_value1, \n" +
            "      sfnl_test2, sfnl_value2, sfnl_test3, \n" +
            "      sfnl_value3, sfnl_test4, sfnl_value4, \n" +
            "      sfnl_test5, sfnl_value5, sfnl_test6, \n" +
            "      sfnl_value6, sfnl_wc, sfnl_result, \n" +
            "      cdsj_test, cdsj_value, cdsj_wc, \n" +
            "      cdsj_result, nbfd_result, tbms_cfresult, \n" +
            "      tbms_ycsj, tbms_wc, tbms_result, \n" +
            "      xlsz_test1, xlsz_value1, xlsz_test2, \n" +
            "      xlsz_value2, xlsz_test3, xlsz_value3, \n" +
            "      xlsz_test4, xlsz_value4, xlsz_test5, \n" +
            "      xlsz_value5, xlsz_wc, xlsz_result, \n" +
            "      sgbj_result, bjx_result, jy_result\n" +
            "      )\n" +
            "    values (#{ccyId,jdbcType=INTEGER}, #{jcyqId,jdbcType=INTEGER}, #{eqId,jdbcType=INTEGER}, \n" +
            "      #{tester,jdbcType=VARCHAR}, #{auditor,jdbcType=VARCHAR}, #{testTime,jdbcType=TIMESTAMP}, \n" +
            "      #{shrJcjl,jdbcType=VARCHAR}, #{shsjTime,jdbcType=TIMESTAMP}, #{jcjl,jdbcType=VARCHAR}, \n" +
            "      #{jcsm,jdbcType=VARCHAR}, #{sfnlTest1,jdbcType=DOUBLE}, #{sfnlValue1,jdbcType=DOUBLE}, \n" +
            "      #{sfnlTest2,jdbcType=DOUBLE}, #{sfnlValue2,jdbcType=DOUBLE}, #{sfnlTest3,jdbcType=DOUBLE}, \n" +
            "      #{sfnlValue3,jdbcType=DOUBLE}, #{sfnlTest4,jdbcType=DOUBLE}, #{sfnlValue4,jdbcType=DOUBLE}, \n" +
            "      #{sfnlTest5,jdbcType=DOUBLE}, #{sfnlValue5,jdbcType=DOUBLE}, #{sfnlTest6,jdbcType=DOUBLE}, \n" +
            "      #{sfnlValue6,jdbcType=DOUBLE}, #{sfnlWc,jdbcType=TINYINT}, #{sfnlResult,jdbcType=TINYINT}, \n" +
            "      #{cdsjTest,jdbcType=VARCHAR}, #{cdsjValue,jdbcType=VARCHAR}, #{cdsjWc,jdbcType=INTEGER}, \n" +
            "      #{cdsjResult,jdbcType=TINYINT}, #{nbfdResult,jdbcType=TINYINT}, #{tbmsCfresult,jdbcType=TINYINT}, \n" +
            "      #{tbmsYcsj,jdbcType=VARCHAR}, #{tbmsWc,jdbcType=INTEGER}, #{tbmsResult,jdbcType=TINYINT}, \n" +
            "      #{xlszTest1,jdbcType=DOUBLE}, #{xlszValue1,jdbcType=DOUBLE}, #{xlszTest2,jdbcType=DOUBLE}, \n" +
            "      #{xlszValue2,jdbcType=DOUBLE}, #{xlszTest3,jdbcType=DOUBLE}, #{xlszValue3,jdbcType=DOUBLE}, \n" +
            "      #{xlszTest4,jdbcType=DOUBLE}, #{xlszValue4,jdbcType=DOUBLE}, #{xlszTest5,jdbcType=DOUBLE}, \n" +
            "      #{xlszValue5,jdbcType=DOUBLE}, #{xlszWc,jdbcType=INTEGER}, #{xlszResult,jdbcType=TINYINT}, \n" +
            "      #{sgbjResult,jdbcType=TINYINT}, #{bjxResult,jdbcType=TINYINT}, #{jyResult,jdbcType=TINYINT}\n" +
            "      )")
    @Options(useGeneratedKeys = true, keyProperty = "ccyId", keyColumn = "ccy_id")
    public void save(Ccy ccy);

    //根据设备id查询设备检测表
    @Select("select ccy_id, jcyq_id, eq_id, tester, auditor, test_time, shr_jcjl, shsj_time, jcjl, jcsm, \n" +
            "    sfnl_test1, sfnl_value1, sfnl_test2, sfnl_value2, sfnl_test3, sfnl_value3, sfnl_test4, \n" +
            "    sfnl_value4, sfnl_test5, sfnl_value5, sfnl_test6, sfnl_value6, sfnl_wc, sfnl_result, \n" +
            "    cdsj_test, cdsj_value, cdsj_wc, cdsj_result, nbfd_result, tbms_cfresult, tbms_ycsj, \n" +
            "    tbms_wc, tbms_result, xlsz_test1, xlsz_value1, xlsz_test2, xlsz_value2, xlsz_test3, \n" +
            "    xlsz_value3, xlsz_test4, xlsz_value4, xlsz_test5, xlsz_value5, xlsz_wc, xlsz_result, \n" +
            "    sgbj_result, bjx_result, jy_result from ccy order by ccy_id desc limit 1 where eq_id = #{eqId}")
    public Ccy findCcy(String eqId);

    //以id排序，查询最后一条记录
    @Select("select * from Ccy order by ccy_id desc limit 1")
    Ccy find();

    //根据设备Id,检测仪器Id以及状态查询查询最后一条记录
    @Select("select * from ccy where ccy.eq_id=#{eqId} and ccy.jcyq_id=#{jcyqId} order by ccy_id desc limit 1" )
    Ccy findByEqIdandJcyqIdLast1(@Param("eqId")String eqId,@Param("jcyqId")String jcyqId);

    //根据设备Id,检测仪器Id以及状态查询电器表
    @Select("select * from ccy where ccy.eq_id=#{eqId} and ccy.jcyq_id=#{jcyqId}" )
    List<Ccy> findByEqIdandJcyqId(@Param("eqId")String eqId, @Param("jcyqId")String jcyqId);

    //查询所有检测表数据信息
    @Select("select * from ccy")
    List<Ccy> findAll();

    /**
     * 删除电器数据
     */
   /* @Delete("delete from Ccy where eq_id=#{eqId} and jcyq_id=#{jcyqId}")
    void delete(@Param("eqId")String eqId,@Param("jcyqId")String jcyqId);*/

    /**
     * 根据iD状态查询
     */
    @Select("select * from ccy where ccy_id=#{ccyId}")
    Ccy findByCcyId(@Param("ccyId")Integer ccyId);
    /*
    修改状态
     */
  /*  @Update("update dqjc set state=#{state} where dqjcid=#{dqjcid}")
    void updateState(@Param("dqjcid")Integer dqjcid,@Param("state")Integer state);*/
    //修改审核人意见
    @Update("update Ccy set shr_jcjl=#{shrJcjl},auditor=#{auditor},shsj_time=#{shsjTime} where ccyId=#{ccyId}")
    void updateShrJcjy(@Param("ccyId")Integer ccyId, @Param("shrJcjl")String shrJcjl, @Param("auditor")String auditor, @Param("shsjTime") Date shsjTime);
}
