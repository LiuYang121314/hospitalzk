package com.litbo.hospitalzj.zk.mapper;

import java.util.List;

import com.litbo.hospitalzj.zk.vo.EqAndUname;
import com.litbo.hospitalzj.zk.vo.UserEqVo;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.litbo.hospitalzj.zk.domian.EqInfo;

@Mapper()
public interface EqInfoMapper1 {

	@Insert(" insert into eq_info "
			+ "(eq_id, eq_mc, eq_dah,"
		    +  "eq_pm_id, eq_gg, eq_xh, eq_jldw_id," 
		    +  "eq_price, eq_zczbh, eq_scbh," 
		      +"eq_num, eq_totalprice, eq_ccdate," 
		     +" eq_cscs, eq_gb, eq_bgbh," 
		      +"eq_sh_fws, eq_sh_qddh, eq_sh_shjl,"
		      +"eq_sh_jldh, eq_sh_fwr, eq_sh_lxr," 
		     + "eq_sh_lxrdh, eq_state, eq_yzm,"
		     +" eq_sh_jlsb, eq_sh_fssb, ht_ids)"
		      
		    +"values (#{eqId,jdbcType=INTEGER}, #{eqMc,jdbcType=VARCHAR}, #{eqDah,jdbcType=VARCHAR},                     "
		    +"#{eqPmId,jdbcType=VARCHAR}, #{eqGg,jdbcType=VARCHAR}, #{eqXh,jdbcType=VARCHAR}, #{eqJldwId,jdbcType=VARCHAR},"
		    +"#{eqPrice,jdbcType=DECIMAL}, #{eqZczbh,jdbcType=VARCHAR}, #{eqScbh,jdbcType=VARCHAR},                      "
		    +"#{eqNum,jdbcType=VARCHAR}, #{eqTotalprice,jdbcType=VARCHAR}, #{eqCcdate,jdbcType=VARCHAR},                 "
		    +"#{eqCscs,jdbcType=VARCHAR}, #{eqGb,jdbcType=VARCHAR}, #{eqBgbh,jdbcType=VARCHAR},                          "
		    +"#{eqShFws,jdbcType=VARCHAR}, #{eqShQddh,jdbcType=VARCHAR}, #{eqShShjl,jdbcType=VARCHAR},                   "
		    +"#{eqShJldh,jdbcType=VARCHAR}, #{eqShFwr,jdbcType=VARCHAR}, #{eqShLxr,jdbcType=VARCHAR},                    "
		    +"#{eqShLxrdh,jdbcType=VARCHAR}, #{eqState,jdbcType=INTEGER}, #{eqYzm,jdbcType=VARCHAR},                     "
		    +"#{eqShJlsb,jdbcType=VARCHAR}, #{eqShFssb,jdbcType=VARCHAR}, #{htIds,jdbcType=INTEGER})")
	
	void insert(EqInfo eq);

	@Delete("delete from EqInfo_template where dc_templateid = #{dcTemplateId}")
	void delete(String id);

	@Select("select * from eq_info")
	List<EqInfo> findAll();

	@Select("SELECT * FROM eq_info WHERE eq_id IN(SELECT eq_id FROM yq_eq WHERE jcyq_id=#{jcyqId})")
	List<EqInfo> findByJcyqId(String jcyqId);

	@Select("SELECT * FROM eq_info WHERE eq_id NOT IN(SELECT eq_id FROM yq_eq WHERE jcyq_id=#{jcyqId})")
	List<EqInfo> findNotByJcyqId(String jcyqId);

	@Select("SELECT * FROM eq_info WHERE eq_id IN(SELECT jc_eqid FROM user_eq WHERE user_id=#{userId})")
	List<EqInfo> findJcEqByUserId(String userId);

	@Select("SELECT * FROM eq_info WHERE eq_id IN(SELECT sh_eqid FROM user_eq WHERE user_id=#{userId})")
	List<EqInfo> findShEqByUserId(String userId);

