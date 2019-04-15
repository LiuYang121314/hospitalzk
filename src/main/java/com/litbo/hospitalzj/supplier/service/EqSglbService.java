package com.litbo.hospitalzj.supplier.service;
/**
 * 设备申购类别业务层接口
 * @author 刘洋
 *
 */

import java.util.List;
import com.litbo.hospitalzj.supplier.entity.EqSglb;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

public interface EqSglbService {

	EqSglb getById(Integer eqsgId);

	List<EqSglb> getAll();
	//shanchu
	void delete(@Param("eqlyId")Integer eqlyId,@Param("isDelete")Integer isDelete);

	void insert(EqSglb eqSglb);
	EqSglb update(EqSglb eqSglb);
	//模糊查询
	List<EqSglb> findEqSglbLike(@Param("eqsgName")String eqsgName);
}
