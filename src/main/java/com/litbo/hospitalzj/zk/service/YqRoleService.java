package com.litbo.hospitalzj.zk.service;


public interface YqRoleService {

//	void insert(YqRole yqRole);
//
//	void delete(YqRole yqRole);

	void insertBatch(String userId, int status, String[] yqId);

	void deleteBatch(String userId, String[] yqId);
	
}
