package com.litbo.hospitalzj.zk.mapper;

import com.litbo.hospitalzj.zk.domian.YqJxjl;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 仪器检修记录表
 */
@Mapper
public interface YqJxjlMapper {
    @Insert("  insert into yq_jxjl (id, yq_id, yq_jxtime, \n" +
            "      yq_name,yq_jxr, yq_jxbg,state)\n" +
            "    values (#{id,jdbcType=INTEGER}, #{yqId,jdbcType=INTEGER}, #{yqJxtime,jdbcType=TIMESTAMP}, \n" +
            "      #{yqName},#{yqDah},#{yqJxr,jdbcType=VARCHAR}, #{yqJxbg,jdbcType=VARCHAR},#{state})")
    int insert(YqJxjl yqJxjl);
    @Update("  update yq_jxjl\n" +
            "    set yq_id = #{yqId,jdbcType=INTEGER},\n" +
            "      yq_name=#{yqName},"+
            "      yq_dah=#{yqDah},"+
            "      yq_jxtime = #{yqJxtime,jdbcType=TIMESTAMP},\n" +
            "      yq_jxr = #{yqJxr,jdbcType=VARCHAR},\n" +
            "      yq_jxbg = #{yqJxbg,jdbcType=VARCHAR}\n" +
            "      state=#{state}"+
            "    where id = #{id,jdbcType=INTEGER}")
    int update(YqJxjl yqJxjl);
    @Update("update yq_jcjl set state=#{state} where id=#{id}")
    int updateState(@Param("state") Integer state,@Param("id")Integer id);
    @Select("select * from yq_jxjl")
    List<YqJxjl> selectAll();


}
