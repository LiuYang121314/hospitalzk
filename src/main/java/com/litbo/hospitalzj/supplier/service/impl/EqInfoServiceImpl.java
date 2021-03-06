package com.litbo.hospitalzj.supplier.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.litbo.hospitalzj.quality.entity.EqPm;
import com.litbo.hospitalzj.quality.mapper.EqPmMapper;
import com.litbo.hospitalzj.quality.mapper.EqXeqMapper;
import com.litbo.hospitalzj.supplier.service.exception.InsertException;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.litbo.hospitalzj.supplier.controller.ex.EqInfoIsNullException;
import com.litbo.hospitalzj.supplier.entity.EqInfo;
import com.litbo.hospitalzj.supplier.mapper.EqInfoMapper;
import com.litbo.hospitalzj.supplier.service.EqInfoService;
import com.litbo.hospitalzj.supplier.vo.SelHtEqVo;
import org.springframework.web.multipart.MultipartFile;

@Service
public class EqInfoServiceImpl implements EqInfoService {
	@Autowired
	public EqInfoMapper eqInfoMapper;
	@Autowired
	public EqXeqMapper eqXeqMapper;
	@Autowired
	public EqPmMapper eqPmMapper;

	@Override
	public Integer InsertEqInfo(EqInfo eqInfo) {
		EqInfo data=eqInfoMapper.selectByName(eqInfo.getEqMc());
		if(data!=null){
			throw new InsertException("设备信息已存在");
		}
		eqInfoMapper.insertEqInfo(eqInfo);
		return eqInfo.getEqId();
	}
	@Override
	public void updateInfo(EqInfo eqInfo) {
		eqInfoMapper.updateInfo(eqInfo);
	}
	@Override
	public List<EqInfo> selectEqInfo(Integer htIds) {
		List<EqInfo> data=eqInfoMapper.selectEqinfo(htIds);
		if(data==null) {
			throw new EqInfoIsNullException("设备信息为空，需要请添加");
		}
		return data;
	}
	@Override
	public List<SelHtEqVo> selectEqHtVo(Integer htIds) {
		List<SelHtEqVo> data=eqInfoMapper.selectEqHtVo(htIds);
		if(data==null) {
			throw new EqInfoIsNullException("设备信息为空，需要请添加");
		}
		return data;
	}

	@Override
	public List<EqInfo> selectByState() {
		return eqInfoMapper.selectByState();
	}

	@Override
	public void delete(Integer eqId) {
		 eqInfoMapper.delete(eqId);
	}

	@Override
	public EqInfo selectByEqId(Integer eqId) {
		return eqInfoMapper.selectByEqId(eqId);
	}

	@Override
	public List<EqInfo> newEqinfo() {
		List<EqInfo> data=eqInfoMapper.newEqInfo();
		List<EqInfo> newE=new ArrayList();
		for(EqInfo eqInfo:data){
			int isNull=eqXeqMapper.findByEqName(eqInfo.getEqPmId());
			if(isNull==1){
				newE.add(eqInfo);
			}
		}
		return newE;
	}

	@Override
	public List<EqInfo> eqInfoYfp(Integer eqState) {
		return eqInfoMapper.eqInfoYfp(eqState);
	}

	@Override
	public List<EqInfo> eqInfoWfp(Integer eqState) {
		List<EqInfo> data=eqInfoMapper.eqInfoWfp(eqState);
		List<EqInfo> newE=new ArrayList();
		for(EqInfo eqInfo:data){
			EqPm eqPm=eqPmMapper.findById(Integer.valueOf(eqInfo.getEqPmId()));
			int isNull=eqXeqMapper.findByEqName(eqPm.getEqPmName());
			if(isNull==1){
				newE.add(eqInfo);
			}
		}
		return newE;
	}

	@Override
	public Integer countWfp(Integer eqState) {
		return eqInfoMapper.countWfp(eqState);
	}

	@Override
	public List<EqInfo> findByUserIdEqInfo(Integer eqState, String userId) {
		return eqInfoMapper.findByUserIdEqInfo(eqState,userId);
	}

	@Override
	public Integer findByUserIdEqInfoCount(Integer eqState, String userId) {
		return eqInfoMapper.findByUserIdEqInfoCount(eqState, userId);
	}

	@Override
	public void updateEqQk(Integer eqId, String eqQk) {
		eqInfoMapper.updateEqQk(eqId,eqQk);
	}

	@Override
	public List<EqInfo> findByEqQk(String eqQk) {
		return eqInfoMapper.findByEqQk(eqQk);
	}

	@Override
	public Integer lastId() {
		return eqInfoMapper.lastId();
	}


	@Override
	public Integer findHtId(Integer eqId) {
		Integer data=eqInfoMapper.selectHtId(eqId);
		if(data==null) {
			throw new EqInfoIsNullException("设备信息为空，需要请添加");
		}
		return data;
	}
	@Override
	public List<EqInfo> findWXEqInfo() {
		return eqInfoMapper.findWXEqInfo();
	}

}
