package com.litbo.hospitalzj.checklist.controller;

import com.litbo.hospitalzj.checklist.domain.Dqjc;
import com.litbo.hospitalzj.checklist.domain.Gpdd;
import com.litbo.hospitalzj.checklist.service.GpddService;
import com.litbo.hospitalzj.checklist.utils.ResponseResult;
import com.litbo.hospitalzj.checklist.utils.commons.CommonUtils;
import com.litbo.hospitalzj.controller.BaseController;
import com.litbo.hospitalzj.supplier.service.EqInfoService;
import com.litbo.hospitalzj.zk.Enum.EnumProcess2;
import com.litbo.hospitalzj.zk.domian.GpddTemplate;
import com.litbo.hospitalzj.zk.service.UserEqService;
import com.litbo.hospitalzj.zk.service.YqEqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/gpdd")
public class GpddController extends BaseController {

    @Autowired
    private GpddService gpddService;
    @Autowired
    private UserEqService userEqService;
    @Autowired
    private EqInfoService eqinfoService;
    @Autowired
    private YqEqService yqEqService;
    //查询模板值
    @RequestMapping("/findTemplate")
    public ResponseResult<GpddTemplate> findTemplate(){
        return new ResponseResult<GpddTemplate>(200, gpddService.findTemplate());
    }
    //修改模板值
    @RequestMapping("/update")
    public ResponseResult<Void> update(GpddTemplate gpddTemplate){
        gpddService.update(gpddTemplate);
        return new ResponseResult<Void>(200);
    }
    //插入模板值
    @RequestMapping("/insert")
    public ResponseResult<Void> insert(GpddTemplate gpddTemplate){
        gpddService.insert(gpddTemplate);
        return new ResponseResult<Void>(200);
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
    public ResponseResult<Gpdd> save(@RequestParam("eqId") String eqId, @RequestParam("jcyqId") String jcyqId,@RequestParam(value = "userEqId") Integer userEqId,
                                     HttpSession session, HttpServletRequest req){
        Gpdd gpdd = CommonUtils.toBean(req.getParameterMap(), Gpdd.class);
        int yqEqId=yqEqService.insertBatch(eqId,jcyqId);
        yqEqService.updateType(yqEqId, EnumProcess2.TO_UPLOAD.getMessage());
        //修改状态为待上传
        userEqService.setEqState(userEqId,EnumProcess2.TO_UPLOAD.getMessage());
        gpddService.save(gpdd);
        return new ResponseResult<Gpdd>(200, gpdd);
    }
    /**
     * 查询根据设备IDand检测仪器id电气检测表数据查询最后一条记录
     * @return
     */
    @RequestMapping("/findByEqIdandJcyqIdLast1")
    public ResponseResult<Gpdd> findByEqIdandJcyqIdLast1(@RequestParam("eqId")String eqId,@RequestParam("jcyqId")String jcyqId){
        Gpdd list = gpddService.findByEqIdandJcyqIdLast1(eqId,jcyqId);
        return new ResponseResult<Gpdd>(200, list);
    }
    /**
     * 查询根据设备IDand检测仪器id电气检测表数据
     * @return
     */
    @RequestMapping("/findByEqIdandJcyqId")
    public ResponseResult<List<Gpdd>> findByEqIdandJcyqId(@RequestParam("eqId")String eqId,@RequestParam("jcyqId")String jcyqId){
        List<Gpdd> list = gpddService.findByEqIdandJcyqId(eqId,jcyqId);
        return new ResponseResult<List<Gpdd>>(200, list);
    }
    /**
     * 查询根据检测仪器id电气检测表数据
     * @return
     */
    @RequestMapping("/findByGpddid")
    public ResponseResult<Gpdd> findByGpddid(Integer gpddid){
        Gpdd list = gpddService.findByGpddid(gpddid);
        return new ResponseResult<Gpdd>(200, list);
    }
    //修改审核人建议同时修改状态
    @RequestMapping("/updateShrJcjy")
    public ResponseResult<Void> updateShrJcjy(@RequestParam("dqjcid")Integer dqjcid, @RequestParam("yqEqId")Integer yqEqId, @RequestParam("shrJcjl")String shrJcjl, @RequestParam("state")Integer state, HttpSession session){
        String auditor=getUserNameFromSession(session);
       /* dqjcService.updateShrJcjy(dqjcid,shrJcjl,auditor);*/
        if(state.equals(1)){
            yqEqService.updateState(yqEqId,1);
        }else{
            yqEqService.updateState(yqEqId,2);
        }
        return new ResponseResult<Void>(200);
    }
}
