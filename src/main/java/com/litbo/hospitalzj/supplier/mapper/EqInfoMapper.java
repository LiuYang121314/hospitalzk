package com.litbo.hospitalzj.supplier.mapper;

import java.util.List;

import org.apache.ibatis.annotations.*;

import com.litbo.hospitalzj.supplier.entity.EqInfo;

import com.litbo.hospitalzj.supplier.vo.SelHtEqVo;



@Mapper
public interface EqInfoMapper {
	/*@Insert({
		 "<script>",
		 "insert into eq_Info (eq_id,ht_ids,eq_pm,eq_gg,"
		 + "eq_xh,eq_jldw_id,eq_price,eq_zczbh,eq_scbh,eq_num,eq_totalprice,"
		 + "eq_ccdate,eq_cscs,eq_gb,eq_bgbh,eq_sh_fws,eq_sh_qddh,eq_sh_shjl,"
		 + "eq_sh_jldh,eq_sh_fwr,eq_sh_lxr,eq_sh_lxrdh,eq_state,eq_yzm,"
		 + "eq_sh_jlsb,eq_sh_fssb) values ",
		 "<foreach collection='eqInfos' item='item' index='index' separator=','>",
		 "(#{item.eqId},#{item.htIds},#{item.eqPm},#{item.eqGg},#{item.eqXh},#{item.eqJldwId},#{item.eqPrice},#{item.eqZczbh},"
		 + "#{item.eqScbh},#{item.eqNum},#{item.eqTotalprice},#{item.eqCcdate},"
		 + "#{item.eqCscs},#{item.eqGb},#{item.eqBgbh},#{item.eqShFws},#{item.eqShQddh},"
		 + "#{item.eqShShjl},#{item.eqShJldh},#{item.eqShFwr},"
		 + "#{item.eqShLxr},#{item.eqShLxrdh},#{item.eqState},#{item.eqYzm},#{item.eqShFssb},"
		 + "#{item.eqShFssb})",
		 "</foreach>",
		 "</script>"
		})
		int insertEqInfoList(@Param(value="eqInfos") List<EqInfo>  eqInfo);*/
	
	@Insert ("insert into eq_info (eq_id, eq_mc, eq_dah, \n" +
			"      eq_pm_id, eq_gg, eq_xh, \n" +
			"      eq_jldw_id, eq_price, eq_zczbh, \n" +
			"      eq_scbh, eq_num, eq_totalprice, \n" +
			"      eq_ccdate, eq_cscs, eq_gb, \n" +
			"      eq_bgbh, eq_sh_fws, eq_sh_qddh, \n" +
			"      eq_sh_shjl, eq_sh_jldh, eq_sh_fwr, \n" +
			"      eq_sh_lxr, eq_sh_lxrdh, eq_state, \n" +
			"      eq_yzm, eq_sh_jlsb, eq_sh_fssb, \n" +
			"      ht_ids, eq_syks, eq_jx, \n" +
			"      eq_qyrq, eq_cfdd, eq_bfjd\n" +
			"      )\n" +
			"    values (#{eqId,jdbcType=INTEGER}, #{eqMc,jdbcType=VARCHAR}, #{eqDah,jdbcType=VARCHAR}, \n" +
			"      #{eqPmId,jdbcType=VARCHAR}, #{eqGg,jdbcType=VARCHAR}, #{eqXh,jdbcType=VARCHAR}, \n" +
			"      #{eqJldwId,jdbcType=VARCHAR}, #{eqPrice,jdbcType=DECIMAL}, #{eqZczbh,jdbcType=VARCHAR}, \n" +
			"      #{eqScbh,jdbcType=VARCHAR}, #{eqNum,jdbcType=VARCHAR}, #{eqTotalprice,jdbcType=VARCHAR}, \n" +
			"      #{eqCcdate,jdbcType=VARCHAR}, #{eqCscs,jdbcType=VARCHAR}, #{eqGb,jdbcType=VARCHAR}, \n" +
			"      #{eqBgbh,jdbcType=VARCHAR}, #{eqShFws,jdbcType=VARCHAR}, #{eqShQddh,jdbcType=VARCHAR}, \n" +
			"      #{eqShShjl,jdbcType=VARCHAR}, #{eqShJldh,jdbcType=VARCHAR}, #{eqShFwr,jdbcType=VARCHAR}, \n" +
			"      #{eqShLxr,jdbcType=VARCHAR}, #{eqShLxrdh,jdbcType=VARCHAR}, #{eqState,jdbcType=INTEGER}, \n" +
			"      #{eqYzm,jdbcType=VARCHAR}, #{eqShJlsb,jdbcType=VARCHAR}, #{eqShFssb,jdbcType=VARCHAR}, \n" +
			"      #{htIds,jdbcType=INTEGER}, #{eqSyks,jdbcType=VARCHAR}, #{eqJx,jdbcType=VARCHAR}, \n" +
			"      #{eqQyrq,jdbcType=VARCHAR}, #{eqCfdd,jdbcType=VARCHAR}, #{eqBfjd,jdbcType=VARCHAR}\n" +
			"      )")
	@Options(useGeneratedKeys = true, keyProperty = "eqId", keyColumn = "eq_id")
	Integer insertEqInfo(EqInfo eqInfo);
	
