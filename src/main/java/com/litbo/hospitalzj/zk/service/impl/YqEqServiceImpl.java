package com.litbo.hospitalzj.zk.service.impl;

import com.litbo.hospitalzj.zk.vo.YqEqVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.litbo.hospitalzj.zk.domian.YqEq;
import com.litbo.hospitalzj.zk.mapper.YqEqMapper;
import com.litbo.hospitalzj.zk.service.YqEqService;

import java.util.List;

@Service
public class YqEqServiceImpl implements YqEqService{

	@Autowired
	YqEqMapper yqEqMapper;

	@Override
	public void insertBatch(String eqId, String jcyqId) {
		YqEq yqEq=new YqEq();
		yqEq.setJcyqId(jcyqId);
		yqEq.setEqId(eqId);
		yqEq.setState(0);
		yqEqMapper.delete(jcyqId, eqId);
		yqEqMapper.insert(yqEq);
	}
	@Override
	public void deleteBatch(String jcyqId, String eqId) {
			yqEqMapper.delete(jcyqId,eqId);
	}

	@Override
	public YqEq selectEqId(String jcyqId) {
		return yqEqMapper.selectEqId(jcyqId);
	}

	@Override
	public void updateState(String jcyqId, String eqId,Integer state) {
		yqEqMapper.updateState(jcyqId, eqId,state);
	}

	@Override
	public void updateType(String jcyqId, String eqId, String state) {
		yqEqMapper.updateType(jcyqId, eqId, state);
	}

	@Override
	public void updateAllType(String eqId, String type) {
		yqEqMapper.updateAllType(eqId, type);
	}

	@Override
	public List<YqEqVo> selectYqEq(String userId, Integer state) {
		return yqEqMapper.selectYqEq(userId, state);
	}


}