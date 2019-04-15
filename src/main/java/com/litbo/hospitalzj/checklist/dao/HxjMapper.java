package com.litbo.hospitalzj.checklist.dao;

import com.litbo.hospitalzj.checklist.domain.Dqjc;
import com.litbo.hospitalzj.checklist.domain.Hxj;
import com.litbo.hospitalzj.checklist.domain.HxjTemplate;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

@Mapper
public interface HxjMapper {

    //查询模板值
    @Select("select * from hxj_template order by hxj_template_id desc limit 1")
    HxjTemplate findTemplate();

    //修改模板值
    @Update("update hxj_template\n" +
            "    set cqz_test1 = #{cqzTest1,jdbcType=INTEGER},\n" +
            "      cqz_test2 = #{cqzTest2,jdbcType=INTEGER},\n" +
            "      cqz_test3 = #{cqzTest3,jdbcType=INTEGER},\n" +
            "      cqz_wc = #{cqzWc,jdbcType=INTEGER},\n" +
            "      qztq_test1 = #{qztqTest1,jdbcType=INTEGER},\n" +
            "      qztq_test2 = #{qztqTest2,jdbcType=INTEGER},\n" +
            "      qztq_test3 = #{qztqTest3,jdbcType=INTEGER},\n" +
            "      qztq_wc = #{qztqWc,jdbcType=INTEGER},\n" +
            "      xrynd_test1 = #{xryndTest1,jdbcType=INTEGER},\n" +
            "      xrynd_test2 = #{xryndTest2,jdbcType=INTEGER},\n" +
            "      xrynd_test3 = #{xryndTest3,jdbcType=INTEGER},\n" +
            "      xrynd_wc = #{xryndWc,jdbcType=INTEGER},\n" +
            "      xqylsp_test1 = #{xqylspTest1,jdbcType=INTEGER},\n" +
            "      xqylsp_test2 = #{xqylspTest2,jdbcType=INTEGER},\n" +
            "      xqylsp_test3 = #{xqylspTest3,jdbcType=INTEGER},\n" +
            "      xqylsp_wc = #{xqylspWc,jdbcType=INTEGER},\n" +
            "      hqmzy_test1 = #{hqmzyTest1,jdbcType=INTEGER},\n" +
            "      hqmzy_test2 = #{hqmzyTest2,jdbcType=INTEGER},\n" +
            "      hqmzy_test3 = #{hqmzyTest3,jdbcType=INTEGER},\n" +
            "      hqmzy_wc = #{hqmzyWc,jdbcType=INTEGER},\n" +
            "      spare1 = #{spare1,jdbcType=TINYINT},\n" +
            "      spare2 = #{spare2,jdbcType=TINYINT}\n" +
            "    where hxj_templateid = #{hxjTemplateid,jdbcType=INTEGER}")
    int updateHxjTemplate(HxjTemplate hxjTemplate);
    //插入模板值
    @Insert("  update hxj_template\n" +
            "    set bhjdzk_yx = #{bhjdzkYx,jdbcType=INTEGER},\n" +
            "      jykz_yx = #{jykzYx,jdbcType=INTEGER},\n" +
            "      ddld_z_yx = #{ddldZYx,jdbcType=INTEGER},\n" +
            "      ddld_d_yx = #{ddldDYx,jdbcType=INTEGER},\n" +
            "      wkld_z_yx = #{wkldZYx,jdbcType=INTEGER},\n" +
            "      wkld_d_yx = #{wkldDYx,jdbcType=INTEGER},\n" +
            "      cqz1 = #{cqz1,jdbcType=INTEGER},\n" +
            "      cqz2 = #{cqz2,jdbcType=INTEGER},\n" +
            "      cqz3 = #{cqz3,jdbcType=INTEGER},\n" +
            "      cqz_zdwc = #{cqzZdwc,jdbcType=INTEGER},\n" +
            "      qztq1 = #{qztq1,jdbcType=INTEGER},\n" +
            "      qztq2 = #{qztq2,jdbcType=INTEGER},\n" +
            "      qztq3 = #{qztq3,jdbcType=INTEGER},\n" +
            "      qztq_zdwc = #{qztqZdwc,jdbcType=INTEGER},\n" +
            "      xry1 = #{xry1,jdbcType=INTEGER},\n" +
            "      xry2 = #{xry2,jdbcType=INTEGER},\n" +
            "      xry3 = #{xry3,jdbcType=INTEGER},\n" +
            "      xry_zdwc = #{xryZdwc,jdbcType=INTEGER},\n" +
            "      xqf1 = #{xqf1,jdbcType=INTEGER},\n" +
            "      xqf2 = #{xqf2,jdbcType=INTEGER},\n" +
            "      xqf3 = #{xqf3,jdbcType=INTEGER},\n" +
            "      xqf_zdwc = #{xqfZdwc,jdbcType=INTEGER},\n" +
            "      hqm1 = #{hqm1,jdbcType=INTEGER},\n" +
            "      hqm2 = #{hqm2,jdbcType=INTEGER},\n" +
            "      hqm3 = #{hqm3,jdbcType=INTEGER},\n" +
            "      hqm_zdwc = #{hqmZdwc,jdbcType=INTEGER},\n" +
            "      dybj = #{dybj,jdbcType=INTEGER},\n" +
            "      yqndsx = #{yqndsx,jdbcType=INTEGER},\n" +
            "      qybj = #{qybj,jdbcType=INTEGER},\n" +
            "      zxbj = #{zxbj,jdbcType=INTEGER},\n" +
            "      qdyl = #{qdyl,jdbcType=INTEGER},\n" +
            "      brhl = #{brhl,jdbcType=INTEGER},\n" +
            "      fztql = #{fztql,jdbcType=INTEGER},\n" +
            "      ajgn = #{ajgn,jdbcType=INTEGER},\n" +
            "      bz = #{bz,jdbcType=INTEGER},\n" +
            "      bz1 = #{bz1,jdbcType=INTEGER}")
    int insertHxjTemplate(HxjTemplate hxjTemplate);

