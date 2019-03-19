package com.litbo.hospitalzj.checklist.controller;

import com.litbo.hospitalzj.checklist.domain.Hxj;
import com.litbo.hospitalzj.checklist.domain.HxjTemplate;
import com.litbo.hospitalzj.checklist.service.HxjService;
import com.litbo.hospitalzj.checklist.utils.commons.CommonUtils;
import com.litbo.hospitalzj.util.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/hxj")
public class HxjController {

    @Autowired
    private HxjService hxjService;


    //查询模板值
    @RequestMapping("/findTemplate")
    public ResponseResult<HxjTemplate> findTemplate(){
        return new ResponseResult<HxjTemplate>(200, hxjService.findTemplate());
    }

    //查询一条数据
    @RequestMapping("/find")
    public ResponseResult<Hxj> find(){
        return new ResponseResult<Hxj>(200, hxjService.find());
    }

    //查询多条数据
    @RequestMapping("findAll")
    public ResponseResult<List<Hxj>> findAll(){
        return new ResponseResult<List<Hxj>>(200, hxjService.findAll());
    }

    //保存呼吸机检测数据
    @RequestMapping("/save")
    public ResponseResult<Hxj> saveChild(@RequestParam(value ="eqId") String eqId, @RequestParam("jcyqId") String yqId,
                                            HttpServletRequest req){
        Hxj hxj = CommonUtils.toBean(req.getParameterMap(), Hxj.class);
        hxjService.save(hxj);
        return new ResponseResult<Hxj>(200, hxj);
    }


}
