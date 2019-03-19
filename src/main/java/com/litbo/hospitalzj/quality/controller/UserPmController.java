package com.litbo.hospitalzj.quality.controller;

import com.litbo.hospitalzj.controller.BaseController;
import com.litbo.hospitalzj.quality.entity.EqPm;
import com.litbo.hospitalzj.quality.entity.UserPm;
import com.litbo.hospitalzj.quality.service.EqPmService;
import com.litbo.hospitalzj.quality.service.UserPmService;
import com.litbo.hospitalzj.quality.vo.UserPmVo;
import com.litbo.hospitalzj.util.ResponseResult;
import com.litbo.hospitalzj.zk.Enum.EnumProcess2;
import com.litbo.hospitalzj.zk.domian.Ndjh;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 用户设备名关联
 */
@RestController
@RequestMapping("/userpm")
public class UserPmController extends BaseController {
    @Autowired
    private UserPmService userPmService;
    @Autowired
    private EqPmService eqPmService;

    //测试通过
    //为用户添加检测设备品名
    @RequestMapping("/insert")
    public ResponseResult<Void> insert(UserPm userPm,HttpSession session) {
        String shrId=getUserIdFromSession(session);
        userPm.setShrId(shrId);
        userPm.setState(EnumProcess2.TO_AUDIT.getMessage());
        userPmService.insert(userPm);
        return new ResponseResult<Void>(SUCCESS);
    }
    @RequestMapping("/delete")
    public ResponseResult<Void> delete(@RequestParam("userId") String userId, @RequestParam("eqPmId") String eqPmId) {
        userPmService.delete(userId,eqPmId);
        return new ResponseResult<Void>(SUCCESS);
    }

    //测试通过
    //查询用户分配的检测设备
    @RequestMapping("/findJcPmByUserId/{userId}")
    public ResponseResult<List<EqPm>> findJcSbByUserId(@PathVariable String userId){
        List<EqPm> data=eqPmService.findJcPmByUserId(userId);
        return new ResponseResult<List<EqPm>>(SUCCESS,data);
    }
    //查询用户分配的检测设备（session）
    @RequestMapping("/findJcPmByUserId")
    public ResponseResult<List<EqPm>> findJcPmByUserId(HttpSession session){
        String userId =getUserIdFromSession(session);
        List<EqPm> data=eqPmService.findJcPmByUserId(userId);
        return new ResponseResult<List<EqPm>>(SUCCESS,data);
    }
    //测试通过
    //查询用户未分配的检测设备
    @RequestMapping("/findJcPmNotByUserId/{userId}")
    public ResponseResult<List<EqPm>> findJcPmNotByUserId(@PathVariable String userId){
        List<EqPm> data=eqPmService.findJcPmNotByUserId(userId);
        return new ResponseResult<List<EqPm>>(SUCCESS,data);
    }
    //待上报状态（待上报检测任务）
    @RequestMapping("/findByUserIdandStateDsb")
    public ResponseResult<List<UserPmVo>> findByUserIdandStateDsb(HttpSession session){
        String userId =getUserIdFromSession(session);
        List<UserPmVo> data=userPmService.findByUserIdandState(userId,EnumProcess2.TO_AUDIT.getMessage());
        return new ResponseResult<List<UserPmVo>>(SUCCESS,data);
    }
    //待上报个数
    @RequestMapping("/dsbCount")
    public ResponseResult<Integer> DsbCount(HttpSession session){
        String userId =getUserIdFromSession(session);
        Integer data=userPmService.dsbNum(userId,EnumProcess2.TO_AUDIT.getMessage());
        return new ResponseResult<Integer>(SUCCESS,data);
    }
}
