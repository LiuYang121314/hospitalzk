package com.litbo.hospitalzj.zk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.litbo.hospitalzj.controller.BaseController;
import com.litbo.hospitalzj.sf.service.UserService;
import com.litbo.hospitalzj.sf.entity.User;
import com.litbo.hospitalzj.util.ResponseResult;
import com.litbo.hospitalzj.zk.domian.Yq;
import com.litbo.hospitalzj.zk.service.YqRoleService;
import com.litbo.hospitalzj.zk.service.YqService;

@RestController
@RequestMapping("/yqRole")
public class YqRoleController extends BaseController{

	@Autowired
	private YqRoleService yqRoleService;
	@Autowired 
	private YqService yqService;
	@Autowired
	private UserService suserService;
	
//	//为人员分配仪器
//	@RequestMapping("/insert")
//	public ResponseResult<Void> insert(String userId,String yqId){
//		YqRole yqRole=new YqRole();
//		yqRole.setUserId("1");
//		yqRole.setYqId("4");
//		yqRoleService.insert(yqRole);
//		return new ResponseResult<Void>(SUCCESS);
//	}
	
	
//	//删除人员的仪器
//	@RequestMapping("/delete")
//	public ResponseResult<Void> delete(String userId,String eyId){
//		YqRole yqRole=new YqRole();
//		yqRole.setUserId("1");
//		yqRole.setYqId("6");
//		yqRoleService.delete(yqRole);
//		return new ResponseResult<Void>(SUCCESS);
//	}
	
	@RequestMapping("/insertBatch")
	public ResponseResult<Void> insertBatch(String userId,int status,String[] yqId){
		yqRoleService.insertBatch(userId,status,yqId);
		return new ResponseResult<Void>(SUCCESS);
	}
	
	@RequestMapping("/deleteBatch")
	public ResponseResult<Void> deleteBatch(String userId,String[] yqId){
		yqRoleService.deleteBatch(userId,yqId);
		return new ResponseResult<Void>(SUCCESS);
	}
	
	//查询人员已分配的仪器
	@RequestMapping("/findByUserId")
	public ResponseResult<List<Yq>> findByUserId(String userId){
		List<Yq> yqList=yqService.findByUserId("1");
		return new ResponseResult<List<Yq>>(SUCCESS,yqList);
	}
	
	//查询人员未分配的仪器
	@RequestMapping("/findNotByUserId")
	public ResponseResult<List<Yq>> findNotByUserId(String userId){
		List<Yq> yqList=yqService.findNotByUserId("1");
		for(int i=0;i<yqList.size();i++){
			System.out.println(yqList.get(i));
		}
		return new ResponseResult<List<Yq>>(SUCCESS,yqList);
	}
	
	@RequestMapping("/userList")
	public ResponseResult<List<User>> findAll(){
		List<User> userList=suserService.findAll();
		return new ResponseResult<List<User>>(SUCCESS,userList);
	}
	
	
}
