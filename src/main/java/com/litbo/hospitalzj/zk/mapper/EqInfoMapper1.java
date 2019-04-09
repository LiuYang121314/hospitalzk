package com.litbo.hospitalzj.zk.mapper;

import java.util.List;

import com.litbo.hospitalzj.sf.entity.User;
import com.litbo.hospitalzj.zk.vo.EqAndUname;
import com.litbo.hospitalzj.zk.vo.UserEqVo;

import org.apache.ibatis.annotations.*;

import com.litbo.hospitalzj.zk.domian.EqInfo;

@Mapper()
public interface EqInfoMapper1 {

	@Insert("  insert into eq_info (eq_id, eq_mc, eq_dah, \n" +
			"      eq_pm_id, eq_xh, eq_jldw_id, \n" +
			"      eq_azdd, eq_bxq, eq_yt, \n" +
			"      eq_price, eq_zczbh, eq_scbh, \n" +
			"      eq_num, eq_totalprice, eq_ccdate, \n" +
			"      eq_cscs, eq_gb, eq_bgbh, \n" +
			"      eq_sh_fws, eq_sh_qddh, eq_sh_shjl, \n" +
			"      eq_sh_jldh, eq_sh_lxr, eq_sh_lxrdh, \n" +
			"      eq_state, eq_yzm, ht_ids, \n" +
			"      eq_sh_lb, eq_syks, eq_jx, \n" +
			"      eq_qyrq, eq_cfdd, eq_bfjd\n" +
			"      )\n" +
			"    values (#{eqId,jdbcType=INTEGER}, #{eqMc,jdbcType=VARCHAR}, #{eqDah,jdbcType=VARCHAR}, \n" +
			"      #{eqPmId,jdbcType=VARCHAR}, #{eqXh,jdbcType=VARCHAR}, #{eqJldwId,jdbcType=VARCHAR}, \n" +
			"      #{eqAzdd,jdbcType=VARCHAR}, #{eqBxq,jdbcType=VARCHAR}, #{eqYt,jdbcType=VARCHAR}, \n" +
			"      #{eqPrice,jdbcType=DECIMAL}, #{eqZczbh,jdbcType=VARCHAR}, #{eqScbh,jdbcType=VARCHAR}, \n" +
			"      #{eqNum,jdbcType=VARCHAR}, #{eqTotalprice,jdbcType=VARCHAR}, #{eqCcdate,jdbcType=VARCHAR}, \n" +
			"      #{eqCscs,jdbcType=VARCHAR}, #{eqGb,jdbcType=VARCHAR}, #{eqBgbh,jdbcType=VARCHAR}, \n" +
			"      #{eqShFws,jdbcType=VARCHAR}, #{eqShQddh,jdbcType=VARCHAR}, #{eqShShjl,jdbcType=VARCHAR}, \n" +
			"      #{eqShJldh,jdbcType=VARCHAR}, #{eqShLxr,jdbcType=VARCHAR}, #{eqShLxrdh,jdbcType=VARCHAR}, \n" +
			"      #{eqState,jdbcType=INTEGER}, #{eqYzm,jdbcType=VARCHAR}, #{htIds,jdbcType=INTEGER}, \n" +
			"      #{eqShLb,jdbcType=VARCHAR}, #{eqSyks,jdbcType=VARCHAR}, #{eqJx,jdbcType=VARCHAR}, \n" +
			"      #{eqQyrq,jdbcType=VARCHAR}, #{eqCfdd,jdbcType=VARCHAR}, #{eqBfjd,jdbcType=VARCHAR}\n" +
			"      )")
	void insert(EqInfo eq);

	@Update("update eq_info set eq_pm_id=#{eqPmId} where eq_id=#{eqId}")
	void updateEqPm(@Param("eqPmId")Integer eqPmId,@Param("eqId") Integer eqId);

	@Delete("delete from EqInfo_template where dc_templateid = #{dcTemplateId}")
	void delete(String id);

