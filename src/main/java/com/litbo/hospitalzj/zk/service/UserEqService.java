package com.litbo.hospitalzj.zk.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.litbo.hospitalzj.zk.vo.UserEqVo;

public interface UserEqService {


	void insertBatchByShEqid(String userId, String[] shEqid);
	
	void insertBatchByJcEqid(String userId, String jcEqId,String shrId,String ndjhId);

	void deleteBatchByShEqid(String userId, String[] shEqId);
	
	void deleteBatchByJcEqid(String userId, String jcEqId);
	
	void setJcEqState2(@Param("userId") String userId, @Param("eqId") String eqId);
	
	void setEqState2(String userId, String jcEqid);

	void setEqState34(String State,String userId, String eqId);

	void setEqState5(String userId, String eqId);

	void setEqState6(String userId, String eqId);

	void setEqStateNotIs(@Param("jceqId")String jceqId,@Param("userId")String userId,@Param("shrId")String shrId);

	void setEqTypeNotIs(@Param("jceqId")String jceqId,@Param("userId")String userId);

	void updateState(@Param("ndjhId")Integer ndjhId,@Param("userEqState") String userEqState,@Param("state") String state);
	
	List<UserEqVo> findUserEq(@Param("userId")String userId,@Param("state")String state,@Param("shState")String shState);

	List<UserEqVo> findUserEqVo(@Param("userId")String userId,@Param("state")String state);

	//查询审核不成功个数
	Integer findByUserIdState(@Param("userId")String userId, @Param("state")String state);
}
