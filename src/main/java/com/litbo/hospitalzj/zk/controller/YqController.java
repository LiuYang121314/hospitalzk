package com.litbo.hospitalzj.zk.controller;

import java.util.List;

import com.litbo.hospitalzj.quality.mapper.UserPmMapper;
import com.litbo.hospitalzj.quality.service.UserPmService;
import com.litbo.hospitalzj.zk.domian.UserEq;
import com.litbo.hospitalzj.zk.service.NdjhService;
import com.litbo.hospitalzj.zk.service.UserEqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.litbo.hospitalzj.controller.BaseController;
import com.litbo.hospitalzj.util.ResponseResult;
import com.litbo.hospitalzj.zk.domian.EqInfo;
import com.litbo.hospitalzj.zk.domian.Yq;
import com.litbo.hospitalzj.zk.service.YqService;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/yq")
public class YqController extends BaseController{

	@Autowired
	private YqService yqService;
	@Autowired
	private UserEqService userEqService;
	@Autowired
	private UserPmService userPmService;
	@Autowired
	private NdjhService ndjhService;
	//新增仪器
	@RequestMapping("/insert")
	public ResponseResult<Void> insert(Yq yq){
		
		yqService.insert(yq);
		return new ResponseResult<Void>(SUCCESS);
	}
	
	//删除仪器
	@RequestMapping("/delete/{yqId}")
	public ResponseResult<Void> delete(@PathVariable String yqId){
		yqService.delete(yqId);
		return new ResponseResult<Void>(SUCCESS);
	}
	
	
	@RequestMapping("/deleteBatch")
	public ResponseResult<Void> deleteBatch(String[] yqId){
		yqService.deleteBatch(yqId);
		
		String[] yqId1={"8","9"};
		for(int i=0;i<yqId.length;i++){
			
			yqService.delete(yqId[i]);
		}
		return new ResponseResult<Void>(SUCCESS);
	}
	
	//查询所有仪器
	@RequestMapping("/findAll")
	public ResponseResult<List<Yq>> findAll(){
		List<Yq> yqList=yqService.findAll();
		for(int i=0;i<yqList.size();i++){
			System.out.println(yqList.get(i));
		}
		return new ResponseResult<List<Yq>>(SUCCESS,yqList);
	}
	
	//修改仪器
	@RequestMapping("/update")
	public ResponseResult<Void> update(String yqId){
		Yq yq=new Yq();
		yq.setJcyqId("5");
		yq.setJcyqName("小刀dao");
		yqService.update(yq);
		return new ResponseResult<Void>(SUCCESS);
	}
	//根据设备Id查询仪器
	@RequestMapping("/select")
	public ResponseResult<List<Yq>> select(Integer eqId){
		List<Yq> data=yqService.select(eqId);
		return new ResponseResult<List<Yq>>(SUCCESS,data);
	}
	//根据档案号查询出设备以及仪器
	@RequestMapping("/selectEqInfo")
	public ResponseResult<EqInfo> selectEqInfo(@RequestParam("eqDah") String eqDah,@RequestParam("eqPmId") String eqPmId,@RequestParam("ndjhId") String ndjhId, HttpSession session){
		EqInfo data=yqService.selectEqInfo(eqDah);
		String eqId= String.valueOf(data.getEqId());
		String userId=getUserIdFromSession(session);
		String shrId=userPmService.selectShrId(userId,eqPmId);
		userEqService.insertBatchByJcEqid(userId,eqId,shrId,ndjhId);
		ndjhService.updateMonth(Integer.valueOf(ndjhId));
		return new ResponseResult<EqInfo>(SUCCESS,data);
	}

	/*@RequestMapping("/selectEqYq")
	public ResponseResult<List<Yq>> selectEqYq(String eqDah){
		List<Yq> data=yqService.selectEqYq(eqDah);
		return new ResponseResult<List<Yq>>(SUCCESS,data);
	}*/
	//电器的数据
	@RequestMapping("/selectEqYqByEqId")
	public ResponseResult<List<Yq>> selectEqYqByEqId(@RequestParam("eqId") Integer eqId){
		List<Yq> data=yqService.selectEqYqByEqId(eqId,"电气安全分析仪");
		return new ResponseResult<List<Yq>>(SUCCESS,data);
	}
	//除电器意外的数据
	@RequestMapping("/selectEqYqNotDqByEqId")
	public ResponseResult<List<Yq>> selectEqYqNotDqByEqId(@RequestParam("eqId") Integer eqId){
		List<Yq> data=yqService.selectEqYqNotDqByEqId(eqId,"电气安全分析仪");
		return new ResponseResult<List<Yq>>(SUCCESS,data);
	}
	//根据设备Id查询出设备以及仪器
	@RequestMapping("/selectEqInfoByEqid")
	public ResponseResult<EqInfo> selectEqInfoByEqid(@RequestParam("eqId") Integer eqId){
		EqInfo data=yqService.selectEqInfoByEqid(eqId);
		return new ResponseResult<EqInfo>(SUCCESS,data);
	}

	@RequestMapping("/selectEqYqByEqid")
	public ResponseResult<List<Yq>> selectEqYqByEqid(@RequestParam("eqId") Integer eqId){
		List<Yq> data=yqService.selectEqYqByEqid(eqId);
		return new ResponseResult<List<Yq>>(SUCCESS,data);
	}
	//管理员查看通过设备ID查询设备检测仪器
	//查看非电气仪器表
	@RequestMapping("/selectYqNotDqByEqId")
	public ResponseResult<List<Yq>> selectYqNotDqByEqId(@RequestParam("eqId") Integer eqId){
		List<Yq> data=yqService.selectYqNotDqByEqId(eqId,"电气安全分析仪");
		return new ResponseResult<List<Yq>>(SUCCESS,data);
	}
	//查看电气仪器表
	@RequestMapping("/selectYqDqByEqId")
	public ResponseResult<List<Yq>> selectYqDqByEqId(@RequestParam("eqId") Integer eqId){
		List<Yq> data=yqService.selectYqDqByEqId(eqId,"电气安全分析仪");
		return new ResponseResult<List<Yq>>(SUCCESS,data);
	}
	//根据设备id查询设备所关联的仪器
	@RequestMapping("/selectYqByEqId")
	public ResponseResult<List<Yq>> selectYqByEqId0(@RequestParam("eqId") Integer eqId){
		List<Yq> data=yqService.selectYqByEqId(eqId);
		return new ResponseResult<List<Yq>>(SUCCESS,data);
	}
	/*@RequestMapping("/selectYqByEqId1")
	public ResponseResult<List<Yq>> selectYqByEqId1(@RequestParam("eqId") Integer eqId){
		List<Yq> data=yqService.selectYqByEqId(eqId);
		return new ResponseResult<List<Yq>>(SUCCESS,data);
	}*/
	/*@RequestMapping("/selectYqByEqId")
	public ResponseResult<List<Yq>> selectYqByEqId(@RequestParam("eqId") Integer eqId){
		List<Yq> data=yqService.selectYqByEqId(eqId);
		return new ResponseResult<List<Yq>>(SUCCESS,data);
	}*/
	/*@RequestMapping("/month")
	public ResponseResult<Void> month(){
		return new ResponseResult<Void>(SUCCESS);
	}*/

}
