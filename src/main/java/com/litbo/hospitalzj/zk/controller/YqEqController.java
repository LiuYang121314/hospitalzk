package com.litbo.hospitalzj.zk.controller;

import java.util.List;

import com.litbo.hospitalzj.zk.vo.YqEqVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.litbo.hospitalzj.controller.BaseController;
import com.litbo.hospitalzj.util.ResponseResult;
import com.litbo.hospitalzj.zk.domian.EqInfo;
import com.litbo.hospitalzj.zk.domian.Yq;
import com.litbo.hospitalzj.zk.domian.YqEq;
import com.litbo.hospitalzj.zk.service.EqInfoService;
import com.litbo.hospitalzj.zk.service.YqEqService;
import com.litbo.hospitalzj.zk.service.YqService;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/yqEq")
public class YqEqController extends BaseController{

	@Autowired
	private YqEqService yqEqService;
	@Autowired
	private EqInfoService eqInfoService;
	@Autowired
	YqService yqService;
	//为仪器分配设备pm
	@RequestMapping("/selectYqEq")
	public ResponseResult<List<YqEqVo>> selectYqEq(HttpSession session){
		String userId=getUserIdFromSession(session);
		List<YqEqVo> data=yqEqService.selectYqEq(userId,2);
		return new ResponseResult<List<YqEqVo>>(SUCCESS,data);
	}
	//修改状态
	@RequestMapping("/insert")
	public ResponseResult<Integer> insert(@RequestParam("jcyqId") String jcyqId,@RequestParam("eqId") String eqId){
		int data=yqEqService.insertBatch(eqId,jcyqId);
		return new ResponseResult<Integer>(SUCCESS,data);
	}
//	
//	//删除仪器设备
//	@RequestMapping("/delete")
//	public ResponseResult<Void> delete(String userId,String eyId){
//		YqEq yqEq=new YqEq();
//		yqEq.setJcyqId("1");
//		yqEq.setEqId("6");
//		yqEqService.delete(yqEq);
//		return new ResponseResult<Void>(SUCCESS);
//	}
//	
	
	/*//为仪器分配设备pm
	@RequestMapping("/insertBatch")
	public ResponseResult<Void> insertBatch(YqEq yqEq){
		yqEq.setState(1);
		yqEqService.insertBatch(yqEq);
		return new ResponseResult<Void>(SUCCESS);
	}
	
	//删除仪器设备
	@RequestMapping("/deleteBatch/{jcyqId}/{eqId}")
	public ResponseResult<Void> deleteBatch(@PathVariable String jcyqId,@PathVariable String eqId){
		yqEqService.deleteBatch(jcyqId,eqId);
		return new ResponseResult<Void>(SUCCESS);
	}*/
	
	/*//查询所有仪器
	@RequestMapping("/findAllYq")
	public ResponseResult<List<Yq>> findAllYq(){
		List<Yq> yqList=yqService.findAll();
		for(int i=0;i<yqList.size();i++){
			System.out.println(yqList.get(i));
		}
		return new ResponseResult<List<Yq>>(SUCCESS,yqList);
	}*/
	
	//查询仪器已分配的设备
	/*@RequestMapping("/findByJcyqId/{jcyqId}")
	public ResponseResult<List<EqInfo>> findByJcyqId(@PathVariable String jcyqId){
		List<EqInfo> yqList=eqInfoService.findByJcyqId(jcyqId);
		return new ResponseResult<List<EqInfo>>(SUCCESS,yqList);
	}
	
	//查询仪器没有分配的设备
	@RequestMapping("/findNotByJcyqId/{jcyqId}")
	public ResponseResult<List<EqInfo>> findNotByJcyqId(@PathVariable String jcyqId){
		List<EqInfo> yqList=eqInfoService.findNotByJcyqId(jcyqId);
		return new ResponseResult<List<EqInfo>>(SUCCESS,yqList);
	}*/
	/*@RequestMapping("/findEqId")
	public ResponseResult<YqEq> findEqId(String jcyqId){
		YqEq yqList=yqEqService.selectEqId(jcyqId);
		return new ResponseResult<YqEq>(SUCCESS,yqList);
	}*/
	
	
	
}
