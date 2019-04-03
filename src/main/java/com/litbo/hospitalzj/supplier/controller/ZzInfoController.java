package com.litbo.hospitalzj.supplier.controller;

import com.litbo.hospitalzj.controller.BaseController;
import com.litbo.hospitalzj.supplier.entity.SuInfo;
import com.litbo.hospitalzj.supplier.entity.ZzInfo;
import com.litbo.hospitalzj.supplier.service.SuInfoService;
import com.litbo.hospitalzj.supplier.service.ZzInfoService;
import com.litbo.hospitalzj.util.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/zzinfo")
public class ZzInfoController extends BaseController {
    @Autowired
    private ZzInfoService zzInfoService;
    @RequestMapping("/{suId}")
    public ResponseResult<ZzInfo> getByCode(@PathVariable("suId") Integer suId) {
        ZzInfo data=zzInfoService.findZzById(suId);
        return new ResponseResult<ZzInfo>(SUCCESS,data);
    }
    @RequestMapping("/update")
    public ResponseResult<Void> update(ZzInfo zzInfo) {
        zzInfoService.update(zzInfo);
        return new ResponseResult<Void>(SUCCESS);
    }
    @RequestMapping("/insert")
    public ResponseResult<Void> insert(ZzInfo zzInfo) {
        zzInfoService.insert(zzInfo);
        return new ResponseResult<Void>(SUCCESS);
    }
}
