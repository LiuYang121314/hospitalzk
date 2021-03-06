package com.litbo.hospitalzj.checklist.dao;

import com.litbo.hospitalzj.checklist.domain.Dcsjhy;
import com.litbo.hospitalzj.checklist.domain.DcsjhyTemplate;
import com.litbo.hospitalzj.checklist.domain.Dqjc;

import com.litbo.hospitalzj.checklist.domain.SybC;
import com.litbo.hospitalzj.checklist.vo.DqjcUser;
import com.litbo.hospitalzj.checklist.vo.JhyUser;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

/**
 * 多参数监护仪dao层
 * @author bigStone
 *
 */
@Mapper
public interface DcsjhyMapper {

	//查询多参数监护仪模板表（成人）
	@Select("select * from dcsjhy_template_m order by dc_templateid desc limit 1")
	public DcsjhyTemplate findTemplate_m();

	//查询多参数监护仪模板表(儿童)
	@Select("select * from dcsjhy_template_c order by dc_templateid desc limit 1")
	public DcsjhyTemplate findTemplate_c();
	//查询多参数监护仪模板表(儿童)
	@Select("select * from ${tableName} wehere dc_templateid=#{dcTemplateid}")
	public DcsjhyTemplate findTemplateById(@Param("dcTemplateid") Integer dcTemplateid,@Param("tableName") String tableName);
	//修改模板表数据
	@Update("update dcsjhy_template_m\n" +
			"    set xl_test1 = #{xlTest1,jdbcType=INTEGER},\n" +
			"      xl_test2 = #{xlTest2,jdbcType=INTEGER},\n" +
			"      xl_test3 = #{xlTest3,jdbcType=INTEGER},\n" +
			"      xl_test4 = #{xlTest4,jdbcType=INTEGER},\n" +
			"      xl_test5 = #{xlTest5,jdbcType=INTEGER},\n" +
			"      xl_wc = #{xlWc,jdbcType=INTEGER},\n" +
			"      hxl_test1 = #{hxlTest1,jdbcType=INTEGER},\n" +
			"      hxl_test2 = #{hxlTest2,jdbcType=INTEGER},\n" +
			"      hxl_test3 = #{hxlTest3,jdbcType=INTEGER},\n" +
			"      hxl_test4 = #{hxlTest4,jdbcType=INTEGER},\n" +
			"      hxl_test5 = #{hxlTest5,jdbcType=INTEGER},\n" +
			"      hxl_wc = #{hxlWc,jdbcType=INTEGER},\n" +
			"      xybhd_test1 = #{xybhdTest1,jdbcType=INTEGER},\n" +
			"      xybhd_test2 = #{xybhdTest2,jdbcType=INTEGER},\n" +
			"      xybhd_test3 = #{xybhdTest3,jdbcType=INTEGER},\n" +
			"      xybhd_test4 = #{xybhdTest4,jdbcType=INTEGER},\n" +
			"      xybhd_test5 = #{xybhdTest5,jdbcType=INTEGER},\n" +
			"      xybhd_wc = #{xybhdWc,jdbcType=INTEGER},\n" +
			"      wcxy_h_test1 = #{wcxyHTest1,jdbcType=INTEGER},\n" +
			"      wcxy_l_test1 = #{wcxyLTest1,jdbcType=INTEGER},\n" +
			"      wcxy_m_test1 = #{wcxyMTest1,jdbcType=INTEGER},\n" +
			"      wcxy_h_test2 = #{wcxyHTest2,jdbcType=INTEGER},\n" +
			"      wcxy_l_test2 = #{wcxyLTest2,jdbcType=INTEGER},\n" +
			"      wcxy_m_test2 = #{wcxyMTest2,jdbcType=INTEGER},\n" +
			"      wcxy_h_test3 = #{wcxyHTest3,jdbcType=INTEGER},\n" +
			"      wcxy_l_test3 = #{wcxyLTest3,jdbcType=INTEGER},\n" +
			"      wcxy_m_test3 = #{wcxyMTest3,jdbcType=INTEGER},\n" +
			"      wcxy_h_test4 = #{wcxyHTest4,jdbcType=INTEGER},\n" +
			"      wcxy_l_test4 = #{wcxyLTest4,jdbcType=INTEGER},\n" +
			"      wcxy_m_test4 = #{wcxyMTest4,jdbcType=INTEGER},\n" +
			"      wcxy_h_test5 = #{wcxyHTest5,jdbcType=INTEGER},\n" +
			"      wcxy_l_test5 = #{wcxyLTest5,jdbcType=INTEGER},\n" +
			"      wcxy_m_test5 = #{wcxyMTest5,jdbcType=INTEGER},\n" +
			"      wcxy_wc = #{wcxyWc,jdbcType=INTEGER},\n" +
			"      wcxyjt_sd = #{wcxyjtSd,jdbcType=INTEGER},\n" +
			"      wcxyjt_wc = #{wcxyjtWc,jdbcType=INTEGER},\n" +
			"      wcxyqm_sd = #{wcxyqmSd,jdbcType=INTEGER},\n" +
			"      wcxyqm_xll_wc = #{wcxyqmXllWc,jdbcType=INTEGER}\n" +
			"    where dc_templateid = #{dcTemplateid,jdbcType=INTEGER}")
	int updateM(DcsjhyTemplate dcsjhyTemplate);
	//成人
	@Update("update dcsjhy_template_c\n" +
			"    set xl_test1 = #{xlTest1,jdbcType=INTEGER},\n" +
			"      xl_test2 = #{xlTest2,jdbcType=INTEGER},\n" +
			"      xl_test3 = #{xlTest3,jdbcType=INTEGER},\n" +
			"      xl_test4 = #{xlTest4,jdbcType=INTEGER},\n" +
			"      xl_test5 = #{xlTest5,jdbcType=INTEGER},\n" +
			"      xl_wc = #{xlWc,jdbcType=INTEGER},\n" +
			"      hxl_test1 = #{hxlTest1,jdbcType=INTEGER},\n" +
			"      hxl_test2 = #{hxlTest2,jdbcType=INTEGER},\n" +
			"      hxl_test3 = #{hxlTest3,jdbcType=INTEGER},\n" +
			"      hxl_test4 = #{hxlTest4,jdbcType=INTEGER},\n" +
			"      hxl_test5 = #{hxlTest5,jdbcType=INTEGER},\n" +
			"      hxl_wc = #{hxlWc,jdbcType=INTEGER},\n" +
			"      xybhd_test1 = #{xybhdTest1,jdbcType=INTEGER},\n" +
			"      xybhd_test2 = #{xybhdTest2,jdbcType=INTEGER},\n" +
			"      xybhd_test3 = #{xybhdTest3,jdbcType=INTEGER},\n" +
			"      xybhd_test4 = #{xybhdTest4,jdbcType=INTEGER},\n" +
			"      xybhd_test5 = #{xybhdTest5,jdbcType=INTEGER},\n" +
			"      xybhd_wc = #{xybhdWc,jdbcType=INTEGER},\n" +
			"      wcxy_h_test1 = #{wcxyHTest1,jdbcType=INTEGER},\n" +
			"      wcxy_l_test1 = #{wcxyLTest1,jdbcType=INTEGER},\n" +
			"      wcxy_m_test1 = #{wcxyMTest1,jdbcType=INTEGER},\n" +
			"      wcxy_h_test2 = #{wcxyHTest2,jdbcType=INTEGER},\n" +
			"      wcxy_l_test2 = #{wcxyLTest2,jdbcType=INTEGER},\n" +
			"      wcxy_m_test2 = #{wcxyMTest2,jdbcType=INTEGER},\n" +
			"      wcxy_h_test3 = #{wcxyHTest3,jdbcType=INTEGER},\n" +
			"      wcxy_l_test3 = #{wcxyLTest3,jdbcType=INTEGER},\n" +
			"      wcxy_m_test3 = #{wcxyMTest3,jdbcType=INTEGER},\n" +
			"      wcxy_h_test4 = #{wcxyHTest4,jdbcType=INTEGER},\n" +
			"      wcxy_l_test4 = #{wcxyLTest4,jdbcType=INTEGER},\n" +
			"      wcxy_m_test4 = #{wcxyMTest4,jdbcType=INTEGER},\n" +
			"      wcxy_h_test5 = #{wcxyHTest5,jdbcType=INTEGER},\n" +
			"      wcxy_l_test5 = #{wcxyLTest5,jdbcType=INTEGER},\n" +
			"      wcxy_m_test5 = #{wcxyMTest5,jdbcType=INTEGER},\n" +
			"      wcxy_wc = #{wcxyWc,jdbcType=INTEGER},\n" +
			"      wcxyjt_sd = #{wcxyjtSd,jdbcType=INTEGER},\n" +
			"      wcxyjt_wc = #{wcxyjtWc,jdbcType=INTEGER},\n" +
			"      wcxyqm_sd = #{wcxyqmSd,jdbcType=INTEGER},\n" +
			"      wcxyqm_xll_wc = #{wcxyqmXllWc,jdbcType=INTEGER}\n" +
			"    where dc_templateid = #{dcTemplateid,jdbcType=INTEGER}")
	int updateC(DcsjhyTemplate dcsjhyTemplate);
	//插入模板表数据
	@Insert(" insert into dcsjhy_template_m (dc_templateid, xl_test1, xl_test2, \n" +
			"      xl_test3, xl_test4, xl_test5, \n" +
			"      xl_wc, hxl_test1, hxl_test2, \n" +
			"      hxl_test3, hxl_test4, hxl_test5, \n" +
			"      hxl_wc, xybhd_test1, xybhd_test2, \n" +
			"      xybhd_test3, xybhd_test4, xybhd_test5, \n" +
			"      xybhd_wc, wcxy_h_test1, wcxy_l_test1, \n" +
			"      wcxy_m_test1, wcxy_h_test2, wcxy_l_test2, \n" +
			"      wcxy_m_test2, wcxy_h_test3, wcxy_l_test3, \n" +
			"      wcxy_m_test3, wcxy_h_test4, wcxy_l_test4, \n" +
			"      wcxy_m_test4, wcxy_h_test5, wcxy_l_test5, \n" +
			"      wcxy_m_test5, wcxy_wc, wcxyjt_sd, \n" +
			"      wcxyjt_wc, wcxyqm_sd, wcxyqm_xll_wc\n" +
			"      )\n" +
			"    values (#{dcTemplateid,jdbcType=INTEGER}, #{xlTest1,jdbcType=INTEGER}, #{xlTest2,jdbcType=INTEGER}, \n" +
			"      #{xlTest3,jdbcType=INTEGER}, #{xlTest4,jdbcType=INTEGER}, #{xlTest5,jdbcType=INTEGER}, \n" +
			"      #{xlWc,jdbcType=INTEGER}, #{hxlTest1,jdbcType=INTEGER}, #{hxlTest2,jdbcType=INTEGER}, \n" +
			"      #{hxlTest3,jdbcType=INTEGER}, #{hxlTest4,jdbcType=INTEGER}, #{hxlTest5,jdbcType=INTEGER}, \n" +
			"      #{hxlWc,jdbcType=INTEGER}, #{xybhdTest1,jdbcType=INTEGER}, #{xybhdTest2,jdbcType=INTEGER}, \n" +
			"      #{xybhdTest3,jdbcType=INTEGER}, #{xybhdTest4,jdbcType=INTEGER}, #{xybhdTest5,jdbcType=INTEGER}, \n" +
			"      #{xybhdWc,jdbcType=INTEGER}, #{wcxyHTest1,jdbcType=INTEGER}, #{wcxyLTest1,jdbcType=INTEGER}, \n" +
			"      #{wcxyMTest1,jdbcType=INTEGER}, #{wcxyHTest2,jdbcType=INTEGER}, #{wcxyLTest2,jdbcType=INTEGER}, \n" +
			"      #{wcxyMTest2,jdbcType=INTEGER}, #{wcxyHTest3,jdbcType=INTEGER}, #{wcxyLTest3,jdbcType=INTEGER}, \n" +
			"      #{wcxyMTest3,jdbcType=INTEGER}, #{wcxyHTest4,jdbcType=INTEGER}, #{wcxyLTest4,jdbcType=INTEGER}, \n" +
			"      #{wcxyMTest4,jdbcType=INTEGER}, #{wcxyHTest5,jdbcType=INTEGER}, #{wcxyLTest5,jdbcType=INTEGER}, \n" +
			"      #{wcxyMTest5,jdbcType=INTEGER}, #{wcxyWc,jdbcType=INTEGER}, #{wcxyjtSd,jdbcType=INTEGER}, \n" +
			"      #{wcxyjtWc,jdbcType=INTEGER}, #{wcxyqmSd,jdbcType=INTEGER}, #{wcxyqmXllWc,jdbcType=INTEGER}\n" +
			"      )")
	int insertM(DcsjhyTemplate dcsjhyTemplate);
	@Insert(" insert into dcsjhy_template_c (dc_templateid, xl_test1, xl_test2, \n" +
			"      xl_test3, xl_test4, xl_test5, \n" +
			"      xl_wc, hxl_test1, hxl_test2, \n" +
			"      hxl_test3, hxl_test4, hxl_test5, \n" +
			"      hxl_wc, xybhd_test1, xybhd_test2, \n" +
			"      xybhd_test3, xybhd_test4, xybhd_test5, \n" +
			"      xybhd_wc, wcxy_h_test1, wcxy_l_test1, \n" +
			"      wcxy_m_test1, wcxy_h_test2, wcxy_l_test2, \n" +
			"      wcxy_m_test2, wcxy_h_test3, wcxy_l_test3, \n" +
			"      wcxy_m_test3, wcxy_h_test4, wcxy_l_test4, \n" +
			"      wcxy_m_test4, wcxy_h_test5, wcxy_l_test5, \n" +
			"      wcxy_m_test5, wcxy_wc, wcxyjt_sd, \n" +
			"      wcxyjt_wc, wcxyqm_sd, wcxyqm_xll_wc\n" +
			"      )\n" +
			"    values (#{dcTemplateid,jdbcType=INTEGER}, #{xlTest1,jdbcType=INTEGER}, #{xlTest2,jdbcType=INTEGER}, \n" +
			"      #{xlTest3,jdbcType=INTEGER}, #{xlTest4,jdbcType=INTEGER}, #{xlTest5,jdbcType=INTEGER}, \n" +
			"      #{xlWc,jdbcType=INTEGER}, #{hxlTest1,jdbcType=INTEGER}, #{hxlTest2,jdbcType=INTEGER}, \n" +
			"      #{hxlTest3,jdbcType=INTEGER}, #{hxlTest4,jdbcType=INTEGER}, #{hxlTest5,jdbcType=INTEGER}, \n" +
			"      #{hxlWc,jdbcType=INTEGER}, #{xybhdTest1,jdbcType=INTEGER}, #{xybhdTest2,jdbcType=INTEGER}, \n" +
			"      #{xybhdTest3,jdbcType=INTEGER}, #{xybhdTest4,jdbcType=INTEGER}, #{xybhdTest5,jdbcType=INTEGER}, \n" +
			"      #{xybhdWc,jdbcType=INTEGER}, #{wcxyHTest1,jdbcType=INTEGER}, #{wcxyLTest1,jdbcType=INTEGER}, \n" +
			"      #{wcxyMTest1,jdbcType=INTEGER}, #{wcxyHTest2,jdbcType=INTEGER}, #{wcxyLTest2,jdbcType=INTEGER}, \n" +
			"      #{wcxyMTest2,jdbcType=INTEGER}, #{wcxyHTest3,jdbcType=INTEGER}, #{wcxyLTest3,jdbcType=INTEGER}, \n" +
			"      #{wcxyMTest3,jdbcType=INTEGER}, #{wcxyHTest4,jdbcType=INTEGER}, #{wcxyLTest4,jdbcType=INTEGER}, \n" +
			"      #{wcxyMTest4,jdbcType=INTEGER}, #{wcxyHTest5,jdbcType=INTEGER}, #{wcxyLTest5,jdbcType=INTEGER}, \n" +
			"      #{wcxyMTest5,jdbcType=INTEGER}, #{wcxyWc,jdbcType=INTEGER}, #{wcxyjtSd,jdbcType=INTEGER}, \n" +
			"      #{wcxyjtWc,jdbcType=INTEGER}, #{wcxyqmSd,jdbcType=INTEGER}, #{wcxyqmXllWc,jdbcType=INTEGER}\n" +
			"      )")
	int insertC(DcsjhyTemplate dcsjhyTemplate);
	//保存多参数监护仪检测表(成人)
	@Insert("insert into dcsjhy_m (dcid, jcyq_id, eq_id,tester, auditor,shsj_time, test_time,shr_jcjl,jcjl, jcsm, xl_test1,                         "
			+"xl_test2, xl_test3, xl_test4, xl_test5, xl_value1, xl_value2,  xl_value3, xl_value4, xl_value5,                         "
			+"xl_wc, xl_result, hxl_test1,  hxl_test2, hxl_test3, hxl_test4, hxl_test5, hxl_value1, hxl_value2,                       "
			+"hxl_value3, hxl_value4, hxl_value5, hxl_wc, hxl_result, xybhd_test1,xybhd_test2, xybhd_test3, xybhd_test4,              "
			+"xybhd_test5, xybhd_value1, xybhd_value2, xybhd_value3, xybhd_value4, xybhd_value5,                                      "
			+"xybhd_wc, xybhd_result, wcxy_h_test1, wcxy_m_test1, wcxy_l_test1, wcxy_h_test2,                                         "
			+"wcxy_m_test2, wcxy_l_test2, wcxy_h_test3, wcxy_m_test3, wcxy_l_test3, wcxy_h_test4,                                     "
			+"wcxy_m_test4, wcxy_l_test4, wcxy_h_test5, wcxy_m_test5, wcxy_l_test5, wcxy_h_value11,                                   "
			+"wcxy_m_value11, wcxy_l_value11, wcxy_h_value12, wcxy_m_value12, wcxy_l_value12, wcxy_h_value13,                         "
			+"wcxy_m_value13, wcxy_l_value13, wcxy_h_value14, wcxy_m_value14, wcxy_l_value14, wcxy_h_value15,                         "
			+"wcxy_m_value15, wcxy_l_value15, wcxy_h_value21,  wcxy_m_value21, wcxy_l_value21, wcxy_h_value22,                        "
			+"wcxy_m_value22, wcxy_l_value22, wcxy_h_value23,  wcxy_m_value23, wcxy_l_value23, wcxy_h_value24,                        "
			+"wcxy_m_value24, wcxy_l_value24, wcxy_h_value25,  wcxy_m_value25, wcxy_l_value25, wcxy_h_value31,                        "
			+"wcxy_m_value31, wcxy_l_value31, wcxy_h_value32, wcxy_m_value32, wcxy_l_value32, wcxy_h_value33,                         "
			+"wcxy_m_value33, wcxy_l_value33, wcxy_h_value34, wcxy_m_value34, wcxy_l_value34, wcxy_h_value35,                         "
			+"wcxy_m_value35, wcxy_l_value35, wcxy_wc, wcxy_result, wcxyjt_sd, wcxyjt_mnq, wcxyjt_jhy, wcxyjt_wc, wcxyjt_result,      "
			+"wcxyqm_sd, wcxyqm_xll, wcxyqm_wc,  wcxyqm_result, sgbj_result, bjxjc_result, jyjc_result, state, spare2,  spare3)      "
			+"values (#{dcid,jdbcType=INTEGER}, #{jcyqId,jdbcType=INTEGER}, #{eqId,jdbcType=INTEGER},                                 "
			+"#{tester,jdbcType=VARCHAR}, #{auditor,jdbcType=VARCHAR}, #{shsjTime},#{testTime,jdbcType=TIMESTAMP},                                "
			+"#{shrJcjl,jdbcType=VARCHAR},#{jcjl,jdbcType=VARCHAR}, #{jcsm,jdbcType=VARCHAR}, #{xlTest1,jdbcType=INTEGER},                                        "
			+"#{xlTest2,jdbcType=INTEGER}, #{xlTest3,jdbcType=INTEGER}, #{xlTest4,jdbcType=INTEGER},                                  "
			+"#{xlTest5,jdbcType=INTEGER}, #{xlValue1,jdbcType=INTEGER}, #{xlValue2,jdbcType=INTEGER},                                "
			+"#{xlValue3,jdbcType=INTEGER}, #{xlValue4,jdbcType=INTEGER}, #{xlValue5,jdbcType=INTEGER},                               "
			+"#{xlWc,jdbcType=INTEGER}, #{xlResult,jdbcType=TINYINT}, #{hxlTest1,jdbcType=INTEGER},                                   "
			+"#{hxlTest2,jdbcType=INTEGER}, #{hxlTest3,jdbcType=INTEGER}, #{hxlTest4,jdbcType=INTEGER},                               "
			+"#{hxlTest5,jdbcType=INTEGER}, #{hxlValue1,jdbcType=INTEGER}, #{hxlValue2,jdbcType=INTEGER},                             "
			+"#{hxlValue3,jdbcType=INTEGER}, #{hxlValue4,jdbcType=INTEGER}, #{hxlValue5,jdbcType=INTEGER},                            "
			+"#{hxlWc,jdbcType=INTEGER}, #{hxlResult,jdbcType=TINYINT}, #{xybhdTest1,jdbcType=INTEGER},                               "
			+"#{xybhdTest2,jdbcType=INTEGER}, #{xybhdTest3,jdbcType=INTEGER}, #{xybhdTest4,jdbcType=INTEGER},                         "
			+"#{xybhdTest5,jdbcType=INTEGER}, #{xybhdValue1,jdbcType=INTEGER}, #{xybhdValue2,jdbcType=INTEGER},                       "
			+"#{xybhdValue3,jdbcType=INTEGER}, #{xybhdValue4,jdbcType=INTEGER}, #{xybhdValue5,jdbcType=INTEGER},                      "
			+"#{xybhdWc,jdbcType=INTEGER}, #{xybhdResult,jdbcType=TINYINT}, #{wcxyHTest1,jdbcType=INTEGER},                           "
			+"#{wcxyMTest1,jdbcType=INTEGER}, #{wcxyLTest1,jdbcType=INTEGER}, #{wcxyHTest2,jdbcType=INTEGER},                         "
			+"#{wcxyMTest2,jdbcType=INTEGER}, #{wcxyLTest2,jdbcType=INTEGER}, #{wcxyHTest3,jdbcType=INTEGER},                         "
			+"#{wcxyMTest3,jdbcType=INTEGER}, #{wcxyLTest3,jdbcType=INTEGER}, #{wcxyHTest4,jdbcType=INTEGER},                         "
			+"#{wcxyMTest4,jdbcType=INTEGER}, #{wcxyLTest4,jdbcType=INTEGER}, #{wcxyHTest5,jdbcType=INTEGER},                         "
			+"#{wcxyMTest5,jdbcType=INTEGER}, #{wcxyLTest5,jdbcType=INTEGER}, #{wcxyHValue11,jdbcType=INTEGER},                       "
			+"#{wcxyMValue11,jdbcType=INTEGER}, #{wcxyLValue11,jdbcType=INTEGER}, #{wcxyHValue12,jdbcType=INTEGER},                   "
			+"#{wcxyMValue12,jdbcType=INTEGER}, #{wcxyLValue12,jdbcType=INTEGER}, #{wcxyHValue13,jdbcType=INTEGER},                   "
			+"#{wcxyMValue13,jdbcType=INTEGER}, #{wcxyLValue13,jdbcType=INTEGER}, #{wcxyHValue14,jdbcType=INTEGER},                   "
			+"#{wcxyMValue14,jdbcType=INTEGER}, #{wcxyLValue14,jdbcType=INTEGER}, #{wcxyHValue15,jdbcType=INTEGER},                   "
			+"#{wcxyMValue15,jdbcType=INTEGER}, #{wcxyLValue15,jdbcType=INTEGER}, #{wcxyHValue21,jdbcType=INTEGER},                   "
			+"#{wcxyMValue21,jdbcType=INTEGER}, #{wcxyLValue21,jdbcType=INTEGER}, #{wcxyHValue22,jdbcType=INTEGER},                   "
			+"#{wcxyMValue22,jdbcType=INTEGER}, #{wcxyLValue22,jdbcType=INTEGER}, #{wcxyHValue23,jdbcType=INTEGER},                   "
			+"#{wcxyMValue23,jdbcType=INTEGER}, #{wcxyLValue23,jdbcType=INTEGER}, #{wcxyHValue24,jdbcType=INTEGER},                   "
			+"#{wcxyMValue24,jdbcType=INTEGER}, #{wcxyLValue24,jdbcType=INTEGER}, #{wcxyHValue25,jdbcType=INTEGER},                   "
			+"#{wcxyMValue25,jdbcType=INTEGER}, #{wcxyLValue25,jdbcType=INTEGER}, #{wcxyHValue31,jdbcType=INTEGER},                   "
			+"#{wcxyMValue31,jdbcType=INTEGER}, #{wcxyLValue31,jdbcType=INTEGER}, #{wcxyHValue32,jdbcType=INTEGER},                   "
			+"#{wcxyMValue32,jdbcType=INTEGER}, #{wcxyLValue32,jdbcType=INTEGER}, #{wcxyHValue33,jdbcType=INTEGER},                   "
			+"#{wcxyMValue33,jdbcType=INTEGER}, #{wcxyLValue33,jdbcType=INTEGER}, #{wcxyHValue34,jdbcType=INTEGER},                   "
			+"#{wcxyMValue34,jdbcType=INTEGER}, #{wcxyLValue34,jdbcType=INTEGER}, #{wcxyHValue35,jdbcType=INTEGER},                   "
			+"#{wcxyMValue35,jdbcType=INTEGER}, #{wcxyLValue35,jdbcType=INTEGER}, #{wcxyWc,jdbcType=INTEGER},                         "
			+"#{wcxyResult,jdbcType=TINYINT}, #{wcxyjtSd,jdbcType=INTEGER}, #{wcxyjtMnq,jdbcType=INTEGER},                            "
			+"#{wcxyjtJhy,jdbcType=INTEGER}, #{wcxyjtWc,jdbcType=INTEGER}, #{wcxyjtResult,jdbcType=TINYINT},                          "
			+"#{wcxyqmSd,jdbcType=INTEGER}, #{wcxyqmXll,jdbcType=INTEGER}, #{wcxyqmWc,jdbcType=INTEGER},                              "
			+"#{wcxyqmResult,jdbcType=TINYINT}, #{sgbjResult,jdbcType=TINYINT}, #{bjxjcResult,jdbcType=TINYINT},                      "
			+"#{jyjcResult,jdbcType=TINYINT}, #{state}, #{spare2,jdbcType=VARCHAR},                                 "
			+"#{spare3,jdbcType=VARCHAR})")
	@Options(useGeneratedKeys = true, keyProperty = "dcid", keyColumn = "dcid")
	public void saveMan( Dcsjhy dcsjhy);
	@Update("update dcsjhy_m\n" +
			"    set jcyq_id = #{jcyqId,jdbcType=INTEGER},\n" +
			"      eq_id = #{eqId,jdbcType=INTEGER},\n" +
			"      tester = #{tester,jdbcType=VARCHAR},\n" +
			"      test_time = #{testTime,jdbcType=TIMESTAMP},\n" +
			"      auditor = #{auditor,jdbcType=VARCHAR},\n" +
			"      shsj_time = #{shsjTime,jdbcType=TIMESTAMP},\n" +
			"      shr_jcjl = #{shrJcjl,jdbcType=VARCHAR},\n" +
			"      jcjl = #{jcjl,jdbcType=VARCHAR},\n" +
			"      jcsm = #{jcsm,jdbcType=VARCHAR},\n" +
			"      xl_test1 = #{xlTest1,jdbcType=INTEGER},\n" +
			"      xl_test2 = #{xlTest2,jdbcType=INTEGER},\n" +
			"      xl_test3 = #{xlTest3,jdbcType=INTEGER},\n" +
			"      xl_test4 = #{xlTest4,jdbcType=INTEGER},\n" +
			"      xl_test5 = #{xlTest5,jdbcType=INTEGER},\n" +
			"      xl_value1 = #{xlValue1,jdbcType=INTEGER},\n" +
			"      xl_value2 = #{xlValue2,jdbcType=INTEGER},\n" +
			"      xl_value3 = #{xlValue3,jdbcType=INTEGER},\n" +
			"      xl_value4 = #{xlValue4,jdbcType=INTEGER},\n" +
			"      xl_value5 = #{xlValue5,jdbcType=INTEGER},\n" +
			"      xl_wc = #{xlWc,jdbcType=INTEGER},\n" +
			"      xl_result = #{xlResult,jdbcType=TINYINT},\n" +
			"      hxl_test1 = #{hxlTest1,jdbcType=INTEGER},\n" +
			"      hxl_test2 = #{hxlTest2,jdbcType=INTEGER},\n" +
			"      hxl_test3 = #{hxlTest3,jdbcType=INTEGER},\n" +
			"      hxl_test4 = #{hxlTest4,jdbcType=INTEGER},\n" +
			"      hxl_test5 = #{hxlTest5,jdbcType=INTEGER},\n" +
			"      hxl_value1 = #{hxlValue1,jdbcType=INTEGER},\n" +
			"      hxl_value2 = #{hxlValue2,jdbcType=INTEGER},\n" +
			"      hxl_value3 = #{hxlValue3,jdbcType=INTEGER},\n" +
			"      hxl_value4 = #{hxlValue4,jdbcType=INTEGER},\n" +
			"      hxl_value5 = #{hxlValue5,jdbcType=INTEGER},\n" +
			"      hxl_wc = #{hxlWc,jdbcType=INTEGER},\n" +
			"      hxl_result = #{hxlResult,jdbcType=TINYINT},\n" +
			"      xybhd_test1 = #{xybhdTest1,jdbcType=INTEGER},\n" +
			"      xybhd_test2 = #{xybhdTest2,jdbcType=INTEGER},\n" +
			"      xybhd_test3 = #{xybhdTest3,jdbcType=INTEGER},\n" +
			"      xybhd_test4 = #{xybhdTest4,jdbcType=INTEGER},\n" +
			"      xybhd_test5 = #{xybhdTest5,jdbcType=INTEGER},\n" +
			"      xybhd_value1 = #{xybhdValue1,jdbcType=INTEGER},\n" +
			"      xybhd_value2 = #{xybhdValue2,jdbcType=INTEGER},\n" +
			"      xybhd_value3 = #{xybhdValue3,jdbcType=INTEGER},\n" +
			"      xybhd_value4 = #{xybhdValue4,jdbcType=INTEGER},\n" +
			"      xybhd_value5 = #{xybhdValue5,jdbcType=INTEGER},\n" +
			"      xybhd_wc = #{xybhdWc,jdbcType=INTEGER},\n" +
			"      xybhd_result = #{xybhdResult,jdbcType=TINYINT},\n" +
			"      wcxy_h_test1 = #{wcxyHTest1,jdbcType=INTEGER},\n" +
			"      wcxy_m_test1 = #{wcxyMTest1,jdbcType=INTEGER},\n" +
			"      wcxy_l_test1 = #{wcxyLTest1,jdbcType=INTEGER},\n" +
			"      wcxy_h_test2 = #{wcxyHTest2,jdbcType=INTEGER},\n" +
			"      wcxy_m_test2 = #{wcxyMTest2,jdbcType=INTEGER},\n" +
			"      wcxy_l_test2 = #{wcxyLTest2,jdbcType=INTEGER},\n" +
			"      wcxy_h_test3 = #{wcxyHTest3,jdbcType=INTEGER},\n" +
			"      wcxy_m_test3 = #{wcxyMTest3,jdbcType=INTEGER},\n" +
			"      wcxy_l_test3 = #{wcxyLTest3,jdbcType=INTEGER},\n" +
			"      wcxy_h_test4 = #{wcxyHTest4,jdbcType=INTEGER},\n" +
			"      wcxy_m_test4 = #{wcxyMTest4,jdbcType=INTEGER},\n" +
			"      wcxy_l_test4 = #{wcxyLTest4,jdbcType=INTEGER},\n" +
			"      wcxy_h_test5 = #{wcxyHTest5,jdbcType=INTEGER},\n" +
			"      wcxy_m_test5 = #{wcxyMTest5,jdbcType=INTEGER},\n" +
			"      wcxy_l_test5 = #{wcxyLTest5,jdbcType=INTEGER},\n" +
			"      wcxy_h_value11 = #{wcxyHValue11,jdbcType=INTEGER},\n" +
			"      wcxy_m_value11 = #{wcxyMValue11,jdbcType=INTEGER},\n" +
			"      wcxy_l_value11 = #{wcxyLValue11,jdbcType=INTEGER},\n" +
			"      wcxy_h_value12 = #{wcxyHValue12,jdbcType=INTEGER},\n" +
			"      wcxy_m_value12 = #{wcxyMValue12,jdbcType=INTEGER},\n" +
			"      wcxy_l_value12 = #{wcxyLValue12,jdbcType=INTEGER},\n" +
			"      wcxy_h_value13 = #{wcxyHValue13,jdbcType=INTEGER},\n" +
			"      wcxy_m_value13 = #{wcxyMValue13,jdbcType=INTEGER},\n" +
			"      wcxy_l_value13 = #{wcxyLValue13,jdbcType=INTEGER},\n" +
			"      wcxy_h_value14 = #{wcxyHValue14,jdbcType=INTEGER},\n" +
			"      wcxy_m_value14 = #{wcxyMValue14,jdbcType=INTEGER},\n" +
			"      wcxy_l_value14 = #{wcxyLValue14,jdbcType=INTEGER},\n" +
			"      wcxy_h_value15 = #{wcxyHValue15,jdbcType=INTEGER},\n" +
			"      wcxy_m_value15 = #{wcxyMValue15,jdbcType=INTEGER},\n" +
			"      wcxy_l_value15 = #{wcxyLValue15,jdbcType=INTEGER},\n" +
			"      wcxy_h_value21 = #{wcxyHValue21,jdbcType=INTEGER},\n" +
			"      wcxy_m_value21 = #{wcxyMValue21,jdbcType=INTEGER},\n" +
			"      wcxy_l_value21 = #{wcxyLValue21,jdbcType=INTEGER},\n" +
			"      wcxy_h_value22 = #{wcxyHValue22,jdbcType=INTEGER},\n" +
			"      wcxy_m_value22 = #{wcxyMValue22,jdbcType=INTEGER},\n" +
			"      wcxy_l_value22 = #{wcxyLValue22,jdbcType=INTEGER},\n" +
			"      wcxy_h_value23 = #{wcxyHValue23,jdbcType=INTEGER},\n" +
			"      wcxy_m_value23 = #{wcxyMValue23,jdbcType=INTEGER},\n" +
			"      wcxy_l_value23 = #{wcxyLValue23,jdbcType=INTEGER},\n" +
			"      wcxy_h_value24 = #{wcxyHValue24,jdbcType=INTEGER},\n" +
			"      wcxy_m_value24 = #{wcxyMValue24,jdbcType=INTEGER},\n" +
			"      wcxy_l_value24 = #{wcxyLValue24,jdbcType=INTEGER},\n" +
			"      wcxy_h_value25 = #{wcxyHValue25,jdbcType=INTEGER},\n" +
			"      wcxy_m_value25 = #{wcxyMValue25,jdbcType=INTEGER},\n" +
			"      wcxy_l_value25 = #{wcxyLValue25,jdbcType=INTEGER},\n" +
			"      wcxy_h_value31 = #{wcxyHValue31,jdbcType=INTEGER},\n" +
			"      wcxy_m_value31 = #{wcxyMValue31,jdbcType=INTEGER},\n" +
			"      wcxy_l_value31 = #{wcxyLValue31,jdbcType=INTEGER},\n" +
			"      wcxy_h_value32 = #{wcxyHValue32,jdbcType=INTEGER},\n" +
			"      wcxy_m_value32 = #{wcxyMValue32,jdbcType=INTEGER},\n" +
			"      wcxy_l_value32 = #{wcxyLValue32,jdbcType=INTEGER},\n" +
			"      wcxy_h_value33 = #{wcxyHValue33,jdbcType=INTEGER},\n" +
			"      wcxy_m_value33 = #{wcxyMValue33,jdbcType=INTEGER},\n" +
			"      wcxy_l_value33 = #{wcxyLValue33,jdbcType=INTEGER},\n" +
			"      wcxy_h_value34 = #{wcxyHValue34,jdbcType=INTEGER},\n" +
			"      wcxy_m_value34 = #{wcxyMValue34,jdbcType=INTEGER},\n" +
			"      wcxy_l_value34 = #{wcxyLValue34,jdbcType=INTEGER},\n" +
			"      wcxy_h_value35 = #{wcxyHValue35,jdbcType=INTEGER},\n" +
			"      wcxy_m_value35 = #{wcxyMValue35,jdbcType=INTEGER},\n" +
			"      wcxy_l_value35 = #{wcxyLValue35,jdbcType=INTEGER},\n" +
			"      wcxy_wc = #{wcxyWc,jdbcType=INTEGER},\n" +
			"      wcxy_result = #{wcxyResult,jdbcType=TINYINT},\n" +
			"      wcxyjt_sd = #{wcxyjtSd,jdbcType=INTEGER},\n" +
			"      wcxyjt_mnq = #{wcxyjtMnq,jdbcType=INTEGER},\n" +
			"      wcxyjt_jhy = #{wcxyjtJhy,jdbcType=INTEGER},\n" +
			"      wcxyjt_wc = #{wcxyjtWc,jdbcType=INTEGER},\n" +
			"      wcxyjt_result = #{wcxyjtResult,jdbcType=TINYINT},\n" +
			"      wcxyqm_sd = #{wcxyqmSd,jdbcType=INTEGER},\n" +
			"      wcxyqm_xll = #{wcxyqmXll,jdbcType=INTEGER},\n" +
			"      wcxyqm_wc = #{wcxyqmWc,jdbcType=INTEGER},\n" +
			"      wcxyqm_result = #{wcxyqmResult,jdbcType=TINYINT},\n" +
			"      sgbj_result = #{sgbjResult,jdbcType=TINYINT},\n" +
			"      bjxjc_result = #{bjxjcResult,jdbcType=TINYINT},\n" +
			"      jyjc_result = #{jyjcResult,jdbcType=TINYINT},\n" +
			"      state = #{state,jdbcType=VARCHAR},\n" +
			"      spare2 = #{spare2,jdbcType=VARCHAR},\n" +
			"      spare3 = #{spare3,jdbcType=VARCHAR}\n" +
			"    where dcid = #{dcid,jdbcType=INTEGER}")
	public void updateMen( Dcsjhy dcsjhy);
	//保存多参数监护仪检测表(幼儿)
	@Insert("insert into dcsjhy_c (dcid, jcyq_id, eq_id,tester, auditor, shsj_time,test_time,shr_jcjl, jcjl, jcsm, xl_test1,                         "
			+"xl_test2, xl_test3, xl_test4, xl_test5, xl_value1, xl_value2,  xl_value3, xl_value4, xl_value5,                         "
			+"xl_wc, xl_result, hxl_test1,  hxl_test2, hxl_test3, hxl_test4, hxl_test5, hxl_value1, hxl_value2,                       "
			+"hxl_value3, hxl_value4, hxl_value5, hxl_wc, hxl_result, xybhd_test1,xybhd_test2, xybhd_test3, xybhd_test4,              "
			+"xybhd_test5, xybhd_value1, xybhd_value2, xybhd_value3, xybhd_value4, xybhd_value5,                                      "
			+"xybhd_wc, xybhd_result, wcxy_h_test1, wcxy_m_test1, wcxy_l_test1, wcxy_h_test2,                                         "
			+"wcxy_m_test2, wcxy_l_test2, wcxy_h_test3, wcxy_m_test3, wcxy_l_test3, wcxy_h_test4,                                     "
			+"wcxy_m_test4, wcxy_l_test4, wcxy_h_test5, wcxy_m_test5, wcxy_l_test5, wcxy_h_value11,                                   "
			+"wcxy_m_value11, wcxy_l_value11, wcxy_h_value12, wcxy_m_value12, wcxy_l_value12, wcxy_h_value13,                         "
			+"wcxy_m_value13, wcxy_l_value13, wcxy_h_value14, wcxy_m_value14, wcxy_l_value14, wcxy_h_value15,                         "
			+"wcxy_m_value15, wcxy_l_value15, wcxy_h_value21,  wcxy_m_value21, wcxy_l_value21, wcxy_h_value22,                        "
			+"wcxy_m_value22, wcxy_l_value22, wcxy_h_value23,  wcxy_m_value23, wcxy_l_value23, wcxy_h_value24,                        "
			+"wcxy_m_value24, wcxy_l_value24, wcxy_h_value25,  wcxy_m_value25, wcxy_l_value25, wcxy_h_value31,                        "
			+"wcxy_m_value31, wcxy_l_value31, wcxy_h_value32, wcxy_m_value32, wcxy_l_value32, wcxy_h_value33,                         "
			+"wcxy_m_value33, wcxy_l_value33, wcxy_h_value34, wcxy_m_value34, wcxy_l_value34, wcxy_h_value35,                         "
			+"wcxy_m_value35, wcxy_l_value35, wcxy_wc, wcxy_result, wcxyjt_sd, wcxyjt_mnq, wcxyjt_jhy, wcxyjt_wc, wcxyjt_result,      "
			+"wcxyqm_sd, wcxyqm_xll, wcxyqm_wc,  wcxyqm_result, sgbj_result, bjxjc_result, jyjc_result, state, spare2,  spare3)      "
			+"values (#{dcid,jdbcType=INTEGER}, #{jcyqId,jdbcType=INTEGER}, #{eqId,jdbcType=INTEGER},                                 "
			+"#{tester,jdbcType=VARCHAR}, #{auditor,jdbcType=VARCHAR}, #{shsjTime},#{testTime,jdbcType=TIMESTAMP},                                "
			+"#{shrJcjl,jdbcType=VARCHAR},#{jcjl,jdbcType=VARCHAR}, #{jcsm,jdbcType=VARCHAR}, #{xlTest1,jdbcType=INTEGER},                                        "
			+"#{xlTest2,jdbcType=INTEGER}, #{xlTest3,jdbcType=INTEGER}, #{xlTest4,jdbcType=INTEGER},                                  "
			+"#{xlTest5,jdbcType=INTEGER}, #{xlValue1,jdbcType=INTEGER}, #{xlValue2,jdbcType=INTEGER},                                "
			+"#{xlValue3,jdbcType=INTEGER}, #{xlValue4,jdbcType=INTEGER}, #{xlValue5,jdbcType=INTEGER},                               "
			+"#{xlWc,jdbcType=INTEGER}, #{xlResult,jdbcType=TINYINT}, #{hxlTest1,jdbcType=INTEGER},                                   "
			+"#{hxlTest2,jdbcType=INTEGER}, #{hxlTest3,jdbcType=INTEGER}, #{hxlTest4,jdbcType=INTEGER},                               "
			+"#{hxlTest5,jdbcType=INTEGER}, #{hxlValue1,jdbcType=INTEGER}, #{hxlValue2,jdbcType=INTEGER},                             "
			+"#{hxlValue3,jdbcType=INTEGER}, #{hxlValue4,jdbcType=INTEGER}, #{hxlValue5,jdbcType=INTEGER},                            "
			+"#{hxlWc,jdbcType=INTEGER}, #{hxlResult,jdbcType=TINYINT}, #{xybhdTest1,jdbcType=INTEGER},                               "
			+"#{xybhdTest2,jdbcType=INTEGER}, #{xybhdTest3,jdbcType=INTEGER}, #{xybhdTest4,jdbcType=INTEGER},                         "
			+"#{xybhdTest5,jdbcType=INTEGER}, #{xybhdValue1,jdbcType=INTEGER}, #{xybhdValue2,jdbcType=INTEGER},                       "
			+"#{xybhdValue3,jdbcType=INTEGER}, #{xybhdValue4,jdbcType=INTEGER}, #{xybhdValue5,jdbcType=INTEGER},                      "
			+"#{xybhdWc,jdbcType=INTEGER}, #{xybhdResult,jdbcType=TINYINT}, #{wcxyHTest1,jdbcType=INTEGER},                           "
			+"#{wcxyMTest1,jdbcType=INTEGER}, #{wcxyLTest1,jdbcType=INTEGER}, #{wcxyHTest2,jdbcType=INTEGER},                         "
			+"#{wcxyMTest2,jdbcType=INTEGER}, #{wcxyLTest2,jdbcType=INTEGER}, #{wcxyHTest3,jdbcType=INTEGER},                         "
			+"#{wcxyMTest3,jdbcType=INTEGER}, #{wcxyLTest3,jdbcType=INTEGER}, #{wcxyHTest4,jdbcType=INTEGER},                         "
			+"#{wcxyMTest4,jdbcType=INTEGER}, #{wcxyLTest4,jdbcType=INTEGER}, #{wcxyHTest5,jdbcType=INTEGER},                         "
			+"#{wcxyMTest5,jdbcType=INTEGER}, #{wcxyLTest5,jdbcType=INTEGER}, #{wcxyHValue11,jdbcType=INTEGER},                       "
			+"#{wcxyMValue11,jdbcType=INTEGER}, #{wcxyLValue11,jdbcType=INTEGER}, #{wcxyHValue12,jdbcType=INTEGER},                   "
			+"#{wcxyMValue12,jdbcType=INTEGER}, #{wcxyLValue12,jdbcType=INTEGER}, #{wcxyHValue13,jdbcType=INTEGER},                   "
			+"#{wcxyMValue13,jdbcType=INTEGER}, #{wcxyLValue13,jdbcType=INTEGER}, #{wcxyHValue14,jdbcType=INTEGER},                   "
			+"#{wcxyMValue14,jdbcType=INTEGER}, #{wcxyLValue14,jdbcType=INTEGER}, #{wcxyHValue15,jdbcType=INTEGER},                   "
			+"#{wcxyMValue15,jdbcType=INTEGER}, #{wcxyLValue15,jdbcType=INTEGER}, #{wcxyHValue21,jdbcType=INTEGER},                   "
			+"#{wcxyMValue21,jdbcType=INTEGER}, #{wcxyLValue21,jdbcType=INTEGER}, #{wcxyHValue22,jdbcType=INTEGER},                   "
			+"#{wcxyMValue22,jdbcType=INTEGER}, #{wcxyLValue22,jdbcType=INTEGER}, #{wcxyHValue23,jdbcType=INTEGER},                   "
			+"#{wcxyMValue23,jdbcType=INTEGER}, #{wcxyLValue23,jdbcType=INTEGER}, #{wcxyHValue24,jdbcType=INTEGER},                   "
			+"#{wcxyMValue24,jdbcType=INTEGER}, #{wcxyLValue24,jdbcType=INTEGER}, #{wcxyHValue25,jdbcType=INTEGER},                   "
			+"#{wcxyMValue25,jdbcType=INTEGER}, #{wcxyLValue25,jdbcType=INTEGER}, #{wcxyHValue31,jdbcType=INTEGER},                   "
			+"#{wcxyMValue31,jdbcType=INTEGER}, #{wcxyLValue31,jdbcType=INTEGER}, #{wcxyHValue32,jdbcType=INTEGER},                   "
			+"#{wcxyMValue32,jdbcType=INTEGER}, #{wcxyLValue32,jdbcType=INTEGER}, #{wcxyHValue33,jdbcType=INTEGER},                   "
			+"#{wcxyMValue33,jdbcType=INTEGER}, #{wcxyLValue33,jdbcType=INTEGER}, #{wcxyHValue34,jdbcType=INTEGER},                   "
			+"#{wcxyMValue34,jdbcType=INTEGER}, #{wcxyLValue34,jdbcType=INTEGER}, #{wcxyHValue35,jdbcType=INTEGER},                   "
			+"#{wcxyMValue35,jdbcType=INTEGER}, #{wcxyLValue35,jdbcType=INTEGER}, #{wcxyWc,jdbcType=INTEGER},                         "
			+"#{wcxyResult,jdbcType=TINYINT}, #{wcxyjtSd,jdbcType=INTEGER}, #{wcxyjtMnq,jdbcType=INTEGER},                            "
			+"#{wcxyjtJhy,jdbcType=INTEGER}, #{wcxyjtWc,jdbcType=INTEGER}, #{wcxyjtResult,jdbcType=TINYINT},                          "
			+"#{wcxyqmSd,jdbcType=INTEGER}, #{wcxyqmXll,jdbcType=INTEGER}, #{wcxyqmWc,jdbcType=INTEGER},                              "
			+"#{wcxyqmResult,jdbcType=TINYINT}, #{sgbjResult,jdbcType=TINYINT}, #{bjxjcResult,jdbcType=TINYINT},                      "
			+"#{jyjcResult,jdbcType=TINYINT}, #{state}, #{spare2,jdbcType=VARCHAR},                                 "
			+"#{spare3,jdbcType=VARCHAR})")
	@Options(useGeneratedKeys = true, keyProperty = "dcid", keyColumn = "dcid")
	public void saveChild( Dcsjhy dcsjhy);
	@Update("update dcsjhy_m\n" +
			"    set jcyq_id = #{jcyqId,jdbcType=INTEGER},\n" +
			"      eq_id = #{eqId,jdbcType=INTEGER},\n" +
			"      tester = #{tester,jdbcType=VARCHAR},\n" +
			"      test_time = #{testTime,jdbcType=TIMESTAMP},\n" +
			"      auditor = #{auditor,jdbcType=VARCHAR},\n" +
			"      shsj_time = #{shsjTime,jdbcType=TIMESTAMP},\n" +
			"      shr_jcjl = #{shrJcjl,jdbcType=VARCHAR},\n" +
			"      jcjl = #{jcjl,jdbcType=VARCHAR},\n" +
			"      jcsm = #{jcsm,jdbcType=VARCHAR},\n" +
			"      xl_test1 = #{xlTest1,jdbcType=INTEGER},\n" +
			"      xl_test2 = #{xlTest2,jdbcType=INTEGER},\n" +
			"      xl_test3 = #{xlTest3,jdbcType=INTEGER},\n" +
			"      xl_test4 = #{xlTest4,jdbcType=INTEGER},\n" +
			"      xl_test5 = #{xlTest5,jdbcType=INTEGER},\n" +
			"      xl_value1 = #{xlValue1,jdbcType=INTEGER},\n" +
			"      xl_value2 = #{xlValue2,jdbcType=INTEGER},\n" +
			"      xl_value3 = #{xlValue3,jdbcType=INTEGER},\n" +
			"      xl_value4 = #{xlValue4,jdbcType=INTEGER},\n" +
			"      xl_value5 = #{xlValue5,jdbcType=INTEGER},\n" +
			"      xl_wc = #{xlWc,jdbcType=INTEGER},\n" +
			"      xl_result = #{xlResult,jdbcType=TINYINT},\n" +
			"      hxl_test1 = #{hxlTest1,jdbcType=INTEGER},\n" +
			"      hxl_test2 = #{hxlTest2,jdbcType=INTEGER},\n" +
			"      hxl_test3 = #{hxlTest3,jdbcType=INTEGER},\n" +
			"      hxl_test4 = #{hxlTest4,jdbcType=INTEGER},\n" +
			"      hxl_test5 = #{hxlTest5,jdbcType=INTEGER},\n" +
			"      hxl_value1 = #{hxlValue1,jdbcType=INTEGER},\n" +
			"      hxl_value2 = #{hxlValue2,jdbcType=INTEGER},\n" +
			"      hxl_value3 = #{hxlValue3,jdbcType=INTEGER},\n" +
			"      hxl_value4 = #{hxlValue4,jdbcType=INTEGER},\n" +
			"      hxl_value5 = #{hxlValue5,jdbcType=INTEGER},\n" +
			"      hxl_wc = #{hxlWc,jdbcType=INTEGER},\n" +
			"      hxl_result = #{hxlResult,jdbcType=TINYINT},\n" +
			"      xybhd_test1 = #{xybhdTest1,jdbcType=INTEGER},\n" +
			"      xybhd_test2 = #{xybhdTest2,jdbcType=INTEGER},\n" +
			"      xybhd_test3 = #{xybhdTest3,jdbcType=INTEGER},\n" +
			"      xybhd_test4 = #{xybhdTest4,jdbcType=INTEGER},\n" +
			"      xybhd_test5 = #{xybhdTest5,jdbcType=INTEGER},\n" +
			"      xybhd_value1 = #{xybhdValue1,jdbcType=INTEGER},\n" +
			"      xybhd_value2 = #{xybhdValue2,jdbcType=INTEGER},\n" +
			"      xybhd_value3 = #{xybhdValue3,jdbcType=INTEGER},\n" +
			"      xybhd_value4 = #{xybhdValue4,jdbcType=INTEGER},\n" +
			"      xybhd_value5 = #{xybhdValue5,jdbcType=INTEGER},\n" +
			"      xybhd_wc = #{xybhdWc,jdbcType=INTEGER},\n" +
			"      xybhd_result = #{xybhdResult,jdbcType=TINYINT},\n" +
			"      wcxy_h_test1 = #{wcxyHTest1,jdbcType=INTEGER},\n" +
			"      wcxy_m_test1 = #{wcxyMTest1,jdbcType=INTEGER},\n" +
			"      wcxy_l_test1 = #{wcxyLTest1,jdbcType=INTEGER},\n" +
			"      wcxy_h_test2 = #{wcxyHTest2,jdbcType=INTEGER},\n" +
			"      wcxy_m_test2 = #{wcxyMTest2,jdbcType=INTEGER},\n" +
			"      wcxy_l_test2 = #{wcxyLTest2,jdbcType=INTEGER},\n" +
			"      wcxy_h_test3 = #{wcxyHTest3,jdbcType=INTEGER},\n" +
			"      wcxy_m_test3 = #{wcxyMTest3,jdbcType=INTEGER},\n" +
			"      wcxy_l_test3 = #{wcxyLTest3,jdbcType=INTEGER},\n" +
			"      wcxy_h_test4 = #{wcxyHTest4,jdbcType=INTEGER},\n" +
			"      wcxy_m_test4 = #{wcxyMTest4,jdbcType=INTEGER},\n" +
			"      wcxy_l_test4 = #{wcxyLTest4,jdbcType=INTEGER},\n" +
			"      wcxy_h_test5 = #{wcxyHTest5,jdbcType=INTEGER},\n" +
			"      wcxy_m_test5 = #{wcxyMTest5,jdbcType=INTEGER},\n" +
			"      wcxy_l_test5 = #{wcxyLTest5,jdbcType=INTEGER},\n" +
			"      wcxy_h_value11 = #{wcxyHValue11,jdbcType=INTEGER},\n" +
			"      wcxy_m_value11 = #{wcxyMValue11,jdbcType=INTEGER},\n" +
			"      wcxy_l_value11 = #{wcxyLValue11,jdbcType=INTEGER},\n" +
			"      wcxy_h_value12 = #{wcxyHValue12,jdbcType=INTEGER},\n" +
			"      wcxy_m_value12 = #{wcxyMValue12,jdbcType=INTEGER},\n" +
			"      wcxy_l_value12 = #{wcxyLValue12,jdbcType=INTEGER},\n" +
			"      wcxy_h_value13 = #{wcxyHValue13,jdbcType=INTEGER},\n" +
			"      wcxy_m_value13 = #{wcxyMValue13,jdbcType=INTEGER},\n" +
			"      wcxy_l_value13 = #{wcxyLValue13,jdbcType=INTEGER},\n" +
			"      wcxy_h_value14 = #{wcxyHValue14,jdbcType=INTEGER},\n" +
			"      wcxy_m_value14 = #{wcxyMValue14,jdbcType=INTEGER},\n" +
			"      wcxy_l_value14 = #{wcxyLValue14,jdbcType=INTEGER},\n" +
			"      wcxy_h_value15 = #{wcxyHValue15,jdbcType=INTEGER},\n" +
			"      wcxy_m_value15 = #{wcxyMValue15,jdbcType=INTEGER},\n" +
			"      wcxy_l_value15 = #{wcxyLValue15,jdbcType=INTEGER},\n" +
			"      wcxy_h_value21 = #{wcxyHValue21,jdbcType=INTEGER},\n" +
			"      wcxy_m_value21 = #{wcxyMValue21,jdbcType=INTEGER},\n" +
			"      wcxy_l_value21 = #{wcxyLValue21,jdbcType=INTEGER},\n" +
			"      wcxy_h_value22 = #{wcxyHValue22,jdbcType=INTEGER},\n" +
			"      wcxy_m_value22 = #{wcxyMValue22,jdbcType=INTEGER},\n" +
			"      wcxy_l_value22 = #{wcxyLValue22,jdbcType=INTEGER},\n" +
			"      wcxy_h_value23 = #{wcxyHValue23,jdbcType=INTEGER},\n" +
			"      wcxy_m_value23 = #{wcxyMValue23,jdbcType=INTEGER},\n" +
			"      wcxy_l_value23 = #{wcxyLValue23,jdbcType=INTEGER},\n" +
			"      wcxy_h_value24 = #{wcxyHValue24,jdbcType=INTEGER},\n" +
			"      wcxy_m_value24 = #{wcxyMValue24,jdbcType=INTEGER},\n" +
			"      wcxy_l_value24 = #{wcxyLValue24,jdbcType=INTEGER},\n" +
			"      wcxy_h_value25 = #{wcxyHValue25,jdbcType=INTEGER},\n" +
			"      wcxy_m_value25 = #{wcxyMValue25,jdbcType=INTEGER},\n" +
			"      wcxy_l_value25 = #{wcxyLValue25,jdbcType=INTEGER},\n" +
			"      wcxy_h_value31 = #{wcxyHValue31,jdbcType=INTEGER},\n" +
			"      wcxy_m_value31 = #{wcxyMValue31,jdbcType=INTEGER},\n" +
			"      wcxy_l_value31 = #{wcxyLValue31,jdbcType=INTEGER},\n" +
			"      wcxy_h_value32 = #{wcxyHValue32,jdbcType=INTEGER},\n" +
			"      wcxy_m_value32 = #{wcxyMValue32,jdbcType=INTEGER},\n" +
			"      wcxy_l_value32 = #{wcxyLValue32,jdbcType=INTEGER},\n" +
			"      wcxy_h_value33 = #{wcxyHValue33,jdbcType=INTEGER},\n" +
			"      wcxy_m_value33 = #{wcxyMValue33,jdbcType=INTEGER},\n" +
			"      wcxy_l_value33 = #{wcxyLValue33,jdbcType=INTEGER},\n" +
			"      wcxy_h_value34 = #{wcxyHValue34,jdbcType=INTEGER},\n" +
			"      wcxy_m_value34 = #{wcxyMValue34,jdbcType=INTEGER},\n" +
			"      wcxy_l_value34 = #{wcxyLValue34,jdbcType=INTEGER},\n" +
			"      wcxy_h_value35 = #{wcxyHValue35,jdbcType=INTEGER},\n" +
			"      wcxy_m_value35 = #{wcxyMValue35,jdbcType=INTEGER},\n" +
			"      wcxy_l_value35 = #{wcxyLValue35,jdbcType=INTEGER},\n" +
			"      wcxy_wc = #{wcxyWc,jdbcType=INTEGER},\n" +
			"      wcxy_result = #{wcxyResult,jdbcType=TINYINT},\n" +
			"      wcxyjt_sd = #{wcxyjtSd,jdbcType=INTEGER},\n" +
			"      wcxyjt_mnq = #{wcxyjtMnq,jdbcType=INTEGER},\n" +
			"      wcxyjt_jhy = #{wcxyjtJhy,jdbcType=INTEGER},\n" +
			"      wcxyjt_wc = #{wcxyjtWc,jdbcType=INTEGER},\n" +
			"      wcxyjt_result = #{wcxyjtResult,jdbcType=TINYINT},\n" +
			"      wcxyqm_sd = #{wcxyqmSd,jdbcType=INTEGER},\n" +
			"      wcxyqm_xll = #{wcxyqmXll,jdbcType=INTEGER},\n" +
			"      wcxyqm_wc = #{wcxyqmWc,jdbcType=INTEGER},\n" +
			"      wcxyqm_result = #{wcxyqmResult,jdbcType=TINYINT},\n" +
			"      sgbj_result = #{sgbjResult,jdbcType=TINYINT},\n" +
			"      bjxjc_result = #{bjxjcResult,jdbcType=TINYINT},\n" +
			"      jyjc_result = #{jyjcResult,jdbcType=TINYINT},\n" +
			"      state = #{state,jdbcType=VARCHAR},\n" +
			"      spare2 = #{spare2,jdbcType=VARCHAR},\n" +
			"      spare3 = #{spare3,jdbcType=VARCHAR}\n" +
			"    where dcid = #{dcid,jdbcType=INTEGER}")
	public void updateChild( Dcsjhy dcsjhy);


