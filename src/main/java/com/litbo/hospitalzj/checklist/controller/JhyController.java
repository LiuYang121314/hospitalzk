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
import com.litbo.hospitalzj.zk.domian.TabEq;
import com.litbo.hospitalzj.zk.service.TabEqService;
import com.litbo.hospitalzj.zk.service.UserEqService;

import com.litbo.hospitalzj.zk.service.YqEqService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/jhy")
public class JhyController extends BaseController {


	@Autowired
	private DcsjhyService dcsjhyService;
	
	@Autowired
    private UserEqService userEqService;

	@Autowired
	private TabEqService tabEqService;
	@Autowired
	private YqEqService yqEqService;
	/**
	 *  查询多参数监护仪模板表数据
	 * @return
	 */
	//成人
	@RequestMapping("/findTemplateMan")
	public ResponseResult<DcsjhyTemplate> findTemplateMan(){
		DcsjhyTemplate dcsjhyTemplate = dcsjhyService.findTemplate_m();
		return new ResponseResult<DcsjhyTemplate>(200, dcsjhyTemplate);
	}

	//幼儿
	@RequestMapping("/findTemplateChild")
	public ResponseResult<DcsjhyTemplate> findTemplateChild(){
		DcsjhyTemplate dcsjhyTemplate = dcsjhyService.findTemplate_c();
		return new ResponseResult<DcsjhyTemplate>(200, dcsjhyTemplate);
	}

