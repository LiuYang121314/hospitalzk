package com.litbo.hospitalzj.supplier.service;

import java.util.List;

import com.litbo.hospitalzj.supplier.entity.EqInfo;
import com.litbo.hospitalzj.supplier.vo.SelHtEqVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.multipart.MultipartFile;

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

	List<EqInfo> eqInfoYfp();

	List<EqInfo> eqInfoWfp();

	void updateEqQk(@Param("eqId") Integer eqId, @Param("eqQk")String eqQk);

	List<EqInfo> findByEqQk(String eqQk);

	Integer lastId();
}
