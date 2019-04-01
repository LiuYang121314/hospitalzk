package com.litbo.hospitalzj.quality.mapper;

import com.litbo.hospitalzj.quality.entity.EqPm;
import com.litbo.hospitalzj.quality.entity.EqXeq;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface EqXeqMapper {
    @Update("pdate eq_xeq\n" +
            "    set eq_name = #{eqName,jdbcType=VARCHAR},\n" +
            "      eq_code = #{eqCode,jdbcType=VARCHAR}\n" +
            "    where id = #{id,jdbcType=INTEGER}")
    int update(EqXeq eqXeq);

    @Insert(" insert into eq_xeq (id, eq_name, eq_code\n" +
            "      )\n" +
            "    values (#{id,jdbcType=INTEGER}, #{eqName,jdbcType=VARCHAR}, #{eqCode,jdbcType=VARCHAR}\n" +
            "      )")
    int insert(EqXeq eqXeq);

    @Delete("delete from eq_xeq where id=#{id}")
    int delete(Integer id);

    @Select("select * from eq_xeq where eq_name=#{eqName}")
    EqXeq findByName(String eqName);

    @Select("select * from eq_xeq")
    List<EqXeq> all();

    //模糊查询
    @Select("SELECT * FROM eq_xeq WHERE eq_name LIKE '%${data}%' or eq_code like '%${data}%'")
    List<EqXeq> findEqXeqLike(@Param("data")String data);

    @Select("SELECT COUNT(*) FROM eq_xeq WHERE find_in_set(#{eqName}, eq_name);")
    int findByEqName(@Param("eqName")String eqName);
}
