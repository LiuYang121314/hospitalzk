package com.litbo.hospitalzj.zk.service;

import com.litbo.hospitalzj.zk.domian.EqInfo;
import com.litbo.hospitalzj.zk.domian.TabEq;
import com.litbo.hospitalzj.zk.domian.Yq;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TabEqService {

	TabEq findTable(Integer eqId,Integer jcyqId);

	void insert(TabEq tabEq);

	List<TabEq> findAll();
}
