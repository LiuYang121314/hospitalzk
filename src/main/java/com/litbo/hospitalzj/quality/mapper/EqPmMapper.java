package com.litbo.hospitalzj.quality.mapper;

import java.util.List;

import org.apache.ibatis.annotations.*;

import com.litbo.hospitalzj.quality.entity.EqPm;
/**
 * 设备品名持久层接口
 * @author 刘洋
 *
 */
@Mapper
public interface EqPmMapper {
	//通过Id查询设备品名
	@Select("SELECT eq_pm_id eqPmId,eq_pm_name eqPmName,eq_pm_lx eqPmLx FROM eq_pm WHERE eq_pm_id=#{eqPmId}")
	EqPm findById(@Param("eqPmId") Integer eqPmId);
	@Select("SELECT eq_pm_id eqPmId,eq_pm_name eqPmName,eq_pm_lx eqPmLx FROM eq_pm WHERE eq_pm_name=#{eqPmName} and is_delete=0")
	EqPm findByName(@Param("eqPmName") String eqPmName);
	@Select("SELECT eq_pm_id eqPmId,eq_pm_name FROM eq_pm where is_delete=0")
	List<EqPm> findAll();
	//删除设备pm
	/*@Delete("delete from eq_pm\n" +
			"    where eq_pm_id = #{eqPmId}")*/
	@Update("update eq_pm set is_delete = #{isDelete} where eq_pm_id = #{eqPmId}")
	int delete(@Param("eqPmId")Integer eqPmId,@Param("isDelete")Integer isDelete);

	@Insert("insert into eq_pm (eq_pm_id, eq_pm_name, eq_pm_lx\n" +
			"      )\n" +
			"    values (#{eqPmId,jdbcType=VARCHAR}, #{eqPmName,jdbcType=VARCHAR}, #{eqPmLx,jdbcType=VARCHAR}\n" +
			"      )")
	int insert(EqPm eqPm);
	@Update(("update eq_pm set eq_pm_name = #{eqPmName,jdbcType=VARCHAR}," +
			"eq_pm_lx = #{eqPmLx,jdbcType=VARCHAR} where eq_pm_id = #{eqPmId,jdbcType=VARCHAR}"))
	Integer update(EqPm eqPm);
	//已分配（用户）
	@Select("SELECT * FROM eq_pm WHERE eq_pm_id IN(SELECT eq_pm_id FROM user_pm WHERE user_id=#{userId})")
	List<EqPm> findJcPmByUserId(String userId);
	//未分配
	@Select("SELECT * FROM eq_pm WHERE eq_pm_id NOT IN(SELECT eq_pm_id FROM user_pm WHERE eq_pm_id IS NOT NULL AND user_id=#{userId})")
	List<EqPm> findJcPmNotByUserId(String userId);
	//已分配（仪器）
	@Select("SELECT * FROM eq_pm WHERE eq_pm_id IN(SELECT eq_pm_id FROM yq_pm WHERE yq_id=#{yqId})")
	List<EqPm> findYqPmByYqId(String yqId);
	//未分配
	@Select("SELECT * FROM eq_pm WHERE eq_pm_id NOT IN(SELECT eq_pm_id FROM yq_pm WHERE eq_pm_id IS NOT NULL AND yq_id=#{yqId})")
	List<EqPm> findYqPmNotByYqId(String yqId);
	//模糊查询
	@Select("SELECT * FROM eq_pm WHERE is_delete =0 and eq_pm_name LIKE '%${eqPmName}%'")
	List<EqPm> findPmLike(@Param("eqPmName")String eqPmName);
}
