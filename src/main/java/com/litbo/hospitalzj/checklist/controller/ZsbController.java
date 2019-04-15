package com.litbo.hospitalzj.checklist.controller;

import com.litbo.hospitalzj.checklist.domain.*;
import com.litbo.hospitalzj.checklist.service.ZsbService;
import com.litbo.hospitalzj.checklist.utils.ResponseResult;
import com.litbo.hospitalzj.checklist.utils.commons.CommonUtils;
import com.litbo.hospitalzj.controller.BaseController;
import com.litbo.hospitalzj.sf.service.UserService;
import com.litbo.hospitalzj.zk.Enum.EnumProcess2;
import com.litbo.hospitalzj.zk.domian.TabEq;
import com.litbo.hospitalzj.zk.service.TabEqService;
import com.litbo.hospitalzj.zk.service.UserEqService;
import com.litbo.hospitalzj.zk.service.YqEqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * 注射泵Controller
 */
@RestController
@RequestMapping("/zsb")
public class ZsbController extends BaseController {

    @Autowired
    private ZsbService zsbService;
    @Autowired
    private UserEqService userEqService;
    @Autowired
    private TabEqService tabEqService;
    @Autowired
    private YqEqService yqEqService;

    //查询模板表中最后一条数据
    @RequestMapping("/findTemplateC")
    public ResponseResult<SybCTemplate> findTemplateC(){
        String tableName="zsb_c_template";
        return new ResponseResult<SybCTemplate>(200, zsbService.findTemplate(tableName));
    }
    @RequestMapping("/findTemplateM")
    public ResponseResult<SybCTemplate> findTemplateM(){
        String tableName="zsb_M_template";
        return new ResponseResult<SybCTemplate>(200, zsbService.findTemplate(tableName));
    }
    @RequestMapping("/findStZsTemplate")
    public ResponseResult<StzsMTemplate> findStZsTemplate(){
        return new ResponseResult<StzsMTemplate>(200, zsbService.findStZsTemplate());
    }
    //修改模板表数据
    @RequestMapping("/updateCT")
    public ResponseResult<Void> updateCT(SybCTemplate sybCTemplate){
        zsbService.updateC(sybCTemplate);
        return new ResponseResult<Void>(200);
    }
    @RequestMapping("/updateMT")
    public ResponseResult<Void> updateMT(SybCTemplate sybCTemplate){
        zsbService.updateM(sybCTemplate);
        return new ResponseResult<Void>(200);
    }
    @RequestMapping("/updateST")
    public ResponseResult<Void> updateST(StzsMTemplate stzsMTemplate){
        zsbService.updateS(stzsMTemplate);
        return new ResponseResult<Void>(200);
    }
    //插入模板表数据
    @RequestMapping("/insertChildTemplate")
    public ResponseResult<Void> insertChildTemplate(SybCTemplate sybCTemplate){
        zsbService.insertChildTemplate(sybCTemplate);
        return new ResponseResult<Void>(200);
    }

    @RequestMapping("/insertManTemplate")
    public ResponseResult<Void> insertManTemplate(SybCTemplate sybCTemplate){
        zsbService.insertManTemplate(sybCTemplate);
        return new ResponseResult<Void>(200);
    }
    @RequestMapping("/insertStzsTemplate")
    public ResponseResult<Void> insertStzsTemplate(StzsMTemplate template){
        zsbService.insertStzsTemplate(template);
        return new ResponseResult<Void>(200);
    }

