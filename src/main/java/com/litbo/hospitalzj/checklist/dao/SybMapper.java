package com.litbo.hospitalzj.checklist.dao;

import com.litbo.hospitalzj.checklist.domain.SybC;
import com.litbo.hospitalzj.checklist.domain.SybCTemplate;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * 输液泵， 注射泵mapper
 */
@Mapper
public interface SybMapper {


    //查询模板数据
    @Select("select * from ${value} order by temp_id desc limit 1")
    SybCTemplate findTemplate(String tableName);
    //修改模板表数据
    //幼儿
    @Update("update syb_c_template\n" +
            "    set llcsd1 = #{llcsd1,jdbcType=INTEGER},\n" +
            "      llcsd2 = #{llcsd2,jdbcType=INTEGER},\n" +
            "      wc = #{wc,jdbcType=INTEGER},\n" +
            "      zsbjllz = #{zsbjllz,jdbcType=INTEGER},\n" +
            "      zsbj_wc1 = #{zsbjWc1,jdbcType=INTEGER},\n" +
            "      zsbj_wc2 = #{zsbjWc2,jdbcType=INTEGER}\n" +
            "    where temp_id = #{tempId,jdbcType=BIGINT}")
    int updateC(SybCTemplate sybCTemplate);
    //成人
    @Update(" update syb_m_template\n" +
            "    set llcsd1 = #{llcsd1,jdbcType=INTEGER},\n" +
            "      llcsd2 = #{llcsd2,jdbcType=INTEGER},\n" +
            "      wc = #{wc,jdbcType=INTEGER},\n" +
            "      zsbjllz = #{zsbjllz,jdbcType=INTEGER},\n" +
            "      zsbj_wc1 = #{zsbjWc1,jdbcType=INTEGER},\n" +
            "      zsbj_wc2 = #{zsbjWc2,jdbcType=INTEGER}\n" +
            "    where temp_id = #{tempId,jdbcType=BIGINT}")
    int updateM(SybCTemplate sybCTemplate);
    //插入模板表数据
    //幼儿
    @Insert("insert into syb_c_template (temp_id, llcsd1, llcsd2, \n" +
            "      wc, zsbjllz, zsbj_wc1, \n" +
            "      zsbj_wc2)\n" +
            "    values (#{tempId,jdbcType=BIGINT}, #{llcsd1,jdbcType=INTEGER}, #{llcsd2,jdbcType=INTEGER}, \n" +
            "      #{wc,jdbcType=INTEGER}, #{zsbjllz,jdbcType=INTEGER}, #{zsbjWc1,jdbcType=INTEGER}, \n" +
            "      #{zsbjWc2,jdbcType=INTEGER})")
    void insertChildTemplate(SybCTemplate template);
    //成人
    @Insert("insert into syb_m_template (temp_id, llcsd1, llcsd2, \n" +
            "      wc, zsbjllz, zsbj_wc1, \n" +
            "      zsbj_wc2)\n" +
            "    values (#{tempId,jdbcType=BIGINT}, #{llcsd1,jdbcType=INTEGER}, #{llcsd2,jdbcType=INTEGER}, \n" +
            "      #{wc,jdbcType=INTEGER}, #{zsbjllz,jdbcType=INTEGER}, #{zsbjWc1,jdbcType=INTEGER}, \n" +
            "      #{zsbjWc2,jdbcType=INTEGER})")
    void insertManTemplate(SybCTemplate template);
    //保存信息
    //输液泵检测信息录入（幼儿）
    @Insert("insert into syb_c (id, jcyq_id, eq_id,  tester, auditor, test_time,    jcjl, jcsm, llcsd1,   pjll_1, llcsd2, pjll_2, \n" +
            "      wc, llcs_result, zsbjcsll,   bjsz_h, bjsz_m, bjsz_l,   bjsj_h, bjsj_m, bjsj_l,     bjyl_h, bjyl_m, bjyl_l, \n" +
            "      zsbj_wc1, zsbj_wc2, zsbj_result,    zs, sygbt, dyxtk, jjkp,   qpbj, kmbj)\n" +
            "    values (#{id,jdbcType=BIGINT}, #{jcyqId,jdbcType=INTEGER}, #{eqId,jdbcType=INTEGER}, \n" +
            "      #{tester,jdbcType=VARCHAR}, #{auditor,jdbcType=VARCHAR}, #{testTime,jdbcType=TIMESTAMP}, \n" +
            "      #{jcjl,jdbcType=VARCHAR}, #{jcsm,jdbcType=VARCHAR}, #{llcsd1,jdbcType=INTEGER}, \n" +
            "      #{pjll1,jdbcType=INTEGER}, #{llcsd2,jdbcType=INTEGER}, #{pjll2,jdbcType=INTEGER}, \n" +
            "      #{wc,jdbcType=INTEGER}, #{llcsResult,jdbcType=INTEGER}, #{zsbjcsll,jdbcType=INTEGER}, \n" +
            "      #{bjszH,jdbcType=INTEGER}, #{bjszM,jdbcType=INTEGER}, #{bjszL,jdbcType=INTEGER}, \n" +
            "      #{bjsjH,jdbcType=INTEGER}, #{bjsjM,jdbcType=INTEGER}, #{bjsjL,jdbcType=INTEGER}, \n" +
            "      #{bjylH,jdbcType=INTEGER}, #{bjylM,jdbcType=INTEGER}, #{bjylL,jdbcType=INTEGER}, \n" +
            "      #{zsbjWc1,jdbcType=INTEGER}, #{zsbjWc2,jdbcType=INTEGER}, #{zsbjResult,jdbcType=TINYINT}, \n" +
            "      #{zs,jdbcType=TINYINT}, #{sygbt,jdbcType=TINYINT}, #{dyxtk,jdbcType=TINYINT}, #{jjkp,jdbcType=TINYINT}, \n" +
            "      #{qpbj,jdbcType=TINYINT}, #{kmbj,jdbcType=TINYINT})")
    void saveChild(SybC sybC);


