package com.litbo.hospitalzj.supplier.controller;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.litbo.hospitalzj.controller.BaseController;

import com.litbo.hospitalzj.supplier.entity.EqInfo;

import com.litbo.hospitalzj.supplier.service.EqInfoService;
import com.litbo.hospitalzj.supplier.vo.SelHtEqVo;
import com.litbo.hospitalzj.util.ResponseResult;


@RestController
@RequestMapping("/eqInfo")
public class EqInfoController extends BaseController{
	@Autowired
	private EqInfoService eqinfoService;
	@RequestMapping("/insert")
	public ResponseResult<Integer> insertEqInfo(EqInfo eqInfo,HttpSession session){
		eqinfoService.InsertEqInfo(eqInfo);
		session.setAttribute("eqId", eqInfo.getEqId());
		System.out.println(eqInfo.getEqId());
		eqInfo.setEqState(1);
		return new ResponseResult<Integer>(SUCCESS,eqInfo.getEqId());
	}
	@RequestMapping("/updateInfo")
	public ResponseResult<Void> updateInfo(EqInfo eqInfo){
		eqinfoService.updateInfo(eqInfo);
		return new ResponseResult<Void>(SUCCESS);
	}
	@RequestMapping("/selectEqHt")
	public ResponseResult<List<EqInfo>> selectEqInfo(Integer htIds,HttpSession session){
		List<EqInfo> eqInfo=eqinfoService.selectEqInfo(htIds);
		return new ResponseResult<List<EqInfo>>(SUCCESS,eqInfo);
	}
	@RequestMapping("/selectEqInfo")
	public ResponseResult<List<SelHtEqVo>> selectEqHt(Integer htIds,HttpSession session){
		List<SelHtEqVo> eqInfo=eqinfoService.selectEqHtVo(htIds);
		System.out.println(eqInfo);
		return new ResponseResult<List<SelHtEqVo>>(SUCCESS,eqInfo);
	}
	@RequestMapping("/selectEqId")
	public ResponseResult<Integer> findByEqId(Integer eqId){
		Integer data=eqinfoService.findHtId(eqId);
		return new ResponseResult<Integer>(SUCCESS,data);
	}
	@RequestMapping("/selectByState")
	public ResponseResult<List<EqInfo>> findByState(){
		List<EqInfo> data=eqinfoService.selectByState();
		return new ResponseResult<List<EqInfo>>(SUCCESS,data);
	}
	@RequestMapping("/delete")
	public ResponseResult<Void> delete(Integer eqId) {
		eqinfoService.delete(eqId);
		return new ResponseResult<Void>(SUCCESS);
	}
	@RequestMapping("/select")
	public ResponseResult<EqInfo> selectByEqId(Integer eqId) {
		EqInfo data=eqinfoService.selectByEqId(eqId);
		return new ResponseResult<EqInfo>(SUCCESS,data);
	}
	//全部新设备信息
	@RequestMapping("/newEqInfo")
	public ResponseResult<List<EqInfo>> newEqinfo() {
		List<EqInfo> data=eqinfoService.newEqinfo();
		return new ResponseResult<List<EqInfo>>(SUCCESS,data);
	}
	//已分配新设备
	@RequestMapping("/eqInfoYfp")
	public ResponseResult<List<EqInfo>> eqInfoYfp() {
		List<EqInfo> data=eqinfoService.eqInfoYfp();
		return new ResponseResult<List<EqInfo>>(SUCCESS,data);
	}
	//未分配新设备
	@RequestMapping("/eqInfoWfp")
	public ResponseResult<List<EqInfo>> eqInfoWfp() {
		List<EqInfo> data=eqinfoService.eqInfoWfp();
		return new ResponseResult<List<EqInfo>>(SUCCESS,data);
	}

	@RequestMapping("/updateEqQk")
	public ResponseResult<Void> updateEqQk(@RequestParam("eqId")Integer eqId,@RequestParam("eqQk")String eqQk) {
		eqinfoService.updateEqQk(eqId,eqQk);
		return new ResponseResult<Void>(SUCCESS);
	}

	@RequestMapping("/findByEqQk")
	public ResponseResult<List<EqInfo>> findByEqQk(@RequestParam("eqQk")String eqQk) {
		List<EqInfo> data=eqinfoService.findByEqQk(eqQk);
		return new ResponseResult<List<EqInfo>>(SUCCESS,data);
	}
}