	@Select("SELECT "
			+"eq_id as eqId,"
			+"eq_mc as eqMc,"
			+"eq_dah as eqDah,"
			+"eq_pm_id as eqPmId,"
			+"eq_gg as eqGg,"
			+"eq_xh as eqXh,"
			+"eq_jldw_id as eqJldwId,"
			+"eq_price as eqPrice,"
			+"eq_zczbh as eqZczbh,"
			+"eq_scbh as eqScbh,"
			+"eq_num as eqNum,"
			+"eq_totalprice as eqTotalprice,"
			+"eq_ccdate as eqCcdate,"
			+"eq_cscs as eqCscs,"
			+"eq_gb as eqGb,"
			+"eq_bgbh as eqBgbh,"
			+"eq_sh_fws as eqShFws,"
			+"eq_sh_qddh as eqShQddh,"
			+"eq_sh_shjl as eqShShjl,"
			+"eq_sh_jldh as eqShJldh,"
			+"eq_sh_fwr as eqShFwr,"
			+"eq_sh_lxr as eqShLxr,"
			+"eq_sh_lxrdh as eqShLxrdh,"
			+"eq_state as eqState,"
			+"eq_yzm as eqYzm,"
			+"eq_sh_jlsb as eqShJlsb,"
			+"eq_sh_fssb as eqShFssb,"
			+"ht_ids as htIds  "
			+" FROM eq_info WHERE eq_id NOT IN(SELECT jc_eqid FROM user_eq WHERE jc_eqid IS NOT NULL AND user_id=#{userId})")
	List<EqInfo> findJcEqNotByUserId(String userId);
	@Select("SELECT * FROM eq_info WHERE eq_id NOT IN(SELECT sh_eqid FROM user_eq WHERE sh_eqid IS NOT NULL AND user_id=#{userId})")
	List<EqInfo> findShEqNotByUserId(String userId);

	/*@Select("SELECT "
			+"eq_id as eqId,"
			+"eq_mc as eqMc,"
			+"eq_dah as eqDah,"
			+"eq_pm_id as eqPmId,"
			+"eq_gg as eqGg,"
			+"eq_xh as eqXh,"
			+"eq_jldw_id as eqJldwId,"
			+"eq_price as eqPrice,"
			+"eq_zczbh as eqZczbh,"
			+"eq_scbh as eqScbh,"
			+"eq_num as eqNum,"
			+"eq_totalprice as eqTotalprice,"
			+"eq_ccdate as eqCcdate,"
			+"eq_cscs as eqCscs,"
			+"eq_gb as eqGb,"
			+"eq_bgbh as eqBgbh,"
			+"eq_sh_fws as eqShFws,"
			+"eq_sh_qddh as eqShQddh,"
			+"eq_sh_shjl as eqShShjl,"
			+"eq_sh_jldh as eqShJldh,"
			+"eq_sh_fwr as eqShFwr,"
			+"eq_sh_lxr as eqShLxr,"
			+"eq_sh_lxrdh as eqShLxrdh,"
			+"eq_state as eqState,"
			+"eq_yzm as eqYzm,"
			+"eq_sh_jlsb as eqShJlsb,"
			+"eq_sh_fssb as eqShFssb,"
			+"ht_ids as htIds  "
			+" FROM eq_info WHERE eq_id NOT IN(SELECT sh_eqid FROM user_eq WHERE sh_eqid IS NOT NULL)")
	List<EqInfo> findShEqNotByUserId(String userId);*/

	@Select("SELECT "
			+"eq_id as eqId,"
			+"eq_mc as eqMc,"
			+"eq_dah as eqDah,"
			+"eq_pm_id as eqPmId,"
			+"eq_gg as eqGg,"
			+"eq_xh as eqXh,"
			+"eq_jldw_id as eqJldwId,"
			+"eq_price as eqPrice,"
			+"eq_zczbh as eqZczbh,"
			+"eq_scbh as eqScbh,"
			+"eq_num as eqNum,"
			+"eq_totalprice as eqTotalprice,"
			+"eq_ccdate as eqCcdate,"
			+"eq_cscs as eqCscs,"
			+"eq_gb as eqGb,"
			+"eq_bgbh as eqBgbh,"
			+"eq_sh_fws as eqShFws,"
			+"eq_sh_qddh as eqShQddh,"
			+"eq_sh_shjl as eqShShjl,"
			+"eq_sh_jldh as eqShJldh,"
			+"eq_sh_fwr as eqShFwr,"
			+"eq_sh_lxr as eqShLxr,"
			+"eq_sh_lxrdh as eqShLxrdh,"
			+"eq_state as eqState,"
			+"eq_yzm as eqYzm,"
			+"eq_sh_jlsb as eqShJlsb,"
			+"eq_sh_fssb as eqShFssb,"
			+"ht_ids as htIds  "
			+" FROM eq_info WHERE eq_dah=#{dah}")
	EqInfo findByDah(String dah);

