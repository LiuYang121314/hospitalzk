package com.litbo.hospitalzj.checklist.dao;

import com.litbo.hospitalzj.checklist.domain.Gpdd;
import com.litbo.hospitalzj.zk.domian.GpddTemplate;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface GpddMapper {

    //查询模板值
    @Select("select * from gpdd_template order by gpdd_template_id desc limit 1")
    GpddTemplate findTemplate();


    //查询一条
    @Select("select * from gpdd order by gpddid desc limit 1")
    Gpdd find();

    //查询所有
    @Select("select * from gpdd")
    List<Gpdd> findAll();
    //保存
    @Insert("insert into gpdd (gpddid, jcyq_id, eq_id,  tester, auditor, test_time,    jcjl, jcsm, djdq_test1, \n" +
            "      djdq_value1, djdq_test2, djdq_value2,  djdq_test3, djdq_value3, djdq_test4,  djdq_value4, djdq_wc, djdq_result,   djdn_test1, djdn_value1, djdn_test2, \n" +
            "      djdn_value2, djdn_test3, djdn_value3, djdn_test4, djdn_value4, djdn_wc,   djdn_result, sjdq_test1, sjdq_value1,   sjdq_test2, sjdq_value2, sjdq_test3, \n" +
            "      sjdq_value3, sjdq_test4, sjdq_value4,  sjdq_wc, sjdq_result, sjdn_test1,  sjdn_value1, sjdn_test2, sjdn_value2,   sjdn_test3, sjdn_value3, sjdn_test4, \n" +
            "      sjdn_value4, sjdn_wc, sjdn_result,   ssld_djdq, ssld_djdn, zxld_djdq,  zxld_djdn, djgpld_wc, djgpld_result,  ssld_sjdq, ssld_sjdn, zxld_sjdq, \n" +
            "      zxld_sjdn, sjgpld_wc, sjgpld_result, spare1, spare2, spare3 , spare4, spare5) values (#{gpddid,jdbcType=INTEGER}, #{jcyqId,jdbcType=INTEGER}, #{eqId,jdbcType=INTEGER}, \n" +
            "      #{tester,jdbcType=VARCHAR}, #{auditor,jdbcType=VARCHAR}, #{testTime,jdbcType=TIMESTAMP}, \n" +
            "      #{jcjl,jdbcType=VARCHAR}, #{jcsm,jdbcType=VARCHAR}, #{djdqTest1,jdbcType=DOUBLE}, \n" +
            "      #{djdqValue1,jdbcType=DOUBLE}, #{djdqTest2,jdbcType=DOUBLE}, #{djdqValue2,jdbcType=DOUBLE}, \n" +
            "      #{djdqTest3,jdbcType=DOUBLE}, #{djdqValue3,jdbcType=DOUBLE}, #{djdqTest4,jdbcType=DOUBLE}, \n" +
            "      #{djdqValue4,jdbcType=DOUBLE}, #{djdqWc,jdbcType=INTEGER}, #{djdqResult,jdbcType=TINYINT}, \n" +
            "      #{djdnTest1,jdbcType=DOUBLE}, #{djdnValue1,jdbcType=DOUBLE}, #{djdnTest2,jdbcType=DOUBLE}, \n" +
            "      #{djdnValue2,jdbcType=DOUBLE}, #{djdnTest3,jdbcType=DOUBLE}, #{djdnValue3,jdbcType=DOUBLE}, \n" +
            "      #{djdnTest4,jdbcType=DOUBLE}, #{djdnValue4,jdbcType=DOUBLE}, #{djdnWc,jdbcType=INTEGER}, \n" +
            "      #{djdnResult,jdbcType=TINYINT}, #{sjdqTest1,jdbcType=DOUBLE}, #{sjdqValue1,jdbcType=DOUBLE}, \n" +
            "      #{sjdqTest2,jdbcType=DOUBLE}, #{sjdqValue2,jdbcType=DOUBLE}, #{sjdqTest3,jdbcType=DOUBLE}, \n" +
            "      #{sjdqValue3,jdbcType=DOUBLE}, #{sjdqTest4,jdbcType=DOUBLE}, #{sjdqValue4,jdbcType=DOUBLE}, \n" +
            "      #{sjdqWc,jdbcType=INTEGER}, #{sjdqResult,jdbcType=TINYINT}, #{sjdnTest1,jdbcType=DOUBLE}, \n" +
            "      #{sjdnValue1,jdbcType=DOUBLE}, #{sjdnTest2,jdbcType=DOUBLE}, #{sjdnValue2,jdbcType=DOUBLE}, \n" +
            "      #{sjdnTest3,jdbcType=DOUBLE}, #{sjdnValue3,jdbcType=DOUBLE}, #{sjdnTest4,jdbcType=DOUBLE}, \n" +
            "      #{sjdnValue4,jdbcType=DOUBLE}, #{sjdnWc,jdbcType=INTEGER}, #{sjdnResult,jdbcType=TINYINT}, \n" +
            "      #{ssldDjdq,jdbcType=DOUBLE}, #{ssldDjdn,jdbcType=DOUBLE}, #{zxldDjdq,jdbcType=DOUBLE}, \n" +
            "      #{zxldDjdn,jdbcType=DOUBLE}, #{djgpldWc,jdbcType=INTEGER}, #{djgpldResult,jdbcType=TINYINT}, \n" +
            "      #{ssldSjdq,jdbcType=DOUBLE}, #{ssldSjdn,jdbcType=DOUBLE}, #{zxldSjdq,jdbcType=DOUBLE}, \n" +
            "      #{zxldSjdn,jdbcType=DOUBLE}, #{sjgpldWc,jdbcType=INTEGER}, #{sjgpldResult,jdbcType=TINYINT}, \n" +
            "      #{spare1,jdbcType=TINYINT}, #{spare2,jdbcType=TINYINT}, #{spare3,jdbcType=TINYINT}, \n" +
            "      #{spare4,jdbcType=TINYINT}, #{spare5,jdbcType=TINYINT})")
    void save(Gpdd gpdd);


}