    //保存录入数据
    @RequestMapping("/saveChild")
    public ResponseResult saveChild(@RequestParam(value = "eqId") String eqId,
                                                           @RequestParam(value = "jcyqId") String jcyqId,
                                                           @RequestParam(value = "userEqId") Integer userEqId,
                                                           SybC sybC, HttpSession session, HttpServletRequest req){
        int yqEqId=yqEqService.insertBatch(eqId,jcyqId);
        yqEqService.updateType(yqEqId, EnumProcess2.TO_UPLOAD.getMessage());
        //修改状态为待上传
        userEqService.setEqState(userEqId,EnumProcess2.TO_UPLOAD.getMessage());
        zsbService.saveChild(sybC);
        TabEq table=new TabEq();
        table.setEqId(Integer.valueOf(eqId));
        table.setJcyqId(Integer.valueOf(jcyqId));
        table.setTableName("zsb_c");
        tabEqService.insert(table);
        long[] x={sybC.getId(),yqEqId};
        return new ResponseResult<>(200,x);
    }
    //修改数据
    @RequestMapping("/updateChild")
    public ResponseResult updateChild(SybC sybC){
        zsbService.updateChild(sybC);
        return new ResponseResult<>(200);
    }
    //保存录入数据
    @RequestMapping("/saveMan")
    public ResponseResult saveMan(@RequestParam(value = "eqId") String eqId,
                                  @RequestParam(value = "jcyqId") String jcyqId,
                                  @RequestParam(value = "userEqId") Integer userEqId,
                                  SybC sybC){
        int yqEqId=yqEqService.insertBatch(eqId,jcyqId);
        yqEqService.updateType(yqEqId, EnumProcess2.TO_UPLOAD.getMessage());
        //修改状态为待上传
        userEqService.setEqState(userEqId,EnumProcess2.TO_UPLOAD.getMessage());
        zsbService.saveMan(sybC);
        TabEq table=new TabEq();
        table.setEqId(Integer.valueOf(eqId));
        table.setJcyqId(Integer.valueOf(jcyqId));
        table.setTableName("zsb_m");
        tabEqService.insert(table);
        long[] x={sybC.getId(),yqEqId};
        return new ResponseResult<>(200,x);
    }
    @RequestMapping("/updateMan")
    public ResponseResult updateMan(SybC sybC){
        zsbService.updateMan(sybC);
        return new ResponseResult<>(200);
    }
    //保存录入数据
    @RequestMapping("/saveStzs")
    public ResponseResult saveStzs(@RequestParam(value = "eqId") String eqId,
                                  @RequestParam(value = "jcyqId") String jcyqId,
                                  @RequestParam(value = "userEqId") Integer userEqId,
                                   StzsM stzsM, HttpSession session, HttpServletRequest req){
        int yqEqId=yqEqService.insertBatch(eqId,jcyqId);
        yqEqService.updateType(yqEqId, EnumProcess2.TO_UPLOAD.getMessage());
        //修改状态为待上传
        userEqService.setEqState(userEqId,EnumProcess2.TO_UPLOAD.getMessage());
        zsbService.saveStzs(stzsM);
        TabEq table=new TabEq();
        table.setEqId(Integer.valueOf(eqId));
        table.setJcyqId(Integer.valueOf(jcyqId));
        table.setTableName("stzs_m");
        long[] x={stzsM.getId(),yqEqId};
        return new ResponseResult<>(200,x);
    }
    @RequestMapping("/updateStzs")
    public ResponseResult updateStzs(StzsM stzsM){
        zsbService.updateStzs(stzsM);
        return new ResponseResult<>(200);
    }

    @RequestMapping("/findByEqIdandJcyqIdLast1")
    public ResponseResult findByEqIdandJcyqIdLast1(@RequestParam("eqId")String eqId,@RequestParam("jcyqId") String jcyqId){
        TabEq table=tabEqService.findTable(Integer.valueOf(eqId),Integer.valueOf(jcyqId));
        SybC data=zsbService.findByEqIdandJcyqIdLast(table.getTableName(),eqId,jcyqId);
        return new ResponseResult(200,data);
    }
    @RequestMapping("/findByEqIdandJcyqId")
    public ResponseResult<List<SybC>> findByEqIdandJcyqId(@RequestParam("eqId")String eqId,@RequestParam("jcyqId") String jcyqId){
        TabEq table=tabEqService.findTable(Integer.valueOf(eqId),Integer.valueOf(jcyqId));
        List<SybC> data=zsbService.findByEqIdandJcyqId(table.getTableName(),eqId,jcyqId);
        return new ResponseResult<List<SybC>>(200,data);
    }


   /* @RequestMapping("/findByEqIdandJcyqIdLast1C")
    public ResponseResult<SybC> findByEqIdandJcyqIdLast1C(String eqId, String jcyqId){
        SybC sybC= zsbService.findByEqIdandJcyqIdLast1C(eqId, jcyqId);
        return new ResponseResult<SybC>(200,sybC);
    }

    @RequestMapping("/findByEqIdandJcyqIdC")
    public ResponseResult<List<SybC>> findByEqIdandJcyqIdC(String eqId, String jcyqId){
        List<SybC> sybC= zsbService.findByEqIdandJcyqIdC(eqId, jcyqId);
        return new ResponseResult<List<SybC>>(200,sybC);
    }

    @RequestMapping("/findByEqIdandJcyqIdLast1M")
    public ResponseResult<SybC> findByEqIdandJcyqIdLast1M(String eqId, String jcyqId){
        SybC sybC= zsbService.findByEqIdandJcyqIdLast1M(eqId, jcyqId);
        return new ResponseResult<SybC>(200,sybC);
    }
    @RequestMapping("/findByEqIdandJcyqIdM")
    public ResponseResult<List<SybC>> findByEqIdandJcyqIdM(String eqId, String jcyqId){
        List<SybC> sybC= zsbService.findByEqIdandJcyqIdM(eqId, jcyqId);
        return new ResponseResult<List<SybC>>(200,sybC);
    }

    @RequestMapping("/findByEqIdandJcyqIdLast1S")
    public ResponseResult<StzsM> findByEqIdandJcyqIdLast1S(String eqId, String jcyqId) {
        StzsM sybCs = zsbService.findByEqIdandJcyqIdLast1S(eqId, jcyqId);
        return new ResponseResult<StzsM>(200, sybCs);
    }
    @RequestMapping("/findByEqIdandJcyqIdS")
    public ResponseResult<List<StzsM>> findByEqIdandJcyqIdS(String eqId, String jcyqId){
        List<StzsM> stzsM= zsbService.findByEqIdandJcyqIdS(eqId, jcyqId);
        return new ResponseResult<List<StzsM>>(200,stzsM);
    }
*/

