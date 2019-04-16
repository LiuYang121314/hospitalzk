package com.litbo.hospitalzj.checklist.service;

import com.litbo.hospitalzj.checklist.dao.DcsjhyMapper;
import com.litbo.hospitalzj.checklist.domain.Dcsjhy;
import com.litbo.hospitalzj.checklist.domain.DcsjhyTemplate;

import com.litbo.hospitalzj.checklist.vo.DqjcUser;
import com.litbo.hospitalzj.checklist.vo.JhyUser;
import org.apache.ibatis.annotations.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface DcsjhyService {

		//查询多参数监护仪模板表（成人）
		public DcsjhyTemplate findTemplate_m();

		//查询多参数监护仪模板表(儿童)
		public DcsjhyTemplate findTemplate_c();
		public DcsjhyTemplate findTemplateById(@Param("dcTemplateid") Integer dcTemplateid,@Param("tableName") String tableName);


	//修改模板表数据
		void updateM(DcsjhyTemplate dcsjhyTemplate);
		//成人
		void updateC(DcsjhyTemplate dcsjhyTemplate);
		//插入模板表数据
		void insertM(DcsjhyTemplate dcsjhyTemplate);
		void insertC(DcsjhyTemplate dcsjhyTemplate);
		//保存多参数监护仪检测表(成人)
		public void saveMan( Dcsjhy dcsjhy);
		public void updateMen( Dcsjhy dcsjhy);
		//保存多参数监护仪检测表(幼儿)
		public void saveChild( Dcsjhy dcsjhy);
		public void updateChild( Dcsjhy dcsjhy);


		//根据设备Id,检测仪器Id以及状态查询最后一条记录
		Dcsjhy findByEqIdandJcyqIdLast(@Param("tableName") String tableName, @Param("eqId")String eqId, @Param("jcyqId")String jcyqId);
		//根据设备Id,检测仪器Id以及状态查询
		List<Dcsjhy> findByEqIdandJcyqId(@Param("tableName") String tableName,@Param("eqId")String eqId,@Param("jcyqId")String jcyqId);

		//查询多参数监护仪检测单条数据（成人）
		List<Dcsjhy> findDcsjhyMans();

		//查询多参数监护仪检测单条数据（幼儿）
		List<Dcsjhy> findDcsjhyChilds();

		//根据id查询
		Dcsjhy findByDcidM(@Param("dcid")Integer dcid);
		Dcsjhy findByDcidC(@Param("dcid")Integer dcid);
		//修改审核人意见
		void updateShrJcjyM(@Param("dcid")Integer dcid,@Param("shrJcjl")String shrJcjl,@Param("auditor")String auditor);
		void updateShrJcjyC(@Param("dcid")Integer dcid,@Param("shrJcjl")String shrJcjl,@Param("auditor")String auditor);
	}


