package com.litbo.hospitalzj.supplier.controller;

import com.litbo.hospitalzj.controller.BaseController;
import com.litbo.hospitalzj.supplier.entity.EqFj;
import com.litbo.hospitalzj.supplier.entity.EqFseq;
import com.litbo.hospitalzj.supplier.service.EqFjService;
import com.litbo.hospitalzj.supplier.service.EqFseqService;
import com.litbo.hospitalzj.util.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/eqfseq")
public class EqFseqController extends BaseController{
	@Autowired
	private EqFseqService eqFseqService;
	@RequestMapping("/insert")
	public ResponseResult<Void> insertEqFj(EqFseq eqFseq){
		eqFseqService.insertEqFseq(eqFseq);
		return new ResponseResult<Void>(SUCCESS);
	}
	@RequestMapping("/updateInfo")
	public ResponseResult<Void> updateInfo(EqFseq eqFseq){
		eqFseqService.updateInfo(eqFseq);
		return new ResponseResult<Void>(SUCCESS);
	}
	@RequestMapping("/selectInfo")
	public ResponseResult<List<EqFj>> selectInfo(Integer eqIds){
		List<EqFj> eqFj=eqFseqService.selectEqFseq(eqIds);
		return new ResponseResult<List<EqFj>>(SUCCESS,eqFj);
	}
	@RequestMapping("/selectById")
	public ResponseResult<EqFseq> selectById(Integer eqFsid){
		EqFseq eqFseq=eqFseqService.selectById(eqFsid);
		return new ResponseResult<EqFseq>(SUCCESS,eqFseq);
	}
	@RequestMapping("/delete")
	public ResponseResult<Void> delete(Integer eqFsid){
		eqFseqService.delete(eqFsid);
		return new ResponseResult<Void>(SUCCESS);
	}
	
}
