package com.litbo.hospitalzj.quality.controller;

import com.litbo.hospitalzj.controller.BaseController;
import com.litbo.hospitalzj.quality.entity.EqPm;
import com.litbo.hospitalzj.quality.entity.EqXeq;
import com.litbo.hospitalzj.quality.service.EqPmService;
import com.litbo.hospitalzj.quality.service.EqXeqService;
import com.litbo.hospitalzj.util.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 设备品名控制层
 * @author 刘洋
 *
 */
@RestController
@RequestMapping("/eqxeq")
public class EqXeqController extends BaseController{
	@Autowired
	public EqXeqService eqXeqService;

	@RequestMapping("/allEqXeq")
	public ResponseResult<List<EqXeq>> All() {
		List<EqXeq> data= eqXeqService.all();
		return new ResponseResult<List<EqXeq>>(SUCCESS,data);
	}


	@RequestMapping("/insert")
	public ResponseResult<Void> insert(EqXeq eqXeq) {
		eqXeqService.insert(eqXeq);
		return new ResponseResult<Void>(SUCCESS);
	}
	@RequestMapping("/delete")
	public ResponseResult<Void> delete(Integer Id) {
		eqXeqService.delete(Id);
		return new ResponseResult<Void>(SUCCESS);
	}
	@RequestMapping("/update")
	public ResponseResult<EqXeq> update(EqXeq eqXeq) {
		eqXeqService.update(eqXeq);
		return new ResponseResult<EqXeq>(SUCCESS);
	}
	@RequestMapping("/selectByEqPmNameLike")
	public ResponseResult<List<EqXeq>> selectByEqPmNameLike(String eqData) {
		List<EqXeq> data=eqXeqService.findEqXeqLike(eqData);
		return new ResponseResult<List<EqXeq> >(SUCCESS,data);
	}

}
