package com.litbo.hospitalzj.zk.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.litbo.hospitalzj.zk.domian.YqRole;

@Mapper
public interface YqRoleMapper {

	@Insert("insert into yq_role (id, user_id, role_status, yq_id) value ("
			+ "#{id}, #{userId},#{roleStatus},#{yqId})") 
	void insert(@Param("userId") String userId, @Param("roleStatus") int status, @Param("yqId") String yqId);

	@Delete("delete from yq_role where user_id = #{userId} AND yq_id = #{yqId}")
	void delete(@Param("userId") String userId, @Param("yqId") String yqId);

	
}