    //输液泵检测信息录入（成人）
    @Insert("insert into syb_m (id, jcyq_id, eq_id,  tester, auditor, test_time,    jcjl, jcsm, llcsd1,   pjll_1, llcsd2, pjll_2, \n" +
            "      wc, llcs_result, zsbjcsll,   bjsz_h, bjsz_m, bjsz_l,   bjsj_h, bjsj_m, bjsj_l,     bjyl_h, bjyl_m, bjyl_l, \n" +
            "      zsbj_wc1, zsbj_wc2, zsbj_result,    zs, sygbt, dyxtk, jjkp,   qpbj, kmbj)\n" +
            "    values (#{id,jdbcType=BIGINT}, #{jcyqId,jdbcType=INTEGER}, #{eqId,jdbcType=INTEGER}, \n" +
            "      #{tester,jdbcType=VARCHAR}, #{auditor,jdbcType=VARCHAR}, #{testTime,jdbcType=TIMESTAMP}, \n" +
            "      #{jcjl,jdbcType=VARCHAR}, #{jcsm,jdbcType=VARCHAR}, #{llcsd1,jdbcType=INTEGER}, \n" +
            "      #{pjll1,jdbcType=INTEGER}, #{llcsd2,jdbcType=INTEGER}, #{pjll2,jdbcType=INTEGER}, \n" +
            "      #{wc,jdbcType=INTEGER}, #{llcsResult,jdbcType=INTEGER}, #{zsbjcsll,jdbcType=INTEGER}, \n" +
            "      #{bjszH,jdbcType=INTEGER}, #{bjszM,jdbcType=INTEGER}, #{bjszL,jdbcType=INTEGER}, \n" +
            "      #{bjsjH,jdbcType=INTEGER}, #{bjsjM,jdbcType=INTEGER}, #{bjsjL,jdbcType=INTEGER}, \n" +
            "      #{bjylH,jdbcType=INTEGER}, #{bjylM,jdbcType=INTEGER}, #{bjylL,jdbcType=INTEGER}, \n" +
            "      #{zsbjWc1,jdbcType=INTEGER}, #{zsbjWc2,jdbcType=INTEGER}, #{zsbjResult,jdbcType=TINYINT}, \n" +
            "      #{zs,jdbcType=TINYINT}, #{sygbt,jdbcType=TINYINT}, #{dyxtk,jdbcType=TINYINT}, #{jjkp,jdbcType=TINYINT}, \n" +
            "      #{qpbj,jdbcType=TINYINT}, #{kmbj,jdbcType=TINYINT})")
    void saveMan(SybC sybC);


    //查询所有录入信息
    @Select("select * from ${value}")
    List<SybC> findAll(String tableName);
    //查询最后录入的一条检测信息
    @Select("select * from ${value} order by id limit 1")
    SybC find(String tableName);


}
