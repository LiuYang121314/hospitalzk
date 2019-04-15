package com.litbo.hospitalzj.supplier.controller;

import com.litbo.hospitalzj.controller.BaseController;
import com.litbo.hospitalzj.supplier.entity.JgLx;
import com.litbo.hospitalzj.supplier.entity.QyLx;
import com.litbo.hospitalzj.supplier.service.JgLxService;
import com.litbo.hospitalzj.supplier.service.QyLxService;
import com.litbo.hospitalzj.util.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/jglx")
public class JgLxController extends BaseController{
	@Autowired
	public JgLxService jgLxService;
	
	@RequestMapping("/insert")
	public ResponseResult<Void> getByCode(JgLx jgLx) {
		jgLxService.insert(jgLx);
		return new ResponseResult<Void>(SUCCESS);
	}
	@RequestMapping("/all")
	public ResponseResult<List<JgLx>> getAll() {
		List<JgLx> data=jgLxService.findAll();
		return new ResponseResult<List<JgLx>>(SUCCESS,data);
	}
	@RequestMapping("/allJgLx")
	public ResponseResult<List<JgLx>> All() {
		List<JgLx> data=jgLxService.findAll();
		return new ResponseResult<List<JgLx>>(SUCCESS,data);
	}
	@RequestMapping("/delete")
	public ResponseResult<Void> delete(Integer jgId) {
		jgLxService.delete(jgId);
		return new ResponseResult<Void>(SUCCESS);
	}
	@RequestMapping("/update")
	public ResponseResult<Void> update(JgLx jgLx) {
		jgLxService.update(jgLx);
		return new ResponseResult<Void>(SUCCESS);
	}
	@RequestMapping("/findByJgLxNameLike")
	public ResponseResult<List<JgLx>> findByJgLxNameLike(String jgLxmc) {
		List<JgLx> data=jgLxService.findByJgLxNameLike(jgLxmc);
		return new ResponseResult<List<JgLx>>(SUCCESS,data);
	}
}
