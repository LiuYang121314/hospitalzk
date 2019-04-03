package com.litbo.hospitalzj.zk.controller;

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

	@RequestMapping("/insertEq")
	public String insert(){
		EqInfo dt=new EqInfo();
		dt.setEqMc("小刀");
		eqInfoService.insert(dt);
		return "success";
	}

	@RequestMapping("/deleteEq")
	public String delete(){
		String id="f1f98c86-e26d-4b8d-85bc-154b67f5ffee";
		eqInfoService.delete(id);
		return "deleteSuccess";
	}

	@RequestMapping("/findAllEq")
	public List<EqInfo> findAll(){
		return eqInfoService.findAll();
	}

	@RequestMapping("/findAll1Eq")
	public ResponseResult<List<EqInfo>> findAll1(){
		List<EqInfo> dataList=eqInfoService.findAll();
		return new ResponseResult<List<EqInfo>>(SUCCESS,dataList);
	}

	@RequestMapping("/findEqYqs/{eqId}")
	public ResponseResult<EqToYqs> findEqYqs(@PathVariable String eqId){
		EqToYqs eqToYqs=eqInfoService.findEqYqs(eqId);
		return new ResponseResult<EqToYqs>(SUCCESS,eqToYqs);
	}

	@RequestMapping("/findEqById/{eqId}")
	public ResponseResult<List<EqInfo>> findEqById(@PathVariable String eqId){
		EqInfo eqInfo=eqInfoService.findEqById(eqId);
		List<EqInfo> list=new ArrayList<EqInfo>();
		list.add(eqInfo);
		return new ResponseResult<List<EqInfo>>(SUCCESS,list);
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
	/*@PostMapping("/save")
	public String addUser(@RequestParam("file") MultipartFile file) {
		String fileName = file.getOriginalFilename();
		try {
			return sysService.batchImport(fileName, file);
		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}catch(Exception e){
			e.printStackTrace();
			return "文件异常,导入失败";

		}
	}*/
}
