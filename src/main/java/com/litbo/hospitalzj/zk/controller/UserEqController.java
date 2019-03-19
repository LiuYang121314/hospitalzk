package com.litbo.hospitalzj.zk.controller;

import java.util.List;

import com.litbo.hospitalzj.zk.Enum.EnumProcess2;
import com.litbo.hospitalzj.zk.service.YqEqService;
import com.litbo.hospitalzj.zk.vo.EqAndUname;
import com.litbo.hospitalzj.zk.vo.UserEqVo;
import com.sun.net.httpserver.HttpsConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.litbo.hospitalzj.controller.BaseController;
import com.litbo.hospitalzj.util.ResponseResult;
import com.litbo.hospitalzj.zk.domian.EqInfo;
import com.litbo.hospitalzj.zk.service.EqInfoService;
import com.litbo.hospitalzj.zk.service.UserEqService;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/userEq")
public class UserEqController extends BaseController{

	@Autowired
	private UserEqService userEqService;
	@Autowired
	private EqInfoService eqInfoService;
	@Autowired
	private YqEqService yqEqService;
	//测试通过
	//为用户添加检测设备
	@RequestMapping("/insertBatchByJcEqid/{userId}/{jcEqid}/{ndjhId}")
	public ResponseResult<Void> insertBatchByJcEqid(@PathVariable String userId,@PathVariable String jcEqid,@PathVariable String ndjhId,HttpSession session){
		String shrId=getUserIdFromSession(session);
		System.out.println(shrId);
		userEqService.deleteBatchByJcEqid(userId,jcEqid);
		userEqService.insertBatchByJcEqid(userId,jcEqid,shrId,ndjhId);
		return new ResponseResult<Void>(SUCCESS);
	}
	
	//测试通过
	//为用户添加审核设备
	@RequestMapping("/insertBatchByShEqid")
	public ResponseResult<Void> insertBatchByShEqid(String userId,String[] shEqid){
		userEqService.insertBatchByShEqid(userId,shEqid);
		return new ResponseResult<Void>(SUCCESS);
	}
	
	//测试通过
	//为用户删除审核设备
	@RequestMapping("/deleteBatchByShEqid")
	public ResponseResult<Void> deleteBatchByShEqid(String userId,String[] shEqid){
		
		userEqService.deleteBatchByShEqid(userId,shEqid);
		
		return new ResponseResult<Void>(SUCCESS);
	}
	
	//测试通过
	//为用户删除检测设备
	@RequestMapping("/deleteBatchByJcEqid/{userId}/{jcEqid}")
	public ResponseResult<Void> deleteBatchByJcEqid(@PathVariable String userId,@PathVariable String jcEqid){
		userEqService.deleteBatchByJcEqid(userId,jcEqid);
		return new ResponseResult<Void>(SUCCESS);
	}
	
	//测试通过
	//查询用户分配的检测设备
	@RequestMapping("/findJcEqByUserId/{userId}")
	public ResponseResult<List<EqInfo>> findJcEqByUserId(@PathVariable String userId){
		List<EqInfo> yqList=eqInfoService.findJcEqByUserId(userId);
		return new ResponseResult<List<EqInfo>>(SUCCESS,yqList);
	}
	//查询用户分配的检测设备
	@RequestMapping("/findJcEqByMyUserId")
	public ResponseResult<List<EqInfo>> findJcEqByMyUserId(HttpSession session){
		String userId =getUserIdFromSession(session);
		List<EqInfo> yqList=eqInfoService.findJcEqByUserId(userId);
		return new ResponseResult<List<EqInfo>>(SUCCESS,yqList);
	}
	//查询用户的设备信息
	@RequestMapping("/findJcEq")
	public ResponseResult<List<EqInfo>> findJcEqBySessionUserId(HttpSession session){
		String userId=getUserIdFromSession(session);
		List<EqInfo> yqList=eqInfoService.findEqInfo(userId);
		return new ResponseResult<List<EqInfo>>(SUCCESS,yqList);
	}
	//测试通过
	//查询用户分配的审核设备
	@RequestMapping("/findShEqByUserId")
	public ResponseResult<List<EqInfo>> findShEqByUserId(String userId){
		List<EqInfo> yqList=eqInfoService.findShEqByUserId(userId);
		return new ResponseResult<List<EqInfo>>(SUCCESS,yqList);
	}

