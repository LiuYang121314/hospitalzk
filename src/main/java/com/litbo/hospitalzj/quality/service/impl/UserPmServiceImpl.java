package com.litbo.hospitalzj.quality.service.impl;

import com.litbo.hospitalzj.quality.entity.UserPm;
import com.litbo.hospitalzj.quality.mapper.UserPmMapper;
import com.litbo.hospitalzj.quality.service.UserPmService;
import com.litbo.hospitalzj.quality.vo.UserPmVo;
import com.litbo.hospitalzj.supplier.service.exception.InsertException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户设备名关联
 */
@Service
public class UserPmServiceImpl implements UserPmService {
    @Autowired
    private UserPmMapper userPmMapper;
    //删除用户设备名关联
    @Override
    public void delete(String userId, String eqPmId) {
        userPmMapper.delete(userId,eqPmId);
    }
    //插入用户设备名关联
    @Override
    public void insert(UserPm userPm) {
        int data=userPmMapper.findNum(userPm.getUserId(),userPm.getEqPmId());
        if(data==1){
            throw new InsertException("此用户已经分配了此种设备");
        }
        userPmMapper.insert(userPm);
    }
    //查询状态设备名称
    @Override
    public List<UserPmVo> findByUserIdandState(String userId, String state) {
        return userPmMapper.findByUserIdandState(userId,state);
    }

    @Override
    public void setuserPmState(String userId, String eqPmId, String state) {
        userPmMapper.setuserPmState(userId, eqPmId,state);
    }

    @Override
    public String selectShrId(String userId, String eqPmId) {
        return userPmMapper.selectShrId(userId,eqPmId);
    }

    @Override
    public int dsbNum(String userId, String state) {
        return userPmMapper.dsbNum(userId, state);
    }
}
