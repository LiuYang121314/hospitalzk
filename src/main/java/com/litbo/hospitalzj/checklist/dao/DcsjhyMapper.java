package com.litbo.hospitalzj.checklist.dao;

import com.litbo.hospitalzj.checklist.domain.Dcsjhy;
import com.litbo.hospitalzj.checklist.domain.DcsjhyTemplate;
import com.litbo.hospitalzj.checklist.domain.Dqjc;

import com.litbo.hospitalzj.checklist.vo.DqjcUser;
import com.litbo.hospitalzj.checklist.vo.JhyUser;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.RequestParam;

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

	//保存多参数监护仪检测表(成人)
	@Insert("insert into dcsjhy_m (dcid, jcyq_id, eq_id,tester, auditor, test_time,shr_jcjl,jcjl, jcsm, xl_test1,                         "
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
			+"#{tester,jdbcType=VARCHAR}, #{auditor,jdbcType=VARCHAR}, #{testTime,jdbcType=TIMESTAMP},                                "
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

	//保存多参数监护仪检测表(幼儿)
	@Insert("insert into dcsjhy_c (dcid, jcyq_id, eq_id,tester, auditor, test_time,sh_jcjl, jcjl, jcsm, xl_test1,                         "
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
			+"#{tester,jdbcType=VARCHAR}, #{auditor,jdbcType=VARCHAR}, #{testTime,jdbcType=TIMESTAMP},                                "
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

	//查询多参数监护仪检测单条数据（成人）
	@Select("select * from dcsjhy_m order by dcid desc limit 1")
	Dcsjhy findDcsjhyMan();
	@Select("select d.* from dcsjhy_m d where eq_id=#{eqId} and jcyq_id=#{jcyqId}")
	Dcsjhy findByEqIdandJcyqIdMan(@Param("eqId")String eqId,@Param("jcyqId")String jcyqId);
	//查询多参数监护仪检测单条数据（幼儿）
	@Select("select * from dcsjhy_c order by dcid desc limit 1")
	Dcsjhy findDcsjhyChild();

	@Select("select d.* from dcsjhy_c d where eq_id=#{eqId} and jcyq_id=#{jcyqId} and state=#{state}")
	Dcsjhy findByEqIdandJcyqIdCh(@Param("eqId")String eqId,@Param("jcyqId")String jcyqId);
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
	@Select("select * from dcsjhy_m where dcid=#{dcid} and state=#{state}")
	Dcsjhy findByDcidM(@Param("dcid")Integer dcid,@Param("state")Integer state);
	@Select("select * from dcsjhy_c where dcid=#{dcid} and state=#{state}")
	Dcsjhy findByDcidC(@Param("dcid")Integer dcid,@Param("state")Integer state);
	//查找审核人，审核人意见(成人)
	@Select("select d.*,s.user_name,u.shr_jcjl,u.date " +
			"from dcsjhy_m d left join user_eq u on u.jc_eqid=d.eq_id " +
			"left join s_user s on u.user_id=s.user_id " +
			"where d.eq_id=#{eqId} and d.jcyq_id=#{jcyqId} and d.state=#{state}")
	JhyUser findShrAndShrjcjlM(@Param("eqId")String eqId, @Param("jcyqId")String jcyqId, @Param("state")Integer state);
	@Select("select d.*,s.user_name,u.shr_jcjl,u.date " +
			"from dcsjhy_c d left join user_eq u on u.jc_eqid=d.eq_id " +
			"left join s_user s on u.user_id=s.user_id " +
			"where d.eq_id=#{eqId} and d.jcyq_id=#{jcyqId} and d.state=#{state}")
	JhyUser findShrAndShrjcjlC(@Param("eqId")String eqId, @Param("jcyqId")String jcyqId, @Param("state")Integer state);
	//修改审核人意见
	@Update("update dcsjhy_m set shr_jcjl=#{shrJcjl},auditor=#{auditor} where dcid=#{dcid}")
	void updateShrJcjyM(@Param("dcid")Integer dcid,@Param("shrJcjl")String shrJcjl,@Param("auditor")String auditor);
	@Update("update dcsjhy_c set shr_jcjl=#{shrJcjl},auditor=#{auditor} where dqjcid=#{dqjcid}")
	void updateShrJcjyC(@Param("dcid")Integer dcid,@Param("shrJcjl")String shrJcjl,@Param("auditor")String auditor);
}