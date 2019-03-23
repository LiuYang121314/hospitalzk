package com.litbo.hospitalzj.sf.controller;

import com.litbo.hospitalzj.controller.BaseController;
import com.litbo.hospitalzj.sf.entity.Role;
import com.litbo.hospitalzj.sf.entity.User;
import com.litbo.hospitalzj.sf.service.RoleService;
import com.litbo.hospitalzj.util.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 角色控制层
 */
@RestController
@RequestMapping("/role")
public class RoleController extends BaseController {
    @Autowired
    private RoleService roleService;
    //查询所有角色
    @RequestMapping("/all")
    public ResponseResult<List<Role>> findAll() {
        List<Role> data=roleService.findAll();
        return new ResponseResult<List<Role>>(SUCCESS,data);
    }
}