	//根据设备Id,检测仪器Id以及状态查询最后一条记录
	@Select("select * from ${tableName} where eq_id=#{eqId} and jcyq_id=#{jcyqId} order by dcid desc limit 1" )
	Dcsjhy findByEqIdandJcyqIdLast(@Param("tableName") String tableName, @Param("eqId")String eqId, @Param("jcyqId")String jcyqId);
	//根据设备Id,检测仪器Id以及状态查询
	@Select("select * from ${tableName} where eq_id=#{eqId} and jcyq_id=#{jcyqId}" )
	List<Dcsjhy> findByEqIdandJcyqId(@Param("tableName") String tableName,@Param("eqId")String eqId,@Param("jcyqId")String jcyqId);

	/*@Select("select * from dcsjhy_m order by dcid desc limit 1")
	Dcsjhy findDcsjhyMan();
	@Select("select * from dcsjhy_m where eq_id=#{eqId} and jcyq_id=#{jcyqId}")
	List<Dcsjhy> findByEqIdandJcyqIdMan(@Param("eqId")String eqId,@Param("jcyqId")String jcyqId);
	//查询多参数监护仪检测单条数据（幼儿）
	@Select("select * from dcsjhy_c order by dcid desc limit 1")
	Dcsjhy findDcsjhyChild();
	@Select("select d.* from dcsjhy_c d where eq_id=#{eqId} and jcyq_id=#{jcyqId}")
	List<Dcsjhy>  findByEqIdandJcyqIdCh(@Param("eqId")String eqId,@Param("jcyqId")String jcyqId);*/
	//查询多参数监护仪检测单条数据（成人）
	@Select("select * from dcsjhy_m")
	List<Dcsjhy> findDcsjhyMans();

