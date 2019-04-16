package com.litbo.hospitalzj.zk.service.impl;

import java.util.List;

import com.litbo.hospitalzj.sf.entity.User;
import com.litbo.hospitalzj.zk.vo.EqAndUname;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.litbo.hospitalzj.zk.domian.EqInfo;
import com.litbo.hospitalzj.zk.domian.Yq;
import com.litbo.hospitalzj.zk.mapper.EqInfoMapper1;
import com.litbo.hospitalzj.zk.mapper.YqMapper;
import com.litbo.hospitalzj.zk.service.EqInfoService;
import com.litbo.hospitalzj.zk.vo.EqToYqs;

@Service("eqInfoS")
public class EqInfoServiceImpl implements EqInfoService {

	@Autowired
	EqInfoMapper1 eqInfoMapper;

	@Autowired
	YqMapper yqMapper;

	@Override
	public Integer updateInfo1(EqInfo eqinfo) {
		return eqInfoMapper.updateInfo1(eqinfo);
	}

	@Override
	public void updateEqPm(Integer eqPmId, Integer eqId) {
		eqInfoMapper.updateEqPm(eqPmId, eqId);
	}

	@Override
	public void insert(EqInfo dt) {
		eqInfoMapper.insert(dt);
	}

	@Override
	public List<EqInfo> findAll() {
	
		return eqInfoMapper.findAll();
	}

	@Override
	public void delete(String id) {
	
		eqInfoMapper.delete(id);
	}

	@Override
	public List<EqInfo> findByJcyqId(String jcyqId) {
	
		return eqInfoMapper.findByJcyqId(jcyqId);
	}

	@Override
	public List<EqInfo> findNotByJcyqId(String jcyqId) {
	
		return eqInfoMapper.findNotByJcyqId(jcyqId);
	}

	@Override
	public List<EqInfo> findJcEqByUserId(String userId) {
	
		return eqInfoMapper.findJcEqByUserId(userId);
	}

	@Override
	public List<EqInfo> findShEqByUserId(String userId) {
	
		return eqInfoMapper.findShEqByUserId(userId);
	}

	@Override
	public List<EqInfo> findJcEqNotByUserId(String userId) {
	
		return eqInfoMapper.findJcEqNotByUserId(userId);
	}

	@Override
	public List<EqInfo> findShEqNotByUserId(String userId) {
	
		return eqInfoMapper.findShEqNotByUserId(userId);
	}

	@Override
	public EqToYqs findEqYqs(String dah) {
		List<Yq> yqList=yqMapper.findByDah(dah);
		EqInfo eqInfo=eqInfoMapper.findByDah(dah);
		EqToYqs eqToYqs=new EqToYqs();
		eqToYqs.setEqInfo(eqInfo);
		eqToYqs.setYqList(yqList);
		return eqToYqs;
	}

	@Override
	public EqInfo findEqById(String eqId) {
		return eqInfoMapper.findEqById(eqId);
	}

	@Override
	public List<Yq> findYqsById(Integer eqId) {
		List<Yq> yqList=yqMapper.select(eqId);
		return yqList;
	}

	@Override
	public List<EqInfo> findEqsByState(String state) {
		List<EqInfo> eqList=eqInfoMapper.findEqsByState(state);
		return eqList;
	}

	@Override
	public List<EqInfo> findEqsByUserIdAndState(String userId, String state) {
		return eqInfoMapper.findEqsByUserIdAndState(userId,state);
	}
	@Override
	public List<EqInfo> findEqInfo(String userId) {
		return eqInfoMapper.findEqInfo(userId);
	}

	@Override
	public List<EqInfo> findNewEqInfo() {
		return eqInfoMapper.findNewEqInfo();
	}

	@Override
	public List<EqInfo> findNewJcEqByUserId(String userId) {
		return eqInfoMapper.findNewJcEqByUserId(userId);
	}

	@Override
	public List<EqAndUname> findJcEqsByUserIdAndState(String userId, String state) {
		return eqInfoMapper.findJcEqsByUserIdAndState(userId,state);
	}

	@Override
	public List<EqInfo> findShEqsByUserIdAndState(String userId, String state) {
		return eqInfoMapper.findShEqsByUserIdAndState(userId,state);
	}

	@Override
	public List<User> findUserIdByEqId(String userId) {
		return eqInfoMapper.findUserIdByEqId(userId);
	}

	@Override
	public EqInfo findByDah(String dah) {
		return eqInfoMapper.findByDah(dah);
	}


}
