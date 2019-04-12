package com.litbo.hospitalzj.checklist.controller;

import com.litbo.hospitalzj.checklist.domain.*;
import com.litbo.hospitalzj.checklist.service.ZsbService;
import com.litbo.hospitalzj.checklist.utils.ResponseResult;
import com.litbo.hospitalzj.checklist.utils.commons.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 注射泵Controller
 */
@RestController
@RequestMapping("/zsb")
public class ZsbController {

    @Autowired
    private ZsbService zsbService;
    //查询双通道注射泵模板数据
    @RequestMapping("/find")
    public ResponseResult<SybC> findStZsTemplate(Integer id){
        String tableName="zsb_c";
        return new ResponseResult<SybC>(200, zsbService.findByidC(id,tableName));
    }
  /*  //查询注射泵模板数据（成人）
    @RequestMapping("/findManTemplate")
    public ResponseResult<SybCTemplate> findManTemplate(){
        return new ResponseResult<SybCTemplate>(200, zsbService.findManTemplate());
    }
    //查询注射泵模板数据（成人）
    @RequestMapping("/findChildTemplate")
    public ResponseResult<SybCTemplate> findChildTemplate(){
        return new ResponseResult<SybCTemplate>(200, zsbService.findChildsTemplate());
    }
    //插入模板数据(双通道注射泵)
    @RequestMapping("/insertStzsTemplate")
    public ResponseResult insertStzsTemplate(StzsMTemplate template){
        zsbService.insertStzsTemplate(template);
        return new ResponseResult(200);
    }

    //插入模板数据（成人）
    @RequestMapping("/insertManTemplate")
    public ResponseResult insertManTemplate(SybCTemplate template){
        System.out.println(template);
        zsbService.insertManTemplate(template);
        return new ResponseResult(200);
    }
    //插入模板数据（儿童）
    @RequestMapping("/insertChildTemplate")
    public ResponseResult insertChildTemplate(SybCTemplate template){
        zsbService.insertChildTemplate(template);
        return new ResponseResult(200);
    }
    //修改模板数据（儿童）
    @RequestMapping("/updateC")
    public ResponseResult updateC(SybCTemplate template){
        zsbService.updateC(template);
        return new ResponseResult(200);
    }
    //修改模板数据（成人）
    @RequestMapping("/updateM")
    public ResponseResult updateM(SybCTemplate template){
        zsbService.updateM(template);
        return new ResponseResult(200);
    }
    //修改模板数据（儿童）
    @RequestMapping("/updateS")
    public ResponseResult updateS(StzsMTemplate stzsMTemplate){
        zsbService.updateS(stzsMTemplate);
        return new ResponseResult(200);
    }
    //保存信息
    @RequestMapping("/savechild")
    public ResponseResult<SybC> saveChild(@RequestParam(value = "eqId") String eqId, @RequestParam("jcyqId") String jcyqId,
                                          HttpServletRequest req){
        SybC sybC = CommonUtils.toBean(req.getParameterMap(), SybC.class);
        zsbService.saveChild(sybC);
        return new ResponseResult<SybC>(200, sybC);
    }

    @RequestMapping("/saveman")
    public ResponseResult<SybC> saveMan(@RequestParam(value = "eqId") String eqId, @RequestParam("jcyqId") String jcyqId,
                                        HttpServletRequest req){

        SybC sybC = CommonUtils.toBean(req.getParameterMap(), SybC.class);
        zsbService.saveMan(sybC);
        return new ResponseResult<SybC>(200, sybC);
    }

    //保存双通道注射泵检测数据
    @RequestMapping("/savestzs")
    public ResponseResult<StzsM> saveStZs(@RequestParam(value = "eqId") String eqId, @RequestParam("jcyqId") String jcyqId,
                                          HttpServletRequest req){
        StzsM stzsM = CommonUtils.toBean(req.getParameterMap(), StzsM.class);
        zsbService.saveStZs(stzsM);
        return new ResponseResult<StzsM>(200, stzsM);
    }



    //查询所有录入信息（双通道）
    @RequestMapping("/findAllStzs")
    public ResponseResult<List<StzsM>> findAllStzsMan(){
        return new ResponseResult<List<StzsM>>(200, zsbService.findAllStzsMan());
    }
    @RequestMapping("/findAllMan")
    public ResponseResult<List<SybC>> findAllMan(){
        return new ResponseResult<List<SybC>>(200, zsbService.findAllMan());
    }
    @RequestMapping("findAllChild")
    public ResponseResult<List<SybC>> findAllChild(){
        return new ResponseResult<List<SybC>>(200, zsbService.findAllChild());
    }
    //查询最后录入的一条检测信息
    @RequestMapping("/findstzs")
    public ResponseResult<StzsM> findStzsMan(){
        return new ResponseResult<StzsM>(200, zsbService.findStzsMan());
    }

    @RequestMapping("/findchild")
    public ResponseResult<SybC> findChild(){
        return new ResponseResult<SybC>(200, zsbService.findChild());
    }

    @RequestMapping("/findman")
    public ResponseResult<SybC> findMan(){
        return new ResponseResult<SybC>(200, zsbService.findMan());
    }
*/
}
