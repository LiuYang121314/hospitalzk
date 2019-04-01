package com.litbo.hospitalzj.supplier.service;

import java.util.List;

import com.litbo.hospitalzj.supplier.entity.EqInfo;
import com.litbo.hospitalzj.supplier.vo.SelHtEqVo;
import org.apache.ibatis.annotations.Param;

public interface EqInfoService {
	Integer InsertEqInfo(EqInfo eqInfo);
	
	Integer findHtId(Integer eqId);
	
	void updateInfo(EqInfo eqInfo);
	
	List<EqInfo> selectEqInfo(Integer htIds);
	
	List<SelHtEqVo> selectEqHtVo(Integer htIds);

	List<EqInfo> selectByState();

	void delete(Integer eqId);

	EqInfo selectByEqId(Integer eqId);

	List<EqInfo> newEqinfo();

	void updateEqQk(@Param("eqId") Integer eqId, @Param("eqQk")String eqQk);

	List<EqInfo> findByEqQk(String eqQk);

}