	//用户检测设备完毕、设置状态为2:待审核
	@RequestMapping("/setEqState2/{userId}/{eqId}")
	public ResponseResult<Void> setEqState2(@PathVariable String userId,@PathVariable String eqId){
		userEqService.setEqState2(userId,eqId);
		return new ResponseResult<Void>(SUCCESS);
	}


	//用户审核设备不通过、设置状态为3:审核不通过
	@RequestMapping("/setEqState34")
	public ResponseResult<Void> setEqState34(
			@RequestParam("state") String state,
			@RequestParam("userId") String userId,
			@RequestParam("jcEqid") String jcEqid){
		userEqService.setEqState34(state,userId,jcEqid);
		return new ResponseResult<Void>(SUCCESS);
	}

	//用户检测设备完毕、设置状态为:待上传
	@RequestMapping("/setEqState5/{userId}/{eqId}")
	public ResponseResult<Void> setEqState5(@PathVariable String userId,@PathVariable String eqId){
		userEqService.setEqState5(userId,eqId);
		return new ResponseResult<Void>(SUCCESS);
	}
	//用户检测设备完毕、设置状态为:审核中
	@RequestMapping("/setEqState6/{userId}/{eqId}")
	public ResponseResult<Void> setEqState6(@PathVariable String userId,@PathVariable String eqId){
		userEqService.setEqState6(userId,eqId);
		return new ResponseResult<Void>(SUCCESS);
	}
	//测试通过
	//查询用户未分配的检测设备
	@RequestMapping("/findJcEqNotByUserId/{userId}")
	public ResponseResult<List<EqInfo>> findJcEqNotByUserId(@PathVariable String userId){
		List<EqInfo> yqList=eqInfoService.findJcEqNotByUserId(userId);
		return new ResponseResult<List<EqInfo>>(SUCCESS,yqList);
	}

