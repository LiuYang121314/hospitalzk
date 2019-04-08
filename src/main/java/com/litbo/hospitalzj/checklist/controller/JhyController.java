package com.litbo.hospitalzj.checklist.controller;

import com.litbo.hospitalzj.checklist.domain.Dcsjhy;
import com.litbo.hospitalzj.checklist.domain.DcsjhyTemplate;
import com.litbo.hospitalzj.checklist.service.DcsjhyService;
import com.litbo.hospitalzj.checklist.utils.commons.CommonUtils;
import com.litbo.hospitalzj.checklist.vo.JhyUser;
import com.litbo.hospitalzj.controller.BaseController;
import com.litbo.hospitalzj.supplier.service.EqInfoService;
import com.litbo.hospitalzj.util.ResponseResult;
import com.litbo.hospitalzj.zk.Enum.EnumProcess2;
import com.litbo.hospitalzj.zk.service.UserEqService;

import com.litbo.hospitalzj.zk.service.YqEqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.List;

@RestController
@RequestMapping("/jhy")
public class JhyController extends BaseController {


	@Autowired
	private DcsjhyService dcsjhyService;
	
	@Autowired
    private UserEqService userEqService;

	@Autowired
	private EqInfoService eqinfoService;
	@Autowired
	private YqEqService yqEqService;

	/**
	 *  查询多参数监护仪模板表数据
	 * @return
	 */
	//成人
	@RequestMapping("/findTemplateMan")
	public ResponseResult<DcsjhyTemplate> findTemplateMan(){
		DcsjhyTemplate dcsjhyTemplate = dcsjhyService.findTemplateMan();
		return new ResponseResult<DcsjhyTemplate>(200, dcsjhyTemplate);
	}
	//幼儿
	@RequestMapping("/findTemplateChild")
	public ResponseResult<DcsjhyTemplate> findTemplateChild(){
		DcsjhyTemplate dcsjhyTemplate = dcsjhyService.findTemplateChild();
		return new ResponseResult<DcsjhyTemplate>(200, dcsjhyTemplate);
	}

	/**
	 * 插入模板表数据
	 * @param dcsjhyTemplate
	 * @return
	 */
	//成人
	@RequestMapping("/insertM")
	public ResponseResult<Void> insertM(DcsjhyTemplate dcsjhyTemplate){
		dcsjhyService.insertM(dcsjhyTemplate);
		return new ResponseResult<Void>(200);
	}
	//幼儿
	@RequestMapping("/insertC")
	public ResponseResult<Void> insertC(DcsjhyTemplate dcsjhyTemplate){
		dcsjhyService.insertC(dcsjhyTemplate);
		return new ResponseResult<Void>(200);
	}

	/**
	 * 修改模板表数据
	 * @param dcsjhyTemplate
	 * @return
	 */
	//成人
	@RequestMapping("/updateM")
	public ResponseResult<Void> updateM(DcsjhyTemplate dcsjhyTemplate){
		dcsjhyService.updateM(dcsjhyTemplate);
		return new ResponseResult<Void>(200);
	}
	//幼儿
	@RequestMapping("/updateC")
	public ResponseResult<Void> updateC(DcsjhyTemplate dcsjhyTemplate){
		dcsjhyService.updateC(dcsjhyTemplate);
		return new ResponseResult<Void>(200);
	}
	/**
	 * 保存成人检测数据
	 * @param eqId
	 * @param jcyqId
	 * @param req
	 * @return
	 */
	@RequestMapping("/saveman")
	public ResponseResult<Integer> saveMan(
			@RequestParam("eqId")String eqId,
			@RequestParam("jcyqId") String jcyqId,
			HttpSession session,
			HttpServletRequest req){
		Dcsjhy dcsjhy = CommonUtils.toBean(req.getParameterMap(), Dcsjhy.class);
		String userId=String.valueOf(session.getAttribute("uid").toString());
		dcsjhyService.delectMen(eqId, jcyqId);
		dcsjhy.setState(0);
		yqEqService.insertBatch(eqId,jcyqId);
		yqEqService.updateType(jcyqId,eqId,EnumProcess2.TO_UPLOAD.getMessage());
		userEqService.setEqState5(userId,eqId);
		dcsjhyService.saveMan(dcsjhy);
		return new ResponseResult<Integer>(200, dcsjhy.getDcid());
	}

