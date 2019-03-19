package com.litbo.hospitalzj.zk.service;

import java.util.List;

import com.litbo.hospitalzj.zk.domian.EqInfo;
import com.litbo.hospitalzj.zk.domian.Yq;
import com.litbo.hospitalzj.zk.vo.EqAndUname;
import com.litbo.hospitalzj.zk.vo.EqToYqs;

public interface EqInfoService {


	public void insert(EqInfo dt);

	public List<EqInfo> findAll();

	public void delete(String id);

	public List<EqInfo> findByJcyqId(String jcyqId);

	public List<EqInfo> findNotByJcyqId(String jcyqId);

	public List<EqInfo> findJcEqByUserId(String userId);

	public List<EqInfo> findShEqByUserId(String userId);

	public List<EqInfo> findJcEqNotByUserId(String string);

	public List<EqInfo> findShEqNotByUserId(String string);

	public EqToYqs findEqYqs(String dah);

	public EqInfo findEqById(String eqId);

	public List<Yq> findYqsById(Integer eqId);

	public List<EqInfo> findEqsByState(String state);

	public List<EqInfo> findEqsByUserIdAndState(String userId, String state);

	List<EqInfo> findEqInfo(String userId);

	List<EqInfo> findNewEqInfo();

	public List<EqAndUname> findJcEqsByUserIdAndState(String userId, String state);

	public List<EqInfo> findShEqsByUserIdAndState(String userId, String state);


}