	@Select("SELECT "
			+"eq_id as eqId,"
			+"eq_mc as eqMc,"
			+"eq_dah as eqDah,"
			+"eq_pm_id as eqPmId,"
			+"eq_gg as eqGg,"
			+"eq_xh as eqXh,"
			+"eq_jldw_id as eqJldwId,"
			+"eq_price as eqPrice,"
			+"eq_zczbh as eqZczbh,"
			+"eq_scbh as eqScbh,"
			+"eq_num as eqNum,"
			+"eq_totalprice as eqTotalprice,"
			+"eq_ccdate as eqCcdate,"
			+"eq_cscs as eqCscs,"
			+"eq_gb as eqGb,"
			+"eq_bgbh as eqBgbh,"
			+"eq_sh_fws as eqShFws,"
			+"eq_sh_qddh as eqShQddh,"
			+"eq_sh_shjl as eqShShjl,"
			+"eq_sh_jldh as eqShJldh,"
			+"eq_sh_fwr as eqShFwr,"
			+"eq_sh_lxr as eqShLxr,"
			+"eq_sh_lxrdh as eqShLxrdh,"
			+"eq_state as eqState,"
			+"eq_yzm as eqYzm,"
			+"eq_sh_jlsb as eqShJlsb,"
			+"eq_sh_fssb as eqShFssb,"
			+"ht_ids as htIds  "
			+" FROM eq_info WHERE eq_id=#{eqId}")
	EqInfo findEqById(String eqId);

	@Select("SELECT "
			+"eq_id as eqId,"
			+"eq_mc as eqMc,"
			+"eq_dah as eqDah,"
			+"eq_pm_id as eqPmId,"
			+"eq_gg as eqGg,"
			+"eq_xh as eqXh,"
			+"eq_jldw_id as eqJldwId,"
			+"eq_price as eqPrice,"
			+"eq_zczbh as eqZczbh,"
			+"eq_scbh as eqScbh,"
			+"eq_num as eqNum,"
			+"eq_totalprice as eqTotalprice,"
			+"eq_ccdate as eqCcdate,"
			+"eq_cscs as eqCscs,"
			+"eq_gb as eqGb,"
			+"eq_bgbh as eqBgbh,"
			+"eq_sh_fws as eqShFws,"
			+"eq_sh_qddh as eqShQddh,"
			+"eq_sh_shjl as eqShShjl,"
			+"eq_sh_jldh as eqShJldh,"
			+"eq_sh_fwr as eqShFwr,"
			+"eq_sh_lxr as eqShLxr,"
			+"eq_sh_lxrdh as eqShLxrdh,"
			+"eq_state as eqState,"
			+"eq_yzm as eqYzm,"
			+"eq_sh_jlsb as eqShJlsb,"
			+"eq_sh_fssb as eqShFssb,"
			+"ht_ids as htIds  "
			+" FROM eq_info WHERE eq_state=#{state}")
	List<EqInfo> findEqsByState(String state);

	@Select("SELECT * FROM eq_info WHERE eq_id IN(SELECT jc_eqid FROM user_eq WHERE user_id=#{userId} AND state=#{state})")
	List<EqInfo> findEqsByUserIdAndState(@Param("userId") String userId, @Param("state") String state);

	@Select("SELECT e.* FROM eq_info e left join user_eq u on e.eq_id=u.jc_eqid " +
			"where u.user_id=#{userId} and u.state='待检测'")
	List<EqInfo> findEqInfo(String userId);

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


	//一个以上参数必须写@Param（“”）
//	SELECT eq_info.* , jcyq_name, yq.jcyq_id FROM eq_info,yq_eq , yq 
//	WHERE yq_eq.`jcyq_id` = yq.`jcyq_id`
//	AND eq_info.`eq_id` = yq_eq.`eq_id`
//	AND yq_eq.`eq_id` = (SELECT eq_id FROM eq_info WHERE eq_dah  = '3');

}
