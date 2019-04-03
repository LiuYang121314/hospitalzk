package com.litbo.hospitalzj.supplier.controller;

import com.litbo.hospitalzj.controller.BaseController;
import com.litbo.hospitalzj.supplier.entity.District;
import com.litbo.hospitalzj.supplier.service.DistrictService;
import com.litbo.hospitalzj.util.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/district")
public class DistrictController extends BaseController {
	
	@Autowired
	private DistrictService districtService;
	
	@RequestMapping("/list/{parent}")
	public ResponseResult<List<District>> getListByParent(@PathVariable("parent") String parent) {
		List<District> list= districtService.getListByParent(parent);
		return new ResponseResult<List<District>>(SUCCESS, list);
	}
	/*@RequestMapping("/list/{parent}")
	public ResponseResult<List<District>> getByCode(@PathVariable("parent") String parent) {
		District list= districtService.getByCode(parent);
		return new ResponseResult<List<District>>(SUCCESS, list);
	}*/

}