	//测试通过
	//查询所有未分配的审核设备
	//审核设备只能分配给一个审核人员
	@RequestMapping("/findShEqNotByUserId/{userId}")
	public ResponseResult<List<EqInfo>> findShEqNotByUserId(@PathVariable String userId){
		List<EqInfo> yqList=eqInfoService.findShEqNotByUserId(userId);
		return new ResponseResult<List<EqInfo>>(SUCCESS,yqList);
	}
	//同意不同意
	@RequestMapping("/setEqStateNotIs")
	public ResponseResult<Void> setEqStateNotIs(@RequestParam("jceqId")String jceqId,@RequestParam("userId")String userId){
		userEqService.setEqStateNotIs(jceqId,userId);
		return new ResponseResult<Void>(SUCCESS);
	}
	@RequestMapping("/setYqStateNotIs")
	public ResponseResult<Void> setYqStateNotIs(@RequestParam("jcyqId")String jcyqId,@RequestParam("eqId")String eqId,@RequestParam("state")Integer state){
		yqEqService.updateState(jcyqId,eqId,state);
		return new ResponseResult<Void>(SUCCESS);
	}
	//待上传
	@RequestMapping("/setEqTypeNotIs")
	public ResponseResult<Void> setEqTypeNotIs(@RequestParam("jceqId")String jceqId,HttpSession session){
		String userId=getUserIdFromSession(session);
		userEqService.setEqTypeNotIs(jceqId,userId);
		yqEqService.updateAllType(jceqId,EnumProcess2.IS_UPLOAD.getMessage());
		return new ResponseResult<Void>(SUCCESS);
	}
	//1:设备信息待审核
	@RequestMapping("/findJcDsh")
	public ResponseResult<List<UserEqVo>> findJcDsh(HttpSession session){
		String userId=getUserIdFromSession(session);
		List<UserEqVo> eqList=userEqService.findUserEqVo(userId, EnumProcess2.UNDER_REVIEW.getMessage());
		return new ResponseResult<List<UserEqVo>>(SUCCESS,eqList);
	}
	//2:审核完成
	@RequestMapping("/findJcShwc")
	public ResponseResult<List<UserEqVo>> findJcShwc(HttpSession session){
		String userId=getUserIdFromSession(session);
		List<UserEqVo> eqList=userEqService.findUserEqVo(userId, EnumProcess2.PERFECT_INFORMATION.getMessage());
		return new ResponseResult<List<UserEqVo>>(SUCCESS,eqList);
	}
	//2:检测审核成功
	@RequestMapping("/findJcShCg")
	public ResponseResult<List<UserEqVo>> findJcShCg(HttpSession session){
		String userId=getUserIdFromSession(session);
		List<UserEqVo> eqList=userEqService.findUserEqVo(userId, EnumProcess2.DETECTION_OF_AUDIT_IS.getMessage());
		return new ResponseResult<List<UserEqVo>>(SUCCESS,eqList);
	}
	//2:检测审核不成功
	@RequestMapping("/findJcShBcg")
	public ResponseResult<List<UserEqVo>> findJcShBcg(HttpSession session){
		String userId=getUserIdFromSession(session);
		List<UserEqVo> eqList=userEqService.findUserEqVo(userId, EnumProcess2.DETECTION_OF_AUDIT_NOT.getMessage());
		return new ResponseResult<List<UserEqVo>>(SUCCESS,eqList);
	}
	//3:审核不通过
	@RequestMapping("/findJcShbtg")
	public ResponseResult<List<UserEqVo>> findJcShbtg(HttpSession session){
		String userId=getUserIdFromSession(session);
		List<UserEqVo> eqList=userEqService.findUserEqVo(userId, EnumProcess2.AUTID_NOT.getMessage());
		return new ResponseResult<List<UserEqVo>>(SUCCESS,eqList);
	}
	//待上传
	@RequestMapping("/findEqDsc")
	public ResponseResult<List<UserEqVo>> findEqDsc(HttpSession session){
		String userId=getUserIdFromSession(session);
		List<UserEqVo> eqList=userEqService.findUserEqVo(userId, EnumProcess2.TO_UPLOAD.getMessage());
		return new ResponseResult<List<UserEqVo>>(SUCCESS,eqList);
	}
	//审核中
	@RequestMapping("/findEqShz")
	public ResponseResult<List<UserEqVo>> findEqShz(HttpSession session){
		String userId=getUserIdFromSession(session);
		List<UserEqVo> eqList=userEqService.findUserEqVo(userId, EnumProcess2.IN_REVIEW.getMessage());
		return new ResponseResult<List<UserEqVo>>(SUCCESS,eqList);
	}

	//待上报/审核上报不通过
	@RequestMapping("/findJcShdsbAndNot")
	public ResponseResult<List<UserEqVo>> findJcShdsbAndNot(HttpSession session){
		String userId=getUserIdFromSession(session);
		List<UserEqVo> eqList=userEqService.findUserEq(userId, EnumProcess2.TO_AUDIT.getMessage(),EnumProcess2.SHANG_AUTID_NOT.getMessage());
		return new ResponseResult<List<UserEqVo>>(SUCCESS,eqList);
	}
	//检测审核不通过
	@RequestMapping("/findShEqsByUserIdAndStateNot")
	public ResponseResult<List<EqInfo>> findShEqsByUserIdAndState(HttpSession session){
		String userId=getUserIdFromSession(session);
		List<EqInfo> eqList=eqInfoService.findShEqsByUserIdAndState(userId, EnumProcess2.DETECTION_OF_AUDIT_NOT.getMessage());
		return new ResponseResult<List<EqInfo>>(SUCCESS,eqList);
	}
	//检测审核成功
	@RequestMapping("/findShEqsByUserIdAndStateIs")
	public ResponseResult<List<EqInfo>> findShEqsByUserIdAndStateIs(HttpSession session){
		String userId=getUserIdFromSession(session);
		List<EqInfo> eqList=eqInfoService.findShEqsByUserIdAndState(userId, EnumProcess2.DETECTION_OF_AUDIT_IS.getMessage());
		return new ResponseResult<List<EqInfo>>(SUCCESS,eqList);
	}
}
