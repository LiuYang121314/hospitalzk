package com.litbo.hospitalzj.supplier.controller;

import com.litbo.hospitalzj.controller.BaseController;
import com.litbo.hospitalzj.supplier.entity.EqCgfs;
import com.litbo.hospitalzj.supplier.entity.SuInfo;
import com.litbo.hospitalzj.supplier.service.SuInfoService;
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
    public ResponseResult<SuInfo> getByCode(@PathVariable("suId") Integer suId) {
        SuInfo data=suInfoService.findSuById(suId);
        return new ResponseResult<SuInfo>(SUCCESS,data);
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
    public ResponseResult<List<SuInfo>> getAll(@RequestParam("offset")Integer offset, @RequestParam("count") Integer count) {
        List<SuInfo> data=suInfoService.selectAll(offset, count);
        return new ResponseResult<List<SuInfo>>(SUCCESS,data);
    }
    @RequestMapping("/update")
    public ResponseResult<Void> update(SuInfo suInfo) {
        suInfoService.update(suInfo);
        return new ResponseResult<Void>(SUCCESS);
    }@RequestMapping("/findBySuMcLike")
    public ResponseResult<List<SuInfo>> findBySuMcLike(String suMc) {
        List<SuInfo> data=suInfoService.findBySuMcLike(suMc);
        return new ResponseResult<List<SuInfo>>(SUCCESS,data);
    }
}
