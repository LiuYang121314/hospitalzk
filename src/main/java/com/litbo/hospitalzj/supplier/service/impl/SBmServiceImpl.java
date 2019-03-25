package com.litbo.hospitalzj.supplier.service.impl;
/**
 * 部门业务层
 * @author 刘洋
 *
 */

import com.litbo.hospitalzj.supplier.entity.EqCgfs;
import com.litbo.hospitalzj.supplier.entity.SBm;
import com.litbo.hospitalzj.supplier.mapper.SBmMapper;
import com.litbo.hospitalzj.supplier.service.SBmService;
import com.litbo.hospitalzj.supplier.service.exception.InsertException;
import com.litbo.hospitalzj.supplier.service.exception.UpdateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SBmServiceImpl implements SBmService {
	@Autowired
	private SBmMapper sBmMapper;

	@Override
	public SBm findById(Integer bmId) {
		return sBmMapper.findById(bmId);
	}

	public SBm findByName(String bmName) {
		return sBmMapper.findByName(bmName);
	}

	@Override
	public List<SBm> findAll(Integer offset, Integer count) {
		return sBmMapper.findAll(offset,count);
	}

	@Override
	public void delete(Integer bmId) {
		sBmMapper.delete(bmId);
	}

	@Override
	public void insert(SBm sBm) {
		SBm data=findByName(sBm.getBmName());
		if(data!=null){
			throw new InsertException("该项部门已存在");
		}
		sBmMapper.insert(data);
	}

	@Override
	public void update(SBm sBm) {
		sBmMapper.update(sBm);
	}

	@Override
	public List<SBm> findByBmNameLike(String bmName) {
		return sBmMapper.findByBmNameLike(bmName);
	}
}
