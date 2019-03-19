package com.litbo.hospitalzj.checklist.dao;

import com.litbo.hospitalzj.checklist.domain.Hxj;
import com.litbo.hospitalzj.checklist.domain.HxjTemplate;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface HxjMapper {

    //查询模板值
    @Select("select * from hxj_template order by hxj_templateid desc limit 1")
    HxjTemplate findTemplate();


    //查询一条
    @Select("select * from hxj order by hxjid desc limit 1")
    Hxj find();

    //查询所有
    @Select("select * from Hxj")
    List<Hxj> findAll();
    //保存
    @Insert("insert into hxj (hxjid, jcyq_id, eq_id, \n" +
            "      tester, auditor, test_time, \n" +
            "      jcjl, jcsm, cqz_test1, \n" +
            "      cqz_test2, cqz_test3, cqz_sz_value1, \n" +
            "      cqz_sz_value2, cqz_sz_value3, cqz_sc_value1, \n" +
            "      cqz_sc_value2, cqz_sc_value3, cqz_wc, \n" +
            "      cqz_sz_result, cqz_sc_result, qztq_test1, \n" +
            "      qztq_test2, qztq_test3, qztq_sz_value1, \n" +
            "      qztq_sz_value2, qztq_sz_value3, qztq_sc_value1, \n" +
            "      qztq_sc_value2, qztq_sc_value3, qztq_wc, \n" +
            "      qztq_sz_result, qztq_sc_result, xrynd_test1, \n" +
            "      xrynd_test2, xrynd_test3, xrynd_sz_value1, \n" +
            "      xrynd_sz_value2, xrynd_sz_value3, xrynd_sc_value1, \n" +
            "      xrynd_sc_value2, xrynd_sc_value3, xrynd_wc, \n" +
            "      xrynd_sz_result, xrynd_sc_result, xqylsp_test1, \n" +
            "      xqylsp_test2, xqylsp_test3, xqylsp_sz_value1, \n" +
            "      xqylsp_sz_value2, xqylsp_sz_value3, xqylsp_sc_value1, \n" +
            "      xqylsp_sc_value2, xqylsp_sc_value3, xqylsp_wc, \n" +
            "      xqylsp_sz_result, xqylsp_sc_result, hqmzy_test1, \n" +
            "      hqmzy_test2, hqmzy_test3, hqmzy_sz_value1, \n" +
            "      hqmzy_sz_value2, hqmzy_sz_value3, hqmzy_sc_value1, \n" +
            "      hqmzy_sc_value2, hqmzy_sc_value3, hqmzy_wc, \n" +
            "      hqmzy_sz_result, hqmzy_sc_result, dybj_result, \n" +
            "      qybj_result, qdylbj_result, fztqlbj_result, \n" +
            "      yndbj_result, zxbj_result, brhlgybh_result, \n" +
            "      ajgnjc_result, spare1, spare2, \n" +
            "      spare3, spare4)\n" +
            "    values (#{hxjid,jdbcType=INTEGER}, #{jcyqId,jdbcType=INTEGER}, #{eqId,jdbcType=INTEGER}, \n" +
            "      #{tester,jdbcType=VARCHAR}, #{auditor,jdbcType=VARCHAR}, #{testTime,jdbcType=TIMESTAMP}, \n" +
            "      #{jcjl,jdbcType=VARCHAR}, #{jcsm,jdbcType=VARCHAR}, #{cqzTest1,jdbcType=INTEGER}, \n" +
            "      #{cqzTest2,jdbcType=INTEGER}, #{cqzTest3,jdbcType=INTEGER}, #{cqzSzValue1,jdbcType=INTEGER}, \n" +
            "      #{cqzSzValue2,jdbcType=INTEGER}, #{cqzSzValue3,jdbcType=INTEGER}, #{cqzScValue1,jdbcType=INTEGER}, \n" +
            "      #{cqzScValue2,jdbcType=INTEGER}, #{cqzScValue3,jdbcType=INTEGER}, #{cqzWc,jdbcType=VARCHAR}, \n" +
            "      #{cqzSzResult,jdbcType=TINYINT}, #{cqzScResult,jdbcType=TINYINT}, #{qztqTest1,jdbcType=INTEGER}, \n" +
            "      #{qztqTest2,jdbcType=INTEGER}, #{qztqTest3,jdbcType=INTEGER}, #{qztqSzValue1,jdbcType=INTEGER}, \n" +
            "      #{qztqSzValue2,jdbcType=INTEGER}, #{qztqSzValue3,jdbcType=INTEGER}, #{qztqScValue1,jdbcType=INTEGER}, \n" +
            "      #{qztqScValue2,jdbcType=INTEGER}, #{qztqScValue3,jdbcType=INTEGER}, #{qztqWc,jdbcType=INTEGER}, \n" +
            "      #{qztqSzResult,jdbcType=TINYINT}, #{qztqScResult,jdbcType=TINYINT}, #{xryndTest1,jdbcType=INTEGER}, \n" +
            "      #{xryndTest2,jdbcType=INTEGER}, #{xryndTest3,jdbcType=INTEGER}, #{xryndSzValue1,jdbcType=INTEGER}, \n" +
            "      #{xryndSzValue2,jdbcType=INTEGER}, #{xryndSzValue3,jdbcType=INTEGER}, #{xryndScValue1,jdbcType=INTEGER}, \n" +
            "      #{xryndScValue2,jdbcType=INTEGER}, #{xryndScValue3,jdbcType=INTEGER}, #{xryndWc,jdbcType=INTEGER}, \n" +
            "      #{xryndSzResult,jdbcType=TINYINT}, #{xryndScResult,jdbcType=TINYINT}, #{xqylspTest1,jdbcType=INTEGER}, \n" +
            "      #{xqylspTest2,jdbcType=INTEGER}, #{xqylspTest3,jdbcType=INTEGER}, #{xqylspSzValue1,jdbcType=INTEGER}, \n" +
            "      #{xqylspSzValue2,jdbcType=INTEGER}, #{xqylspSzValue3,jdbcType=INTEGER}, #{xqylspScValue1,jdbcType=INTEGER}, \n" +
            "      #{xqylspScValue2,jdbcType=INTEGER}, #{xqylspScValue3,jdbcType=INTEGER}, #{xqylspWc,jdbcType=INTEGER}, \n" +
            "      #{xqylspSzResult,jdbcType=TINYINT}, #{xqylspScResult,jdbcType=TINYINT}, #{hqmzyTest1,jdbcType=INTEGER}, \n" +
            "      #{hqmzyTest2,jdbcType=INTEGER}, #{hqmzyTest3,jdbcType=INTEGER}, #{hqmzySzValue1,jdbcType=INTEGER}, \n" +
            "      #{hqmzySzValue2,jdbcType=INTEGER}, #{hqmzySzValue3,jdbcType=INTEGER}, #{hqmzyScValue1,jdbcType=INTEGER}, \n" +
            "      #{hqmzyScValue2,jdbcType=INTEGER}, #{hqmzyScValue3,jdbcType=INTEGER}, #{hqmzyWc,jdbcType=INTEGER}, \n" +
            "      #{hqmzySzResult,jdbcType=TINYINT}, #{hqmzyScResult,jdbcType=TINYINT}, #{dybjResult,jdbcType=TINYINT}, \n" +
            "      #{qybjResult,jdbcType=TINYINT}, #{qdylbjResult,jdbcType=TINYINT}, #{fztqlbjResult,jdbcType=TINYINT}, \n" +
            "      #{yndbjResult,jdbcType=TINYINT}, #{zxbjResult,jdbcType=TINYINT}, #{brhlgybhResult,jdbcType=TINYINT}, \n" +
            "      #{ajgnjcResult,jdbcType=TINYINT}, #{spare1,jdbcType=TINYINT}, #{spare2,jdbcType=TINYINT}, \n" +
            "      #{spare3,jdbcType=TINYINT}, #{spare4,jdbcType=TINYINT})")
    void save(Hxj hxj);



}
