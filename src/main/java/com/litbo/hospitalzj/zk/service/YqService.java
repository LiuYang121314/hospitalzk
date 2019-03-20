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
	//根据档案号查询出设备以及仪器
	EqInfo selectEqInfo(String eqDah);
	/*List<Yq> selectEqYq(String eqDah);*/

	//电器的数据
	List<Yq> selectEqYqByEqId(@Param("eqId") Integer eqId,@Param("jcyqName") String jcyqName);
    //除电器意外的数据
	List<Yq> selectEqYqNotDqByEqId(@Param("eqId") Integer eqId,@Param("jcyqName") String jcyqName);
	//根据设备Id查询出设备以及仪器
	EqInfo selectEqInfoByEqid(Integer eqId);

	List<Yq> selectEqYqByEqid(Integer eqId);
	//管理员查看通过设备ID查询设备检测仪器
	//查看非电气仪器表
	/*List<Yq> selectYqByEqId(@Param("eqId") Integer eqId);*/
	List<Yq> selectYqNotDqByEqId(@Param("eqId") Integer eqId);
	//查看电气仪器表
	List<Yq> selectYqDqByEqId(@Param("eqId") Integer eqId);

	List<Yq> selectTime();
}
