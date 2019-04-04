package com.litbo.hospitalzj.supplier.mapper;

import com.litbo.hospitalzj.supplier.entity.SuInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 供货商信息
 */
@Mapper
public interface SuInfoMapper {
    @Insert(" insert into su_info (su_id, su_mc,su_sf, su_cs, \n" +
            "      su_xq, su_fr, su_djr, \n" +
            "      su_fzr, su_khyh, su_khyhzh, \n" +
            "      su_gsdz, su_lxrxm, su_lxrdh, \n" +
            "      su_lxrbm, su_dh, su_yb, \n" +
            "      su_email, su_cz, su_wz, \n" +
            "      bz,is_delete,state)\n" +
            "    values (#{suId,jdbcType=INTEGER},#{suMc},#{suSf,jdbcType=VARCHAR}, #{suCs,jdbcType=VARCHAR}, \n" +
            "      #{suXq,jdbcType=VARCHAR}, #{suFr,jdbcType=VARCHAR}, #{suDjr,jdbcType=VARCHAR}, \n" +
            "      #{suFzr,jdbcType=VARCHAR}, #{suKhyh,jdbcType=VARCHAR}, #{suKhyhzh,jdbcType=VARCHAR}, \n" +
            "      #{suGsdz,jdbcType=VARCHAR}, #{suLxrxm,jdbcType=VARCHAR}, #{suLxrdh,jdbcType=VARCHAR}, \n" +
            "      #{suLxrbm,jdbcType=VARCHAR}, #{suDh,jdbcType=VARCHAR}, #{suYb,jdbcType=VARCHAR}, \n" +
            "      #{suEmail,jdbcType=VARCHAR}, #{suCz,jdbcType=VARCHAR}, #{suWz,jdbcType=VARCHAR}, \n" +
            "      #{bz,jdbcType=VARCHAR},#{isDelete},#{state})")
    @Options(useGeneratedKeys = true, keyProperty = "suId", keyColumn = "su_id")
    int insert(SuInfo suInfo);
    @Update("update su_info set is_delete=#{isDelete} where su_id=#{suId} ")
    int delete(@Param("suId") Integer suId,@Param("isDelete") Integer isDelete);
    @Update("update su_info set state=#{state} where su_id=#{suId} ")
    int updateState(@Param("suId") Integer suId,@Param("state") Integer state);
    @Update(" update su_info\n" +
            "    set su_sf = #{suSf,jdbcType=VARCHAR},\n" +
            "      su_cs = #{suCs,jdbcType=VARCHAR},\n" +
            "      su_xq = #{suXq,jdbcType=VARCHAR},\n" +
            "      su_fr = #{suFr,jdbcType=VARCHAR},\n" +
            "      su_djr = #{suDjr,jdbcType=VARCHAR},\n" +
            "      su_fzr = #{suFzr,jdbcType=VARCHAR},\n" +
            "      su_khyh = #{suKhyh,jdbcType=VARCHAR},\n" +
            "      su_khyhzh = #{suKhyhzh,jdbcType=VARCHAR},\n" +
            "      su_gsdz = #{suGsdz,jdbcType=VARCHAR},\n" +
            "      su_lxrxm = #{suLxrxm,jdbcType=VARCHAR},\n" +
            "      su_lxrdh = #{suLxrdh,jdbcType=VARCHAR},\n" +
            "      su_lxrbm = #{suLxrbm,jdbcType=VARCHAR},\n" +
            "      su_dh = #{suDh,jdbcType=VARCHAR},\n" +
            "      su_yb = #{suYb,jdbcType=VARCHAR},\n" +
            "      su_email = #{suEmail,jdbcType=VARCHAR},\n" +
            "      su_cz = #{suCz,jdbcType=VARCHAR},\n" +
            "      su_wz = #{suWz,jdbcType=VARCHAR},\n" +
            "      bz = #{bz,jdbcType=VARCHAR}\n" +
            "    where su_id = #{suId,jdbcType=INTEGER}")
    int update(SuInfo suInfo);
    @Select("select * from su_info where is_delete=0")
    List<SuInfo> selectAll();
    @Select("select * from su_info where su_id=#{suId} and is_delete=0")
    SuInfo findSuById(Integer suId);
    @Select("select * from su_info where su_mc=#{suMc} and is_delete=0")
    SuInfo findSuByMc(String suMc);
    //模糊查询
	@Select("SELECT * FROM su_info WHERE su_mc LIKE '%${suMc}%' and is_delete=0")
	List<SuInfo> findBySuMcLike(@Param("suMc") String suMc);

}
