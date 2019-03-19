package com.litbo.hospitalzj.checklist.service;

import com.litbo.hospitalzj.checklist.dao.DqjcMapper;
import com.litbo.hospitalzj.checklist.domain.Dcsjhy;
import com.litbo.hospitalzj.checklist.domain.Dqjc;
import com.litbo.hospitalzj.checklist.domain.DqjcTemplate;

import com.litbo.hospitalzj.checklist.vo.DqjcUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 电气检测Service
 * @author bigStone
 *
 */
@Service("dqjcService")
@Transactional
public class DqjcService {

	@Autowired
	private DqjcMapper dqjcMapper;

	//根据表名查询电器检测模板表
	public Dqjc findTemplate() {
		DqjcTemplate dqjcTemplate = dqjcMapper.findTemplate();
		Dqjc dqjc = new Dqjc();
		BeanUtils.copyProperties(dqjcTemplate, dqjc);
		return dqjc;
	}

	//保存带有检测数据的电器检测表
	public void save(Dqjc dqjc) {
		DqjcTemplate dqjcTemplate = dqjcMapper.findTemplate();
		BeanUtils.copyProperties(dqjcTemplate, dqjc);
		dqjcMapper.save(dqjc);
	}

	//根据设备id查询设备检测表
	public Dqjc findDqjc(String eqId) {
		return dqjcMapper.findDqjc(eqId);
		
	}

	/**
	 * 默认查询最后一条电气检测表
	 * @return
	 */
	public Dqjc find() {
		return dqjcMapper.find();
	}

	/**
	 * 查询所有电气检测表数据
	 * @return
	 */
    public  List<Dqjc> findAll() {
    	return dqjcMapper.findAll();
    }
    public  Dqjc findByEqIdandJcyqId(String eqId,String jcyqId) {
    	return dqjcMapper.findByEqIdandJcyqId(eqId, jcyqId);
    }

	/**
	 * 删除数据
	 * @param eqId
	 */
    public void delete(String eqId,String jcyqId){
		dqjcMapper.delete(eqId,jcyqId);
	}

	public Dqjc findByDqjcid(Integer dqjcid,Integer state){
		return dqjcMapper.findByDqjcid(dqjcid,state);
	}

	/**
	 * 修改状态
	 * @param dqjcid
	 * @param state
	 */
	public void updateState(Integer dqjcid,Integer state){
    	dqjcMapper.updateState(dqjcid,state);
	}

	/**
	 * 查找审核人，审核人意见
	 * @param eqId
	 * @param jcyqId
	 * @param state
	 * @return
	 */
	public DqjcUser findShrAndShrjcjl(String eqId, String jcyqId, Integer state){
		return dqjcMapper.findShrAndShrjcjl(eqId, jcyqId, state);
	}
	/**
	 * 修改审核人意见
	 */
	public void updateShrJcjy(@Param("dqjcid")Integer dqjcid,@Param("shrJcjl")String shrJcjl,@Param("auditor")String auditor){
		dqjcMapper.updateShrJcjy(dqjcid,shrJcjl,auditor);
	}
}