	//查询多参数监护仪检测单条数据（幼儿）
	@Select("select * from dcsjhy_c")
	 List<Dcsjhy> findDcsjhyChilds();

	//删除数据
	@Delete("delete from dcsjhy_m where eq_id=#{eqId} and jcyq_id=#{jcyqId}")
	void delectMen(@Param("eqId")String eqId,@Param("jcyqId")String jcyqId);
	@Delete("delete from dcsjhy_c where eq_id=#{eqId} and jcyq_id=#{jcyqId}")
	void delectChi(@Param("eqId")String eqId,@Param("jcyqId")String jcyqId);
	//修改状态
	@Update("update dcsjhy_m set state=#{state} where dcid=#{dcid}")
	void updateStateM(@Param("dcid")Integer dcid,@Param("state")Integer state);
	@Update("update dcsjhy_c set state=#{state} where dcid=#{dcid}")
	void updateStateC(@Param("dcid")Integer dcid,@Param("state")Integer state);
	//根据id查询
	@Select("select * from dcsjhy_m where dcid=#{dcid}")
	Dcsjhy findByDcidM(@Param("dcid")Integer dcid);
	@Select("select * from dcsjhy_c where dcid=#{dcid}")
	Dcsjhy findByDcidC(@Param("dcid")Integer dcid);
	//修改审核人意见
	@Update("update dcsjhy_m set shr_jcjl=#{shrJcjl},auditor=#{auditor},shsj_time=#{shsjTime} where dcid=#{dcid}")
	void updateShrJcjyM(@Param("dcid")Integer dcid,@Param("shrJcjl")String shrJcjl,@Param("auditor")String auditor,@Param("shsjTime") Date shsjTime);
	@Update("update dcsjhy_c set shr_jcjl=#{shrJcjl},auditor=#{auditor},shsj_time=#{shsjTime} where dqjcid=#{dqjcid}")
	void updateShrJcjyC(@Param("dcid")Integer dcid,@Param("shrJcjl")String shrJcjl,@Param("auditor")String auditor,@Param("shsjTime") Date shsjTime);
}