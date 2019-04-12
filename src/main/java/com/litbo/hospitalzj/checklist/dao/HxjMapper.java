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
    @Select("select * from hxj_template order by hxj_templateid desc limit 1")
    HxjTemplate findTemplate();

    //修改模板值
    @Update("   update hxj_template\n" +
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
    @Insert("  insert into hxj_template (hxj_templateid, cqz_test1, cqz_test2, \n" +
            "      cqz_test3, cqz_wc, qztq_test1, \n" +
            "      qztq_test2, qztq_test3, qztq_wc, \n" +
            "      xrynd_test1, xrynd_test2, xrynd_test3, \n" +
            "      xrynd_wc, xqylsp_test1, xqylsp_test2, \n" +
            "      xqylsp_test3, xqylsp_wc, hqmzy_test1, \n" +
            "      hqmzy_test2, hqmzy_test3, hqmzy_wc, \n" +
            "      spare1, spare2)\n" +
            "    values (#{hxjTemplateid,jdbcType=INTEGER}, #{cqzTest1,jdbcType=INTEGER}, #{cqzTest2,jdbcType=INTEGER}, \n" +
            "      #{cqzTest3,jdbcType=INTEGER}, #{cqzWc,jdbcType=INTEGER}, #{qztqTest1,jdbcType=INTEGER}, \n" +
            "      #{qztqTest2,jdbcType=INTEGER}, #{qztqTest3,jdbcType=INTEGER}, #{qztqWc,jdbcType=INTEGER}, \n" +
            "      #{xryndTest1,jdbcType=INTEGER}, #{xryndTest2,jdbcType=INTEGER}, #{xryndTest3,jdbcType=INTEGER}, \n" +
            "      #{xryndWc,jdbcType=INTEGER}, #{xqylspTest1,jdbcType=INTEGER}, #{xqylspTest2,jdbcType=INTEGER}, \n" +
            "      #{xqylspTest3,jdbcType=INTEGER}, #{xqylspWc,jdbcType=INTEGER}, #{hqmzyTest1,jdbcType=INTEGER}, \n" +
            "      #{hqmzyTest2,jdbcType=INTEGER}, #{hqmzyTest3,jdbcType=INTEGER}, #{hqmzyWc,jdbcType=INTEGER}, \n" +
            "      #{spare1,jdbcType=TINYINT}, #{spare2,jdbcType=TINYINT})")
    int insertHxjTemplate(HxjTemplate hxjTemplate);

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
    @Options(useGeneratedKeys = true, keyProperty = "dqjcid", keyColumn = "dqjcid")
    void save(Hxj hxj);
@Update("update hxj\n" +
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
    @Select("select hxjid, jcyq_id, eq_id, tester, auditor, test_time, jcjl, jcsm, cqz_test1, cqz_test2, \n" +
            "    cqz_test3, cqz_sz_value1, cqz_sz_value2, cqz_sz_value3, cqz_sc_value1, cqz_sc_value2, \n" +
            "    cqz_sc_value3, cqz_wc, cqz_sz_result, cqz_sc_result, qztq_test1, qztq_test2, qztq_test3, \n" +
            "    qztq_sz_value1, qztq_sz_value2, qztq_sz_value3, qztq_sc_value1, qztq_sc_value2, qztq_sc_value3, \n" +
            "    qztq_wc, qztq_sz_result, qztq_sc_result, xrynd_test1, xrynd_test2, xrynd_test3, xrynd_sz_value1, \n" +
            "    xrynd_sz_value2, xrynd_sz_value3, xrynd_sc_value1, xrynd_sc_value2, xrynd_sc_value3, \n" +
            "    xrynd_wc, xrynd_sz_result, xrynd_sc_result, xqylsp_test1, xqylsp_test2, xqylsp_test3, \n" +
            "    xqylsp_sz_value1, xqylsp_sz_value2, xqylsp_sz_value3, xqylsp_sc_value1, xqylsp_sc_value2, \n" +
            "    xqylsp_sc_value3, xqylsp_wc, xqylsp_sz_result, xqylsp_sc_result, hqmzy_test1, hqmzy_test2, \n" +
            "    hqmzy_test3, hqmzy_sz_value1, hqmzy_sz_value2, hqmzy_sz_value3, hqmzy_sc_value1, \n" +
            "    hqmzy_sc_value2, hqmzy_sc_value3, hqmzy_wc, hqmzy_sz_result, hqmzy_sc_result, dybj_result, \n" +
            "    qybj_result, qdylbj_result, fztqlbj_result, yndbj_result, zxbj_result, brhlgybh_result, \n" +
            "    ajgnjc_result, spare1, spare2, spare3, spare4 from hxj order by hxjid desc limit 1 where eq_id = #{eqId}")
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
    @Select("select * from dqjc where hxjid=#{hxjid}")
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
