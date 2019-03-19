package com.litbo.hospitalzj.quality.mapper;

import com.litbo.hospitalzj.quality.entity.YqPm;
import org.apache.ibatis.annotations.*;

/**
 * 仪器品名关联持久层
 */
@Mapper
public interface YqPmMapper {
    @Insert("insert into yq_pm (id, yq_id, eq_pm_id\n" +
            "      )\n" +
            "    values (#{id,jdbcType=INTEGER}, #{yqId,jdbcType=VARCHAR}, #{eqPmId,jdbcType=VARCHAR}\n" +
            "      )")
    int insert(YqPm yqPm);
    @Select("select * from yq_pm where yq_id=#{yqId} and eq_pm_id=#{eqPmId}")
    YqPm selectById(@Param("yqId")String yqId,@Param("eqPmId")String eqPmId);

    @Delete("delete from yq_pm where yq_id=#{yqId} and eq_pm_id=#{eqPmId}")
    void delete(@Param("yqId") String yqId, @Param("eqPmId") String eqPmId);
}
