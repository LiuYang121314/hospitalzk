package com.litbo.hospitalzj.zk.mapper;

import com.litbo.hospitalzj.zk.domian.YqTsls;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;

/**
 * 仪器推送流水
 */
@Mapper
public interface YqTslsMapper {
    @Select("select push_msg from yq_tsls where push_role=#{pushRole}")
    List<String> select(String pushRole);
    @Insert("insert into yqtsls (id, yq_name, yq_expire_date, \n" +
            "      push_role, push_msg)\n" +
            "    values (#{id,jdbcType=INTEGER}, #{yqName,jdbcType=VARCHAR}, #{yqExpireDate,jdbcType=TIMESTAMP}, \n" +
            "      #{pushRole,jdbcType=VARCHAR}, #{pushMsg,jdbcType=VARCHAR}) ")
    YqTsls insert(YqTsls yqTsls);
    @Delete("delete from yq_tsls\n" +
            "    where yq_expire_date = #{yqExpireDate}")
    void delete(Date yqExpireDate);
}
