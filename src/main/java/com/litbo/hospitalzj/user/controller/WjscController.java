package com.litbo.hospitalzj.user.controller;

import com.litbo.hospitalzj.controller.BaseController;
import com.litbo.hospitalzj.hospital.utils.FileDownLoad;
import com.litbo.hospitalzj.hospital.utils.FileUpload;
import com.litbo.hospitalzj.supplier.entity.HtInfo;
import com.litbo.hospitalzj.user.bean.EqNdjh;
import com.litbo.hospitalzj.user.bean.Wjsc;
import com.litbo.hospitalzj.user.service.WjscService;
import com.litbo.hospitalzj.util.ResponseResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Time;
import java.util.Date;
import java.util.List;

//文件上传控制类
@RestController
@RequestMapping("/wjsc")
public class WjscController extends BaseController {
    @Autowired
    private WjscService wjscService;
    @RequestMapping("/insertHtwj")
    public ResponseResult<Void> insertHtwj(Wjsc wjsc, @RequestParam("file") MultipartFile file,HttpSession session) {
        String path = FileUpload.uploadOne(file,session);
        System.out.println(path);
        wjsc.setSourceType(0);
        wjsc.setPath(path);
        wjsc.setScTime(new Date());
        wjscService.insert(wjsc);
        return new ResponseResult<Void>(SUCCESS);
    }
    @RequestMapping("/insertDhdj")
    public ResponseResult<Void> insertDhdj(Wjsc wjsc, @RequestParam("file") MultipartFile file,HttpSession session) {
        String path = FileUpload.uploadOne(file,session);
        System.out.println(path);
        wjsc.setSourceType(1);
        wjsc.setPath(path);
        wjsc.setScTime(new Date());
        wjscService.insert(wjsc);
        return new ResponseResult<Void>(SUCCESS);
    }
    @RequestMapping("/insertWszl")
    public ResponseResult<Void> insertWszl(Wjsc wjsc, @RequestParam("file") MultipartFile file,HttpSession session) {
        String path = FileUpload.uploadOne(file,session);
        System.out.println(path);
        wjsc.setSourceType(2);
        wjsc.setPath(path);
        wjsc.setScTime(new Date());
        wjscService.insert(wjsc);
        return new ResponseResult<Void>(SUCCESS);
    }
    @RequestMapping("/delete")
    public ResponseResult<Void> delete(Integer htId) {
        wjscService.delete(htId);
        return new ResponseResult<Void>(SUCCESS);
    }
    //sourceType供应商，验收
    //sourceId来源id，httongid
    //文件类型
    @RequestMapping("/select")
    public ResponseResult<List<Wjsc>> select(@RequestParam("sourceType")Integer sourceType, @RequestParam("sourceId")Integer sourceId, @RequestParam("type")Integer type) {
        List<Wjsc> data=wjscService.select(sourceType,sourceId,type);
        return new ResponseResult<List<Wjsc>>(SUCCESS,data);
    }
    //文件下载
    @RequestMapping("/downloadFile")
    private ResponseResult<Void> downloadFile(String filePath, HttpServletResponse response, HttpSession session) throws FileNotFoundException, IllegalStateException{
        File path = new File(ResourceUtils.getURL("classpath:").getPath());
        System.out.println(path);
        if(!path.exists()) path = new File("");
        File upload = new File(path.getAbsolutePath(),"static/images/");
        if(!upload.exists()) upload.mkdirs();
        String path1=upload.getAbsolutePath()+filePath;
        FileDownLoad.downloadFile1(response,path1,"1.jpg");
        return new ResponseResult<Void>(SUCCESS);
    }
}
