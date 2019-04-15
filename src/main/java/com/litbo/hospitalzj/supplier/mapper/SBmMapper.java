package com.litbo.hospitalzj.supplier.mapper;

import com.litbo.hospitalzj.supplier.entity.EqCgfs;
import com.litbo.hospitalzj.supplier.entity.SBm;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 部门科室持久层接口
 * @author 刘洋
 *
 */
@Mapper
public interface SBmMapper {
	//通过id查询
	@Select("SELECT * FROM s_bm WHERE bm_id=#{bmId}")
	SBm findById(@Param("bmId") Integer bmId);

	@Select("SELECT bm_name from s_bm where bm_name = #{bmName}")
	SBm findByName(@Param("bmName") String bmName);
	//查询全部部门
	@Select("SELECT * FROM s_bm")
	List<SBm> findAll();
	//删除记录
	@Delete(" delete from s_bm where bm_id = #{bmId,jdbcType=INTEGER}")
	int delete(@Param("bmId") Integer bmId);
	//插入部门
	@Insert("insert into s_bm (bm_id, bm_name, user_name, \n" +
			"      bm_tel, bm_addr, wx_flag, \n" +
			"      p_bm_id, obm_id, xbm_flag)\n" +
			"    values (#{bmId,jdbcType=CHAR}, #{bmName,jdbcType=VARCHAR}, #{userName,jdbcType=VARCHAR}, \n" +
			"      #{bmTel,jdbcType=VARCHAR}, #{bmAddr,jdbcType=VARCHAR}, #{wxFlag,jdbcType=CHAR}, \n" +
			"      #{pBmId,jdbcType=CHAR}, #{obmId,jdbcType=INTEGER}, #{xbmFlag,jdbcType=CHAR})")
	int insert(SBm sBm);
	//提供修改
	@Update("update s_bm\n" +
			"    set bm_name = #{bmName,jdbcType=VARCHAR},\n" +
			"      user_name = #{userName,jdbcType=VARCHAR},\n" +
			"      bm_tel = #{bmTel,jdbcType=VARCHAR},\n" +
			"      bm_addr = #{bmAddr,jdbcType=VARCHAR},\n" +
			"      wx_flag = #{wxFlag,jdbcType=CHAR},\n" +
			"      p_bm_id = #{pBmId,jdbcType=CHAR},\n" +
			"      obm_id = #{obmId,jdbcType=INTEGER},\n" +
			"      xbm_flag = #{xbmFlag,jdbcType=CHAR}\n" +
			"    where bm_id = #{bmId,jdbcType=INTEGER}")
	Integer update(SBm sBm);
	//模糊查询
	@Select("SELECT * FROM s_bm WHERE bm_name LIKE '%${bmName}%'")
	List<SBm> findByBmNameLike(@Param("bmName") String bmName);
}
