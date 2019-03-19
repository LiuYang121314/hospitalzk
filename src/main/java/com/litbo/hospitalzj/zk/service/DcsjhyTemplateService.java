package com.litbo.hospitalzj.zk.service;

import java.util.List;

import com.litbo.hospitalzj.zk.domian.DcsjhyTemplate;

public interface DcsjhyTemplateService {

	public void insert(DcsjhyTemplate dt);
	
	public List<DcsjhyTemplate> findAll();
	
	public void delete(String id);
	
}
