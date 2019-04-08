package com.litbo.hospitalzj.checklist.dao;

import com.litbo.hospitalzj.checklist.domain.StzsM;
import com.litbo.hospitalzj.checklist.domain.StzsMTemplate;
import com.litbo.hospitalzj.checklist.domain.SybC;
import com.litbo.hospitalzj.checklist.domain.SybCTemplate;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * 注射泵mapper
 */
@Mapper
public interface ZsbMapper {

    //查询模板数据（成人，幼儿）
    @Select("select * from ${value} order by temp_id desc limit 1")
    SybCTemplate findTemplate(String tableName);

    //查询双通道模板数据，最后一条记录
    @Select("select * from stzs_m_template order by temp_id desc limit 1")
    StzsMTemplate findStZsTemplate();
    //修改模板表数据
    //幼儿
    @Update(" update zsb_c_template\n" +
            "    set llcsd1 = #{llcsd1,jdbcType=INTEGER},\n" +
            "      llcsd2 = #{llcsd2,jdbcType=INTEGER},\n" +
            "      wc = #{wc,jdbcType=INTEGER},\n" +
            "      zsbjllz = #{zsbjllz,jdbcType=INTEGER},\n" +
            "      zsbj_wc1 = #{zsbjWc1,jdbcType=INTEGER},\n" +
            "      zsbj_wc2 = #{zsbjWc2,jdbcType=INTEGER}\n" +
            "    where temp_id = #{tempId,jdbcType=BIGINT}")
    int updateC(SybCTemplate sybCTemplate);
    //成人
    @Update("update zsb_m_template\n" +
            "    set llcsd1 = #{llcsd1,jdbcType=INTEGER},\n" +
            "      llcsd2 = #{llcsd2,jdbcType=INTEGER},\n" +
            "      wc = #{wc,jdbcType=INTEGER},\n" +
            "      zsbjllz = #{zsbjllz,jdbcType=INTEGER},\n" +
            "      zsbj_wc1 = #{zsbjWc1,jdbcType=INTEGER},\n" +
            "      zsbj_wc2 = #{zsbjWc2,jdbcType=INTEGER}\n" +
            "    where temp_id = #{tempId,jdbcType=BIGINT}")
    int updateM(SybCTemplate sybCTemplate);
    //双通道
    @Update("update stzs_m_template\n" +
            "    set llcsd11 = #{llcsd11,jdbcType=INTEGER},\n" +
            "      llcsd21 = #{llcsd21,jdbcType=INTEGER},\n" +
            "      wc1 = #{wc1,jdbcType=INTEGER},\n" +
            "      zsbjcsz1 = #{zsbjcsz1,jdbcType=INTEGER},\n" +
            "      zsbj_wc11 = #{zsbjWc11,jdbcType=INTEGER},\n" +
            "      zsbj_wc21 = #{zsbjWc21,jdbcType=INTEGER},\n" +
            "      llcsd12 = #{llcsd12,jdbcType=INTEGER},\n" +
            "      llcsd22 = #{llcsd22,jdbcType=INTEGER},\n" +
            "      wc2 = #{wc2,jdbcType=INTEGER},\n" +
            "      zsbjcsz2 = #{zsbjcsz2,jdbcType=INTEGER},\n" +
            "      zsbj_wc12 = #{zsbjWc12,jdbcType=INTEGER},\n" +
            "      zsbj_wc22 = #{zsbjWc22,jdbcType=INTEGER}\n" +
            "    where temp_id = #{tempId,jdbcType=BIGINT}")
    int updateS(StzsMTemplate stzsMTemplate);
    //插入模板表数据
    //幼儿
    @Insert("insert into zsb_c_template (temp_id, llcsd1, llcsd2, \n" +
            "      wc, zsbjllz, zsbj_wc1, \n" +
            "      zsbj_wc2)\n" +
            "    values (#{tempId,jdbcType=BIGINT}, #{llcsd1,jdbcType=INTEGER}, #{llcsd2,jdbcType=INTEGER}, \n" +
            "      #{wc,jdbcType=INTEGER}, #{zsbjllz,jdbcType=INTEGER}, #{zsbjWc1,jdbcType=INTEGER}, \n" +
            "      #{zsbjWc2,jdbcType=INTEGER})")
    int insertChildTemplate(SybCTemplate template);
    //成人
    @Insert("insert into zsb_m_template (temp_id, llcsd1, llcsd2, \n" +
            "      wc, zsbjllz, zsbj_wc1, \n" +
            "      zsbj_wc2)\n" +
            "    values (#{tempId,jdbcType=BIGINT}, #{llcsd1,jdbcType=INTEGER}, #{llcsd2,jdbcType=INTEGER}, \n" +
            "      #{wc,jdbcType=INTEGER}, #{zsbjllz,jdbcType=INTEGER}, #{zsbjWc1,jdbcType=INTEGER}, \n" +
            "      #{zsbjWc2,jdbcType=INTEGER})")
    int insertManTemplate(SybCTemplate template);
    //双通道
    @Insert("insert into stzs_m_template (temp_id, llcsd11, llcsd21, \n" +
            "      wc1, zsbjcsz1, zsbj_wc11, \n" +
            "      zsbj_wc21, llcsd12, llcsd22, \n" +
            "      wc2, zsbjcsz2, zsbj_wc12, \n" +
            "      zsbj_wc22)\n" +
            "    values (#{tempId,jdbcType=BIGINT}, #{llcsd11,jdbcType=INTEGER}, #{llcsd21,jdbcType=INTEGER}, \n" +
            "      #{wc1,jdbcType=INTEGER}, #{zsbjcsz1,jdbcType=INTEGER}, #{zsbjWc11,jdbcType=INTEGER}, \n" +
            "      #{zsbjWc21,jdbcType=INTEGER}, #{llcsd12,jdbcType=INTEGER}, #{llcsd22,jdbcType=INTEGER}, \n" +
            "      #{wc2,jdbcType=INTEGER}, #{zsbjcsz2,jdbcType=INTEGER}, #{zsbjWc12,jdbcType=INTEGER}, \n" +
            "      #{zsbjWc22,jdbcType=INTEGER})")
    int insertStzsTemplate(StzsMTemplate template);
    //保存信息
    //输液泵检测信息录入（幼儿）
    @Insert("insert into zsb_c (id, jcyq_id, eq_id,  tester, auditor, test_time,    jcjl, jcsm, llcsd1,   pjll_1, llcsd2, pjll_2, \n" +
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
    @Insert("insert into zsb_m (id, jcyq_id, eq_id,  tester, auditor, test_time,    jcjl, jcsm, llcsd1,   pjll_1, llcsd2, pjll_2, \n" +
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

    //插入双通道注射泵检测数据
    @Insert("insert into stzs_m (id, jcyq_id, eq_id,   tester, auditor, test_time,   jcjl, jcsm, llcsd11,  pjll_11, llcsd21, pjll_21, \n" +
            "      wc1, llcs_result1, zsbj_llz1,   bjsz_h1, bjsz_m1, bjsz_l1,    bjsj_h1, bjsj_m1, bjsj_l1,     bjyl_h1, bjyl_m1, bjyl_l1, \n" +
            "      zsbj_wc11, zsbj_wc21, zsbj_result1,   zs1, sygbt1, dyxtk1,   jjkp1, qpbj1, kmbj1,     llcsd12, pjll_12, llcsd22, \n" +
            "      pjll_22, wc2, llcs_result2,    zsbjcsll2, bjsz_h2, bjsz_m2,     bjsz_l2, bjsj_h2, bjsj_m2, \n" +
            "      bjsj_l2, bjyl_h2, bjyl_m2,    bjyl_l2, zsbj_wc12, zsbj_wc22,    zsbj_result2, zs2, sygbt2,     dyxtk2, jjkp2, qpbj2, \n" +
            "      kmbj2)   values (#{id,jdbcType=BIGINT}, #{jcyqId,jdbcType=INTEGER}, #{eqId,jdbcType=INTEGER}, \n" +
            "      #{tester,jdbcType=VARCHAR}, #{auditor,jdbcType=VARCHAR}, #{testTime,jdbcType=TIMESTAMP}, \n" +
            "      #{jcjl,jdbcType=VARCHAR}, #{jcsm,jdbcType=VARCHAR}, #{llcsd11,jdbcType=INTEGER}, \n" +
            "      #{pjll11,jdbcType=INTEGER}, #{llcsd21,jdbcType=INTEGER}, #{pjll21,jdbcType=INTEGER}, \n" +
            "      #{wc1,jdbcType=INTEGER}, #{llcsResult1,jdbcType=INTEGER}, #{zsbjLlz1,jdbcType=INTEGER}, \n" +
            "      #{bjszH1,jdbcType=INTEGER}, #{bjszM1,jdbcType=INTEGER}, #{bjszL1,jdbcType=INTEGER}, \n" +
            "      #{bjsjH1,jdbcType=INTEGER}, #{bjsjM1,jdbcType=INTEGER}, #{bjsjL1,jdbcType=INTEGER}, \n" +
            "      #{bjylH1,jdbcType=INTEGER}, #{bjylM1,jdbcType=INTEGER}, #{bjylL1,jdbcType=INTEGER}, \n" +
            "      #{zsbjWc11,jdbcType=INTEGER}, #{zsbjWc21,jdbcType=INTEGER}, #{zsbjResult1,jdbcType=TINYINT}, \n" +
            "      #{zs1,jdbcType=TINYINT}, #{sygbt1,jdbcType=TINYINT}, #{dyxtk1,jdbcType=TINYINT}, \n" +
            "      #{jjkp1,jdbcType=TINYINT}, #{qpbj1,jdbcType=TINYINT}, #{kmbj1,jdbcType=TINYINT}, \n" +
            "      #{llcsd12,jdbcType=INTEGER}, #{pjll12,jdbcType=INTEGER}, #{llcsd22,jdbcType=INTEGER}, \n" +
            "      #{pjll22,jdbcType=INTEGER}, #{wc2,jdbcType=INTEGER}, #{llcsResult2,jdbcType=INTEGER}, \n" +
            "      #{zsbjcsll2,jdbcType=INTEGER}, #{bjszH2,jdbcType=INTEGER}, #{bjszM2,jdbcType=INTEGER}, \n" +
            "      #{bjszL2,jdbcType=INTEGER}, #{bjsjH2,jdbcType=INTEGER}, #{bjsjM2,jdbcType=INTEGER}, \n" +
            "      #{bjsjL2,jdbcType=INTEGER}, #{bjylH2,jdbcType=INTEGER}, #{bjylM2,jdbcType=INTEGER}, \n" +
            "      #{bjylL2,jdbcType=INTEGER}, #{zsbjWc12,jdbcType=INTEGER}, #{zsbjWc22,jdbcType=INTEGER}, \n" +
            "      #{zsbjResult2,jdbcType=TINYINT}, #{zs2,jdbcType=TINYINT}, #{sygbt2,jdbcType=TINYINT}, \n" +
            "      #{dyxtk2,jdbcType=TINYINT}, #{jjkp2,jdbcType=TINYINT}, #{qpbj2,jdbcType=TINYINT}, \n" +
            "      #{kmbj2,jdbcType=TINYINT})")
    void saveStzs(StzsM stzsM);

    //查询所有录入信息
    @Select("select * from ${value}")
    List<SybC> findAll(String tableName);
    //查询最后录入的一条检测信息
    @Select("select * from ${value} order by id limit 1")
    SybC find(String tableName);

    //查询双通道检测数据（一条）
    @Select("select * from stzs_m order by id desc limit 1")
    StzsM findStzsM();

    //查询双通道所有检测数据
    @Select("select * from stzs_m")
    List<StzsM> findAllStzsM();



}
