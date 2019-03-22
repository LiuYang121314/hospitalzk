package com.litbo.hospitalzj.supplier.mapper;

import java.util.List;

import org.apache.ibatis.annotations.*;

import com.litbo.hospitalzj.supplier.entity.EqCgfs;
/**
 * 采购持久层接口
 * @author 刘洋
 *
 */
@Mapper
public interface EqCgMapper {
	@Select("SELECT eqcg_id eqcgId, eqcg_name eqcgName FROM eq_cgfs WHERE eqcg_id=#{eqcgId}")
	EqCgfs findById(@Param("eqcgId") Integer eqcgId);

	@Select("SELECT eqcg_id eqcgId, eqcg_name eqcgName FROM eq_cgfs WHERE eqcg_name=#{eqcgName}")
	EqCgfs findByName(@Param("eqcgName") String eqcgName);

	@Select("SELECT eqcg_id eqcgId, eqcg_name eqcgName FROM eq_cgfs where is_delete=0")
	List<EqCgfs> findAll();
	//删除记录
	/*@Delete("delete from eq_cgfs where eqcg_id = #{eqcgId,jdbcType=VARCHAR}")*/
	@Update("update eq_cgfs set is_delete = #{isDelete} where eqcg_id = #{eqcgId}")
	int delete(@Param("eqcgId")Integer eqcgId,@Param("isDelete")Integer isDelete);
	@Insert("insert into eq_cgfs (eqcg_id, eqcg_name) values (#{eqcgId}, #{eqcgName})")
	int insert(EqCgfs eqCgfs);
	//提供修改
	@Update(" update eq_cgfs\n" +
			"    set eqcg_name = #{eqcgName,jdbcType=VARCHAR}\n" +
			"    where eqcg_id = #{eqcgId,jdbcType=VARCHAR}")
	Integer update(EqCgfs eqCgfs);
	//模糊查询
	@Select("SELECT * FROM eq_cgfs WHERE eqcg_name LIKE '%${eqcgName}%'")
	List<EqCgfs> findByEqcgNameLike(@Param("eqcgName") String eqcgName);
}
