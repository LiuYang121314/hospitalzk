package com.litbo.hospitalzj.checklist.dao;

import com.litbo.hospitalzj.checklist.domain.Dqjc;
import com.litbo.hospitalzj.checklist.domain.DqjcTemplate;
import com.litbo.hospitalzj.checklist.domain.YepyxTemplate;
import com.litbo.hospitalzj.checklist.vo.DqjcUser;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface YepyxMapper {
    //查询婴儿培养箱检测模板表
    @Select("select * from yepyx_template order by pyx_template_id desc limit 1")
    public DqjcTemplate findTemplate();
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
    void insertTemplate(DqjcTemplate dqjcTemplate);

    //保存电气检测数据
    @Insert("insert into dqjc (dqjcid, jcyq_id, eq_id, \n" +
            "      tester, auditor, test_time, \n" +
            "      shr_jcjl,jcjl, jcsm, dydy, dydy_value, \n" +
            "      dydy_result, jdzk, jdzk_value, \n" +
            "      jdzk_result, jyzk, jyzk_value, \n" +
            "      jyzk_result, ddldl_zc, ddldl_zc_zx_value, \n" +
            "      ddldl_zc_fx_value, ddldl_zc_result, ddldl_dy, \n" +
            "      ddldl_dy_zxdl_value, ddldl_dy_fxdl_value, ddldl_dy_result, \n" +
            "      wkldl_zc, wkldl_zc_zx_value, wkldl_zc_fx_value, \n" +
            "      wkldl_zc_result, wkldl_dy, wkldl_dy_zxdl_value, \n" +
            "      wkldl_dy_zxdd_value, wkldl_dy_fxdl_value, wkldl_dy_fxdd_value, \n" +
            "      wkldl_dy_result, hzldl_zc_zxbf_value, hzldl_zc_fxbf_value, \n" +
            "      hzldl_zc_zxcf_value, hzldl_zc_fxcf_value, hzldl_zc_result, \n" +
            "      hzldl_dy_zxdlbf_value, hzldl_dy_zxddbf_value, hzldl_dy_fxdlbf_value, \n" +
            "      hzldl_dy_fxddbf_value, hzldl_dy_zxdlcf_value, hzldl_dy_zxddcf_value, \n" +
            "      hzldl_dy_fxdlcf_value, hzldl_dy_fxddcf_value, hzldl_dy_result, \n" +
            "      hzfzldl_zc_zxbf_value, hzfzldl_zc_fxbf_value, hzfzldl_zc_zxcf_value, \n" +
            "      hzfzldl_zc_fxcf_value, hzfzldl_zc_result, hzfzldl_dy_zxdlbf_value, \n" +
            "      hzfzldl_dy_zxddbf_value, hzfzldl_dy_fxdlbf_value, \n" +
            "      hzfzldl_dy_fxddbf_value, hzfzldl_dy_zxdlcf_value, \n" +
            "      hzfzldl_dy_zxddcf_value, hzfzldl_dy_fxdlcf_value, \n" +
            "      hzfzldl_dy_fxddcf_value, hzfzldl_dy_result, state, \n" +
            "      spare2, spare3, spare4, \n" +
            "      spare5)\n" +
            "    values (#{dqjcid,jdbcType=INTEGER}, #{jcyqId,jdbcType=INTEGER}, #{eqId,jdbcType=INTEGER}, \n" +
            "      #{tester,jdbcType=VARCHAR}, #{auditor,jdbcType=VARCHAR}, #{testTime,jdbcType=TIMESTAMP}, \n" +
            "      #{shrJcjl,jdbcType=VARCHAR},#{jcjl,jdbcType=VARCHAR}, #{jcsm,jdbcType=VARCHAR}, #{dydy,jdbcType=DOUBLE}, #{dydyValue,jdbcType=DOUBLE}, \n" +
            "      #{dydyResult,jdbcType=TINYINT}, #{jdzk,jdbcType=DOUBLE}, #{jdzkValue,jdbcType=DOUBLE}, \n" +
            "      #{jdzkResult,jdbcType=TINYINT}, #{jyzk,jdbcType=DOUBLE}, #{jyzkValue,jdbcType=DOUBLE}, \n" +
            "      #{jyzkResult,jdbcType=TINYINT}, #{ddldlZc,jdbcType=DOUBLE}, #{ddldlZcZxValue,jdbcType=DOUBLE}, \n" +
            "      #{ddldlZcFxValue,jdbcType=DOUBLE}, #{ddldlZcResult,jdbcType=TINYINT}, #{ddldlDy,jdbcType=DOUBLE}, \n" +
            "      #{ddldlDyZxdlValue,jdbcType=DOUBLE}, #{ddldlDyFxdlValue,jdbcType=DOUBLE}, #{ddldlDyResult,jdbcType=TINYINT}, \n" +
            "      #{wkldlZc,jdbcType=DOUBLE}, #{wkldlZcZxValue,jdbcType=DOUBLE}, #{wkldlZcFxValue,jdbcType=DOUBLE}, \n" +
            "      #{wkldlZcResult,jdbcType=TINYINT}, #{wkldlDy,jdbcType=DOUBLE}, #{wkldlDyZxdlValue,jdbcType=DOUBLE}, \n" +
            "      #{wkldlDyZxddValue,jdbcType=DOUBLE}, #{wkldlDyFxdlValue,jdbcType=DOUBLE}, #{wkldlDyFxddValue,jdbcType=DOUBLE}, \n" +
            "      #{wkldlDyResult,jdbcType=TINYINT}, #{hzldlZcZxbfValue,jdbcType=DOUBLE}, #{hzldlZcFxbfValue,jdbcType=DOUBLE}, \n" +
            "      #{hzldlZcZxcfValue,jdbcType=DOUBLE}, #{hzldlZcFxcfValue,jdbcType=DOUBLE}, #{hzldlZcResult,jdbcType=TINYINT}, \n" +
            "      #{hzldlDyZxdlbfValue,jdbcType=DOUBLE}, #{hzldlDyZxddbfValue,jdbcType=DOUBLE}, #{hzldlDyFxdlbfValue,jdbcType=DOUBLE}, \n" +
            "      #{hzldlDyFxddbfValue,jdbcType=DOUBLE}, #{hzldlDyZxdlcfValue,jdbcType=DOUBLE}, #{hzldlDyZxddcfValue,jdbcType=DOUBLE}, \n" +
            "      #{hzldlDyFxdlcfValue,jdbcType=DOUBLE}, #{hzldlDyFxddcfValue,jdbcType=DOUBLE}, #{hzldlDyResult,jdbcType=TINYINT}, \n" +
            "      #{hzfzldlZcZxbfValue,jdbcType=DOUBLE}, #{hzfzldlZcFxbfValue,jdbcType=DOUBLE}, #{hzfzldlZcZxcfValue,jdbcType=DOUBLE}, \n" +
            "      #{hzfzldlZcFxcfValue,jdbcType=DOUBLE}, #{hzfzldlZcResult,jdbcType=TINYINT}, #{hzfzldlDyZxdlbfValue,jdbcType=DOUBLE}, \n" +
            "      #{hzfzldlDyZxddbfValue,jdbcType=DOUBLE}, #{hzfzldlDyFxdlbfValue,jdbcType=DOUBLE}, \n" +
            "      #{hzfzldlDyFxddbfValue,jdbcType=DOUBLE}, #{hzfzldlDyZxdlcfValue,jdbcType=DOUBLE}, \n" +
            "      #{hzfzldlDyZxddcfValue,jdbcType=DOUBLE}, #{hzfzldlDyFxdlcfValue,jdbcType=DOUBLE}, \n" +
            "      #{hzfzldlDyFxddcfValue,jdbcType=DOUBLE}, #{hzfzldlDyResult,jdbcType=TINYINT}, #{state,jdbcType=TINYINT}, \n" +
            "      #{spare2,jdbcType=TINYINT}, #{spare3,jdbcType=TINYINT}, #{spare4,jdbcType=TINYINT}, \n" +
            "      #{spare5,jdbcType=TINYINT})")
    @Options(useGeneratedKeys = true, keyProperty = "dqjcid", keyColumn = "dqjcid")
    public void save(Dqjc dqjc);

    //根据电气检测设备id查询设备检测表
    @Select("select dqjcid, jcyq_id, eq_id, tester, auditor, test_time, jcjl, jcsm, dydy, dydy_value, "
            +"dydy_result, jdzk, jdzk_value, jdzk_result, jyzk, jyzk_value, jyzk_result, ddldl_zc,            "
            +"ddldl_zc_zx_value, ddldl_zc_fx_value, ddldl_zc_result, ddldl_dy, ddldl_dy_zxdl_value,           "
            +"ddldl_dy_fxdl_value, ddldl_dy_result, wkldl_zc, wkldl_zc_zx_value, wkldl_zc_fx_value,           "
            +"wkldl_zc_result, wkldl_dy, wkldl_dy_zxdl_value, wkldl_dy_zxdd_value, wkldl_dy_fxdl_value,       "
            +"wkldl_dy_fxdd_value, wkldl_dy_result, hzldl_zc_bf, hzldl_zc_cf, hzldl_zc_zx_value,              "
            +"hzldl_zc_fx_value, hzldl_zc_result, hzldl_dy_bf, hzldl_dy_cf, hzldl_dy_zxdl_value,              "
            +"hzldl_dy_zxdd_value, hzldl_dy_fxdl_value, hzldl_dy_fxdd_value, hzldl_dy_result, hzfzldl_zc_bf,  "
            +"hzfzldl_zc_cf, hzfzldl_zc_zx_value, hzfzldl_zc_fx_value, hzfzldl_zc_result, hzfzldl_dy_bf,      "
            +"hzfzldl_dy_cf, hzfzldl_dy_zxdl_value, hzfzldl_dy_zxdd_value, hzfzldl_dy_fxdl_value,             "
            +"hzfzldl_dy_fxdd_value, hzfzldl_dy_result, spare1, spare2, spare3, spare4, spare5 from dqjc order by dqjcid desc limit 1 where eq_id = '#{eqId}'")
    public Dqjc findDqjc(String eqId);

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
