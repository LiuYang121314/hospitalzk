package com.litbo.hospitalzj.zk.controller;

import com.litbo.hospitalzj.controller.BaseController;
import com.litbo.hospitalzj.quality.service.UserPmService;
import com.litbo.hospitalzj.util.ResponseResult;
import com.litbo.hospitalzj.zk.Enum.EnumProcess2;
import com.litbo.hospitalzj.zk.domian.Ndjh;
import com.litbo.hospitalzj.zk.service.NdjhService;
import com.litbo.hospitalzj.zk.service.UserEqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 *
 */
@RestController
@RequestMapping("/ndjh")
public class NdjhController extends BaseController {
    @Autowired
    private NdjhService ndjhService;
    @Autowired
    private UserEqService userEqService;
    @Autowired
    private UserPmService userPmService;
    /*
     * 插入年度计划
     */
    @RequestMapping("/insert")
    public ResponseResult<Void> insert(@RequestParam("eqPmId") String eqPmId, Ndjh ndjh, HttpSession session){
        ndjhService.deletENdjh(ndjh.getNdjhId());
        System.out.println(ndjh.getNdjhId());
        String userId=getUserIdFromSession(session);
        ndjh.setUserId(userId);
        ndjh.setState(EnumProcess2.UNDER_REVIEW.getMessage());
        userPmService.setuserPmState(userId,eqPmId,"0");
        ndjh.setEqPmId(eqPmId);
        ndjhService.insertNdjh(ndjh);
        return new ResponseResult<Void>(SUCCESS);
    }

    @RequestMapping("/delete")
    public ResponseResult<Void> delete(Integer ndjhId){
        ndjhService.deletENdjh(ndjhId);
        return new ResponseResult<Void>(SUCCESS);
    }
    @RequestMapping("/select")
    public ResponseResult<Ndjh> selectNdjh(Integer ndjhId){
        Ndjh data=ndjhService.selectNdjh(ndjhId);
        return new ResponseResult<Ndjh>(SUCCESS,data);
    }
    /**{
     * 根据审核人查询不同状态
     * @param session
     * @return
     */
    //待审核
    @RequestMapping("/selectByShrId")
    public ResponseResult<List<Ndjh>> selectByShrId(HttpSession session){
        String shrId=getUserIdFromSession(session);
        List<Ndjh> data=ndjhService.selectByShrId(shrId,EnumProcess2.UNDER_REVIEW.getMessage());
        return new ResponseResult<List<Ndjh>>(SUCCESS,data);
    }

    //审核成功
    @RequestMapping("/selectByShrIdShcg")
    public ResponseResult<List<Ndjh>> selectByShrIdShcg(HttpSession session){
        String shrId=getUserIdFromSession(session);
        List<Ndjh> data=ndjhService.selectByShrId(shrId,EnumProcess2.UNDER_DETECTIO.getMessage());
        return new ResponseResult<List<Ndjh>>(SUCCESS,data);
    }
    @RequestMapping("/selectByUserId")
    public ResponseResult<List<Ndjh>> selectByUserId(HttpSession session){
    	String userId=getUserIdFromSession(session);
        List<Ndjh> data=ndjhService.selectByUserId(userId);
        return new ResponseResult<List<Ndjh>>(SUCCESS,data);
    }
    //根据状态查询年度计划
    @RequestMapping("/selectByUserIdAndState")
    public ResponseResult<List<Ndjh>> selectByUserIdAndState(HttpSession session){
    	String userId=getUserIdFromSession(session);
        List<Ndjh> data=ndjhService.selectByUserIdAndState(userId,EnumProcess2.UNDER_DETECTIO.getMessage());
        return new ResponseResult<List<Ndjh>>(SUCCESS,data);
    }
    //待审核年度计划
    @RequestMapping("/selectByUserIdAndStateDsh")
    public ResponseResult<List<Ndjh>> selectByUserIdAndStateDsh(HttpSession session){
        String userId=getUserIdFromSession(session);
        List<Ndjh> data=ndjhService.selectByUserIdAndState(userId,EnumProcess2.UNDER_REVIEW.getMessage());
        return new ResponseResult<List<Ndjh>>(SUCCESS,data);
    }
    //审核不通过年度计划
    @RequestMapping("/selectByUserIdAndStateShbtg")
    public ResponseResult<List<Ndjh>> selectByUserIdAndStateShbtg(HttpSession session){
        String userId=getUserIdFromSession(session);
        List<Ndjh> data=ndjhService.selectByUserIdAndState(userId,EnumProcess2.SHANG_AUTID_NOT.getMessage());
        return new ResponseResult<List<Ndjh>>(SUCCESS,data);
    }
    //年度计划同意不同意
    @RequestMapping("/updateStateNot")
    public ResponseResult<Void> updateStateNot(@RequestParam("ndjhId") Integer ndjhId){
      ndjhService.update(ndjhId,EnumProcess2.SHANG_AUTID_NOT.getMessage());
      return new ResponseResult<Void>(SUCCESS);
    }
    @RequestMapping("/updateStateIs")
    public ResponseResult<Void> updateStateIs(@RequestParam("ndjhId")Integer ndjhId){
        ndjhService.update(ndjhId,EnumProcess2.UNDER_DETECTIO.getMessage());
        return new ResponseResult<Void>(SUCCESS);
    }
    @RequestMapping("/updateMonth")
    public ResponseResult<Void> updateMonth(Integer ndjhId,HttpSession session){
        ndjhService.updateMonth(ndjhId);
        return new ResponseResult<Void>(SUCCESS);
    }
    //管理员根据用户品名关联表和年度计划表查询待审核数量
    @RequestMapping("/ByShrIddshCount")
    public ResponseResult<Integer> dshCount(HttpSession session){
        String shrId=getUserIdFromSession(session);
        Integer data=ndjhService.dshCount(shrId,EnumProcess2.UNDER_REVIEW.getMessage());
        return new ResponseResult<Integer>(SUCCESS,data);
    }
    //查询未通过数量
    @RequestMapping("/btgCount")
    public ResponseResult<Integer> btgCount(HttpSession session){
        String userId=getUserIdFromSession(session);
        Integer data=ndjhService.jhCount(userId,EnumProcess2.AUTID_NOT.getMessage());
        return new ResponseResult<Integer>(SUCCESS,data);
    }
}