	/**
	 * 保存幼儿检测数据
	 * @param eqId
	 * @param req
	 * @return
	 */
	@RequestMapping("/savechild")
	public ResponseResult<Integer> saveChild(
			@RequestParam("eqId")String eqId,
			@RequestParam("jcyqId") String jcyqId,
			HttpSession session,
			HttpServletRequest req){
		Dcsjhy dcsjhy = CommonUtils.toBean(req.getParameterMap(), Dcsjhy.class);
	    String userId=String.valueOf(session.getAttribute("uid").toString());
		dcsjhyService.delectChi(eqId, jcyqId);
		dcsjhy.setState(0);
		yqEqService.insertBatch(eqId,jcyqId);
		yqEqService.updateType(jcyqId,eqId, EnumProcess2.TO_UPLOAD.getMessage());
		userEqService.setEqState5(userId,eqId);
		dcsjhyService.saveChild(dcsjhy);
		return new ResponseResult<Integer>(200, dcsjhy.getDcid());
	}

	/**
	 * 查询单条多参数监护仪检测数据(成人)单条数据
	 * @return
	 */
	@RequestMapping("/findman")
	public ResponseResult<Dcsjhy> findMan(){
		return new ResponseResult<Dcsjhy>(200, dcsjhyService.findDcsjhyMan());
	}

	/**
	 * 查询单条多参数监护仪检测数据(成人)多条数据
	 * @return
	 */
	@RequestMapping("/findmans")
	public ResponseResult<List<Dcsjhy>> findMans(){
		return new ResponseResult<List<Dcsjhy>>(200, dcsjhyService.findDcsjhyMans());
	}

	/**
	 * 查询单条多参数监护仪检测数据
	 * @return
	 */
	@RequestMapping("/findchild")
	public ResponseResult<Dcsjhy> findChild(){
		return new ResponseResult<Dcsjhy>(200, dcsjhyService.findDcsjhyChild());
	}


