package com.litbo.hospitalzj.supplier.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;


import com.litbo.hospitalzj.supplier.entity.HtInfo;
import com.litbo.hospitalzj.supplier.vo.EqHtVo;
import org.apache.ibatis.annotations.Select;

public interface HtInfoService {
	//插入合同
	Integer InsertHtInfo(HtInfo htinfo);
	
	void updateYzm(@Param("htId") Integer htId, @Param("htYzm") String htYzm, @Param("htState") String htState);

	void updateInfo(HtInfo htinfo);
	
	HtInfo select(Integer htId);
	
	List<HtInfo> selectHtinfo(Integer sbcsId);

	List<HtInfo> selectAllHtInfo();
	
	List<EqHtVo> selectEqHtVo(String htYzm);
	
	HtInfo selectHtInfo(String htYzm);

	//上传合同文件
	/*int updateURL(Integer htId, String path);*/

	int updateOne(@Param("htId") Integer htId, @Param("htFile1") String htFile1);
	int updateTwo(@Param("htId") Integer htId, @Param("htFile2") String htFile2);
	int updateThree(@Param("htId") Integer htId, @Param("htFile3") String htFile3);
	int updateFour(@Param("htId") Integer htId, @Param("htFile4") String htFile4);
    int updateFive(@Param("htId") Integer htId, @Param("htFile5") String htFile5);

	String[] showFile1(Integer htId);
	String[] showFile2(Integer htId);
	String[] showFile3(Integer htId);
	String[] showFile4(Integer htId);
	String[] showFile5(Integer htId);
	int agreeHtInfoById(Integer htId, String yy, String date);

	int refuseHtInfoById(Integer htId, String yy, String date);

	List<HtInfo> selectAllHtWaitRegister();

	int updateHtInfoState(Integer htId, String htState);

    List<HtInfo> selectAllHtWaitAccept();

	List<HtInfo> selectAllHtAccept();

	List<HtInfo> selectAllHtByhtState(String htState);
}
