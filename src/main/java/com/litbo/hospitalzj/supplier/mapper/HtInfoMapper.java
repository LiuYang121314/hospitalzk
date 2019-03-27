 package com.litbo.hospitalzj.supplier.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.litbo.hospitalzj.supplier.entity.HtInfo;
import com.litbo.hospitalzj.supplier.vo.EqHtVo;

@Mapper
public interface HtInfoMapper {
	//插入合同
	@Insert("insert into ht_info(ht_id,ht_ghsn,ht_ghslxr,ht_ghsdh,ht_hthao,ht_gzspd,ht_zhbhao,ht_bz,ht_qytime,ht_dhtime,ht_bxtime,"
			+ "ht_syks,ht_azdd,ht_ly,ht_cgfs,ht_sglb,ht_sbyt,ht_jfly"
			+ ",ht_state,ht_yzm,sbcs_id,ht_yssj,ht_ysbz) value "
			+ "(#{htId},#{htGhsn},#{htGhslxr},#{htGhsdh},#{htHthao},#{htGzspd},#{htZhbhao},#{htBz},#{htQytime},#{htDhtime},#{htBxtime},"
			+ "#{htSyks},#{htAzdd},#{htLy},#{htCgfs},#{htSglb},#{htSbyt},#{htJfly},#{htState},#{htYzm},#{sbcsId},#{htYssj},#{htYsbz})")
	@Options(useGeneratedKeys = true, keyProperty = "htId", keyColumn = "ht_id")
	Integer insertHt(HtInfo htInfo);
	//上传合同文件
	/*@Update("update ht_info set ht_file1 = CONCAT(ht_file1,#{path}) where ht_id=#{htId}")
	int updateURL(@Param("htId") Integer htId, @Param("path") String path);*/
	//上传文件
	@Update("update ht_info set ht_file1 = CONCAT(ht_file1,#{htFile1}) where ht_id=#{htId}")
	Integer updateOne(@Param("htId") Integer htId, @Param("htFile1") String htFile1);
	@Update("update ht_info set ht_file2 = CONCAT(ht_file2,#{htFile2}) where ht_id=#{htId}")
	Integer updateTwo(@Param("htId") Integer htId, @Param("htFile2") String htFile2);
	@Update("update ht_info set ht_file3 = CONCAT(ht_file3,#{htFile3}) where ht_id=#{htId}")
	Integer updateThree(@Param("htId") Integer htId, @Param("htFile3") String htFile3);
	@Update("update ht_info set ht_file4 = CONCAT(ht_file4,#{htFile4}) where ht_id=#{htId}")
	Integer updateFour(@Param("htId") Integer htId, @Param("htFile4") String htFile4);
	@Update("update ht_info set ht_file5 = CONCAT(ht_file5,#{htFile5}) where ht_id=#{htId}")
	Integer updateFive(@Param("htId") Integer htId, @Param("htFile5") String htFile5);
	//显示图片
	@Select("select ht_file1 from ht_info where ht_id = #{htId}")
	String showFile1(Integer htId);
	@Select("select ht_file2 from ht_info where ht_id = #{htId}")
	String showFile2(Integer htId);
	@Select("select ht_file3 from ht_info where ht_id = #{htId}")
	String showFile3(Integer htId);
	@Select("select ht_file4 from ht_info where ht_id = #{htId}")
	String showFile4(Integer htId);
	@Select("select ht_file5 from ht_info where ht_id = #{htId}")
	String showFile5(Integer htId);

