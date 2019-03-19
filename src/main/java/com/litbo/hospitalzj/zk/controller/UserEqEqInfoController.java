package com.litbo.hospitalzj.zk.controller;

import com.litbo.hospitalzj.controller.BaseController;
import com.litbo.hospitalzj.util.ResponseResult;
import com.litbo.hospitalzj.zk.Enum.EnumProcess2;
import com.litbo.hospitalzj.zk.domian.Ndjh;
import com.litbo.hospitalzj.zk.service.UserEqEqinfoService;
import com.litbo.hospitalzj.zk.vo.UserEqAndEqInfo;
import com.litbo.hospitalzj.zk.vo.UserEqVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/correlation")
public class UserEqEqInfoController extends BaseController {
    @Autowired
    private UserEqEqinfoService userEqEqinfoService;
    @RequestMapping("/select")
    public ResponseResult<List<UserEqAndEqInfo>> insert(HttpSession session){
        String userId=getUserIdFromSession(session);
        System.out.println(userId);
        List<UserEqAndEqInfo> data=userEqEqinfoService.select(userId);
        return new ResponseResult<List<UserEqAndEqInfo>>(SUCCESS,data);
    }
    //根据审核人id查询待审核
    @RequestMapping("/findByShrIdEqDsh")
    public ResponseResult<List<UserEqVo>> findByUserIdEqDsh(HttpSession session){
        String shrId=getUserIdFromSession(session);
        List<UserEqVo> eqList=userEqEqinfoService.findUserEqVo(shrId, EnumProcess2.UNDER_REVIEW.getMessage());
        return new ResponseResult<List<UserEqVo>>(SUCCESS,eqList);
    }
    //根据审核人id查询待审核数量
    @RequestMapping("/findByShrIdEqDshCount")
    public ResponseResult<Integer> findByShrIdEqDshCount(HttpSession session){
        String shrId=getUserIdFromSession(session);
        Integer eqList=userEqEqinfoService.findByShrIdEqDshCount(shrId, EnumProcess2.UNDER_REVIEW.getMessage());
        return new ResponseResult<Integer>(SUCCESS,eqList);
    }
    //待审核(用户)
    @RequestMapping("/findEqDshU")
    public ResponseResult<List<UserEqVo>> findEqShzY(HttpSession session){
        String userId=getUserIdFromSession(session);
        List<UserEqVo> eqList=userEqEqinfoService.findUserEqVoY(userId, EnumProcess2.UNDER_REVIEW.getMessage());
        return new ResponseResult<List<UserEqVo>>(SUCCESS,eqList);
    }
}
