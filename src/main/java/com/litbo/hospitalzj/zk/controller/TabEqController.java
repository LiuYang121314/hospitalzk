package com.litbo.hospitalzj.zk.controller;

import com.litbo.hospitalzj.controller.BaseController;
import com.litbo.hospitalzj.quality.service.UserPmService;
import com.litbo.hospitalzj.util.ResponseResult;
import com.litbo.hospitalzj.zk.domian.EqInfo;
import com.litbo.hospitalzj.zk.domian.TabEq;
import com.litbo.hospitalzj.zk.domian.Yq;
import com.litbo.hospitalzj.zk.domian.YqJxjl;
import com.litbo.hospitalzj.zk.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/tableName")
public class TabEqController extends BaseController{

	@Autowired
	private TabEqService tabEqService;

	//查询表名称  区分成人幼儿
	@RequestMapping("/findTable")
	public ResponseResult<Integer> findTable(@RequestParam("eqId") Integer eqId,@RequestParam("jcyqId") Integer jcyqId){
		TabEq table=tabEqService.findTable(eqId,jcyqId);
		System.out.println(table.getValue());
		return new ResponseResult<Integer>(SUCCESS,table.getValue());
	}
}
