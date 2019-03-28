package com.litbo.hospitalzj.hospital.controller;

import com.litbo.hospitalzj.controller.BaseController;
import com.litbo.hospitalzj.hospital.entity.EqDhdj;
import com.litbo.hospitalzj.hospital.service.EqDhdjService;
import com.litbo.hospitalzj.supplier.entity.HtInfo;
import com.litbo.hospitalzj.supplier.entity.SgdjHw;
import com.litbo.hospitalzj.util.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/eqdhdj")
public class EqDhdjController extends BaseController {
    @Autowired
    private EqDhdjService eqDhdjService;
    @RequestMapping("/insert")
    public ResponseResult<Void> insert(SgdjHw sgdjHw){
        System.out.print(sgdjHw);
        return new ResponseResult<Void>(SUCCESS);
    }
}
