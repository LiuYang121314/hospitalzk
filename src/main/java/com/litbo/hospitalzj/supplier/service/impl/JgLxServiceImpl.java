package com.litbo.hospitalzj.supplier.service.impl;


import com.litbo.hospitalzj.supplier.entity.JgLx;
import com.litbo.hospitalzj.supplier.entity.QyLx;
import com.litbo.hospitalzj.supplier.mapper.JgLxMapper;
import com.litbo.hospitalzj.supplier.mapper.QyLxMapper;
import com.litbo.hospitalzj.supplier.service.JgLxService;
import com.litbo.hospitalzj.supplier.service.QyLxService;
import com.litbo.hospitalzj.supplier.service.exception.InsertException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JgLxServiceImpl implements JgLxService {
	@Autowired
	private JgLxMapper jgLxMapper;

	@Override
	public List<JgLx> findAll(Integer offset, Integer count) {
		return jgLxMapper.findAll(offset,count);
	}

	@Override
	public void insert(JgLx jgLx) {
		JgLx data=jgLxMapper.findByName(jgLx.getJgLxmc());
		if(data!=null){
			throw new InsertException("此项数据已存在");
		}
		jgLxMapper.insert(jgLx);
	}

	@Override
	public void update(JgLx jgLx) {
		jgLxMapper.update(jgLx);
	}

	@Override
	public List<JgLx> findByJgLxNameLike(String jgLx) {
		return jgLxMapper.findByJgLxNameLike(jgLx);
	}

	@Override
	public void delete(Integer jgId) {
		jgLxMapper.delete(jgId);
	}
}