    //查询数据表中全部数据
     @RequestMapping("/findAllC")
     public ResponseResult<List<SybC>> findAllC(){
         String tableName="zsb_c";
         List<SybC> sybC= zsbService.findAll(tableName);
         return new ResponseResult<List<SybC>>(200,sybC);
     }
    @RequestMapping("/findAllM")
    public ResponseResult<List<SybC>> findAllM(){
        String tableName="zsb_m";
        List<SybC> sybC= zsbService.findAll(tableName);
        return new ResponseResult<List<SybC>>(200,sybC);
    }
    @RequestMapping("/findAllS")
    public ResponseResult<List<StzsM>> findAllS(){
        List<StzsM> sybC= zsbService.findAllS();
        return new ResponseResult<List<StzsM>>(200,sybC);
    }
    //通过id查询表中数据
    @RequestMapping("/findByidC")
    public ResponseResult<SybC> findByidC(Integer id){
        String tableName="zsb_c";
        return new ResponseResult<SybC>(200, zsbService.findByid(id,tableName));
    }
    @RequestMapping("/findByidM")
    public ResponseResult<SybC> findByidM(Integer id){
        String tableName="zsb_m";
        return new ResponseResult<SybC>(200, zsbService.findByid(id,tableName));
    }
    @RequestMapping("/findByidS")
    public ResponseResult<StzsM> findByidS(Integer id){
        return new ResponseResult<StzsM>(200, zsbService.findByidS(id));
    }
    //修改审核人状态
    @RequestMapping("/updateShrJcjyC")
    public com.litbo.hospitalzj.util.ResponseResult<Void> updateShrJcjy(@RequestParam("id")Integer id, @RequestParam("jcyqId")Integer jcyqId,
                                                                        @RequestParam("eqId")Integer eqId, @RequestParam("shrJcjl")String shrJcjl, @RequestParam("state")Integer state, HttpSession session){
        String auditor=getUserNameFromSession(session);
        Integer yqEqId= yqEqService.findId(jcyqId,eqId);
        zsbService.updateShrJcjyC(id,shrJcjl,auditor);
        if(state.equals(1)){
            yqEqService.updateState(yqEqId,1);
        }else{
            yqEqService.updateState(yqEqId,2);
        }
        return new com.litbo.hospitalzj.util.ResponseResult<Void>(200);
    }
    @RequestMapping("/updateShrJcjyM")
    public com.litbo.hospitalzj.util.ResponseResult<Void> updateShrJcjyM(@RequestParam("id")Integer id, @RequestParam("jcyqId")Integer jcyqId,
                                                                        @RequestParam("eqId")Integer eqId, @RequestParam("shrJcjl")String shrJcjl, @RequestParam("state")Integer state, HttpSession session){
        String auditor=getUserNameFromSession(session);
        Integer yqEqId= yqEqService.findId(jcyqId,eqId);
        zsbService.updateShrJcjyM(id,shrJcjl,auditor);
        if(state.equals(1)){
            yqEqService.updateState(yqEqId,1);
        }else{
            yqEqService.updateState(yqEqId,2);
        }
        return new com.litbo.hospitalzj.util.ResponseResult<Void>(200);
    }
    @RequestMapping("/updateShrJcjyS")
    public com.litbo.hospitalzj.util.ResponseResult<Void> updateShrJcjyS(@RequestParam("id")Integer id, @RequestParam("jcyqId")Integer jcyqId,
                                                                        @RequestParam("eqId")Integer eqId, @RequestParam("shrJcjl")String shrJcjl, @RequestParam("state")Integer state, HttpSession session){
        String auditor=getUserNameFromSession(session);
        Integer yqEqId= yqEqService.findId(jcyqId,eqId);
        zsbService.updateShrJcjyS(id,shrJcjl,auditor);
        if(state.equals(1)){
            yqEqService.updateState(yqEqId,1);
        }else{
            yqEqService.updateState(yqEqId,2);
        }
        return new com.litbo.hospitalzj.util.ResponseResult<Void>(200);
    }
}
