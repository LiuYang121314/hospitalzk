package com.litbo.hospitalzj.supplier.mapper;

import java.util.List;

import com.litbo.hospitalzj.supplier.entity.EqSglb;
import org.apache.ibatis.annotations.*;
import com.litbo.hospitalzj.supplier.entity.EqYt;
/**
 * 设备用途持久层接口
 * @author 刘洋
 *
 */
@Mapper
public interface EqYtMapper {
	@Select("SELECT eqyt_id eqytId, eqyt_name eqytName FROM eq_sbyt WHERE eqyt_id=#{eqytId}")
	EqYt findById(@Param("eqytId") Integer eqytId);
	@Select("SELECT eqyt_id eqytId, eqyt_name eqytName FROM eq_sbyt WHERE eqyt_name=#{eqytName} and is_delete=0")
	EqYt findByName(@Param("eqytName") String eqytName);

	@Select("SELECT eqyt_id eqytId, eqyt_name eqytName FROM eq_sbyt where is_delete=0")
	List<EqYt> findAll();
	/*@Delete(" delete from eq_sbyt\n" +
			"    where eqyt_id = #{eqytId,jdbcType=VARCHAR}")*/
	//删除，修改状态
	/*@Delete("delete from eq_sglb\n" +
			"    where eqsg_id = #{eqsgId,jdbcType=VARCHAR}")*/
	@Update("update eq_sbyt set is_delete = #{isDelete} where eqyt_id = #{eqytId}")
	int delete(@Param("eqytId")Integer eqytId,@Param("isDelete")Integer isDelete);

	@Insert(" insert into eq_sbyt (eqyt_id, eqyt_name)\n" +
			"    values (#{eqytId,jdbcType=VARCHAR}, #{eqytName,jdbcType=VARCHAR})")
	int insert(EqYt eqYt);
	@Update(("   update eq_sbyt\n" +
			"    set eqyt_name = #{eqytName,jdbcType=VARCHAR}\n" +
			"    where eqyt_id = #{eqytId,jdbcType=VARCHAR}"))
	Integer update(EqYt eqYt);
	//模糊查询
	@Select("SELECT * FROM eq_sbyt WHERE eqyt_name LIKE '%${eqytName}%' where is_delete=0")
	List<EqYt> findEqYtLike(@Param("eqytName")String eqytName);
}
