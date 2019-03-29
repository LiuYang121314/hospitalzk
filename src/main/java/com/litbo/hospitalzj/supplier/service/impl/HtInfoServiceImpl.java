package com.litbo.hospitalzj.supplier.service.impl;

import java.util.List;

import com.litbo.hospitalzj.hospital.enums.EnumProcess;
import com.litbo.hospitalzj.supplier.service.exception.InsertException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.litbo.hospitalzj.supplier.controller.ex.HtInfoIsNullException;
import com.litbo.hospitalzj.supplier.service.exception.YzmNonentityException;
import com.litbo.hospitalzj.supplier.entity.HtInfo;
import com.litbo.hospitalzj.supplier.mapper.EqHtFjVoMapper;
import com.litbo.hospitalzj.supplier.mapper.HtInfoMapper;
import com.litbo.hospitalzj.supplier.service.HtInfoService;
import com.litbo.hospitalzj.supplier.vo.EqHtVo;
import org.springframework.transaction.annotation.Transactional;

@Service
public class HtInfoServiceImpl implements HtInfoService {
	@Autowired
	public HtInfoMapper htInfoMapper;
    @Autowired
    public EqHtFjVoMapper eqhtfjMapper;
	@Override
	public Integer InsertHtInfo(HtInfo htInfo) {
		htInfoMapper.insertHt(htInfo);
		Integer a=htInfo.getHtId();
		System.out.println(a);
		return htInfo.getHtId();
	}
	@Override
	public List<EqHtVo> selectEqHtVo(String htYzm) {
		List<EqHtVo> date=htInfoMapper.EqHtVo(htYzm);
		if(date==null) {
			throw new YzmNonentityException("验证码不存在");
		}
		return date;
	}

	@Override
	public List<HtInfo> selectAllHtInfo() {
		List<HtInfo> data=htInfoMapper.findAll(EnumProcess.WAIT_ACCEPT.getMessage());
		if (data== null) {
			throw new HtInfoIsNullException("合同不存在，请根据需要添加合同");
		}
		return data;
	}

	@Override
	public void updateInfo(HtInfo htinfo) {
		htInfoMapper.updateInfo(htinfo);
	}
	@Override
	public List<HtInfo> selectHtinfo(Integer sbcsId) {
		List<HtInfo> data=htInfoMapper.findBySbcsId(sbcsId);
		if (data== null) {
			throw new HtInfoIsNullException("合同不存在，请根据需要添加合同");
		}
		return data;
	}
	@Override
	public void updateYzm(Integer htId, String htYzm, String htState) {
		htInfoMapper.updateYzm(htId,htYzm,htState);
	}
	@Override
	public HtInfo select(Integer htId) {
		HtInfo data=htInfoMapper.findByHtId(htId);
		return data;
	}
	@Override
	public HtInfo selectHtInfo(String htYzm) {
		HtInfo data=htInfoMapper.findByHtYzm(htYzm);
		if (data== null) {
			throw new HtInfoIsNullException("验证码不存在，请根据添加合同");
		}
		return data;
	}


	@Override
	public int agreeHtInfoById(Integer htId, String yy, String date) {
		System.out.println(123);
		return htInfoMapper.updateState(htId,yy,date,EnumProcess.APPOINMENT_ACCEPTANCE.getMessage());
	}

	@Override
	public int refuseHtInfoById(Integer htId, String yy, String date) {
		return htInfoMapper.updateState(htId,yy,date,EnumProcess.IMPERFECT_CONTRACT_INFORMATION.getMessage());
	}

	@Override
	public List<HtInfo> selectAllHtWaitRegister() {
		List<HtInfo> data=htInfoMapper.findAll(EnumProcess.APPOINMENT_ACCEPTANCE.getMessage());
		return data;
	}

	@Override
	public int updateHtInfoState(Integer htId, String htState) {
		return htInfoMapper.updateStateById(htId,htState);
	}

	@Override
	public List<HtInfo> selectAllHtWaitAccept() {
		List<HtInfo> data=htInfoMapper.findAll(EnumProcess.WAIT_ACCEPT_YS.getMessage());
		return data;
	}

	@Override
	public List<HtInfo> selectAllHtAccept() {
		List<HtInfo> data=htInfoMapper.findAll(EnumProcess.ACCEPT_OVER.getMessage());
		return data;
	}
	@Override
	public List<HtInfo> selectAllHtByhtState(String htState) {
		List<HtInfo> data=htInfoMapper.findAll(htState);
		return data;
	}
}