	@Select("select * from eq_info")
	List<EqInfo> findAll();

	@Select("SELECT * FROM eq_info WHERE eq_id IN(SELECT eq_id FROM yq_eq WHERE jcyq_id=#{jcyqId})")
	List<EqInfo> findByJcyqId(String jcyqId);

	@Select("SELECT * FROM eq_info WHERE eq_id NOT IN(SELECT eq_id FROM yq_eq WHERE jcyq_id=#{jcyqId})")
	List<EqInfo> findNotByJcyqId(String jcyqId);
	//查询用户分配的检测设备
	@Select("SELECT * FROM eq_info WHERE eq_id IN(SELECT jc_eqid FROM user_eq WHERE user_id=#{userId})")
	List<EqInfo> findJcEqByUserId(String userId);
	//查询用户已分配的新设备信息
	@Select("SELECT * FROM eq_info WHERE eq_dah='' and eq_id IN(SELECT jc_eqid FROM user_eq WHERE user_id=#{userId})")
	List<EqInfo> findNewJcEqByUserId(String userId);

	@Select("SELECT * FROM S_user WHERE user_id IN(SELECT user_id FROM user_eq WHERE jc_eqid=#{jcEqid})")
	List<User> findUserIdByEqId(String userId);

	@Select("SELECT * FROM eq_info WHERE eq_id IN(SELECT sh_eqid FROM user_eq WHERE user_id=#{userId})")
	List<EqInfo> findShEqByUserId(String userId);

	@Select("SELECT * FROM eq_info WHERE eq_id NOT IN(SELECT jc_eqid FROM user_eq WHERE jc_eqid IS NOT NULL AND user_id=#{userId})")
	List<EqInfo> findJcEqNotByUserId(String userId);
	@Select("SELECT * FROM eq_info WHERE eq_id NOT IN(SELECT sh_eqid FROM user_eq WHERE sh_eqid IS NOT NULL AND user_id=#{userId})")
	List<EqInfo> findShEqNotByUserId(String userId);
	//通过档案号查询设备信息
	@Select("SELECT * FROM eq_info WHERE eq_dah=#{dah}")
	EqInfo findByDah(@Param("dah")String dah);

	@Select("SELECT * FROM eq_info WHERE eq_id=#{eqId}")
	EqInfo findEqById(String eqId);

	@Select("SELECT * FROM eq_info WHERE eq_state=#{state}")
	List<EqInfo> findEqsByState(String state);

	@Select("SELECT * FROM eq_info WHERE eq_id IN(SELECT jc_eqid FROM user_eq WHERE user_id=#{userId} AND state=#{state})")
	List<EqInfo> findEqsByUserIdAndState(@Param("userId") String userId, @Param("state") String state);

	@Select("SELECT e.* FROM eq_info e left join user_eq u on e.eq_id=u.jc_eqid " +
			"where u.user_id=#{userId} and u.state='待检测'")
	List<EqInfo> findEqInfo(@Param("userId")String userId);

	@Select("select * from eq_info where eq_state=1")
	List<EqInfo> findNewEqInfo();
	@Select("SELECT * FROM eq_info, s_user, (SELECT user_eq.jc_eqid AS A,user_eq.shr_id AS B " +
			"FROM user_eq WHERE " +
			"user_eq.user_id =#{userId} AND user_eq.state=#{state}) AS midle WHERE midle.A = eq_info.eq_id " +
			"AND midle.B = s_user.user_id;")
	List<EqAndUname> findJcEqsByUserIdAndState(@Param("userId") String userId, @Param("state") String state);

	@Select("SELECT * FROM eq_info WHERE eq_id " +
			"IN(SELECT sh_eqid FROM user_eq WHERE user_id=#{userId} AND state=#{state})")
	List<EqInfo> findShEqsByUserIdAndState(@Param("userId") String userId, @Param("state") String state);
	@Select("SELECT * FROM eq_info WHERE eq_dah=#{dah}")
	EqInfo Dah(@Param("dah")String dah);
}
