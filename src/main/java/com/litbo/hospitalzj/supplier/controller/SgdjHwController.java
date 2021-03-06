package com.litbo.hospitalzj.supplier.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.litbo.hospitalzj.hospital.enums.EnumProcess;
import com.litbo.hospitalzj.supplier.entity.HtInfo;
import com.litbo.hospitalzj.supplier.service.HtInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.litbo.hospitalzj.controller.BaseController;
import com.litbo.hospitalzj.supplier.controller.ex.FileUploadException;
import com.litbo.hospitalzj.supplier.entity.SgdjHw;
import com.litbo.hospitalzj.supplier.service.SgdjHwService;
import com.litbo.hospitalzj.util.ResponseResult;
import org.springframework.web.context.support.HttpRequestHandlerServlet;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/sgdjhw")
public class SgdjHwController extends BaseController{
	@Autowired
	private SgdjHwService sgdjHwService;
	@Autowired
	private HtInfoService htinfoService;
	@RequestMapping("/select")
	public ResponseResult<SgdjHw> select(Integer htIds) {
		SgdjHw all= sgdjHwService.selectSgdjHw(htIds);
		return new ResponseResult<SgdjHw>(SUCCESS,all);
	}
	@RequestMapping(value = "/insert",method = RequestMethod.POST)
	public ResponseResult<Void> insert(SgdjHw sgdjHw) {
		sgdjHwService.InsertSgdjHw(sgdjHw);
		return new ResponseResult<Void>(SUCCESS);
	}
	@RequestMapping("/updateInfo")
	public ResponseResult<Void> updateInfo(SgdjHw sgdjHw) {
		System.out.println(sgdjHw.getDjhwSbwg());
		System.out.println(sgdjHw.getDjhwSxwj());
		sgdjHwService.updateInfo(sgdjHw);
	/*	htinfoService.updateHtInfoState(sgdjHw.getHtIds(), EnumProcess.PERFECT_INFORMATION.getMessage());*/
		return new ResponseResult<Void>(SUCCESS);
	}
/*	//同意验收数量
	@RequestMapping("/countByTyys")
	public ResponseResult<Integer> countByTyys() {
		Integer all= sgdjHwService.count(EnumProcess.TONG_YI_YANSHOU.getMessage());
		return new ResponseResult<Integer>(SUCCESS,all);
	}*/
	/*//等待审核验收数量
	@RequestMapping("/countByDdshys")
	public ResponseResult<Integer> countByDdshys() {
		Integer all= sgdjHwService.count(EnumProcess.WAIT_ACCEPT_YS.getMessage());
		return new ResponseResult<Integer>(SUCCESS,all);
	}*/
}
