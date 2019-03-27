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
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.litbo.hospitalzj.controller.BaseController;
import com.litbo.hospitalzj.supplier.controller.ex.FileUploadException;
import com.litbo.hospitalzj.supplier.entity.HtInfo;
import com.litbo.hospitalzj.supplier.service.HtInfoService;
import com.litbo.hospitalzj.supplier.util.Upload;
import com.litbo.hospitalzj.supplier.vo.EqHtVo;
import com.litbo.hospitalzj.util.ResponseResult;


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
    @RequestMapping("/yfh")
    public ResponseResult<Void> updataState(Integer htId) {
        htinfoService.updateHtInfoState(htId, EnumProcess.YI_FA_HUO.getMessage());
        htLcService.InsertHtLc(htId, EnumProcess.YI_FA_HUO.getMessage(), new Date());
        return new ResponseResult<Void>(SUCCESS);
    }
    //完善资料
    @RequestMapping("/wszl")
    public ResponseResult<Void> updataStatePerfectOne(Integer htId) {
        htinfoService.updateHtInfoState(htId, EnumProcess.PERFECT_INFORMATION.getMessage());
        htLcService.InsertHtLc(htId, EnumProcess.PERFECT_INFORMATION.getMessage(), new Date());
        return new ResponseResult<Void>(SUCCESS);
    }

    //等待审核验收
    @RequestMapping("/ddshjys")
    public ResponseResult<Void> updataStatePerfectTwo(Integer htId) {
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


    //通过供货商id查询在供货商下的所有的合同信息
    @RequestMapping("/selectHtInfo")
    public ResponseResult<List<HtInfo>> selectHtInfo(HttpSession session) {
        Integer sbcsId = getUidFromSession(session);
        List<HtInfo> htInfos = htinfoService.selectHtinfo(sbcsId);
        return new ResponseResult<List<HtInfo>>(SUCCESS, htInfos);
    }

    //上传文件图片
    @PostMapping("/uploadOne")
    public ResponseResult<String> uploadOne(
            @RequestParam("htId") Integer htId,
            @RequestParam("file") MultipartFile file,
            HttpSession session) {
        if(htinfoService.select(htId)==null){
            ResponseResult responseResult = new ResponseResult();
            responseResult.setMessage("找不到合同号");
            return responseResult;
        }
        String path = FileUpload.uploadOne(file,session);
        System.out.println(path);
        HtInfo data = htinfoService.select(htId);
       /* if(data!=null&&data.getHtFile1().split(" ").length>7){
            ResponseResult responseResult = new ResponseResult();
            responseResult.setMessage("图片过多");
            return responseResult;
        }*/
        int res  = htinfoService.updateOne(htId,path);
        return new ResponseResult(SUCCESS);
    }

    @PostMapping("/uploadTwo")
    public ResponseResult<String> uploadTwo(
            @RequestParam("htId") Integer htId,
            @RequestParam("file") MultipartFile file) {
        if(htinfoService.select(htId)==null){
            ResponseResult responseResult = new ResponseResult();
            responseResult.setMessage("找不到合同号");
            return responseResult;
        }
        String path = FileUpload.upload("images/upload/",file);
        System.out.println(path);
        HtInfo data = htinfoService.select(htId);
        System.out.println(data);
        System.out.println(htId);
       /* if(data!=null&&data.getHtFile1().split(" ").length>7){
            ResponseResult responseResult = new ResponseResult();
            responseResult.setMessage("图片过多");
            return responseResult;
        }*/
        int res  = htinfoService.updateTwo(htId,path);
        return new ResponseResult(SUCCESS);
    }

    @PostMapping("/uploadThree")
    public ResponseResult<String> uploadThree(
            @RequestParam("htId") Integer htId,
            @RequestParam("file") MultipartFile file) {
        if(htinfoService.select(htId)==null){
            ResponseResult responseResult = new ResponseResult();
            responseResult.setMessage("找不到合同号");
            return responseResult;
        }
        String path = FileUpload.upload("images/upload/",file);
        System.out.println(path);
        HtInfo data = htinfoService.select(htId);
        System.out.println(data);
        System.out.println(htId);
       /* if(data!=null&&data.getHtFile1().split(" ").length>7){
            ResponseResult responseResult = new ResponseResult();
            responseResult.setMessage("图片过多");
            return responseResult;
        }*/
        int res  = htinfoService.updateThree(htId,path);
        return new ResponseResult(SUCCESS);
    }

    @PostMapping("/uploadFour")
    public ResponseResult<String> uploadFour(
            @RequestParam("htId") Integer htId,
            @RequestParam("file") MultipartFile file) {
        if(htinfoService.select(htId)==null){
            ResponseResult responseResult = new ResponseResult();
            responseResult.setMessage("找不到合同号");
            return responseResult;
        }
        String path = FileUpload.upload("images/upload/",file);
        System.out.println(path);
        HtInfo data = htinfoService.select(htId);
        System.out.println(data);
        System.out.println(htId);
       /* if(data!=null&&data.getHtFile1().split(" ").length>7){
            ResponseResult responseResult = new ResponseResult();
            responseResult.setMessage("图片过多");
            return responseResult;
        }*/
        int res  = htinfoService.updateFour(htId,path);
        return new ResponseResult(SUCCESS);
    }

    @PostMapping("/uploadFive")
    public ResponseResult<String> uploadFive(
            @RequestParam("htId") Integer htId,
            @RequestParam("file") MultipartFile file) {
        if(htinfoService.select(htId)==null){
            ResponseResult responseResult = new ResponseResult();
            responseResult.setMessage("找不到合同号");
            return responseResult;
        }
        String path = FileUpload.upload("images/upload/",file);
        System.out.println(path);
        HtInfo data = htinfoService.select(htId);
        System.out.println(data);
        System.out.println(htId);
       /* if(data!=null&&data.getHtFile1().split(" ").length>7){
            ResponseResult responseResult = new ResponseResult();
            responseResult.setMessage("图片过多");
            return responseResult;
        }*/
        int res  = htinfoService.updateFive(htId,path);
        return new ResponseResult(SUCCESS);
    }

   /* @RequestMapping("/downloadFile")
    private ResponseResult<Void> downloadFile(String filePath, HttpServletResponse response,HttpSession session) {
        String parentPath = session.getServletContext().getRealPath(UPLOAD_DIR_NAME);
        System.out.println(parentPath+filePath);
        FileDownLoad.downloadFile1(response,filePath,"111.jpg");
            return new ResponseResult<Void>(SUCCESS);
    }*/
    @RequestMapping("/showFile1")
    public ResponseResult showFile1(Integer htId){
        String[] imgs = htinfoService.showFile1(htId);
        return new ResponseResult(SUCCESS,imgs);
    }
    @RequestMapping("/showFile2")
    public ResponseResult showFile2(Integer htId){
        String[] imgs = htinfoService.showFile2(htId);
        return new ResponseResult(SUCCESS,imgs);
    }
}

