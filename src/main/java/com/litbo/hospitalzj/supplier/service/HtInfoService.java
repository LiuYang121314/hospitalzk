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

	int agreeHtInfoById(Integer htId, String yy, String date,String htYsyDh);

	int refuseHtInfoById(Integer htId, String yy, String date,String htYsyDh);

	List<HtInfo> selectAllHtWaitRegister();

	int updateHtInfoState(Integer htId, String htState);

    List<HtInfo> selectAllHtWaitAccept();

	List<HtInfo> selectAllHtAccept();

	List<HtInfo> selectAllHtByhtState(String htState);

	void HtJC(Integer htId);

	int count(@Param("htState") String htState);
}
