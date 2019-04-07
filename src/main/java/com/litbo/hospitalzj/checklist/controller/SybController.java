package com.litbo.hospitalzj.checklist.controller;

import com.litbo.hospitalzj.checklist.domain.SybC;
import com.litbo.hospitalzj.checklist.domain.SybCTemplate;
import com.litbo.hospitalzj.checklist.service.SybService;
import com.litbo.hospitalzj.checklist.utils.ResponseResult;
import com.litbo.hospitalzj.checklist.utils.commons.CommonUtils;
import com.litbo.hospitalzj.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 输液泵Controller
 */
@RestController
@RequestMapping("/syb")
public class SybController extends BaseController {

    @Autowired
    private SybService sybService;
    //插入模板数据
    //插入输液泵儿童模板值
    @RequestMapping("/insertChildTemplate")
    public ResponseResult insertChildTemplate(SybCTemplate template){
        sybService.insertChildTemplate(template);
        return new ResponseResult(200);
    }
    //插入输液泵成人模板值
    @RequestMapping("/insertManTemplate")
    public ResponseResult insertManTemplate(SybCTemplate template){
        sybService.insertManTemplate(template);
        return new ResponseResult(200);
    }

    //查询模板数据（成年人）
    @RequestMapping("/findManTemplate")
    public ResponseResult<SybCTemplate> findManTemplate(){
        return new ResponseResult<SybCTemplate>(200, sybService.findManTemplate());
    }
    //查询模板数据（儿童 ）
    @RequestMapping("/findChildTemplate")
    public ResponseResult<SybCTemplate> findChildTemplate(){
        return new ResponseResult<SybCTemplate>(200, sybService.findChildTemplate());
    }

    //修改模板数据
    //幼儿
    @RequestMapping("/updateC")
    public ResponseResult updateC(SybCTemplate template){
        sybService.updateC(template);
        return new ResponseResult(200);
    }

    //成人
    @RequestMapping("/updateM")
    public ResponseResult updateM(SybCTemplate template){
        sybService.updateM(template);
        return new ResponseResult(200);
    }

    //保存信息
    @RequestMapping("/savechild")
    public ResponseResult<SybC> saveChild(@RequestParam(value = "eqId") String eqId, @RequestParam("jcyqId") String jcyqId,
                                          HttpServletRequest req){
        SybC sybC = CommonUtils.toBean(req.getParameterMap(), SybC.class);
        sybService.saveChild(sybC);
        return new ResponseResult<SybC>(200, sybC);
    }

    @RequestMapping("/saveman")
    public ResponseResult<SybC> saveMan(@RequestParam(value = "eqId") String eqId, @RequestParam("jcyqId") String jcyqId,
                                        HttpServletRequest req){
        SybC sybC = CommonUtils.toBean(req.getParameterMap(), SybC.class);
        sybService.saveMan(sybC);
        return new ResponseResult<SybC>(200, sybC);
    }

    //查询所有录入信息(成人)
    @RequestMapping("/findAllMan")
    public ResponseResult<List<SybC>> findAllMan(){
        return new ResponseResult<List<SybC>>(200, sybService.findAllMan());
    }
    //查询所有录入信息(儿童)
    @RequestMapping("/findAllChild")
    public ResponseResult<List<SybC>> findAllChild(){
        return new ResponseResult<List<SybC>>(200, sybService.findAllChild());
    }
    //查询最后录入的一条检测信息
    @RequestMapping("/findMan")
    public ResponseResult<SybC> findMan(){
        return new ResponseResult<SybC>(200, sybService.findMan());
    }
    @RequestMapping("/findChild")
    public ResponseResult<SybC> findChild(){
        return new ResponseResult<SybC>(200, sybService.findChild());
    }

}
