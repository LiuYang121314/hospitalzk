package com.litbo.hospitalzj.supplier.service.impl;
/**
 * 设备来源业务层
 * @author 刘洋
 *
 */

import java.util.List;

import com.litbo.hospitalzj.supplier.entity.EqJfly;
import com.litbo.hospitalzj.supplier.service.exception.DeleteException;
import com.litbo.hospitalzj.supplier.service.exception.InsertException;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.litbo.hospitalzj.supplier.entity.EqLy;
import com.litbo.hospitalzj.supplier.mapper.EqLyMapper;
import com.litbo.hospitalzj.supplier.service.EqLyService;

@Service
public class EqLyServiceImpl implements EqLyService{
	@Autowired
	private EqLyMapper eqLyMapper;

	@Override
	public EqLy getById(Integer eqlyId) {
		return findById(eqlyId);
	}
	private EqLy findById(Integer eqlyId) {
		return eqLyMapper.findById(eqlyId);
	}
	@Override
	public List<EqLy> getAll(@Param("offset")Integer offset, @Param("count") Integer count) {
		return eqLyMapper.findAll(offset,count);
	}

	@Override
	public void delete(Integer eqlyId,Integer isDelete) {
		EqLy data=findById(eqlyId);
		if(data==null){
			throw new DeleteException("设备来源不存在");
		}
		eqLyMapper.delete(eqlyId,isDelete);
	}

	@Override
	public void insert(EqLy eqLy) {
		EqLy data=eqLyMapper.findByName(eqLy.getEqlyName());
		if(data!=null){
			throw new InsertException("设备来源号或名称已存在");
		}
		eqLyMapper.insert(eqLy);
	}

	@Override
	public EqLy update(EqLy eqLy) {
		eqLyMapper.update(eqLy);
		return eqLy;
	}

	@Override
	public List<EqLy> findEqLyLike(String eqlyName) {
		return eqLyMapper.findEqLyLike(eqlyName);
	}
}
