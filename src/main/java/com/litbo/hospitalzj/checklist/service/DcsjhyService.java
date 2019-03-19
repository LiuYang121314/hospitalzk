package com.litbo.hospitalzj.checklist.service;

import com.litbo.hospitalzj.checklist.dao.DcsjhyMapper;
import com.litbo.hospitalzj.checklist.domain.Dcsjhy;
import com.litbo.hospitalzj.checklist.domain.DcsjhyTemplate;

import com.litbo.hospitalzj.checklist.vo.DqjcUser;
import com.litbo.hospitalzj.checklist.vo.JhyUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

;

/**
 * 多参数监护仪service层
 * @author bigStone
 *
 */

@Service("dcsjhyService")
@Transactional
public class DcsjhyService {

	@Autowired
	private DcsjhyMapper dcsjhyMapper;


	//查询最新插入的监护仪检测数据{成人}单条数据
	public Dcsjhy findDcsjhyMan() {
		return dcsjhyMapper.findDcsjhyMan();
	}


    //查询最新插入的监护仪检测数据{成人}所有数据
    public List<Dcsjhy> findDcsjhyMans() {
        return dcsjhyMapper.findDcsjhyMans();
    }

    //查询最新插入的监护仪检测数据{幼儿}所有数据
    public List<Dcsjhy> findDcsjhyChilds() {
        return dcsjhyMapper.findDcsjhyChilds();
    }

    //查询最新插入的监护仪检测数据{幼儿}
    public Dcsjhy findDcsjhyChild() {
        return dcsjhyMapper.findDcsjhyChild();
    }

	//保存录入数据(成人)
	public void saveMan(Dcsjhy dcsjhy) {
		DcsjhyTemplate dcsjhyTempate = dcsjhyMapper.findTemplate_m();
		//System.out.println(dcsjhyTempate);
		BeanUtils.copyProperties(dcsjhyTempate, dcsjhy);
		//System.out.println(dcsjhy);
		dcsjhyMapper.saveMan(dcsjhy);
	}
	//保存录入数据(婴儿)
	public void saveChild(Dcsjhy dcsjhy) {
		DcsjhyTemplate dcsjhyTempate = dcsjhyMapper.findTemplate_c();
		//System.out.println(dcsjhyTempate);
		BeanUtils.copyProperties(dcsjhyTempate, dcsjhy);
		//System.out.println(dcsjhy);
		dcsjhyMapper.saveChild(dcsjhy);
	}

	//查询成人模板表数据
    public DcsjhyTemplate findTemplateMan() {
		DcsjhyTemplate dcsjhyTempate = dcsjhyMapper.findTemplate_m();
		return dcsjhyTempate;
    }
    public Dcsjhy findByEqIdandJcyqIdCh(String string, String jcyqId){
		return dcsjhyMapper.findByEqIdandJcyqIdCh(string,jcyqId);
	}
    public Dcsjhy findByEqIdandJcyqIdMan(String eqId, String jcyqId){
		return dcsjhyMapper.findByEqIdandJcyqIdMan(eqId,jcyqId);
	}
    //查询幼儿模板表数据
	public DcsjhyTemplate findTemplateChild() {
		DcsjhyTemplate dcsjhyTempate = dcsjhyMapper.findTemplate_c();
		return dcsjhyTempate;
	}
	//删除数据
	public void delectMen(String eqId,String jcyqId){
		dcsjhyMapper.delectMen(eqId, jcyqId);
	}
	public void delectChi(String eqId,String jcyqId){
		dcsjhyMapper.delectChi(eqId, jcyqId);
	}
	/**
	 * 修改状态
	 */
	public void updateStateM(Integer dcid,Integer state){
		dcsjhyMapper.updateStateM(dcid,state);
	}
	public void updateStateC(Integer dcid,Integer state){
		dcsjhyMapper.updateStateC(dcid,state);
	}
	//根据id状态查询
	public Dcsjhy findByDcidM(Integer dcid,Integer state){
		return dcsjhyMapper.findByDcidM(dcid, state);
	}
	public Dcsjhy findByDcidC(Integer dcid,Integer state){
		return dcsjhyMapper.findByDcidC(dcid, state);
	}
	//查找审核人，审核人意见(成人)
	public JhyUser findShrAndShrjcjlM(String eqId, String jcyqId, Integer state){
		return dcsjhyMapper.findShrAndShrjcjlM(eqId, jcyqId, state);
	}
	public JhyUser findShrAndShrjcjlC(String eqId, String jcyqId, Integer state){
		return dcsjhyMapper.findShrAndShrjcjlC(eqId, jcyqId, state);
	}
	//修改审核人意见
	public void updateShrJcjyM(@Param("dcid")Integer dcid,@Param("shrJcjl")String shrJcjl,@Param("auditor")String auditor){
		dcsjhyMapper.updateShrJcjyM(dcid,shrJcjl,auditor);
	}
	public void updateShrJcjyC(@Param("dcid")Integer dcid,@Param("shrJcjl")String shrJcjl,@Param("auditor")String auditor){
		dcsjhyMapper.updateShrJcjyC(dcid,shrJcjl,auditor);
	}
}