    //保存
    @Insert("insert into hxj (hxjid, jcyq_id, eq_id, \n" +
            "      tester, auditor, shsj_time, \n" +
            "      test_time, jcjl, jcsm, \n" +
            "      bhjdzk_test, bhjdzk_yx, bhjdzk_result, \n" +
            "      jykz_test, jykz_yx, jykz_result, \n" +
            "      ddld_z_z, ddld_z_f, ddld_z_yx, \n" +
            "      ddld_z_result, ddld_d_z1, ddld_d_z2, \n" +
            "      ddld_d_yx, ddld_d_result, wkld_z_z, \n" +
            "      wkld_z_f, wkld_z_yx, wkld_z_result, \n" +
            "      wkld_d_z1, wkld_d_z2, wkld_d_z3, \n" +
            "      wkld_d_z4, wkld_d_yx, wkld_d_result, \n" +
            "      cqz1, cqzh11, cqzh12, \n" +
            "      cqzh13, cqzhp11, cqzc11, \n" +
            "      cqzc12, cqzc13, cqzcp12, \n" +
            "      cqz1_swc, cqz2, cqzh21, \n" +
            "      cqzh22, cqzh23, cqzhp21, \n" +
            "      cqzc21, cqzc22, cqzc23, \n" +
            "      cqzcp22, cqz2_swc, cqz3, \n" +
            "      cqzh31, cqzh32, cqzh33, \n" +
            "      cqzhp31, cqzc31, cqzc32, \n" +
            "      cqzc33, cqzcp32, cqz3_swc, \n" +
            "      cqz_zdwc, cqz_result, qztq1, \n" +
            "      qztqh11, qztqh12, qztqh13, \n" +
            "      qztqhp11, qztqc11, qztqc12, \n" +
            "      qztqc13, qztqcp12, qztq1_swc, \n" +
            "      qztq2, qztqh21, qztqh22, \n" +
            "      qztqh23, qztqhp21, qztqc21, \n" +
            "      qztqc22, qztqc23, qztqcp22, \n" +
            "      qztq2_swc, qztq3, qztqh31, \n" +
            "      qztqh32, qztqh33, qztqhp31, \n" +
            "      qztqc31, qztqc32, qztqc33, \n" +
            "      qztqcp32, qztq3_swc, qztq_zdwc, \n" +
            "      qztq_result, xry1, xryh11, \n" +
            "      xryh12, xryh13, xryhp11, \n" +
            "      xryc11, xryc12, xryc13, \n" +
            "      xrycp12, xry1_swc, xry2, \n" +
            "      xryh21, xryh22, xryh23, \n" +
            "      xryhp21, xryc21, xryc22, \n" +
            "      xryc23, xrycp22, xry2_swc, \n" +
            "      xry3, xryh31, xryh32, \n" +
            "      xryh33, xryhp31, xryc31, \n" +
            "      xryc32, xryc33, xrycp32, \n" +
            "      xry3_swc, xry_zdwc, xry_result, \n" +
            "      xqf1, xqfh11, xqfh12, \n" +
            "      xqfh13, xqfhp11, xqfc11, \n" +
            "      xqfc12, xqfc13, xqfcp12, \n" +
            "      xqf1_swc, xqf2, xqfh21, \n" +
            "      xqfh22, xqfh23, xqfhp21, \n" +
            "      xqfc21, xqfc22, xqfc23, \n" +
            "      xqfcp22, xqf2_swc, xqf3, \n" +
            "      xqfh31, xqfh32, xqfh33, \n" +
            "      xqfhp31, xqfc31, xqfc32, \n" +
            "      xqfc33, xqfcp32, xqf3_swc, \n" +
            "      xqf_zdwc, xqf_result, hqm1, \n" +
            "      hqmh11, hqmh12, hqmh13, \n" +
            "      hqmhp11, hqmc11, hqmc12, \n" +
            "      hqmc13, hqmcp12, hqm1_swc, \n" +
            "      hqm2, hqmh21, hqmh22, \n" +
            "      hqmh23, hqmhp21, hqmc21, \n" +
            "      hqmc22, hqmc23, hqmcp22, \n" +
            "      hqm2_swc, hqm3, hqmh31, \n" +
            "      hqmh32, hqmh33, hqmhp31, \n" +
            "      hqmc31, hqmc32, hqmc33, \n" +
            "      hqmcp32, hqm3_swc, hqm_zdwc, \n" +
            "      hqm_result, dybj, yqndsx, \n" +
            "      qybj, zxbj, qdyl, brhl, \n" +
            "      fztql, ajgn, bz, bz1\n" +
            "      )\n" +
            "    values (#{hxjid,jdbcType=INTEGER}, #{jcyqId,jdbcType=INTEGER}, #{eqId,jdbcType=INTEGER}, \n" +
            "      #{tester,jdbcType=VARCHAR}, #{auditor,jdbcType=VARCHAR}, #{shsjTime,jdbcType=TIMESTAMP}, \n" +
            "      #{testTime,jdbcType=TIMESTAMP}, #{jcjl,jdbcType=VARCHAR}, #{jcsm,jdbcType=VARCHAR}, \n" +
            "      #{bhjdzkTest,jdbcType=INTEGER}, #{bhjdzkYx,jdbcType=INTEGER}, #{bhjdzkResult,jdbcType=INTEGER}, \n" +
            "      #{jykzTest,jdbcType=INTEGER}, #{jykzYx,jdbcType=INTEGER}, #{jykzResult,jdbcType=INTEGER}, \n" +
            "      #{ddldZZ,jdbcType=INTEGER}, #{ddldZF,jdbcType=INTEGER}, #{ddldZYx,jdbcType=INTEGER}, \n" +
            "      #{ddldZResult,jdbcType=INTEGER}, #{ddldDZ1,jdbcType=INTEGER}, #{ddldDZ2,jdbcType=INTEGER}, \n" +
            "      #{ddldDYx,jdbcType=INTEGER}, #{ddldDResult,jdbcType=INTEGER}, #{wkldZZ,jdbcType=INTEGER}, \n" +
            "      #{wkldZF,jdbcType=INTEGER}, #{wkldZYx,jdbcType=INTEGER}, #{wkldZResult,jdbcType=INTEGER}, \n" +
            "      #{wkldDZ1,jdbcType=INTEGER}, #{wkldDZ2,jdbcType=INTEGER}, #{wkldDZ3,jdbcType=INTEGER}, \n" +
            "      #{wkldDZ4,jdbcType=INTEGER}, #{wkldDYx,jdbcType=INTEGER}, #{wkldDResult,jdbcType=INTEGER}, \n" +
            "      #{cqz1,jdbcType=INTEGER}, #{cqzh11,jdbcType=INTEGER}, #{cqzh12,jdbcType=INTEGER}, \n" +
            "      #{cqzh13,jdbcType=INTEGER}, #{cqzhp11,jdbcType=INTEGER}, #{cqzc11,jdbcType=INTEGER}, \n" +
            "      #{cqzc12,jdbcType=INTEGER}, #{cqzc13,jdbcType=INTEGER}, #{cqzcp12,jdbcType=INTEGER}, \n" +
            "      #{cqz1Swc,jdbcType=INTEGER}, #{cqz2,jdbcType=INTEGER}, #{cqzh21,jdbcType=INTEGER}, \n" +
            "      #{cqzh22,jdbcType=INTEGER}, #{cqzh23,jdbcType=INTEGER}, #{cqzhp21,jdbcType=INTEGER}, \n" +
            "      #{cqzc21,jdbcType=INTEGER}, #{cqzc22,jdbcType=INTEGER}, #{cqzc23,jdbcType=INTEGER}, \n" +
            "      #{cqzcp22,jdbcType=INTEGER}, #{cqz2Swc,jdbcType=INTEGER}, #{cqz3,jdbcType=INTEGER}, \n" +
            "      #{cqzh31,jdbcType=INTEGER}, #{cqzh32,jdbcType=INTEGER}, #{cqzh33,jdbcType=INTEGER}, \n" +
            "      #{cqzhp31,jdbcType=INTEGER}, #{cqzc31,jdbcType=INTEGER}, #{cqzc32,jdbcType=INTEGER}, \n" +
            "      #{cqzc33,jdbcType=INTEGER}, #{cqzcp32,jdbcType=INTEGER}, #{cqz3Swc,jdbcType=INTEGER}, \n" +
            "      #{cqzZdwc,jdbcType=INTEGER}, #{cqzResult,jdbcType=INTEGER}, #{qztq1,jdbcType=INTEGER}, \n" +
            "      #{qztqh11,jdbcType=INTEGER}, #{qztqh12,jdbcType=INTEGER}, #{qztqh13,jdbcType=INTEGER}, \n" +
            "      #{qztqhp11,jdbcType=INTEGER}, #{qztqc11,jdbcType=INTEGER}, #{qztqc12,jdbcType=INTEGER}, \n" +
            "      #{qztqc13,jdbcType=INTEGER}, #{qztqcp12,jdbcType=INTEGER}, #{qztq1Swc,jdbcType=INTEGER}, \n" +
            "      #{qztq2,jdbcType=INTEGER}, #{qztqh21,jdbcType=INTEGER}, #{qztqh22,jdbcType=INTEGER}, \n" +
            "      #{qztqh23,jdbcType=INTEGER}, #{qztqhp21,jdbcType=INTEGER}, #{qztqc21,jdbcType=INTEGER}, \n" +
            "      #{qztqc22,jdbcType=INTEGER}, #{qztqc23,jdbcType=INTEGER}, #{qztqcp22,jdbcType=INTEGER}, \n" +
            "      #{qztq2Swc,jdbcType=INTEGER}, #{qztq3,jdbcType=INTEGER}, #{qztqh31,jdbcType=INTEGER}, \n" +
            "      #{qztqh32,jdbcType=INTEGER}, #{qztqh33,jdbcType=INTEGER}, #{qztqhp31,jdbcType=INTEGER}, \n" +
            "      #{qztqc31,jdbcType=INTEGER}, #{qztqc32,jdbcType=INTEGER}, #{qztqc33,jdbcType=INTEGER}, \n" +
            "      #{qztqcp32,jdbcType=INTEGER}, #{qztq3Swc,jdbcType=INTEGER}, #{qztqZdwc,jdbcType=INTEGER}, \n" +
            "      #{qztqResult,jdbcType=INTEGER}, #{xry1,jdbcType=INTEGER}, #{xryh11,jdbcType=INTEGER}, \n" +
            "      #{xryh12,jdbcType=INTEGER}, #{xryh13,jdbcType=INTEGER}, #{xryhp11,jdbcType=INTEGER}, \n" +
            "      #{xryc11,jdbcType=INTEGER}, #{xryc12,jdbcType=INTEGER}, #{xryc13,jdbcType=INTEGER}, \n" +
            "      #{xrycp12,jdbcType=INTEGER}, #{xry1Swc,jdbcType=INTEGER}, #{xry2,jdbcType=INTEGER}, \n" +
            "      #{xryh21,jdbcType=INTEGER}, #{xryh22,jdbcType=INTEGER}, #{xryh23,jdbcType=INTEGER}, \n" +
            "      #{xryhp21,jdbcType=INTEGER}, #{xryc21,jdbcType=INTEGER}, #{xryc22,jdbcType=INTEGER}, \n" +
            "      #{xryc23,jdbcType=INTEGER}, #{xrycp22,jdbcType=INTEGER}, #{xry2Swc,jdbcType=INTEGER}, \n" +
            "      #{xry3,jdbcType=INTEGER}, #{xryh31,jdbcType=INTEGER}, #{xryh32,jdbcType=INTEGER}, \n" +
            "      #{xryh33,jdbcType=INTEGER}, #{xryhp31,jdbcType=INTEGER}, #{xryc31,jdbcType=INTEGER}, \n" +
            "      #{xryc32,jdbcType=INTEGER}, #{xryc33,jdbcType=INTEGER}, #{xrycp32,jdbcType=INTEGER}, \n" +
            "      #{xry3Swc,jdbcType=INTEGER}, #{xryZdwc,jdbcType=INTEGER}, #{xryResult,jdbcType=INTEGER}, \n" +
            "      #{xqf1,jdbcType=INTEGER}, #{xqfh11,jdbcType=INTEGER}, #{xqfh12,jdbcType=INTEGER}, \n" +
            "      #{xqfh13,jdbcType=INTEGER}, #{xqfhp11,jdbcType=INTEGER}, #{xqfc11,jdbcType=INTEGER}, \n" +
            "      #{xqfc12,jdbcType=INTEGER}, #{xqfc13,jdbcType=INTEGER}, #{xqfcp12,jdbcType=INTEGER}, \n" +
            "      #{xqf1Swc,jdbcType=INTEGER}, #{xqf2,jdbcType=INTEGER}, #{xqfh21,jdbcType=INTEGER}, \n" +
            "      #{xqfh22,jdbcType=INTEGER}, #{xqfh23,jdbcType=INTEGER}, #{xqfhp21,jdbcType=INTEGER}, \n" +
            "      #{xqfc21,jdbcType=INTEGER}, #{xqfc22,jdbcType=INTEGER}, #{xqfc23,jdbcType=INTEGER}, \n" +
            "      #{xqfcp22,jdbcType=INTEGER}, #{xqf2Swc,jdbcType=INTEGER}, #{xqf3,jdbcType=INTEGER}, \n" +
            "      #{xqfh31,jdbcType=INTEGER}, #{xqfh32,jdbcType=INTEGER}, #{xqfh33,jdbcType=INTEGER}, \n" +
            "      #{xqfhp31,jdbcType=INTEGER}, #{xqfc31,jdbcType=INTEGER}, #{xqfc32,jdbcType=INTEGER}, \n" +
            "      #{xqfc33,jdbcType=INTEGER}, #{xqfcp32,jdbcType=INTEGER}, #{xqf3Swc,jdbcType=INTEGER}, \n" +
            "      #{xqfZdwc,jdbcType=INTEGER}, #{xqfResult,jdbcType=INTEGER}, #{hqm1,jdbcType=INTEGER}, \n" +
            "      #{hqmh11,jdbcType=INTEGER}, #{hqmh12,jdbcType=INTEGER}, #{hqmh13,jdbcType=INTEGER}, \n" +
            "      #{hqmhp11,jdbcType=INTEGER}, #{hqmc11,jdbcType=INTEGER}, #{hqmc12,jdbcType=INTEGER}, \n" +
            "      #{hqmc13,jdbcType=INTEGER}, #{hqmcp12,jdbcType=INTEGER}, #{hqm1Swc,jdbcType=INTEGER}, \n" +
            "      #{hqm2,jdbcType=INTEGER}, #{hqmh21,jdbcType=INTEGER}, #{hqmh22,jdbcType=INTEGER}, \n" +
            "      #{hqmh23,jdbcType=INTEGER}, #{hqmhp21,jdbcType=INTEGER}, #{hqmc21,jdbcType=INTEGER}, \n" +
            "      #{hqmc22,jdbcType=INTEGER}, #{hqmc23,jdbcType=INTEGER}, #{hqmcp22,jdbcType=INTEGER}, \n" +
            "      #{hqm2Swc,jdbcType=INTEGER}, #{hqm3,jdbcType=INTEGER}, #{hqmh31,jdbcType=INTEGER}, \n" +
            "      #{hqmh32,jdbcType=INTEGER}, #{hqmh33,jdbcType=INTEGER}, #{hqmhp31,jdbcType=INTEGER}, \n" +
            "      #{hqmc31,jdbcType=INTEGER}, #{hqmc32,jdbcType=INTEGER}, #{hqmc33,jdbcType=INTEGER}, \n" +
            "      #{hqmcp32,jdbcType=INTEGER}, #{hqm3Swc,jdbcType=INTEGER}, #{hqmZdwc,jdbcType=INTEGER}, \n" +
            "      #{hqmResult,jdbcType=INTEGER}, #{dybj,jdbcType=INTEGER}, #{yqndsx,jdbcType=INTEGER}, \n" +
            "      #{qybj,jdbcType=INTEGER}, #{zxbj,jdbcType=INTEGER}, #{qdyl,jdbcType=INTEGER}, #{brhl,jdbcType=INTEGER}, \n" +
            "      #{fztql,jdbcType=INTEGER}, #{ajgn,jdbcType=INTEGER}, #{bz,jdbcType=INTEGER}, #{bz1,jdbcType=INTEGER}\n" +
            "      )")
    @Options(useGeneratedKeys = true, keyProperty = "hxjid", keyColumn = "hxjid")
    void save(Hxj hxj);
@Update(" update hxj\n" +
        "    set jcyq_id = #{jcyqId,jdbcType=INTEGER},\n" +
        "      eq_id = #{eqId,jdbcType=INTEGER},\n" +
        "      tester = #{tester,jdbcType=VARCHAR},\n" +
        "      auditor = #{auditor,jdbcType=VARCHAR},\n" +
        "      test_time = #{testTime,jdbcType=TIMESTAMP},\n" +
        "      jcjl = #{jcjl,jdbcType=VARCHAR},\n" +
        "      jcsm = #{jcsm,jdbcType=VARCHAR},\n" +
        "      cqz_test1 = #{cqzTest1,jdbcType=INTEGER},\n" +
        "      cqz_test2 = #{cqzTest2,jdbcType=INTEGER},\n" +
        "      cqz_test3 = #{cqzTest3,jdbcType=INTEGER},\n" +
        "      cqz_sz_value1 = #{cqzSzValue1,jdbcType=INTEGER},\n" +
        "      cqz_sz_value2 = #{cqzSzValue2,jdbcType=INTEGER},\n" +
        "      cqz_sz_value3 = #{cqzSzValue3,jdbcType=INTEGER},\n" +
        "      cqz_sc_value1 = #{cqzScValue1,jdbcType=INTEGER},\n" +
        "      cqz_sc_value2 = #{cqzScValue2,jdbcType=INTEGER},\n" +
        "      cqz_sc_value3 = #{cqzScValue3,jdbcType=INTEGER},\n" +
        "      cqz_wc = #{cqzWc,jdbcType=INTEGER},\n" +
        "      cqz_sz_result = #{cqzSzResult,jdbcType=TINYINT},\n" +
        "      cqz_sc_result = #{cqzScResult,jdbcType=TINYINT},\n" +
        "      qztq_test1 = #{qztqTest1,jdbcType=INTEGER},\n" +
        "      qztq_test2 = #{qztqTest2,jdbcType=INTEGER},\n" +
        "      qztq_test3 = #{qztqTest3,jdbcType=INTEGER},\n" +
        "      qztq_sz_value1 = #{qztqSzValue1,jdbcType=INTEGER},\n" +
        "      qztq_sz_value2 = #{qztqSzValue2,jdbcType=INTEGER},\n" +
        "      qztq_sz_value3 = #{qztqSzValue3,jdbcType=INTEGER},\n" +
        "      qztq_sc_value1 = #{qztqScValue1,jdbcType=INTEGER},\n" +
        "      qztq_sc_value2 = #{qztqScValue2,jdbcType=INTEGER},\n" +
        "      qztq_sc_value3 = #{qztqScValue3,jdbcType=INTEGER},\n" +
        "      qztq_wc = #{qztqWc,jdbcType=INTEGER},\n" +
        "      qztq_sz_result = #{qztqSzResult,jdbcType=TINYINT},\n" +
        "      qztq_sc_result = #{qztqScResult,jdbcType=TINYINT},\n" +
        "      xrynd_test1 = #{xryndTest1,jdbcType=INTEGER},\n" +
        "      xrynd_test2 = #{xryndTest2,jdbcType=INTEGER},\n" +
        "      xrynd_test3 = #{xryndTest3,jdbcType=INTEGER},\n" +
        "      xrynd_sz_value1 = #{xryndSzValue1,jdbcType=INTEGER},\n" +
        "      xrynd_sz_value2 = #{xryndSzValue2,jdbcType=INTEGER},\n" +
        "      xrynd_sz_value3 = #{xryndSzValue3,jdbcType=INTEGER},\n" +
        "      xrynd_sc_value1 = #{xryndScValue1,jdbcType=INTEGER},\n" +
        "      xrynd_sc_value2 = #{xryndScValue2,jdbcType=INTEGER},\n" +
        "      xrynd_sc_value3 = #{xryndScValue3,jdbcType=INTEGER},\n" +
        "      xrynd_wc = #{xryndWc,jdbcType=INTEGER},\n" +
        "      xrynd_sz_result = #{xryndSzResult,jdbcType=TINYINT},\n" +
        "      xrynd_sc_result = #{xryndScResult,jdbcType=TINYINT},\n" +
        "      xqylsp_test1 = #{xqylspTest1,jdbcType=INTEGER},\n" +
        "      xqylsp_test2 = #{xqylspTest2,jdbcType=INTEGER},\n" +
        "      xqylsp_test3 = #{xqylspTest3,jdbcType=INTEGER},\n" +
        "      xqylsp_sz_value1 = #{xqylspSzValue1,jdbcType=INTEGER},\n" +
        "      xqylsp_sz_value2 = #{xqylspSzValue2,jdbcType=INTEGER},\n" +
        "      xqylsp_sz_value3 = #{xqylspSzValue3,jdbcType=INTEGER},\n" +
        "      xqylsp_sc_value1 = #{xqylspScValue1,jdbcType=INTEGER},\n" +
        "      xqylsp_sc_value2 = #{xqylspScValue2,jdbcType=INTEGER},\n" +
        "      xqylsp_sc_value3 = #{xqylspScValue3,jdbcType=INTEGER},\n" +
        "      xqylsp_wc = #{xqylspWc,jdbcType=INTEGER},\n" +
        "      xqylsp_sz_result = #{xqylspSzResult,jdbcType=TINYINT},\n" +
        "      xqylsp_sc_result = #{xqylspScResult,jdbcType=TINYINT},\n" +
        "      hqmzy_test1 = #{hqmzyTest1,jdbcType=INTEGER},\n" +
        "      hqmzy_test2 = #{hqmzyTest2,jdbcType=INTEGER},\n" +
        "      hqmzy_test3 = #{hqmzyTest3,jdbcType=INTEGER},\n" +
        "      hqmzy_sz_value1 = #{hqmzySzValue1,jdbcType=INTEGER},\n" +
        "      hqmzy_sz_value2 = #{hqmzySzValue2,jdbcType=INTEGER},\n" +
        "      hqmzy_sz_value3 = #{hqmzySzValue3,jdbcType=INTEGER},\n" +
        "      hqmzy_sc_value1 = #{hqmzyScValue1,jdbcType=INTEGER},\n" +
        "      hqmzy_sc_value2 = #{hqmzyScValue2,jdbcType=INTEGER},\n" +
        "      hqmzy_sc_value3 = #{hqmzyScValue3,jdbcType=INTEGER},\n" +
        "      hqmzy_wc = #{hqmzyWc,jdbcType=INTEGER},\n" +
        "      hqmzy_sz_result = #{hqmzySzResult,jdbcType=TINYINT},\n" +
        "      hqmzy_sc_result = #{hqmzyScResult,jdbcType=TINYINT},\n" +
        "      dybj_result = #{dybjResult,jdbcType=TINYINT},\n" +
        "      qybj_result = #{qybjResult,jdbcType=TINYINT},\n" +
        "      qdylbj_result = #{qdylbjResult,jdbcType=TINYINT},\n" +
        "      fztqlbj_result = #{fztqlbjResult,jdbcType=TINYINT},\n" +
        "      yndbj_result = #{yndbjResult,jdbcType=TINYINT},\n" +
        "      zxbj_result = #{zxbjResult,jdbcType=TINYINT},\n" +
        "      brhlgybh_result = #{brhlgybhResult,jdbcType=TINYINT},\n" +
        "      ajgnjc_result = #{ajgnjcResult,jdbcType=TINYINT},\n" +
        "      spare1 = #{spare1,jdbcType=TINYINT},\n" +
        "      spare2 = #{spare2,jdbcType=TINYINT},\n" +
        "      spare3 = #{spare3,jdbcType=TINYINT},\n" +
        "      spare4 = #{spare4,jdbcType=TINYINT}\n" +
        "    where hxjid = #{hxjid,jdbcType=INTEGER}")
void updateHxj(Hxj hxj);
    //根据电气检测设备id查询设备检测表
    @Select("select  hxjid, jcyq_id, eq_id, tester, auditor, shsj_time, test_time, jcjl, jcsm, bhjdzk_test, \n" +
            "    bhjdzk_yx, bhjdzk_result, jykz_test, jykz_yx, jykz_result, ddld_z_z, ddld_z_f, ddld_z_yx, \n" +
            "    ddld_z_result, ddld_d_z1, ddld_d_z2, ddld_d_yx, ddld_d_result, wkld_z_z, wkld_z_f, \n" +
            "    wkld_z_yx, wkld_z_result, wkld_d_z1, wkld_d_z2, wkld_d_z3, wkld_d_z4, wkld_d_yx, \n" +
            "    wkld_d_result, cqz1, cqzh11, cqzh12, cqzh13, cqzhp11, cqzc11, cqzc12, cqzc13, cqzcp12, \n" +
            "    cqz1_swc, cqz2, cqzh21, cqzh22, cqzh23, cqzhp21, cqzc21, cqzc22, cqzc23, cqzcp22, \n" +
            "    cqz2_swc, cqz3, cqzh31, cqzh32, cqzh33, cqzhp31, cqzc31, cqzc32, cqzc33, cqzcp32, \n" +
            "    cqz3_swc, cqz_zdwc, cqz_result, qztq1, qztqh11, qztqh12, qztqh13, qztqhp11, qztqc11, \n" +
            "    qztqc12, qztqc13, qztqcp12, qztq1_swc, qztq2, qztqh21, qztqh22, qztqh23, qztqhp21, \n" +
            "    qztqc21, qztqc22, qztqc23, qztqcp22, qztq2_swc, qztq3, qztqh31, qztqh32, qztqh33, \n" +
            "    qztqhp31, qztqc31, qztqc32, qztqc33, qztqcp32, qztq3_swc, qztq_zdwc, qztq_result, \n" +
            "    xry1, xryh11, xryh12, xryh13, xryhp11, xryc11, xryc12, xryc13, xrycp12, xry1_swc, \n" +
            "    xry2, xryh21, xryh22, xryh23, xryhp21, xryc21, xryc22, xryc23, xrycp22, xry2_swc, \n" +
            "    xry3, xryh31, xryh32, xryh33, xryhp31, xryc31, xryc32, xryc33, xrycp32, xry3_swc, \n" +
            "    xry_zdwc, xry_result, xqf1, xqfh11, xqfh12, xqfh13, xqfhp11, xqfc11, xqfc12, xqfc13, \n" +
            "    xqfcp12, xqf1_swc, xqf2, xqfh21, xqfh22, xqfh23, xqfhp21, xqfc21, xqfc22, xqfc23, \n" +
            "    xqfcp22, xqf2_swc, xqf3, xqfh31, xqfh32, xqfh33, xqfhp31, xqfc31, xqfc32, xqfc33, \n" +
            "    xqfcp32, xqf3_swc, xqf_zdwc, xqf_result, hqm1, hqmh11, hqmh12, hqmh13, hqmhp11, hqmc11, \n" +
            "    hqmc12, hqmc13, hqmcp12, hqm1_swc, hqm2, hqmh21, hqmh22, hqmh23, hqmhp21, hqmc21, \n" +
            "    hqmc22, hqmc23, hqmcp22, hqm2_swc, hqm3, hqmh31, hqmh32, hqmh33, hqmhp31, hqmc31, \n" +
            "    hqmc32, hqmc33, hqmcp32, hqm3_swc, hqm_zdwc, hqm_result, dybj, yqndsx, qybj, zxbj, \n" +
            "    qdyl, brhl, fztql, ajgn, bz, bz1 from hxj order by hxjid desc limit 1 where eq_id = #{eqId}")
    public Hxj findHxj(String eqId);

