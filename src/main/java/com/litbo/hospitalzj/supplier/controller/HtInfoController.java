package com.litbo.hospitalzj.supplier.controller;

import java.io.*;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.litbo.hospitalzj.hospital.enums.EnumProcess;
import com.litbo.hospitalzj.hospital.utils.FileDownLoad;
import com.litbo.hospitalzj.hospital.utils.FileUpload;
import com.litbo.hospitalzj.supplier.controller.ex.FileDownLoadException;
import com.litbo.hospitalzj.supplier.entity.SgdjHw;
import com.litbo.hospitalzj.supplier.mapper.EqInfoMapper;
import com.litbo.hospitalzj.supplier.service.HtLcService;
import com.litbo.hospitalzj.supplier.service.exception.InsertException;
import com.litbo.hospitalzj.supplier.util.Message;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;

import com.litbo.hospitalzj.controller.BaseController;
import com.litbo.hospitalzj.supplier.controller.ex.FileUploadException;
import com.litbo.hospitalzj.supplier.entity.HtInfo;
import com.litbo.hospitalzj.supplier.service.HtInfoService;
import com.litbo.hospitalzj.supplier.util.Upload;
import com.litbo.hospitalzj.supplier.vo.EqHtVo;
import com.litbo.hospitalzj.util.ResponseResult;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;


@RestController
@RequestMapping("/htInfo")
public class HtInfoController extends BaseController {
    @Autowired
    private HtInfoService htinfoService;
    @Autowired
    public HtLcService htLcService;
    @Autowired
    private EqInfoMapper eqInfoMapper;

    //增加合同
    @RequestMapping("/insert")
    public ResponseResult<Integer> insertHtInfo(HtInfo htInfo, HttpSession session) {
        htInfo.setSbcsId(getUidFromSession(session));
        htinfoService.InsertHtInfo(htInfo);
        int htId = htInfo.getHtId();
        session.setAttribute("htId", htId);
        htinfoService.updateHtInfoState(htId, EnumProcess.WAIT_ACCEPT.getMessage());
        htLcService.InsertHtLc(htId, EnumProcess.CONTRACT_ENTRY.getMessage(), new Date());
        return new ResponseResult<Integer>(SUCCESS, htInfo.getHtId());
    }

    //设置状态
    @RequestMapping("/yyys")
    public ResponseResult<Void> updataStatePerfect(String view, Integer htId) {
        if ("同意".equals(view)) {
            //预约验收
            htinfoService.updateHtInfoState(htId, EnumProcess.APPOINMENT_ACCEPTANCE.getMessage());
            htLcService.InsertHtLc(htId, EnumProcess.APPOINMENT_ACCEPTANCE.getMessage(), new Date());
        } else {
            //合同信息不完善
            htinfoService.updateHtInfoState(htId, EnumProcess.IMPERFECT_CONTRACT_INFORMATION.getMessage());
            htLcService.InsertHtLc(htId, EnumProcess.IMPERFECT_CONTRACT_INFORMATION.getMessage(), new Date());
        }
        return new ResponseResult<Void>(SUCCESS);
    }

    //修改合同状态为已发货
    @RequestMapping("/tyys")
    public ResponseResult<Void> updataState(Integer htId) {
        htinfoService.updateHtInfoState(htId, EnumProcess.TONG_YI_YANSHOU.getMessage());
        htLcService.InsertHtLc(htId, EnumProcess.TONG_YI_YANSHOU.getMessage(), new Date());
        return new ResponseResult<Void>(SUCCESS);
    }

    //完善资料
    @RequestMapping("/wszl")
    public ResponseResult<Void> updataStatePerfectOne(Integer htId) {
        htinfoService.updateHtInfoState(htId, EnumProcess.PERFECT_INFORMATION.getMessage());
        htLcService.InsertHtLc(htId, EnumProcess.PERFECT_INFORMATION.getMessage(), new Date());
        return new ResponseResult<Void>(SUCCESS);
    }