	/**
	 * 查询单条多参数监护仪检测数据
	 * @return
	 */
	@RequestMapping("/findchilds")
	public ResponseResult<List<Dcsjhy>> findChilds(){
		return new ResponseResult<List<Dcsjhy>>(200, dcsjhyService.findDcsjhyChilds());
	}
	@RequestMapping("/findch")
	public ResponseResult<Dcsjhy> findch(@RequestParam("eqId")String eqId,@RequestParam("jcyqId")String jcyqId){
		Dcsjhy data=dcsjhyService.findByEqIdandJcyqIdCh(eqId, jcyqId);
		return new ResponseResult<Dcsjhy>(200, data);
	}
	@RequestMapping("/findMa")
	public ResponseResult<Dcsjhy> findMa(@RequestParam("eqId")String eqId,@RequestParam("jcyqId")String jcyqId){
		Dcsjhy data=dcsjhyService.findByEqIdandJcyqIdMan(eqId, jcyqId);
		return new ResponseResult<Dcsjhy>(200, data);
	}
	//修改状态
	@RequestMapping("/updateStateM")
	public ResponseResult<Void> updateStateM(@RequestParam("eqId")String eqId, @RequestParam("jcyqId")String jcyqId,HttpSession session){
		yqEqService.updateState(jcyqId,eqId,0);
		yqEqService.updateType(jcyqId,eqId,EnumProcess2.IS_UPLOAD.getMessage());
		userEqService.setJcEqState2(getUserIdFromSession(session),eqId);
		return new ResponseResult<Void>(200);
	}
	@RequestMapping("/updateStateC")
	public ResponseResult<Void> updateStateC(@RequestParam("eqId")String eqId, @RequestParam("jcyqId")String jcyqId,HttpSession session){
		yqEqService.updateState(jcyqId,eqId,0);
		yqEqService.updateType(jcyqId,eqId,EnumProcess2.IS_UPLOAD.getMessage());
		userEqService.setJcEqState2(getUserIdFromSession(session),eqId);
		return new ResponseResult<Void>(200);
	}
	//修改仪器为已上传
	//修改状态
	@RequestMapping("/updateType")
	public ResponseResult<Void> updateType(@RequestParam("eqId")String eqId, @RequestParam("jcyqId")String jcyqId,HttpSession session){
		yqEqService.updateState(jcyqId,eqId,0);
		yqEqService.updateType(jcyqId,eqId,EnumProcess2.IS_UPLOAD.getMessage());
		return new ResponseResult<Void>(200);
	}
	//根据id状态查询
	@RequestMapping("/findByDcidM")
	public ResponseResult<Dcsjhy> findByDcidM(Integer dcid){
		Dcsjhy data=dcsjhyService.findByDcidM(dcid,0);
		return new ResponseResult<Dcsjhy>(200,data);
	}
	@RequestMapping("/findByDcidC")
	public ResponseResult<Dcsjhy> findByDcidC(Integer dcid){
		Dcsjhy data=dcsjhyService.findByDcidC(dcid,0);
		return new ResponseResult<Dcsjhy>(200,data);
	}
	/**
	 * 查找审核人，审核人意见(成人)
	 */
	@RequestMapping("/findShrAndShrjcjlM")
	public ResponseResult<JhyUser> findShrAndShrjcjlM(@RequestParam("eqId")String eqId, @RequestParam("jcyqId")String jcyqId){
		JhyUser data=dcsjhyService.findShrAndShrjcjlM(eqId,jcyqId,0);
		return new ResponseResult<JhyUser>(200,data);
	}
	@RequestMapping("/findShrAndShrjcjlC")
	public ResponseResult<JhyUser> findShrAndShrjcjlC(@RequestParam("eqId")String eqId, @RequestParam("jcyqId")String jcyqId){
		JhyUser data=dcsjhyService.findShrAndShrjcjlC(eqId,jcyqId,0);
		return new ResponseResult<JhyUser>(200,data);
	}
	//修改审核人建议同时修改状态
	@RequestMapping("/updateShrJcjyM")
	public ResponseResult<Void> updateShrJcjyM(@RequestParam("dcid")Integer dcid, @RequestParam("jcyqId")String jcyqId,@RequestParam("eqId")String eqId,@RequestParam("shrJcjl")String shrJcjl,@RequestParam("state")Integer state,HttpSession session){
		String auditor=getUserNameFromSession(session);
		dcsjhyService.updateShrJcjyM(dcid,shrJcjl,auditor);
		if(state.equals(1)){
			yqEqService.updateState(jcyqId,eqId,1);
		}else{
			yqEqService.updateState(jcyqId,eqId,2);
		}
		return new ResponseResult<Void>(200);
	}
	@RequestMapping("/updateShrJcjyC")
	public ResponseResult<Void> updateShrJcjyC(@RequestParam("dcid")Integer dcid, @RequestParam("jcyqId")String jcyqId,@RequestParam("eqId")String eqId,@RequestParam("shrJcjl")String shrJcjl,@RequestParam("state")Integer state,HttpSession session){
		String auditor=getUserNameFromSession(session);
		dcsjhyService.updateShrJcjyC(dcid,shrJcjl,auditor);
		if(state.equals(1)){
			yqEqService.updateState(jcyqId,eqId,1);
		}else{
			yqEqService.updateState(jcyqId,eqId,2);
		}
		return new ResponseResult<Void>(200);
	}
}
