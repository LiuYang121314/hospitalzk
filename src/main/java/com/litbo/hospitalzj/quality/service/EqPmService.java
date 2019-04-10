package com.litbo.hospitalzj.quality.service;
/**
 * 设备用途业务层接口
 * @author 刘洋
 *
 */

import java.util.List;

import com.litbo.hospitalzj.quality.entity.EqPm;
import org.apache.ibatis.annotations.Param;

public interface EqPmService {

	EqPm getById(Integer eqPmId);
/*	//通过pm nam去查询
	EqPm findByName(@Param("eqPmName") String eqPmName);*/
	List<EqPm> getAll();
	//删除，修改状态
	void delete(@Param("eqPmId")Integer eqPmId, @Param("isDelete")Integer isDelete);

	void insert(EqPm eqPm);

	EqPm update(EqPm eqPm);

	List<EqPm> findJcPmByUserId(String userId);

	List<EqPm> findJcPmNotByUserId(String userId);

	List<EqPm> findYqPmByYqId(String yqId);

	List<EqPm> findYqPmNotByYqId(String yqId);
	//模糊查询名称
	List<EqPm> findPmLike(String eqPmName);
}
