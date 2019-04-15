package com.litbo.hospitalzj.zk.mapper;

import com.litbo.hospitalzj.zk.domian.EqInfo;
import com.litbo.hospitalzj.zk.domian.TabEq;
import com.litbo.hospitalzj.zk.domian.Yq;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TabEqMapper {

	@Select("SELECT table_name FROM tab_eq WHERE eq_id=#{eqId} and jcyq_id=#{jcyqId} order by eq_id desc limit 1")
	String findTable(@Param("eqId") Integer eqId,@Param("jcyqId")Integer jcyqId);

	@Select("select * from tab_eq")
	List<TabEq> findAll();

	@Insert("insert into tab_eq (id, eq_id, jcyq_id,table_name\n" +
			"      )\n" +
			"    values (#{id,jdbcType=INTEGER}, #{eqId,jdbcType=INTEGER}, #{jcyqId},#{tableName,jdbcType=VARCHAR}\n" +
			"      )")
	void insert(TabEq tabEq);
}
