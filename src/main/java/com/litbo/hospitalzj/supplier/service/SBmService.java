package com.litbo.hospitalzj.supplier.service;
/**
 * 设备采购方式业务层接口
 * @author 刘洋
 *
 */

import com.litbo.hospitalzj.supplier.entity.EqCgfs;
import com.litbo.hospitalzj.supplier.entity.SBm;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface SBmService {
	//通过id查询
	SBm findById(@Param("bmId") Integer bmId);
	/*//通过名称查询
	SBm findByName(@Param("bmName") String bmName);*/
	//查询全部部门
	List<SBm> findAll(@Param("offset") Integer offset, @Param("count") Integer count);
	//删除记录
	void delete(@Param("bmId") Integer bmId);
	//插入部门
	void insert(SBm sBm);
	//提供修改
	void update(SBm sBm);
	//模糊查询
	List<SBm> findByBmNameLike(@Param("bmName") String bmName);
}
