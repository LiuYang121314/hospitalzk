package com.litbo.hospitalzj.user.dao;

import com.litbo.hospitalzj.user.bean.EqZjls;
import com.litbo.hospitalzj.user.bean.MonCount;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/***
 * 质检设备流水
 */
@Mapper
public interface EqZjlsDao {
    @Delete("delete from eq_zjls\n" +
            "    where dz_id = #{dzId,jdbcType=INTEGER}")
    int delete(Integer dzId);
    @Insert("insert into eq_zjls (dz_id, test_time, eq_id, \n" +
            "      eq_mc,tester, auditor)\n" +
            "    values (#{dzId,jdbcType=INTEGER}, #{testTime,jdbcType=TIMESTAMP}, #{eqId,jdbcType=INTEGER}, \n" +
            "      #{eqMc},#{tester,jdbcType=VARCHAR}, #{auditor,jdbcType=VARCHAR})")
    int insert(EqZjls eqZjls);
    @Select("select * from eq_zjls")
    List<EqZjls> selectAll();
    @Select("  select * from eq_zjls\n" +
            "    where dz_id = #{dzId,jdbcType=INTEGER}")
    EqZjls select(Integer dzId);

    @Select("select DATE_FORMAT(test_time,'%c')months,count(*)count  from eq_zjls where tester=#{tester} group by months")
    List<MonCount> count(String tester);

    @Select("  select * from eq_zjls where eq_id = #{eqId}")
    List<EqZjls> selectEq(Integer eqId);

}
