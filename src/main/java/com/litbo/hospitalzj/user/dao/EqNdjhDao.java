package com.litbo.hospitalzj.user.dao;

import com.litbo.hospitalzj.user.bean.EqNdjh;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 年度计划持久层
 */
@Mapper
public interface EqNdjhDao {
    @Insert("insert into eq_ndjh (jcjh_id, eq_name, eq_pm_name, \n" +
            "      eq_jcnf, user_name, eq_zjhjcl, \n" +
            "      eq_jcys, eq_jcyf, eq_jhwcsj, \n" +
            "      eq_shr, eq_shsj, eq_bz1, \n" +
            "      eq_bz2, eq_bz3, eq_bz4, \n" +
            "      eq_bz5)\n" +
            "    values (#{jcjhId,jdbcType=INTEGER}, #{eqName,jdbcType=VARCHAR}, #{eqPmName,jdbcType=VARCHAR}, \n" +
            "      #{eqJcnf,jdbcType=VARCHAR}, #{userName,jdbcType=VARCHAR}, #{eqZjhjcl,jdbcType=VARCHAR}, \n" +
            "      #{eqJcys,jdbcType=DATE}, #{eqJcyf,jdbcType=VARCHAR}, #{eqJhwcsj,jdbcType=VARCHAR}, \n" +
            "      #{eqShr,jdbcType=VARCHAR}, #{eqShsj,jdbcType=VARCHAR}, #{eqBz1,jdbcType=VARCHAR}, \n" +
            "      #{eqBz2,jdbcType=VARCHAR}, #{eqBz3,jdbcType=VARCHAR}, #{eqBz4,jdbcType=VARCHAR}, \n" +
            "      #{eqBz5,jdbcType=VARCHAR})")
    EqNdjh insert(EqNdjh eqNdjh);
    @Update("update eq_ndjh\n" +
            "    set eq_name = #{eqName,jdbcType=VARCHAR},\n" +
            "      eq_pm_name = #{eqPmName,jdbcType=VARCHAR},\n" +
            "      eq_jcnf = #{eqJcnf,jdbcType=VARCHAR},\n" +
            "      user_name = #{userName,jdbcType=VARCHAR},\n" +
            "      eq_zjhjcl = #{eqZjhjcl,jdbcType=VARCHAR},\n" +
            "      eq_jcys = #{eqJcys,jdbcType=DATE},\n" +
            "      eq_jcyf = #{eqJcyf,jdbcType=VARCHAR},\n" +
            "      eq_jhwcsj = #{eqJhwcsj,jdbcType=VARCHAR},\n" +
            "      eq_shr = #{eqShr,jdbcType=VARCHAR},\n" +
            "      eq_shsj = #{eqShsj,jdbcType=VARCHAR},\n" +
            "      eq_bz1 = #{eqBz1,jdbcType=VARCHAR},\n" +
            "      eq_bz2 = #{eqBz2,jdbcType=VARCHAR},\n" +
            "      eq_bz3 = #{eqBz3,jdbcType=VARCHAR},\n" +
            "      eq_bz4 = #{eqBz4,jdbcType=VARCHAR},\n" +
            "      eq_bz5 = #{eqBz5,jdbcType=VARCHAR}\n" +
            "    where jcjh_id = #{jcjhId,jdbcType=INTEGER}")
    Integer update(EqNdjh eqNdjh);

    @Select("select * from eq_ndjh where jcjh_id=#{jcjhId}")
    EqNdjh select(Integer jcjhId);

    @Select("select * from eq_ndjh")
    List<EqNdjh> selectAll();

    @Delete("delete from eq_ndjh\n" +
            "    where jcjh_id = #{jcjhId,jdbcType=INTEGER}")
    Integer delete(Integer jcjhId);
}
