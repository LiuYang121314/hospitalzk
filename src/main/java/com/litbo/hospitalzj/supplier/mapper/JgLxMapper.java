package com.litbo.hospitalzj.supplier.mapper;

import com.litbo.hospitalzj.supplier.entity.EqCgfs;
import com.litbo.hospitalzj.supplier.entity.JgLx;
import com.litbo.hospitalzj.supplier.entity.QyLx;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 采购持久层接口
 * @author 刘洋
 *
 */
@Mapper
public interface JgLxMapper {

	@Select("SELECT * FROM jg_lx WHERE jg_lxmc=#{jgLxmc}")
	JgLx findByName(@Param("jgLxmc") String jgLxmc);

	@Select("SELECT * FROM jg_lx ORDER BY jg_id ASC LIMIT #{offset}, #{count}")
	List<JgLx> findAll(@Param("offset") Integer offset, @Param("count") Integer count);

	@Insert(" insert into jg_lx (jg_id, jg_lxmc, jg_lx_code\n" +
			"      )\n" +
			"    values (#{jgId,jdbcType=INTEGER}, #{jgLxmc,jdbcType=VARCHAR}, #{jgLxCode,jdbcType=VARCHAR}\n" +
			"      )")
	int insert(JgLx jgLx);
	//提供修改
	@Update("update jg_lx\n" +
			"    set jg_lxmc = #{jgLxmc,jdbcType=VARCHAR},\n" +
			"      jg_lx_code = #{jgLxCode,jdbcType=VARCHAR}\n" +
			"    where jg_id = #{jgId,jdbcType=INTEGER}")
	Integer update(JgLx jgLx);
	//模糊查询
	@Select("SELECT * FROM jg_lx WHERE jg_lxmc LIKE '%${jgLx}%' or qy_lx_code LIKE '%${jgLx}%'")
	List<JgLx> findByJgLxNameLike(@Param("jgLx") String jgLx);
	@Delete("delete from jg_lx where jg_id = #{jgId}")
	int delete(Integer jgId);
}
