package com.litbo.hospitalzj.zk.service;

import com.litbo.hospitalzj.zk.domian.YqEq;
import com.litbo.hospitalzj.zk.vo.YqEqVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface YqEqService {

	int insertBatch(String eqId, String jcyqId);
	
	void deleteBatch(String jcyqId, String eqId);
	
	YqEq selectEqId(String jcyqId);

	void updateState(Integer yqEqId,Integer state);

	void updateType(Integer yqEqId,String state);

	void updateAllType(@Param("eqId") String eqId,@Param("type") String  type);
	List<YqEqVo> selectYqEq(@Param("userId") String userId, @Param("state") Integer state);
	Integer findId(@Param("jcyqId") Integer jcyqId,@Param("eqId") Integer eqId);


}
