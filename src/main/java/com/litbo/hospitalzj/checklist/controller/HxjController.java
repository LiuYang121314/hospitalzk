package com.litbo.hospitalzj.checklist.controller;

import com.litbo.hospitalzj.checklist.domain.Gpdd;
import com.litbo.hospitalzj.checklist.domain.Hxj;
import com.litbo.hospitalzj.checklist.domain.HxjTemplate;
import com.litbo.hospitalzj.checklist.service.HxjService;
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
import java.util.List;

@RestController
@RequestMapping("/hxj")
public class HxjController extends BaseController {

    @Autowired
    private HxjService hxjService;
    @Autowired
    private UserEqService userEqService;
    @Autowired
    private EqInfoService eqinfoService;
    @Autowired
    private YqEqService yqEqService;

    //查询模板值
    @RequestMapping("/findTemplate")
    public ResponseResult<HxjTemplate> findTemplate(){
        return new ResponseResult<HxjTemplate>(200, hxjService.findTemplate());
    }
    //修改模板值
    @RequestMapping("/updateTemplate")
    public ResponseResult<Void> updateTemplate(HxjTemplate hxjTemplate){
        hxjService.updateHxjTemplate(hxjTemplate);
        return new ResponseResult<Void>(200);
    }
    //插入模板值
    @RequestMapping("/insert")
    public ResponseResult<Void> insert(HxjTemplate hxjTemplate){
        hxjService.insertHxjTemplate(hxjTemplate);
        return new ResponseResult<Void>(200);
    }

    //保存呼吸机检测数据
    @RequestMapping("/save")
    public ResponseResult saveChild(@RequestParam("eqId") String eqId,
                                         @RequestParam("jcyqId") String jcyqId,
                                         @RequestParam(value = "userEqId") Integer userEqId,
                                            Hxj hxj){
        int yqEqId=yqEqService.insertBatch(eqId,jcyqId);
        yqEqService.updateType(yqEqId, EnumProcess2.TO_UPLOAD.getMessage());
        //修改状态为待上传
        userEqService.setEqState(userEqId,EnumProcess2.TO_UPLOAD.getMessage());
        hxjService.save(hxj);
        int[] x={hxj.getHxjid(),yqEqId};
        return new ResponseResult(200, x);
    }

    //修改录入数据
    @RequestMapping("/updateHxj")
    public ResponseResult<Void> updateHxj(Hxj hxj){
        hxjService.updateHxj(hxj);
        return new ResponseResult<Void>(200);
    }

    //查询本设备的最后一条
    @RequestMapping("/findGpdd")
    public ResponseResult<Hxj> findGpdd(String eqId){
        hxjService.findHxj(eqId);
        return new ResponseResult<Hxj>(200);
    }
    /**
     * 查询根据设备IDand检测仪器id电气检测表数据查询最后一条记录
     * @return
     */
    @RequestMapping("/findByEqIdandJcyqIdLast1")
    public ResponseResult<Hxj> findByEqIdandJcyqIdLast1(@RequestParam("eqId")String eqId, @RequestParam("jcyqId")String jcyqId){
        Hxj list = hxjService.findByEqIdandJcyqIdLast1(eqId,jcyqId);
        return new ResponseResult<Hxj>(200, list);
    }
    /**
     * 查询根据设备IDand检测仪器id电气检测表数据
     * @return
     */
    @RequestMapping("/findByEqIdandJcyqId")
    public ResponseResult<List<Hxj>> findByEqIdandJcyqId(@RequestParam("eqId")String eqId, @RequestParam("jcyqId")String jcyqId){
        List<Hxj> list = hxjService.findByEqIdandJcyqId(eqId,jcyqId);
        return new ResponseResult<List<Hxj>>(200, list);
    }
    //查询所有
    @RequestMapping("/findAll")
    public ResponseResult<List<Hxj>> findAll(){
        List<Hxj> data=hxjService.findAll();
        return new ResponseResult<List<Hxj>>(200,data);
    }
    /**
     * 查询根据检测仪器id检测表数据
     * @return
     */
    @RequestMapping("/findByHxjId")
    public ResponseResult<Hxj> findByHxjId(Integer hxjId){
        Hxj list = hxjService.findByHxjId(hxjId);
        return new ResponseResult<Hxj>(200, list);
    }
    //修改审核人建议同时修改状态
    @RequestMapping("/updateShrJcjy")
    public ResponseResult<Void> updateShrJcjy(@RequestParam("hxjid")Integer hxjid,
                                               @RequestParam("jcyqId")Integer jcyqId,
                                               @RequestParam("eqId")Integer eqId,
                                               @RequestParam("shrJcjl")String shrJcjl,
                                               @RequestParam("state")Integer state,
                                              HttpSession session){
        String auditor=getUserNameFromSession(session);
        Integer yqEqId= yqEqService.findId(jcyqId,eqId);
        hxjService.updateShrJcjy(hxjid,shrJcjl,auditor);
        if(state.equals(1)){
            yqEqService.updateState(yqEqId,1);
        }else{
            yqEqService.updateState(yqEqId,2);
        }
        return new ResponseResult<Void>(200);
    }

}
