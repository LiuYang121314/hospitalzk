package com.litbo.hospitalzj.supplier.controller;

import com.litbo.hospitalzj.controller.BaseController;
import com.litbo.hospitalzj.supplier.entity.SBm;
import com.litbo.hospitalzj.supplier.service.SBmService;
import com.litbo.hospitalzj.util.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 设备来源控制层
 * @author 刘洋
 *
 */
@RestController
@RequestMapping("/sbm")
public class SBmController extends BaseController {
	@Autowired
	public SBmService sBmService;
	
	@RequestMapping("/update")
	public ResponseResult<Void> update(SBm sBm) {
		sBmService.update(sBm);
		return new ResponseResult<Void>(SUCCESS);
	}
	@RequestMapping("/selectAll")
	public ResponseResult<List<SBm>> getAll() {
		List<SBm> data=sBmService.findAll();
		return new ResponseResult<List<SBm>>(SUCCESS,data);
	}
	@RequestMapping("/select")
	public ResponseResult<SBm> getone(Integer bmId) {
		SBm data=sBmService.findById(bmId);
		return new ResponseResult<SBm>(SUCCESS,data);
	}
	@RequestMapping("/insert")
	public ResponseResult<Void> insert(SBm sBm) {
		System.out.println("11111111111"+sBm.getBmName());
		sBmService.insert(sBm);
		return new ResponseResult<Void>(SUCCESS);
	}
	@RequestMapping("/delete")
	public ResponseResult<Void> delete(Integer bmId) {
		sBmService.delete(bmId);
		return new ResponseResult<Void>(SUCCESS);
	}
	@RequestMapping("/findByBmNameLike")
	public ResponseResult<List<SBm>> findByBmNameLike(String bmName) {
		List<SBm> data=sBmService.findByBmNameLike(bmName);
		return new ResponseResult<List<SBm>>(SUCCESS,data);
	}
}