	//修改合同状态
	@Update("UPDATE ht_info SET ht_yzm=#{htYzm},ht_state=#{htState} where ht_id=#{htId}")
	Integer updateYzm(@Param("htId") Integer htId, @Param("htYzm") String htYzm, @Param("htState") String htState);
	//修改合通信息
	@Update("UPDATE ht_info SET ht_ghslxr=#{htGhslxr},ht_hthao=#{htHthao},ht_ghsdh=#{htGhsdh},ht_zhbhao=#{htZhbhao},"
			+ "ht_bz=#{htBz},ht_qytime=#{htQytime},ht_dhtime=#{htDhtime},"
			+ "ht_bxtime=#{htBxtime},ht_syks=#{htSyks},ht_azdd=#{htAzdd},ht_ly=#{htLy},ht_cgfs=#{htCgfs},"
			+ "ht_sglb=#{htSglb},ht_sbyt=#{htSbyt},ht_jfly=#{htJfly},"
			+ "ht_file1=#{htFile1},ht_file2=#{htFile2},ht_file3=#{htFile3},ht_file4=#{htFile4},ht_file5=#{htFile5},ht_State=#{htState} "
			+ "where ht_id=#{htId}")
	void updateInfo(HtInfo htinfo);
	//通过供应商iD查询合同
	@Select("select ht_id htId,ht_ghsn htGhsn,ht_ghslxr htGhslxr,ht_ghsdh htGhsdh,ht_ghsdh htGhsdh,IFNULL(ht_hthao,'无') htHthao,IFNULL(ht_gzspd,'无') htGzspd,"
			+ "ht_zhbhao htZhbhao,ht_bz htBz,ht_qytime htQytime,ht_dhtime htDhtime,ht_bxtime htBxtime,"
			+ "ht_syks htSyks,ht_azdd htAzdd,ht_ly htLy,ht_cgfs htCgfs,ht_sglb htSglb,ht_sbyt htSbyt,"
			+ "ht_jfly htJfly,ht_file1 htFile1,ht_file2 htFile2,ht_file3 htFile3,ht_file4 htFile4,"
			+ "ht_file5 htFile5,ht_state htState,ht_yzm htYzm,sbcs_id sbcdId,ht_yssj htYssj,"
			+ "ht_ysbz htYsbz from ht_info where sbcs_id=#{sbcsId}")
	List<HtInfo> findBySbcsId(Integer sbcsId);
	//通过合同id查询合同信息
	@Select("select ht_id htId,ht_ghsn htGhsn,ht_ghslxr htGhslxr,ht_ghsdh htGhsdh,ht_ghsdh htGhsdh,IFNULL(ht_hthao,'无') htHthao,IFNULL(ht_gzspd,'无') htGzspd,"
			+ "ht_zhbhao htZhbhao,ht_bz htBz,ht_qytime htQytime,ht_dhtime htDhtime,ht_bxtime htBxtime,"
			+ "ht_syks htSyks,ht_azdd htAzdd,ht_ly htLy,ht_cgfs htCgfs,ht_sglb htSglb,ht_sbyt htSbyt,"
			+ "ht_jfly htJfly,ht_state htState,ht_yzm htYzm,sbcs_id sbcdId,ht_yssj htYssj,"
			+ "ht_ysbz htYsbz from ht_info where ht_id=#{htId}")
	HtInfo findByHtId(Integer htId);
	//通过验证码查询合同
	@Select("select ht_id htId,ht_ghsn htGhsn,ht_ghslxr htGhslxr,ht_ghsdh htGhsdh,IFNULL(ht_hthao,'无')  htHthao,IFNULL(ht_gzspd,'无') htGzspd,ht_zhbhao htZhbhao,"
			+ "ht_bz htBz,ht_qytime htQytime,ht_dhtime htDhtime,ht_bxtime htBxtime,ht_syks htSyks,ht_azdd htAzdd,ht_ly htLy,ht_cgfs htCgfs,ht_sglb htSglb,ht_sbyt htSbyt,"
			+ "ht_jfly htJfly,ht_file1 htFile1,ht_file2 htFile2,ht_file3 htFile3,ht_file4 htFile4,ht_file5 htFile5,ht_state htState,ht_yzm htYzm,sbcs_id sbcdId,ht_yssj htYssj,ht_ysbz htYsbz from ht_info where ht_yzm=#{htYzm}")
	HtInfo findByHtYzm(@Param("htYzm") String htYzm);
	//通过验证码查询存在的合同以及设备信息
	@Select("select ht_ids htIds,ht_hthao htHthao,eq_pm eqPm,eq_gg eqGg,eq_xh eqXh,ht_qytime htQytime,ht_state htState,ht_yzm htYzm from ht_info inner join eq_info on ht_info.ht_id=eq_info.ht_ids where ht_yzm=#{htYzm}")
	List<EqHtVo> EqHtVo(String htYzm);
	//通过状态查询合同信息
	@Select("select ht_id ,ht_ghsn ,ht_ghslxr ,ht_ghsdh ,ht_ghsdh ,IFNULL(ht_hthao,'无') ht_hthao,IFNULL(ht_gzspd,'无') ht_gzspd,"
			+ "ht_zhbhao ,ht_bz ,ht_qytime ,ht_dhtime ,ht_bxtime ,"
			+ "ht_syks ,ht_azdd ,ht_ly ,ht_cgfs ,ht_sglb ,ht_sbyt ,"
			+ "ht_jfly   ,ht_file1 ,ht_file2 ,ht_file3 ,ht_file4 ,"
			+ "ht_file5 ,ht_state ,ht_yzm ,sbcs_id ,ht_yssj ,"
			+ "ht_ysbz  from ht_info where ht_state=#{state}")
    List<HtInfo> findAll(String state);

	@Update("UPDATE ht_info SET ht_State=#{htState},ht_bz =#{yy},ht_yssj=#{date} where ht_id=#{htId}")
	int updateState(@Param("htId") Integer htId, @Param("yy") String yy, @Param("date") String date, @Param("htState") String htState);
	//通过合同id修改合同状态
	@Update("UPDATE ht_info SET ht_State=#{htState} where ht_id=#{htId}")
	int updateStateById(@Param("htId") Integer htId, @Param("htState") String htState);
}
