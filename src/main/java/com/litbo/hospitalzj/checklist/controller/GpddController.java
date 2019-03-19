package com.litbo.hospitalzj.checklist.controller;

import com.litbo.hospitalzj.checklist.domain.Gpdd;
import com.litbo.hospitalzj.checklist.service.GpddService;
import com.litbo.hospitalzj.checklist.utils.ResponseResult;
import com.litbo.hospitalzj.checklist.utils.commons.CommonUtils;
import com.litbo.hospitalzj.zk.domian.GpddTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/gpdd")
public class GpddController {

    @Autowired
    private GpddService gpddService;

    //查询模板值
    @RequestMapping("/findTemplate")
    public ResponseResult<GpddTemplate> findTemplate(){
        return new ResponseResult<GpddTemplate>(200, gpddService.findTemplate());
    }

    //查询一条
    @RequestMapping("/find")
    public ResponseResult<Gpdd> find(){
        return new ResponseResult<Gpdd>(200, gpddService.find());
    }
    //查询所有
    @RequestMapping("/findAll")
    public ResponseResult<List<Gpdd>> findAll(){
        return new ResponseResult<List<Gpdd>>(200, gpddService.findAll());
    }
    //保存
    @RequestMapping("/save")
    public ResponseResult<Gpdd> save(@RequestParam("eqId") String eqId, @RequestParam("jcyqId") String jcyqId,
                                     HttpServletRequest req){
        Gpdd gpdd = CommonUtils.toBean(req.getParameterMap(), Gpdd.class);
        gpddService.save(gpdd);
        return new ResponseResult<Gpdd>(200, gpdd);

    }
}
