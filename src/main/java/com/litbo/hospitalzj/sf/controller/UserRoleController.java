package com.litbo.hospitalzj.sf.controller;

import com.litbo.hospitalzj.controller.BaseController;
import com.litbo.hospitalzj.sf.entity.User;
import com.litbo.hospitalzj.sf.entity.UserRole;
import com.litbo.hospitalzj.sf.service.UserRoleService;
import com.litbo.hospitalzj.util.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户角色控制类
 */
@RestController
@RequestMapping("/userrole")
public class UserRoleController extends BaseController {
    @Autowired
    private UserRoleService userRoleService;
    //插入用户角色
    @RequestMapping("/insert")
    public ResponseResult<Void> insertUserRole(UserRole userRole) {
        userRoleService.insert(userRole);
        return new ResponseResult<Void>(SUCCESS);
    }
    //删除用户角色
    @RequestMapping("/delete")
    public ResponseResult<Void> deleteUserRole(@RequestParam("userId")String userId,@RequestParam("roleId")String roleId) {
        userRoleService.delete(userId,roleId);
        return new ResponseResult<Void>(SUCCESS);
    }
}
