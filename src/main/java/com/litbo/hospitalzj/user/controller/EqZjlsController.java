package com.litbo.hospitalzj.user.controller;

import com.litbo.hospitalzj.controller.BaseController;
import com.litbo.hospitalzj.user.bean.EqZjls;
import com.litbo.hospitalzj.user.bean.MonCount;
import com.litbo.hospitalzj.user.service.EqZjlsService;
import com.litbo.hospitalzj.util.ResponseResult;
import com.litbo.hospitalzj.zk.domian.EqInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 控制层
 */
@RestController
@RequestMapping("/eqzjls")
public class EqZjlsController extends BaseController {
    @Autowired
    private EqZjlsService eqZjlsService;

    @RequestMapping("/selectOne")
    public ResponseResult<EqZjls> selectOne(Integer dzId) {
        EqZjls data=eqZjlsService.select(dzId);
        return new ResponseResult<EqZjls>(SUCCESS,data);
    }
    @RequestMapping("/all")
    public ResponseResult<Void> getAll() {
        List<EqZjls> data=eqZjlsService.selectAll();
        return new ResponseResult<Void>(SUCCESS);
    }
    @RequestMapping("/insert")
    public ResponseResult<Void> insert(EqZjls eqZjls) {
        eqZjlsService.insert(eqZjls);
        return new ResponseResult<Void>(SUCCESS);
    }
    @RequestMapping("/delete")
    public ResponseResult<Void> delete(@RequestParam("dzId")Integer dzId) {
        eqZjlsService.delete(dzId);
        return new ResponseResult<Void>(SUCCESS);
    }
    @RequestMapping("/count")
    public ResponseResult<List<MonCount>> count(String tester) {
    	List<MonCount> data=eqZjlsService.count(tester);
        return new ResponseResult<List<MonCount>>(SUCCESS,data);
    }

    @RequestMapping("/selectEq")
    public ResponseResult<List<EqZjls>> selectEq(Integer eqId) {
        List<EqZjls> data=eqZjlsService.selectEq(eqId);
        return new ResponseResult<List<EqZjls>>(SUCCESS,data);
    }
}
