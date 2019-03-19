package com.litbo.hospitalzj.zk.service.impl;

import com.litbo.hospitalzj.sf.entity.User;
import com.litbo.hospitalzj.supplier.service.exception.InsertException;
import com.litbo.hospitalzj.supplier.service.exception.ServiceException;
import com.litbo.hospitalzj.zk.Enum.EnumProcess2;

import com.litbo.hospitalzj.zk.mapper.YqEqMapper;
import com.litbo.hospitalzj.zk.mapper.YqMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.litbo.hospitalzj.zk.domian.UserEq;
import com.litbo.hospitalzj.zk.mapper.UserEqMapper;
import com.litbo.hospitalzj.zk.service.UserEqService;
import com.litbo.hospitalzj.zk.vo.UserEqVo;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

@Service
public class UserEqServiceImpl implements UserEqService{

	@Autowired
	UserEqMapper userEqMapper;
	@Autowired
	YqEqMapper yqEqMapper;

	@Override
	public void insertBatchByShEqid(String userId, String[] shEqid) {
		UserEq userEq=new UserEq();
		userEq.setUserId(userId);
		for(int i=0;i<shEqid.length;i++){
			User data=userEqMapper.findUserRole(userId);
			if("管理员&检测员"!=data.getRoleName()){
				throw new InsertException("请给管理员&检测员添加审核设备");
			}
			userEq.setShEqid(shEqid[i]);
			userEqMapper.insertBatchByShEqid(userEq);
		}
	}

	@Override
	public void insertBatchByJcEqid(String userId, String jcEqid ,String shrId,String ndjhId) {
		UserEq userEq=new UserEq();
		userEq.setUserId(userId);
		userEq.setJcEqid(jcEqid);
		userEq.setShrId(shrId);
		userEq.setNdjhId(ndjhId);
		userEq.setDate(new Date());
		userEq.setState("待上传");
		userEqMapper.deleteBatchByJcEqid(userId,jcEqid);
		userEqMapper.insertBatchByJcEqid(userEq);
	}

	@Override
	public void deleteBatchByShEqid(String userId, String[] shEqId) {
		for(int i=0;i<shEqId.length;i++){
			userEqMapper.deleteBatchByShEqid(userId,shEqId[i]);
		}
	}

	@Override
	public void deleteBatchByJcEqid(String userId, String jcEqId) {
			userEqMapper.deleteBatchByJcEqid(userId,jcEqId);
	}

	@Override
	public void setJcEqState2(String userId, String eqId) {
		userEqMapper.setJcEqState2(userId,eqId);
	}

	@Override
	public void setEqState2(String userId, String eqId) {
		//检测人员不仅要把自己的检测设备设置状态还要设置将要
		//审核该设备的人员的设备状态
		userEqMapper.setJcEqState2(userId,eqId);
		userEqMapper.setShEqState2(eqId);
	}

	@Override
	public void setEqState34(String State,String userId, String eqId) {
		// TODO Auto-generated method stub
		if(State.equals("1")){
			userEqMapper.setEqState4(userId,eqId);
		}else{
			userEqMapper.setEqState3(userId,eqId);
		}
	}
	@Override
	public void setEqState5(String userId, String eqId) {
		userEqMapper.setEqState5(userId, eqId);
	}

	@Override
	public void setEqState6(String userId, String eqId) {
		userEqMapper.setEqState6(userId, eqId);
	}

	@Override
	public void updateState(Integer ndjhId, String userEqState, String state) {
		userEqMapper.updateState(ndjhId,userEqState,state);
		
	}

	@Override
	public List<UserEqVo> findUserEqVo(String userId,String state) {
		return userEqMapper.findUserEqVo(userId,state);
	}

	@Override
	public List<UserEqVo> findUserEq(String userId, String state, String shState) {
		return userEqMapper.findUserEq(userId,state,shState);
	}
	@Override
	public void setEqStateNotIs(String jceqId,String userId) {
		if(yqEqMapper.selectStateNot(jceqId,0)>0){
			throw new ServiceException("此设备，您还有数据没有验收！！！");
		}
		if(yqEqMapper.selectStateNot(jceqId,2)>0){
			userEqMapper.setEqStateNotIs(jceqId,userId,EnumProcess2.DETECTION_OF_AUDIT_NOT.getMessage());
		}else{
			userEqMapper.setEqStateNotIs(jceqId,userId,EnumProcess2.DETECTION_OF_AUDIT_IS.getMessage());
		}
	}

	@Override
	public void setEqTypeNotIs(String jceqId, String userId) {
	/*if(yqEqMapper.selectTypeNot(jceqId,EnumProcess2.TO_UPLOAD.getMessage())>0){
		    userEqMapper.setEqStateNotIs(jceqId,userId,EnumProcess2.TO_UPLOAD.getMessage());
			throw new ServiceException("此设备，您还有数据没有上传！！！");
		}else{*/
		userEqMapper.setEqStateNotIs(jceqId,userId,EnumProcess2.UNDER_REVIEW.getMessage());
	/*	}*/
	}
	//查询审核不成功个数
	@Override
	public Integer findByUserIdState(String userId, String state) {
		return userEqMapper.findByUserIdState(userId,state);
	}
}