    /*//以id排序，查询最后一条记录
    @Select("select * from dqjc order by dqjcid desc limit 1")
    Dqjc find();
*/

    //根据设备Id,检测仪器Id以及状态查询电器表查询最后一条记录
    @Select("select hxj.* from hxj where hxj.eq_id=#{eqId} and hxj.jcyq_id=#{jcyqId} order by hxjid desc limit 1" )
    Hxj findByEqIdandJcyqIdLast1(@Param("eqId")String eqId,@Param("jcyqId")String jcyqId);

    //根据设备Id,检测仪器Id以及状态查询电器表
    @Select("select hxj.* from hxj where hxj.eq_id=#{eqId} and hxj.jcyq_id=#{jcyqId}" )
    List<Hxj> findByEqIdandJcyqId(@Param("eqId")String eqId,@Param("jcyqId")String jcyqId);

    //查询所有
    @Select("select * from Hxj")
    List<Hxj> findAll();

    /**
     * 删除电器数据
     */
    /*@Delete("delete from dqjc where eq_id=#{eqId} and jcyq_id=#{jcyqId}")
    void delete(@Param("eqId")String eqId,@Param("jcyqId")String jcyqId);*/

    /**
     * 根据iD状态查询
     */
    @Select("select * from hxj where hxjid=#{hxjid}")
    Hxj findByHxjId(@Param("hxjid")Integer hxjid);
    /*
    修改状态
     */
    /*@Update("update Hxj set state=#{state} where dqjcid=#{dqjcid}")
    void updateState(@Param("dqjcid")Integer dqjcid,@Param("state")Integer state);*/
    //修改审核人意见
    @Update("update Hxj set shr_jcjl=#{shrJcjl},auditor=#{auditor},shsj_time=#{shsjTime} where hxjid=#{hxjid}")
    void updateShrJcjy(@Param("hxjid")Integer hxjid, @Param("shrJcjl")String shrJcjl, @Param("auditor")String auditor, @Param("shsjTime") Date shsjTime);




}
