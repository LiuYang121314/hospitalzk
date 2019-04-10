package com.litbo.hospitalzj.quality.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.litbo.hospitalzj.controller.BaseController;
import com.litbo.hospitalzj.quality.entity.EqPm;
import com.litbo.hospitalzj.quality.service.EqPmService;
import com.litbo.hospitalzj.util.ResponseResult;
/**
 * 设备品名控制层
 * @author 刘洋
 *
 */
@RestController
@RequestMapping("/eqpm")
public class EqPmController extends BaseController{
	@Autowired
	public EqPmService eqPmService;
	
	@RequestMapping("/{eqPmId}")
	public ResponseResult<EqPm> getByCode(@PathVariable("eqPmId") Integer eqPmId) {
		EqPm data= eqPmService.getById(eqPmId);
		return new ResponseResult<EqPm>(SUCCESS,data);
	}
	@RequestMapping("/all")
	public ResponseResult<List<EqPm>> getAll() {
		List<EqPm> data= eqPmService.getAll();
		return new ResponseResult<List<EqPm>>(SUCCESS,data);
	}
	@RequestMapping("/allEqPm")
	public ResponseResult<List<EqPm>> All() {
		List<EqPm> data= eqPmService.getAll();
		return new ResponseResult<List<EqPm>>(SUCCESS,data);
	}
	@RequestMapping("/insert")
	public ResponseResult<Void> insert(EqPm eqPm) {
		eqPmService.insert(eqPm);
		return new ResponseResult<Void>(SUCCESS);
	}
	@RequestMapping("/delete")
	public ResponseResult<Void> delete(Integer eqPmId) {
		eqPmService.delete(eqPmId,1);
		return new ResponseResult<Void>(SUCCESS);
	}
	@RequestMapping("/update")
	public ResponseResult<EqPm> update(EqPm eqPm) {
		EqPm data=eqPmService.update(eqPm);
		return new ResponseResult<EqPm>(SUCCESS,data);
	}
	@RequestMapping("/selectByEqPmNameLike")
	public ResponseResult<List<EqPm>> selectByEqPmNameLike(String eqPmName) {
		List<EqPm> data=eqPmService.findPmLike(eqPmName);
		return new ResponseResult<List<EqPm> >(SUCCESS,data);
	}
}
