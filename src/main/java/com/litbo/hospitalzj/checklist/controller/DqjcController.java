package com.litbo.hospitalzj.checklist.controller;

import com.litbo.hospitalzj.checklist.domain.Dqjc;
import com.litbo.hospitalzj.checklist.domain.DqjcTemplate;
import com.litbo.hospitalzj.checklist.service.DqjcService;
import com.litbo.hospitalzj.checklist.utils.commons.CommonUtils;
import com.litbo.hospitalzj.checklist.vo.DqjcUser;
import com.litbo.hospitalzj.controller.BaseController;
import com.litbo.hospitalzj.supplier.service.EqInfoService;
import com.litbo.hospitalzj.util.ResponseResult;
import com.litbo.hospitalzj.zk.Enum.EnumProcess2;
import com.litbo.hospitalzj.zk.service.UserEqService;
import com.litbo.hospitalzj.zk.service.YqEqService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import java.util.List;

@RestController
@RequestMapping("/dqjc")
public class DqjcController extends BaseController {

    @Autowired
    private DqjcService dqjcService;
    @Autowired
    private UserEqService userEqService;
    @Autowired
    private EqInfoService eqinfoService;
    @Autowired
    private YqEqService yqEqService;

    /**
     * 查询含有模板表数据的电气检测表
     * @return
     */
    @RequestMapping("/findTemplate")
    public ResponseResult<Dqjc> findTemplate(){
        Dqjc dqjc = dqjcService.findTemplate();
        return new ResponseResult<Dqjc>(200, dqjc);
    }
    /**
     * 修改模板表数据
     * @return
     */
    @RequestMapping("/updateTemplate")
    public ResponseResult<DqjcTemplate> updateTemplate(DqjcTemplate dqjcTemplate){
        DqjcTemplate data = dqjcService.updateTemplate(dqjcTemplate);
        return new ResponseResult<DqjcTemplate>(200, data);
    }
    /**
     * 插入模板表数据
     * @return
     */
    @RequestMapping("/insertTemplate")
    public ResponseResult<Void> insertTemplate(DqjcTemplate dqjcTemplate){
        dqjcService.insertTemplate(dqjcTemplate);
        return new ResponseResult<Void>(200);
    }

    /**
     * 保存电器检测数据
     * @param eqId
     * @param jcyqId
     * @param req
     * @return
     */
    @RequestMapping("/save")
    public ResponseResult<Integer> saveDq(@RequestParam(value = "eqId") String eqId,@RequestParam(value = "jcyqId") String jcyqId,
                                      HttpSession session, HttpServletRequest req){
       Dqjc dqjc = CommonUtils.toBean(req.getParameterMap(), Dqjc.class);
       String userId=String.valueOf(session.getAttribute("uid").toString());
       dqjcService.delete(eqId,jcyqId);
       dqjc.setState(0);
       yqEqService.insertBatch(eqId,jcyqId);
       yqEqService.updateType(jcyqId,eqId,EnumProcess2.TO_UPLOAD.getMessage());
       userEqService.setEqState5(userId,eqId);
       dqjcService.save(dqjc);
       return new ResponseResult<Integer>(200, dqjc.getDqjcid());
    }

    
    //查询电气检测表（最后一条）
    @RequestMapping("/find")
    public ResponseResult<Dqjc> find(){
        Dqjc dqjc = dqjcService.find();
        return new ResponseResult<Dqjc>(200, dqjc);
    }

    /***
     * 查询所有电气检测表数据
     * @return
     */
    @RequestMapping("/findAll")
    public ResponseResult<List<Dqjc>> findAll(){
        List<Dqjc> list = dqjcService.findAll();
        return new ResponseResult<List<Dqjc>>(200, list);
    }
    /**
     * 查询根据设备IDand检测仪器id电气检测表数据查询最后一条记录
     * @return
     */
    @RequestMapping("/findByEqIdandJcyqIdLast1")
    public ResponseResult<Dqjc> findByEqIdandJcyqIdLast1(@RequestParam("eqId")String eqId,@RequestParam("jcyqId")String jcyqId){
        Dqjc list = dqjcService.findByEqIdandJcyqIdLast1(eqId,jcyqId);
        return new ResponseResult<Dqjc>(200, list);
    }
    /**
     * 查询根据设备IDand检测仪器id电气检测表数据
     * @return
     */
    @RequestMapping("/findByEqIdandJcyqId")
    public ResponseResult<List<Dqjc>> findByEqIdandJcyqId(@RequestParam("eqId")String eqId,@RequestParam("jcyqId")String jcyqId){
        List<Dqjc> list = dqjcService.findByEqIdandJcyqId(eqId,jcyqId);
        return new ResponseResult<List<Dqjc>>(200, list);
    }
    /**
     * 查询根据检测仪器id电气检测表数据
     * @return
     */
    @RequestMapping("/findByDqjcid")
    public ResponseResult<Dqjc> findByDqjcid(Integer dqjcid){
        Dqjc list = dqjcService.findByDqjcid(dqjcid,0);
        return new ResponseResult<Dqjc>(200, list);
    }
    //修改状态
    @RequestMapping("/updateState")
    public ResponseResult<Void> updateState(@RequestParam("eqId")String eqId, @RequestParam("jcyqId")String jcyqId,HttpSession session){
        yqEqService.updateState(jcyqId,eqId,0);
        yqEqService.updateType(jcyqId,eqId,EnumProcess2.IS_UPLOAD.getMessage());
        userEqService.setJcEqState2(getUserIdFromSession(session),eqId);
        return new ResponseResult<Void>(200);
    }
    //修改仪器为已上传
    //修改状态
    @RequestMapping("/updateType")
    public ResponseResult<Void> updateType(@RequestParam("eqId")String eqId, @RequestParam("jcyqId")String jcyqId,HttpSession session){
        yqEqService.updateState(jcyqId,eqId,0);
        yqEqService.updateType(jcyqId,eqId,EnumProcess2.IS_UPLOAD.getMessage());
        return new ResponseResult<Void>(200);
    }
    /**
     * 查找审核人，审核人意见
     */
    @RequestMapping("/findShrAndShrjcjl")
    public ResponseResult<DqjcUser> findShrAndShrjcjl(@RequestParam("eqId")String eqId, @RequestParam("jcyqId")String jcyqId){
        DqjcUser data=dqjcService.findShrAndShrjcjl(eqId,jcyqId,1);
        return new ResponseResult<DqjcUser>(200,data);
    }
    //修改审核人建议同时修改状态
    @RequestMapping("/updateShrJcjy")
    public ResponseResult<Void> updateShrJcjy(@RequestParam("dqjcid")Integer dqjcid, @RequestParam("jcyqId")String jcyqId,@RequestParam("eqId")String eqId,@RequestParam("shrJcjl")String shrJcjl,@RequestParam("state")Integer state,HttpSession session){
        String auditor=getUserNameFromSession(session);
        dqjcService.updateShrJcjy(dqjcid,shrJcjl,auditor);
        if(state.equals(1)){
            yqEqService.updateState(jcyqId,eqId,1);
        }else{
            yqEqService.updateState(jcyqId,eqId,2);
        }
        return new ResponseResult<Void>(200);
    }

}