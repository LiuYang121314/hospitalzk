package com.litbo.hospitalzj.supplier.service;

import com.litbo.hospitalzj.supplier.entity.EqFj;
import com.litbo.hospitalzj.supplier.entity.EqFseq;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EqFseqService {
	void insertEqFseq(EqFseq eqFseq);

	List<EqFseq> selectEqFseq(Integer eqIds);

	void updateInfo(EqFseq eqFseq);

	void delete(Integer eqFsid);

	EqFseq selectById(Integer eqFsid);

}