    /* //等待审核验收
     @RequestMapping("/ddshjys")
     public ResponseResult<Void> updataStatePerfectTwo(@RequestParam("htId") Integer htId,
                                                       @RequestParam("state") String state) {
         if(state.equals("同意")){
             htinfoService.updateHtInfoState(htId, EnumProcess.WAIT_ACCEPT_YS.getMessage());
             htLcService.InsertHtLc(htId, EnumProcess.WAIT_ACCEPT_YS.getMessage(), new Date());
         }else{
             htinfoService.updateHtInfoState(htId, EnumProcess.WAIT_ACCEPT_YS_NOT.getMessage());
             htLcService.InsertHtLc(htId, EnumProcess.WAIT_ACCEPT_YS_NOT.getMessage(), new Date());
         }
         return new ResponseResult<Void>(SUCCESS);
     }*/
    //等待审核验收
    @RequestMapping("/ddshys")
    public ResponseResult<Void> ddshys(@RequestParam("htId") Integer htId) {
        htinfoService.updateHtInfoState(htId, EnumProcess.WAIT_ACCEPT_YS.getMessage());
        htLcService.InsertHtLc(htId, EnumProcess.WAIT_ACCEPT_YS.getMessage(), new Date());
        return new ResponseResult<Void>(SUCCESS);
    }

    //验收完成
    @RequestMapping("/yswc")
    public ResponseResult<Void> updataStatePerfectThree(Integer htId) {
        htinfoService.updateHtInfoState(htId, EnumProcess.ACCEPT_OVER.getMessage());
        htLcService.InsertHtLc(htId, EnumProcess.ACCEPT_OVER.getMessage(), new Date());
        eqInfoMapper.update(htId, 1);
        return new ResponseResult<Void>(SUCCESS);
    }

    @RequestMapping("/updateInfo")
    public ResponseResult<Void> updateInfo(HtInfo htInfo) {
        htinfoService.updateInfo(htInfo);
        htLcService.InsertHtLc(htInfo.getHtId(), EnumProcess.REVISE_A_CONTRACT.getMessage(), new Date());
        return new ResponseResult<Void>(SUCCESS);
    }

    //通过验证码查询全部合同设备信息
    @RequestMapping("/select")
    public ResponseResult<List<EqHtVo>> selectEqHtVo(String htYzm) {
        List<EqHtVo> data = htinfoService.selectEqHtVo(htYzm);
        return new ResponseResult<List<EqHtVo>>(SUCCESS, data);
    }

    //通过验证码查询合同信息
    @RequestMapping("/yzm")
    public ResponseResult<HtInfo> selectHtInfo(String htYzm) {
        HtInfo data = htinfoService.selectHtInfo(htYzm);
        return new ResponseResult<HtInfo>(SUCCESS, data);
    }

    //通过合同id查询一条合同的信息
    @RequestMapping("/selectOne")
    public ResponseResult<HtInfo> selectOne(Integer htId) {
        HtInfo data = htinfoService.select(htId);
        return new ResponseResult<HtInfo>(SUCCESS, data);
    }

    //生成验证码，并修改
    @RequestMapping("/updateYzm")
    public ResponseResult<Void> updataYzm(@RequestParam("htId") Integer htId, @RequestParam("htYzm") String htYzm, HttpSession session) {
        htinfoService.updateYzm(htId, htYzm, EnumProcess.WAIT_ACCEPT.getMessage());
        htLcService.InsertHtLc(htId, EnumProcess.WAIT_ACCEPT.getMessage(), new Date());
        return new ResponseResult<Void>(SUCCESS);
    }

    //拆分设备，是否需要检测
    @RequestMapping("/htjc")
    public ResponseResult<Void> htjc(@RequestParam("htId") Integer htId) {
        htinfoService.HtJC(htId);
        return new ResponseResult<Void>(SUCCESS);
    }

    //查询状态数量
    @RequestMapping("/countByYyys")
    public ResponseResult<Integer> htStateByYyys() {
        Integer data = htinfoService.count(EnumProcess.WAIT_ACCEPT.getMessage());
        return new ResponseResult<Integer>(SUCCESS, data);
    }

    //等待审核验收数量
    @RequestMapping("/countByDdshys")
    public ResponseResult<Integer> countByDdshys() {
        Integer all = htinfoService.count(EnumProcess.WAIT_ACCEPT_YS.getMessage());
        return new ResponseResult<Integer>(SUCCESS, all);
    }

    //同意验收数量
    @RequestMapping("/countByTyys")
    public ResponseResult<Integer> countByTyys() {
        Integer all = htinfoService.count(EnumProcess.TONG_YI_YANSHOU.getMessage());
        return new ResponseResult<Integer>(SUCCESS, all);
    }

    //调用接口发送短信
    @RequestMapping("/sendInfo")
    public ResponseResult<Integer> sendInfo() {
        Message.sendMessage();
        return new ResponseResult<Integer>(SUCCESS);
    }



}

