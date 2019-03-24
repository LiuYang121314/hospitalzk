package com.litbo.hospitalzj.supplier.mapper;

import java.util.List;

import com.litbo.hospitalzj.supplier.entity.EqLy;
import org.apache.ibatis.annotations.*;
import com.litbo.hospitalzj.supplier.entity.EqSglb;
/**
 * 设备申购类别持久层接口
 * @author 刘洋
 *
 */
@Mapper
public interface EqSglbMapper {
	@Select("SELECT eqsg_id eqsgId, eqsg_name eqsgName FROM eq_sglb WHERE eqsg_id=#{eqsgId}")
	EqSglb findById(@Param("eqsgId") Integer eqsgId);

	@Select("SELECT eqsg_id eqsgId, eqsg_name eqsgName FROM eq_sglb where is_delete=0 ORDER BY eqsg_id ASC LIMIT #{offset}, #{count}")
	List<EqSglb> findAll(@Param("offset")Integer offset, @Param("count") Integer count);

	//删除，修改状态
	/*@Delete("delete from eq_sglb\n" +
			"    where eqsg_id = #{eqsgId,jdbcType=VARCHAR}")*/
	@Update("update eq_sglb set is_delete = #{isDelete} where eqsg_id = #{eqsgId}")
	int delete(@Param("eqsgId")Integer eqsgId,@Param("isDelete")Integer isDelete);

	@Insert(" insert into eq_sglb (eqsg_id, eqsg_name) values (#{eqsgId,jdbcType=VARCHAR}, #{eqsgName,jdbcType=VARCHAR})")
	int insert(EqSglb eqSglb);

	@Update(" update eq_sglb\n" +
			"    set eqsg_name = #{eqsgName,jdbcType=VARCHAR}\n" +
			"    where eqsg_id = #{eqsgId,jdbcType=VARCHAR}")
	Integer update(EqSglb eqSglb);
	//模糊查询
	@Select("SELECT * FROM eq_sglb WHERE eqsg_name LIKE '%${eqsgName}%' where is_delete=0")
	List<EqSglb> findEqSglbLike(@Param("eqsgName")String eqsgName);
}
