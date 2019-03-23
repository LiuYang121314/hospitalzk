package com.litbo.hospitalzj.supplier.service.impl;
/**
 * 设备经费业务层
 * @author 刘洋
 *
 */

import java.util.List;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.litbo.hospitalzj.supplier.entity.EqCgfs;
import com.litbo.hospitalzj.supplier.service.exception.DeleteException;
import com.litbo.hospitalzj.supplier.service.exception.InsertException;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.litbo.hospitalzj.supplier.entity.EqJfly;
import com.litbo.hospitalzj.supplier.mapper.EqJfMapper;
import com.litbo.hospitalzj.supplier.service.EqJfService;

@Service
public class EqJfServiceImp implements EqJfService{
	@Autowired
	private EqJfMapper eqJflyMapper;

	@Override
	public EqJfly getById(Integer eqjfId) {
		return findById(eqjfId);
	}
	private EqJfly findById(Integer eqjfId) {
		return eqJflyMapper.findById(eqjfId);
	}
	@Override
	public List<EqJfly> getAll(@Param("offset")Integer offset, @Param("count") Integer count) {
		return eqJflyMapper.findAll(offset,count);
	}

	@Override
	public void delete(Integer eqjfId,Integer isDelete) {
		EqJfly data=eqJflyMapper.findById(eqjfId);
		if(data==null){
			throw new DeleteException("经费来源不存在");
		}
		eqJflyMapper.delete(eqjfId,isDelete);
	}

	@Override
	public void insert(EqJfly eqJfly) {
		EqJfly data=eqJflyMapper.findByName(eqJfly.getEqjfName());
		if(data!=null){
			throw new InsertException("经费来源或名称已存在");
		}
		eqJflyMapper.insert(eqJfly);
	}

	@Override
	public EqJfly update(EqJfly eqJfly) {
		eqJflyMapper.update(eqJfly);
		return eqJfly;
	}

	@Override
	public List<EqJfly> findEqJflyLike(String eqjfName) {
		return eqJflyMapper.findEqJflyLike(eqjfName);
	}
}