	@Select("select * from eq_info where ht_ids=#{htIds}")
	List<EqInfo> selectEqinfo(Integer htIds);
	
	@Select("select ht_ids htIds from eq_info where eq_id=#{eqId}")
	Integer selectHtId(Integer eqId);
	@Select("select ht_ids htIds from eq_info where eq_mc=#{eqMc}")
	EqInfo selectByName(String eqMc);
	@Select("select IFNULL(ht_hthao,'无') htHthao,IFNULL(ht_gzspd,'无') htGzspd,eq_id eqId,eq_mc eqMc,ht_ids htIds,eq_pm_id eqPmId,eq_gg eqGg,eq_xh eqXh,eq_jldw_id eqJlDwId,eq_price eqPrice,eq_zczbh eqZczbh,eq_scbh eqScbh,eq_num eqNum,eq_totalprice eqTotalprice,eq_ccdate eqCcdate,eq_cscs eqCscs,eq_gb eqGb,eq_bgbh eqBgbh,eq_sh_fws eqShFws,eq_sh_qddh eqShQddh,eq_sh_shjl eqShShjl,eq_sh_jldh eqShJldh,eq_sh_fwr eqShFwr,eq_sh_lxr eqShLxr,eq_sh_lxrdh eqShLxrdh,eq_state eqState,eq_yzm eqYzm,eq_sh_jlsb eqShJlsb,eq_sh_fssb eqShFssb,eq_syks eqSyks from eq_info e left join ht_info h on e.ht_ids=h.ht_id where ht_ids=#{htIds}")
	List<SelHtEqVo> selectEqHtVo(Integer htIds);
	@Update("update eq_info\n" +
			"    set eq_mc = #{eqMc,jdbcType=VARCHAR},\n" +
			"      eq_dah = #{eqDah,jdbcType=VARCHAR},\n" +
			"      eq_pm_id = #{eqPmId,jdbcType=VARCHAR},\n" +
			"      eq_gg = #{eqGg,jdbcType=VARCHAR},\n" +
			"      eq_xh = #{eqXh,jdbcType=VARCHAR},\n" +
			"      eq_jldw_id = #{eqJldwId,jdbcType=VARCHAR},\n" +
			"      eq_price = #{eqPrice,jdbcType=DECIMAL},\n" +
			"      eq_zczbh = #{eqZczbh,jdbcType=VARCHAR},\n" +
			"      eq_scbh = #{eqScbh,jdbcType=VARCHAR},\n" +
			"      eq_num = #{eqNum,jdbcType=VARCHAR},\n" +
			"      eq_totalprice = #{eqTotalprice,jdbcType=VARCHAR},\n" +
			"      eq_ccdate = #{eqCcdate,jdbcType=VARCHAR},\n" +
			"      eq_cscs = #{eqCscs,jdbcType=VARCHAR},\n" +
			"      eq_gb = #{eqGb,jdbcType=VARCHAR},\n" +
			"      eq_bgbh = #{eqBgbh,jdbcType=VARCHAR},\n" +
			"      eq_sh_fws = #{eqShFws,jdbcType=VARCHAR},\n" +
			"      eq_sh_qddh = #{eqShQddh,jdbcType=VARCHAR},\n" +
			"      eq_sh_shjl = #{eqShShjl,jdbcType=VARCHAR},\n" +
			"      eq_sh_jldh = #{eqShJldh,jdbcType=VARCHAR},\n" +
			"      eq_sh_fwr = #{eqShFwr,jdbcType=VARCHAR},\n" +
			"      eq_sh_lxr = #{eqShLxr,jdbcType=VARCHAR},\n" +
			"      eq_sh_lxrdh = #{eqShLxrdh,jdbcType=VARCHAR},\n" +
			"      eq_state = #{eqState,jdbcType=INTEGER},\n" +
			"      eq_yzm = #{eqYzm,jdbcType=VARCHAR},\n" +
			"      eq_sh_jlsb = #{eqShJlsb,jdbcType=VARCHAR},\n" +
			"      eq_sh_fssb = #{eqShFssb,jdbcType=VARCHAR},\n" +
			"      ht_ids = #{htIds,jdbcType=INTEGER},\n" +
			"      eq_syks = #{eqSyks,jdbcType=VARCHAR},\n" +
			"      eq_jx = #{eqJx,jdbcType=VARCHAR},\n" +
			"      eq_qyrq = #{eqQyrq,jdbcType=VARCHAR},\n" +
			"      eq_cfdd = #{eqCfdd,jdbcType=VARCHAR},\n" +
			"      eq_bfjd = #{eqBfjd,jdbcType=VARCHAR}\n" +
			"    where eq_id = #{eqId,jdbcType=INTEGER}")
	Integer updateInfo(EqInfo eqinfo);

	@Update("update eq_info set eq_state = #{eqState,jdbcType=INTEGER} where ht_ids=#{htIds}")
	Integer update(Integer htIds, Integer eqState);

	@Select("select * from eq_info where eq_state=1")
	List<EqInfo> selectByState();
	@Select("select * from eq_info where eq_id=#{eqId}")
	EqInfo selectByEqId(Integer eqId);
	@Delete("delect from eq_info where eq_id=eqId")
	Integer delete(Integer eqId);


}
