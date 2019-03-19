package com.litbo.hospitalzj.zk.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.litbo.hospitalzj.zk.domian.DcsjhyTemplate;
import com.litbo.hospitalzj.zk.mapper.DcsjhyTemplateMapper;
import com.litbo.hospitalzj.zk.service.DcsjhyTemplateService;

@Service
public class DcsjhyTemplateServiceImpl implements DcsjhyTemplateService {

	@Autowired
	DcsjhyTemplateMapper dcsjhyTemplateMapper;
	
	@Override
	public void insert(DcsjhyTemplate dt) {
		// TODO Auto-generated method stub

		dcsjhyTemplateMapper.insert(dt);
	}

	@Override
	public List<DcsjhyTemplate> findAll() {
		// TODO Auto-generated method stub
		return dcsjhyTemplateMapper.findAll();
	}

	

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		dcsjhyTemplateMapper.delete(id);
	}

}
