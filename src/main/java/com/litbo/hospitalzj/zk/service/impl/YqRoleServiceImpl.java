package com.litbo.hospitalzj.zk.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.litbo.hospitalzj.zk.mapper.YqRoleMapper;
import com.litbo.hospitalzj.zk.service.YqRoleService;

@Service
public class YqRoleServiceImpl implements YqRoleService{

	@Autowired
	YqRoleMapper yqRoleMapper;
	
//	public void insert(YqRole yqRole){
//		
//		yqRoleMapper.insert(yqRole);
//	}

//	@Override
//	public void delete(YqRole yqRole) {
//		// TODO Auto-generated method stub
//		yqRoleMapper.delete(yqRole);
//	}

	@Override
	public void insertBatch(String userId, int status,String[] yqId) {
		// TODO Auto-generated method stub
		
		for(int i=0;i<yqId.length;i++){
			
			yqRoleMapper.insert(userId,status,yqId[i]);
		}
	}

	@Override
	public void deleteBatch(String userId, String[] yqId) {
		// TODO Auto-generated method stub
		
		for(int i=0;i<yqId.length;i++){
			yqRoleMapper.delete(userId,yqId[i]);
		}
	}
	
}
