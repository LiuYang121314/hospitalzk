package com.litbo.hospitalzj.supplier.controller;

import com.litbo.hospitalzj.controller.BaseController;
import com.litbo.hospitalzj.supplier.entity.EqCgfs;
import com.litbo.hospitalzj.supplier.entity.SuInfo;
import com.litbo.hospitalzj.supplier.service.SuInfoService;
import com.litbo.hospitalzj.supplier.vo.SuInfoAndZzInfo;
import com.litbo.hospitalzj.util.ResponseResult;
import net.sf.jsqlparser.statement.select.Offset;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/suinfo")
public class SuInfoController extends BaseController {
    @Autowired
    private SuInfoService suInfoService;
    @RequestMapping("/{suId}")
    public ResponseResult<SuInfoAndZzInfo> getByCode(@PathVariable("suId") Integer suId) {
        SuInfoAndZzInfo data=suInfoService.findSuById(suId);
        return new ResponseResult<SuInfoAndZzInfo>(SUCCESS,data);
    }
    @RequestMapping("/insert")
    public ResponseResult<Integer> insert(SuInfo suInfo) {
        suInfo.setIsDelete(0);
        suInfoService.insert(suInfo);
        return new ResponseResult<Integer>(SUCCESS, suInfo.getSuId());
    }
    @RequestMapping("/delete")
    public ResponseResult<Void> delete(@RequestParam("suId") Integer suId) {
        suInfoService.delete(suId,1);
        return new ResponseResult<Void>(SUCCESS);
    }
    @RequestMapping("/all")
    public ResponseResult<List<SuInfo>> getAll() {
        List<SuInfo> data=suInfoService.selectAll();
        return new ResponseResult<List<SuInfo>>(SUCCESS,data);
    }
    @RequestMapping("/update")
    public ResponseResult<Void> update(SuInfo suInfo) {
        suInfoService.update(suInfo);
        return new ResponseResult<Void>(SUCCESS);
    }
    @RequestMapping("/updateStateIs")
    public ResponseResult<Void> updateStateIs(Integer suId) {
        suInfoService.updateState(suId,1);
        return new ResponseResult<Void>(SUCCESS);
    }
    @RequestMapping("/updateStateNot")
    public ResponseResult<Void> updateStateNot(Integer suId) {
        suInfoService.updateState(suId,2);
        return new ResponseResult<Void>(SUCCESS);
    }
    @RequestMapping("/findBySuMcLike")
    public ResponseResult<List<SuInfo>> findBySuMcLike(String suMc) {
        List<SuInfo> data=suInfoService.findBySuMcLike(suMc);
        return new ResponseResult<List<SuInfo>>(SUCCESS,data);
    }
    @RequestMapping("/findSuByState")
    public ResponseResult<List<SuInfo>> findSuByState() {
        List<SuInfo> data=suInfoService.findSuByState(1);
        return new ResponseResult<List<SuInfo>>(SUCCESS,data);
    }
    @RequestMapping("/count")
    public ResponseResult<Integer> count() {
        Integer data=suInfoService.count(0);
        return new ResponseResult<Integer>(SUCCESS,data);
    }
}
