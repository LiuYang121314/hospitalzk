package com.litbo.hospitalzj.quality.controller;

import com.litbo.hospitalzj.controller.BaseController;
import com.litbo.hospitalzj.quality.entity.EqPm;
import com.litbo.hospitalzj.quality.entity.YqPm;
import com.litbo.hospitalzj.quality.service.EqPmService;
import com.litbo.hospitalzj.quality.service.YqPmService;
import com.litbo.hospitalzj.util.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 设备品名控制层
 * @author 刘洋
 *
 */
@RestController
@RequestMapping("/yqpm")
public class YqPmController extends BaseController{
	@Autowired
	public YqPmService yqPmService;
	@Autowired
	public EqPmService eqPmService;

	@RequestMapping("/insert")
	public ResponseResult<Void> insert(YqPm yqPm) {
		yqPmService.insert(yqPm);
		return new ResponseResult<Void>(SUCCESS);
	}
	@RequestMapping("/delete/{yqId}/{eqPmId}")
	public ResponseResult<Void> delete(@PathVariable String yqId,@PathVariable String eqPmId) {
		yqPmService.delete(yqId,eqPmId);
		return new ResponseResult<Void>(SUCCESS);
	}
	////通过yqId查询分配的设备pm
	@RequestMapping("/findYqPmByYqId/{yqId}")
	public ResponseResult<List<EqPm>> findYqPmByYqId(@PathVariable String yqId){
		List<EqPm> data=eqPmService.findYqPmByYqId(yqId);
		return new ResponseResult<List<EqPm>>(SUCCESS,data);
	}
	//测试通过
	//通过yqId查询未分配的设备pm
	@RequestMapping("/findYqPmNotByYqId/{yqId}")
	public ResponseResult<List<EqPm>> findYqPmNotByYqId(@PathVariable String yqId) {
		List<EqPm> data = eqPmService.findYqPmNotByYqId(yqId);
		return new ResponseResult<List<EqPm>>(SUCCESS, data);
	}
}
