package com.litbo.hospitalzj.supplier.service.impl;

import com.litbo.hospitalzj.supplier.controller.ex.EqFjIsNullException;
import com.litbo.hospitalzj.supplier.entity.EqFj;
import com.litbo.hospitalzj.supplier.entity.EqFseq;
import com.litbo.hospitalzj.supplier.mapper.EqFjMapper;
import com.litbo.hospitalzj.supplier.mapper.EqFseqMapper;
import com.litbo.hospitalzj.supplier.service.EqFjService;
import com.litbo.hospitalzj.supplier.service.EqFseqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EqFseqServiceImpl implements EqFseqService {
	@Autowired
	private EqFseqMapper eqFseqMapper;


	@Override
	public void insertEqFseq(EqFseq eqFseq) {
		eqFseqMapper.insertEqFseq(eqFseq);
	}

	@Override
	public List<EqFj> selectEqFseq(Integer eqIds) {
		return eqFseqMapper.selectEqFseq(eqIds);
	}

	@Override
	public void updateInfo(EqFseq eqFseq) {
		eqFseqMapper.updateInfo(eqFseq);
	}

	@Override
	public void delete(Integer eqFsid) {
		eqFseqMapper.delete(eqFsid);
	}

	@Override
	public EqFseq selectById(Integer eqFsid) {
		return eqFseqMapper.selectById(eqFsid);
	}
}
