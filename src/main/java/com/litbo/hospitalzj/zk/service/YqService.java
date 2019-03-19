package com.litbo.hospitalzj.zk.service;

import java.util.List;

import com.litbo.hospitalzj.zk.domian.EqInfo;
import com.litbo.hospitalzj.zk.domian.Yq;
import org.apache.ibatis.annotations.Param;
import org.quartz.SchedulerException;

public interface YqService {

	List<Yq> findByUserId(String userId);
	
	List<Yq> findNotByUserId(String userId);

	void insert(Yq yq);

	void delete(String yqId);

	List<Yq> findAll();

	void update(Yq yq);

	void deleteBatch(String[] yqId);

	List<Yq> select(Integer eqId);
	
	EqInfo selectEqInfo(String eqDah);

	List<Yq> selectEqYq(String eqDah);
	//根据设备Id查询出设备以及仪器
	EqInfo selectEqInfoByEqid(Integer eqId);

	List<Yq> selectEqYqByEqid(Integer eqId);

	List<Yq> selectYqByEqId(@Param("eqId") Integer eqId);

	List<Yq> selectTime();
}
