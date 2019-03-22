package com.litbo.hospitalzj.quality.service;
/**
 * 设备用途业务层接口
 * @author 刘洋
 *
 */

import java.util.List;

import com.litbo.hospitalzj.quality.entity.EqPm;

public interface EqPmService {

	EqPm getById(String eqPmId);

	List<EqPm> getAll();

	void delete(String eqPmId);

	void insert(EqPm eqPm);

	EqPm update(EqPm eqPm);

	List<EqPm> findJcPmByUserId(String userId);

	List<EqPm> findJcPmNotByUserId(String userId);

	List<EqPm> findYqPmByYqId(String yqId);

	List<EqPm> findYqPmNotByYqId(String yqId);
	//模糊查询名称
	List<EqPm> findPmLike(String eqPmName);
}
