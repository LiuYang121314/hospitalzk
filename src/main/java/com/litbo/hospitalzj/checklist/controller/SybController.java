package com.litbo.hospitalzj.checklist.controller;

import com.litbo.hospitalzj.checklist.domain.SybC;
import com.litbo.hospitalzj.checklist.domain.SybCTemplate;
import com.litbo.hospitalzj.checklist.service.SybService;
import com.litbo.hospitalzj.checklist.utils.ResponseResult;
import com.litbo.hospitalzj.checklist.utils.commons.CommonUtils;
import com.litbo.hospitalzj.controller.BaseController;
import com.litbo.hospitalzj.sf.service.UserService;
import com.litbo.hospitalzj.zk.service.UserEqService;
import com.litbo.hospitalzj.zk.service.YqEqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 输液泵Controller
 */
@RestController
@RequestMapping("/syb")
public class SybController extends BaseController {

    @Autowired
    private SybService sybService;
    @Autowired
    private UserEqService userEqService;
    @Autowired
    private YqEqService yqEqService;
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
        String template = "syb_c_template";
        return new ResponseResult<SybCTemplate>(200, sybService.findTemplate(template));
    }
    //查询模板数据（儿童 ）
    @RequestMapping("/findChildTemplate")
    public ResponseResult<SybCTemplate> findChildTemplate(){
        String template = "syb_m_template";
        return new ResponseResult<SybCTemplate>(200, sybService.findTemplate(template));
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

    //修改幼儿数据表信息
    @RequestMapping("/updateChild")
    public ResponseResult<SybC> updateChild(SybC sybC){
        sybService.updateChild(sybC);
        return new ResponseResult<SybC>(200, sybC);
    }

    @RequestMapping("/saveman")
    public ResponseResult<SybC> saveMan(@RequestParam(value = "eqId") String eqId, @RequestParam("jcyqId") String jcyqId,
                                        HttpServletRequest req){
        SybC sybC = CommonUtils.toBean(req.getParameterMap(), SybC.class);
        sybService.saveMan(sybC);
        return new ResponseResult<SybC>(200, sybC);
    }
    @RequestMapping("/updateMan")
    public ResponseResult<SybC> updateMan(SybC sybC){
        sybService.updateMan(sybC);
        return new ResponseResult<SybC>(200, sybC);
    }
    //查询所有录入信息(成人)
    @RequestMapping("/findAllMan")
    public ResponseResult<List<SybC>> findAllMan(){
        return new ResponseResult<List<SybC>>(200, sybService.findAll("syb_m"));
    }
    //查询所有录入信息(儿童)
    @RequestMapping("/findAllChild")
    public ResponseResult<List<SybC>> findAllChild(){
        return new ResponseResult<List<SybC>>(200, sybService.findAll("syb_c"));
    }
    //查询最后录入的一条检测信息
    @RequestMapping("/findByidM")
    public ResponseResult<SybC> findByidM(Integer id){
        String tableName="syb_m";
        return new ResponseResult<SybC>(200, sybService.findByid(id,tableName));
    }
    @RequestMapping("/findByidC")
    public ResponseResult<SybC> findByidC(Integer id){
        String tableName="syb_c";
        return new ResponseResult<SybC>(200, sybService.findByid(id,tableName));
    }
    //修改审核人意见
    @RequestMapping("/updateShrJcjyM")
    public ResponseResult<Void> updateShrJcjyM(@RequestParam("id")Integer id, @RequestParam("jcyqId")Integer jcyqId,
                                                                        @RequestParam("eqId")Integer eqId, @RequestParam("shrJcjl")String shrJcjl,
                                                                        @RequestParam("state")Integer state, HttpSession session){
        String auditor=getUserNameFromSession(session);
        Integer yqEqId= yqEqService.findId(jcyqId,eqId);
        sybService.updateShrJcjyM(id,shrJcjl,auditor);
        if(state.equals(1)){
            yqEqService.updateState(yqEqId,1);
        }else{
            yqEqService.updateState(yqEqId,2);
        }
        return new ResponseResult<Void>(200);
    }
    @RequestMapping("/updateShrJcjyC")
    public ResponseResult<Void> updateShrJcjyC(@RequestParam("id")Integer id, @RequestParam("jcyqId")Integer jcyqId,
                                               @RequestParam("eqId")Integer eqId, @RequestParam("shrJcjl")String shrJcjl,
                                               @RequestParam("state")Integer state, HttpSession session){
        String auditor=getUserNameFromSession(session);
        Integer yqEqId= yqEqService.findId(jcyqId,eqId);
        sybService.updateShrJcjyC(id,shrJcjl,auditor);
        if(state.equals(1)){
            yqEqService.updateState(yqEqId,1);
        }else{
            yqEqService.updateState(yqEqId,2);
        }
        return new ResponseResult<Void>(200);
    }
}
