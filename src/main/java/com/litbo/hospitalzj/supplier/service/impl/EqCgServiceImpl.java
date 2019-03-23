package com.litbo.hospitalzj.supplier.service.impl;
/**
 * 设备来源业务层
 * @author 刘洋
 *
 */

import java.util.List;

import com.litbo.hospitalzj.supplier.service.exception.DeleteException;
import com.litbo.hospitalzj.supplier.service.exception.InsertException;
import com.litbo.hospitalzj.supplier.service.exception.UpdateException;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.litbo.hospitalzj.supplier.entity.EqCgfs;
import com.litbo.hospitalzj.supplier.entity.EqLy;
import com.litbo.hospitalzj.supplier.mapper.EqCgMapper;
import com.litbo.hospitalzj.supplier.mapper.EqLyMapper;
import com.litbo.hospitalzj.supplier.service.EqCgService;
import com.litbo.hospitalzj.supplier.service.EqLyService;

@Service
public class EqCgServiceImpl implements EqCgService{
	@Autowired
	private EqCgMapper eqCgMapper;

	@Override
	public EqCgfs getById(Integer eqcgId) {
		return findById(eqcgId);
	}

	private EqCgfs findById(Integer eqcgId) {
		return eqCgMapper.findById(eqcgId);
	}

	/*@Override
	public EqCgfs getById(Integer eqcgId) {
		return null;
	}*/

	@Override
	public List<EqCgfs> getAll(@Param("offset")Integer offset, @Param("count") Integer count) {
		return eqCgMapper.findAll(offset,count);
	}


	@Override
	public void delete(Integer eqcgId,Integer isDelete) {
		EqCgfs data=eqCgMapper.findById(eqcgId);
		if(data==null){
			throw new DeleteException("采购方式不已存在");
		}
		eqCgMapper.delete(eqcgId,isDelete);
	}

	@Override
	public void insert(EqCgfs eqCgfs) {
		EqCgfs data=eqCgMapper.findByName(eqCgfs.getEqcgName());
		if(data!=null){
			throw new InsertException("采购方式或名称已存在");
		}
		eqCgMapper.insert(eqCgfs);
	}

	@Override
	public EqCgfs update(EqCgfs eqCgfs) {
		eqCgMapper.update(eqCgfs);
		return eqCgfs;
	}

	@Override
	public List<EqCgfs> findByEqcgNameLike(String eqcgName) {
		return eqCgMapper.findByEqcgNameLike(eqcgName);
	}
}