	/**
	 * 插入模板表数据
	 * @param dcsjhyTemplate
	 * @return
	 */
	//成人
	@RequestMapping("/insertTemplateM")
	public ResponseResult<Void> insertTemplateM(DcsjhyTemplate dcsjhyTemplate){
		dcsjhyService.insertM(dcsjhyTemplate);
		return new ResponseResult<Void>(200);
	}
	//幼儿
	@RequestMapping("/insertTemplateC")
	public ResponseResult<Void> insertTemplateC(DcsjhyTemplate dcsjhyTemplate){
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
	public ResponseResult saveMan(
			@RequestParam("eqId")String eqId,
			@RequestParam("jcyqId") String jcyqId,
			@RequestParam("userEqId") Integer userEqId,
			HttpSession session,
			HttpServletRequest req){
		Dcsjhy dcsjhy = CommonUtils.toBean(req.getParameterMap(), Dcsjhy.class);
		int yqEqId=yqEqService.insertBatch(eqId,jcyqId);
		yqEqService.updateType(yqEqId,EnumProcess2.TO_UPLOAD.getMessage());
		//修改状态为待上传
		userEqService.setEqState(userEqId,EnumProcess2.TO_UPLOAD.getMessage());
		dcsjhyService.saveMan(dcsjhy);
		TabEq table=new TabEq();
		table.setEqId(Integer.valueOf(eqId));
		table.setJcyqId(Integer.valueOf(jcyqId));
		table.setTableName("dcsjhy_m");
		table.setValue(2);
		tabEqService.insert(table);
		int[] x={dcsjhy.getDcid(),yqEqId};
		return new ResponseResult<>(200, x);
	}

	/**
	 * 保存幼儿检测数据
	 * @param eqId
	 * @param req
	 * @return
	 */
	@RequestMapping("/savechild")
	public ResponseResult saveChild(
			@RequestParam("eqId")String eqId,
			@RequestParam("jcyqId") String jcyqId,
			@RequestParam("userEqId") Integer userEqId,
			HttpSession session,
			HttpServletRequest req){
		Dcsjhy dcsjhy = CommonUtils.toBean(req.getParameterMap(), Dcsjhy.class);
		int yqEqId=yqEqService.insertBatch(eqId,jcyqId);
		yqEqService.updateType(yqEqId, EnumProcess2.TO_UPLOAD.getMessage());
		userEqService.setEqState(userEqId,EnumProcess2.TO_UPLOAD.getMessage());
		dcsjhyService.saveChild(dcsjhy);
		TabEq table=new TabEq();
		table.setEqId(Integer.valueOf(eqId));
		table.setJcyqId(Integer.valueOf(jcyqId));
		table.setTableName("dcsjhy_c");
		table.setValue(1);
		tabEqService.insert(table);
		int[] x={dcsjhy.getDcid(),yqEqId};
		return new ResponseResult<>(200, x);
	}

	//成人
	@RequestMapping("/updateMen")
	public ResponseResult<Void> updateMen(Dcsjhy dcsjhy){
		dcsjhyService.updateMen(dcsjhy);
		return new ResponseResult<Void>(200);
	}
	//幼儿
	@RequestMapping("/updateChild")
	public ResponseResult<Void> updateC(Dcsjhy dcsjhy){
		dcsjhyService.updateChild(dcsjhy);
		return new ResponseResult<Void>(200);
	}

	@RequestMapping("/findByEqIdandJcyqIdLast1")
	public ResponseResult findByEqIdandJcyqIdLast1(@RequestParam("eqId")String eqId,@RequestParam("jcyqId") String jcyqId){
		TabEq table=tabEqService.findTable(Integer.valueOf(eqId),Integer.valueOf(jcyqId));
		Dcsjhy data=dcsjhyService.findByEqIdandJcyqIdLast(table.getTableName(),eqId,jcyqId);
		return new ResponseResult(200,data);
	}
	@RequestMapping("/findByEqIdandJcyqId")
	public ResponseResult<List<Dcsjhy>> findByEqIdandJcyqId(@RequestParam("eqId")String eqId,@RequestParam("jcyqId") String jcyqId){
		TabEq table=tabEqService.findTable(Integer.valueOf(eqId),Integer.valueOf(jcyqId));
		List<Dcsjhy> data=dcsjhyService.findByEqIdandJcyqId(table.getTableName(),eqId,jcyqId);
		List list= new ArrayList();
		return new ResponseResult<List<Dcsjhy>>(200,data);
	}


	@RequestMapping("/findDcsjhyMans")
	public ResponseResult<List<Dcsjhy>> findDcsjhyMans(){
		List<Dcsjhy> data=dcsjhyService.findDcsjhyMans();
		return new ResponseResult<List<Dcsjhy>>(200,data);
	}

	@RequestMapping("/findDcsjhyChilds")
	public ResponseResult<List<Dcsjhy>> findDcsjhyChilds(){
		List<Dcsjhy> data=dcsjhyService.findDcsjhyChilds();
		return new ResponseResult<List<Dcsjhy>>(200,data);
	}

	@RequestMapping("/findByDcidM")
	public ResponseResult<Dcsjhy> findByDcidM(Integer dcid){
		Dcsjhy data=dcsjhyService.findByDcidM(dcid);
		return new ResponseResult<Dcsjhy>(200,data);
	}
	@RequestMapping("/findByDcidC")
	public ResponseResult<Dcsjhy> findByDcidC(Integer dcid){
		Dcsjhy data=dcsjhyService.findByDcidC(dcid);
		return new ResponseResult<Dcsjhy>(200,data);
	}

	//修改审核人建议同时修改状态
	@RequestMapping("/updateShrJcjyM")
	public ResponseResult<Void> updateShrJcjyM(@RequestParam("dcid")Integer dcid,  @RequestParam("jcyqId")Integer jcyqId,
		@RequestParam("eqId")Integer eqId,@RequestParam("shrJcjl")String shrJcjl,@RequestParam("state")Integer state,HttpSession session){
		String auditor=getUserNameFromSession(session);
		Integer yqEqId= yqEqService.findId(jcyqId,eqId);
		dcsjhyService.updateShrJcjyM(dcid,shrJcjl,auditor);
		if(state.equals(1)){
			yqEqService.updateState(yqEqId,1);
		}else{
			yqEqService.updateState(yqEqId,2);
		}
		return new ResponseResult<Void>(200);
	}
	@RequestMapping("/updateShrJcjyC")
	public ResponseResult<Void> updateShrJcjyC(@RequestParam("dcid")Integer dcid, @RequestParam("jcyqId")Integer jcyqId,
        @RequestParam("eqId")Integer eqId,@RequestParam("shrJcjl")String shrJcjl,@RequestParam("state")Integer state,HttpSession session){
		String auditor=getUserNameFromSession(session);
		Integer yqEqId= yqEqService.findId(jcyqId,eqId);
		dcsjhyService.updateShrJcjyC(dcid,shrJcjl,auditor);
		if(state.equals(1)){
			yqEqService.updateState(yqEqId,1);
		}else{
			yqEqService.updateState(yqEqId,2);
		}
		return new ResponseResult<Void>(200);
	}
}
