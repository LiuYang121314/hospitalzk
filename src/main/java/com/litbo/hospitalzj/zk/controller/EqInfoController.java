package com.litbo.hospitalzj.zk.controller;

import ch.qos.logback.core.util.FileUtil;
import com.litbo.hospitalzj.controller.BaseController;
import com.litbo.hospitalzj.util.ResponseResult;
import com.litbo.hospitalzj.zk.domian.EqInfo;
import com.litbo.hospitalzj.zk.domian.Yq;
import com.litbo.hospitalzj.zk.service.EqInfoService;
import com.litbo.hospitalzj.zk.vo.EqToYqs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@RestController("eqInfo")
@RequestMapping("/zkeq")
public class EqInfoController extends BaseController{
	@Autowired
	private EqInfoService eqInfoService;

	@RequestMapping("/updateEqPm")
	public ResponseResult<Void> updateEqPm(@RequestParam("eqId")Integer eqId,@RequestParam("eqPmId")Integer eqPmId){
		eqInfoService.updateEqPm(eqId,eqPmId);
		return new ResponseResult<Void>(SUCCESS);
	}

	@RequestMapping("/updateEqInfo1")
	public ResponseResult<Void> updateEqInfo1(EqInfo eqInfo){
		eqInfoService.updateInfo1(eqInfo);
		return new ResponseResult<Void>(SUCCESS);
	}

	@RequestMapping("/findAllEq")
	public ResponseResult<List<EqInfo>> findAll1(@RequestParam("page") Integer offset,
												 @RequestParam("limit") Integer count){
		List<EqInfo> dataList=eqInfoService.findAll(offset, count);
		return new ResponseResult<List<EqInfo>>(SUCCESS,dataList);
	}

	@RequestMapping("/findEqYqs/{eqId}")
	public ResponseResult<EqToYqs> findEqYqs(@PathVariable String eqId){
		EqToYqs eqToYqs=eqInfoService.findEqYqs(eqId);
		return new ResponseResult<EqToYqs>(SUCCESS,eqToYqs);
	}

	@RequestMapping("/findEqById/{eqId}")
	public ResponseResult<EqInfo> findEqById(@PathVariable String eqId){
		EqInfo eqInfo=eqInfoService.findEqById(eqId);
		return new ResponseResult<EqInfo>(SUCCESS,eqInfo);
	}

	@RequestMapping("/findEqsByState/{state}")
	public ResponseResult<List<EqInfo>> findEqsByState(@PathVariable String state){
		List<EqInfo> eqInfoList=eqInfoService.findEqsByState(state);
		return new ResponseResult<List<EqInfo>>(SUCCESS,eqInfoList);
	}

	@RequestMapping("/findYqsById/{eqId}")
	public ResponseResult<List<Yq>> findYqsById(@PathVariable Integer eqId){
		List<Yq> yqList=eqInfoService.findYqsById(eqId);
		return new ResponseResult<List<Yq>>(SUCCESS,yqList);
	}

	@RequestMapping("/findNewEqId")
	public ResponseResult<List<EqInfo>> findNewEqid(){
		List<EqInfo> data=eqInfoService.findNewEqInfo();
		return new ResponseResult<List<EqInfo>>(SUCCESS,data);
	}
	@RequestMapping("/findByDah")
	public ResponseResult<EqInfo> findByDah(String dah){
		EqInfo data=eqInfoService.findByDah(dah);
		return new ResponseResult<EqInfo>(SUCCESS,data);
	}
}
