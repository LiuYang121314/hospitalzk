package com.litbo.hospitalzj.supplier.controller;

import com.litbo.hospitalzj.controller.BaseController;
import com.litbo.hospitalzj.supplier.entity.EqCgfs;
import com.litbo.hospitalzj.supplier.entity.SuInfo;
import com.litbo.hospitalzj.supplier.service.SuInfoService;
import com.litbo.hospitalzj.supplier.vo.SuInfoAndZzInfo;
import com.litbo.hospitalzj.util.ResponseResult;

import net.sf.jsqlparser.statement.select.Offset;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/suinfo")
public class SuInfoController extends BaseController {
    @Autowired
    private SuInfoService suInfoService;
    @RequestMapping("/login")
    public ResponseResult<SuInfo> handleLogin(
            @RequestParam("username") String suMc,
            @RequestParam("password") String password,
            HttpSession session) {
        // 执行登录
        SuInfo user= suInfoService.login(suMc, password);
        System.out.println(user.getSuId());
        session.setAttribute("suMc", user.getSuMc());
        session.setAttribute("suId", user.getSuId());
        System.out.println(getUidFromSession(session));
        // 返回
        return new ResponseResult<>(SUCCESS, user);
    }
    @RequestMapping("/one")
    public ResponseResult<SuInfoAndZzInfo> getByCode(HttpSession session) {
        Integer suId=getUidFromSession(session);
        SuInfoAndZzInfo data=suInfoService.findSuById(suId);
        return new ResponseResult<SuInfoAndZzInfo>(SUCCESS,data);
    }
    @RequestMapping("/insert")
    public ResponseResult<Integer> insert(SuInfo suInfo) {
        suInfo.setIsDelete(0);
        suInfoService.insert(suInfo);
        return new ResponseResult<Integer>(SUCCESS, suInfo.getSuId());
    }
    @RequestMapping("/delete")
    public ResponseResult<Void> delete(@RequestParam("suId") Integer suId) {
        suInfoService.delete(suId,1);
        return new ResponseResult<Void>(SUCCESS);
    }
    @RequestMapping("/all")
    public ResponseResult<List<SuInfo>> getAll() {
        List<SuInfo> data=suInfoService.selectAll();
        return new ResponseResult<List<SuInfo>>(SUCCESS,data);
    }
    @RequestMapping("/update")
    public ResponseResult<Void> update(SuInfo suInfo) {
        suInfoService.update(suInfo);
        return new ResponseResult<Void>(SUCCESS);
    }
    @RequestMapping("/updateStateIs")
    public ResponseResult<Void> updateStateIs(Integer suId) {
        suInfoService.updateState(suId,1);
        return new ResponseResult<Void>(SUCCESS);
    }
    @RequestMapping("/updateStateNot")
    public ResponseResult<Void> updateStateNot(Integer suId) {
        suInfoService.updateState(suId,2);
        return new ResponseResult<Void>(SUCCESS);
    }
    @RequestMapping("/findBySuMcLike")
    public ResponseResult<List<SuInfo>> findBySuMcLike(String suMc) {
        List<SuInfo> data=suInfoService.findBySuMcLike(suMc);
        return new ResponseResult<List<SuInfo>>(SUCCESS,data);
    }
    //待审核供应商
    @RequestMapping("/findSuByStateSh")
    public ResponseResult<List<SuInfo>> findSuByStateSh() {
        List<SuInfo> data=suInfoService.findSuByState(0);
        return new ResponseResult<List<SuInfo>>(SUCCESS,data);
    }
    //已审核供应商
    @RequestMapping("/findSuByStateXg")
    public ResponseResult<List<SuInfo>> findSuByStateXg() {
        List<SuInfo> data=suInfoService.findSuByState(1);
        return new ResponseResult<List<SuInfo>>(SUCCESS,data);
    }
    //供应商申请数量
    @RequestMapping("/countByGyssq")
    public ResponseResult<Integer> countByGyssq() {
        Integer data=suInfoService.count(0);
        return new ResponseResult<Integer>(SUCCESS,data);
    }
    //修改密码
    @RequestMapping("/updatePwd")
    public ResponseResult<Void> updatePwd(@RequestParam("suId")Integer suId,@RequestParam("password") String password) {
        suInfoService.updatePwd(suId,password);
        return new ResponseResult<Void>(SUCCESS);
    }
    //发送密码和用户
    @RequestMapping("/mail")
	public ResponseResult<Void> sendMail(@RequestParam("email") String email,
			@RequestParam("suMc") String suMc,
			@RequestParam("password") String password,
			HttpSession session) throws MessagingException {
		suInfoService.sendEmail(suMc,email,password);
		return new ResponseResult<>(SUCCESS);
	}
}
