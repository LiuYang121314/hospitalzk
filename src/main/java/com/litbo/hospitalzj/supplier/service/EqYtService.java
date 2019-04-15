package com.litbo.hospitalzj.supplier.service;
/**
 * 设备用途业务层接口
 * @author 刘洋
 *
 */

import java.util.List;

import com.litbo.hospitalzj.supplier.entity.EqYt;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

public interface EqYtService {

	EqYt getById(Integer eqytId);

	List<EqYt> getAll();

	void delete(@Param("eqytId")Integer eqytId, @Param("isDelete")Integer isDelete);

	void insert(EqYt eqYt);

	EqYt update(EqYt eqYt);

	List<EqYt> findEqYtLike(@Param("eqytName")String eqytName);
}
