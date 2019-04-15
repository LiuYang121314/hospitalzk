package com.litbo.hospitalzj.supplier.service;
/**
 * 设备经费业务层接口
 * @author 刘洋
 *
 */

import java.util.List;

import com.litbo.hospitalzj.supplier.entity.EqJfly;
import org.apache.ibatis.annotations.Param;

public interface EqJfService {

	EqJfly getById(Integer eqjfId);

	List<EqJfly> getAll();

	void delete(@Param("eqjfId")Integer eqjfId, @Param("isDelete")Integer isDelete);

	void insert(EqJfly eqJfly);
	EqJfly update(EqJfly eqJfly);
	List<EqJfly> findEqJflyLike(@Param("eqjfName")String eqjfName);
}
