package com.litbo.hospitalzj.zk.controller;

import com.litbo.hospitalzj.controller.BaseController;
import com.litbo.hospitalzj.util.ResponseResult;
import com.litbo.hospitalzj.zk.domian.YqJxjl;
import com.litbo.hospitalzj.zk.service.YqJxjlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/yqjxjl")
public class YqJxjlController extends BaseController {
    @Autowired
    private YqJxjlService yqJxjlService;
    @RequestMapping("/selectNew")
    public ResponseResult<List<YqJxjl>> selectNew(){
        List<YqJxjl> data= yqJxjlService.selectNew();
        return new ResponseResult<List<YqJxjl>>(SUCCESS,data);
    }
}
