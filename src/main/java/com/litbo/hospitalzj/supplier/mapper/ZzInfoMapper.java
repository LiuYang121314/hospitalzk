package com.litbo.hospitalzj.supplier.mapper;

import com.litbo.hospitalzj.supplier.entity.SuInfo;
import com.litbo.hospitalzj.supplier.entity.ZzInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 供货商信息
 */
@Mapper
public interface ZzInfoMapper {
    @Insert(" insert into zz_info (zz_id, su_id, zz_yyzch, \n" +
            "      zz_yyzzbh, zz_yyclrq, zz_yyfdr, \n" +
            "      zz_yyzczj, zz_qylx, zz_yysxrq, \n" +
            "      zz_yyjzrq, zz_yyyx, zz_zlglr, \n" +
            "      zz_zlglrdz, zz_yyscdz, zz_ckdz, \n" +
            "      zz_yybz, zz_jyzh, zz_jyqyfzr, \n" +
            "      zz_jyfddbr, zz_jysxrq, zz_jyjzrq, \n" +
            "      zz_jyyx, zz_jyzcdz, zz_jybz, \n" +
            "      zz_zzdm, zz_zzlx, zz_zzsxrq, \n" +
            "      zz_zzjzrq, zz_zzdz, zz_zzbz\n" +
            "      )\n" +
            "    values (#{zzId,jdbcType=INTEGER}, #{suId,jdbcType=INTEGER}, #{zzYyzch,jdbcType=VARCHAR}, \n" +
            "      #{zzYyzzbh,jdbcType=VARCHAR}, #{zzYyclrq,jdbcType=DATE}, #{zzYyfdr,jdbcType=VARCHAR}, \n" +
            "      #{zzYyzczj,jdbcType=VARCHAR}, #{zzQylx,jdbcType=VARCHAR}, #{zzYysxrq,jdbcType=DATE}, \n" +
            "      #{zzYyjzrq,jdbcType=DATE}, #{zzYyyx,jdbcType=VARCHAR}, #{zzZlglr,jdbcType=VARCHAR}, \n" +
            "      #{zzZlglrdz,jdbcType=VARCHAR}, #{zzYyscdz,jdbcType=VARCHAR}, #{zzCkdz,jdbcType=VARCHAR}, \n" +
            "      #{zzYybz,jdbcType=VARCHAR}, #{zzJyzh,jdbcType=VARCHAR}, #{zzJyqyfzr,jdbcType=VARCHAR}, \n" +
            "      #{zzJyfddbr,jdbcType=VARCHAR}, #{zzJysxrq,jdbcType=DATE}, #{zzJyjzrq,jdbcType=DATE}, \n" +
            "      #{zzJyyx,jdbcType=VARCHAR}, #{zzJyzcdz,jdbcType=VARCHAR}, #{zzJybz,jdbcType=VARCHAR}, \n" +
            "      #{zzZzdm,jdbcType=VARCHAR}, #{zzZzlx,jdbcType=VARCHAR}, #{zzZzsxrq,jdbcType=DATE}, \n" +
            "      #{zzZzjzrq,jdbcType=DATE}, #{zzZzdz,jdbcType=VARCHAR}, #{zzZzbz,jdbcType=VARCHAR}\n" +
            "      )")
    int insert(ZzInfo zzInfo);
    @Update("  update zz_info\n" +
            "    set su_id = #{suId,jdbcType=INTEGER},\n" +
            "      zz_yyzch = #{zzYyzch,jdbcType=VARCHAR},\n" +
            "      zz_yyzzbh = #{zzYyzzbh,jdbcType=VARCHAR},\n" +
            "      zz_yyclrq = #{zzYyclrq,jdbcType=DATE},\n" +
            "      zz_yyfdr = #{zzYyfdr,jdbcType=VARCHAR},\n" +
            "      zz_yyzczj = #{zzYyzczj,jdbcType=VARCHAR},\n" +
            "      zz_qylx = #{zzQylx,jdbcType=VARCHAR},\n" +
            "      zz_yysxrq = #{zzYysxrq,jdbcType=DATE},\n" +
            "      zz_yyjzrq = #{zzYyjzrq,jdbcType=DATE},\n" +
            "      zz_yyyx = #{zzYyyx,jdbcType=VARCHAR},\n" +
            "      zz_zlglr = #{zzZlglr,jdbcType=VARCHAR},\n" +
            "      zz_zlglrdz = #{zzZlglrdz,jdbcType=VARCHAR},\n" +
            "      zz_yyscdz = #{zzYyscdz,jdbcType=VARCHAR},\n" +
            "      zz_ckdz = #{zzCkdz,jdbcType=VARCHAR},\n" +
            "      zz_yybz = #{zzYybz,jdbcType=VARCHAR},\n" +
            "      zz_jyzh = #{zzJyzh,jdbcType=VARCHAR},\n" +
            "      zz_jyqyfzr = #{zzJyqyfzr,jdbcType=VARCHAR},\n" +
            "      zz_jyfddbr = #{zzJyfddbr,jdbcType=VARCHAR},\n" +
            "      zz_jysxrq = #{zzJysxrq,jdbcType=DATE},\n" +
            "      zz_jyjzrq = #{zzJyjzrq,jdbcType=DATE},\n" +
            "      zz_jyyx = #{zzJyyx,jdbcType=VARCHAR},\n" +
            "      zz_jyzcdz = #{zzJyzcdz,jdbcType=VARCHAR},\n" +
            "      zz_jybz = #{zzJybz,jdbcType=VARCHAR},\n" +
            "      zz_zzdm = #{zzZzdm,jdbcType=VARCHAR},\n" +
            "      zz_zzlx = #{zzZzlx,jdbcType=VARCHAR},\n" +
            "      zz_zzsxrq = #{zzZzsxrq,jdbcType=DATE},\n" +
            "      zz_zzjzrq = #{zzZzjzrq,jdbcType=DATE},\n" +
            "      zz_zzdz = #{zzZzdz,jdbcType=VARCHAR},\n" +
            "      zz_zzbz = #{zzZzbz,jdbcType=VARCHAR}\n" +
            "    where zz_id = #{zzId,jdbcType=INTEGER}")
    int update(ZzInfo zzInfo);
    @Select("select * from zz_info where su_id=#{suId}")
    ZzInfo findZzById(Integer suId);
}
