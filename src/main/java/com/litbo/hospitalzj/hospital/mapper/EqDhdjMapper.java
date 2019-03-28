package com.litbo.hospitalzj.hospital.mapper;

import com.litbo.hospitalzj.hospital.entity.EqDhdj;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/*到货登记*/
@Mapper
public interface EqDhdjMapper {
    @Select("")
    EqDhdj select();
    @Insert(" insert into eq_dhdj (id, ht_id, dhdj_type, \n" +
            "      dhdj_qk, dhdj_time)\n" +
            "    values (#{id,jdbcType=INTEGER}, #{htId,jdbcType=INTEGER}, #{dhdjType,jdbcType=INTEGER}, \n" +
            "      #{dhdjQk,jdbcType=INTEGER}, #{dhdjTime,jdbcType=TIMESTAMP})")
    int insert(EqDhdj eqDhdj);
    @Update("update eq_dhdj\n" +
            "    set ht_id = #{htId,jdbcType=INTEGER},\n" +
            "      dhdj_type = #{dhdjType,jdbcType=INTEGER},\n" +
            "      dhdj_qk = #{dhdjQk,jdbcType=INTEGER},\n" +
            "      dhdj_time = #{dhdjTime,jdbcType=TIMESTAMP}\n" +
            "    where id = #{id,jdbcType=INTEGER}")
    int update(EqDhdj eqDhdj);
}
