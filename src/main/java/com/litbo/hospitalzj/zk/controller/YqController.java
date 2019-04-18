package com.litbo.hospitalzj.zk.controller;

import java.util.List;

import com.litbo.hospitalzj.quality.mapper.UserPmMapper;
import com.litbo.hospitalzj.quality.service.UserPmService;
import com.litbo.hospitalzj.zk.domian.UserEq;
import com.litbo.hospitalzj.zk.domian.YqJxjl;
import com.litbo.hospitalzj.zk.service.NdjhService;
import com.litbo.hospitalzj.zk.service.UserEqService;
import com.litbo.hospitalzj.zk.service.YqJxjlService;
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
	private NdjhService ndjhService;
	@Autowired
	private YqJxjlService yqJxjlService;
	//仪器模糊查询
	@RequestMapping("/findYqByYqNameLike")
	public ResponseResult<List<Yq>> findYqByYqNameLike(String jcyqName){
		List<Yq> data=yqService.findYqByYqNameLike(jcyqName);
		return new ResponseResult<List<Yq>>(SUCCESS,data);
	}
	//新增仪器
	@RequestMapping("/insert")
	public ResponseResult<Void> insert(Yq yq){
		yq.setIsDelete(0);
		yqService.insert(yq);
		YqJxjl data=new YqJxjl();
		data.setYqId(Integer.valueOf(yq.getJcyqId()));
		data.setYqJxtime(yq.getJcyqQyTime());
		yqJxjlService.insert(data);
		return new ResponseResult<Void>(SUCCESS);
	}
	//删除仪器
	@RequestMapping("/delete/{jcyqId}")
	public ResponseResult<Void> delete(@PathVariable Integer jcyqId){
		yqService.delete(jcyqId);
		return new ResponseResult<Void>(SUCCESS);
	}
	//查询所有仪器
	@RequestMapping("/findAll")
	public ResponseResult<List<Yq>> findAll(){
		List<Yq> yqList=yqService.findAll();
		return new ResponseResult<List<Yq>>(SUCCESS,yqList);
	}
	@RequestMapping("/findById")
	public ResponseResult<Yq> findById(Integer jcyqId){
		Yq yqList=yqService.findById(jcyqId);
		return new ResponseResult<Yq>(SUCCESS,yqList);
	}
	//修改仪器
	@RequestMapping("/update")
		public ResponseResult<Void> update(Yq yq){
		
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
	public ResponseResult<EqInfo> selectEqInfo(@RequestParam("eqDah") String eqDah,@RequestParam("ndjhId") String ndjhId,HttpSession session){
		EqInfo data=yqService.selectEqInfo(eqDah);
		ndjhService.updateMonth(Integer.valueOf(ndjhId));
		return new ResponseResult<EqInfo>(SUCCESS,data);
	}

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
}
