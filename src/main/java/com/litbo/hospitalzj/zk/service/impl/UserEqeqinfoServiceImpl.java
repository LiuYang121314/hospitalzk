package com.litbo.hospitalzj.zk.service.impl;

import com.litbo.hospitalzj.zk.mapper.UserEqEqInfoMapper;
import com.litbo.hospitalzj.zk.service.UserEqEqinfoService;
import com.litbo.hospitalzj.zk.vo.UserEqAndEqInfo;
import com.litbo.hospitalzj.zk.vo.UserEqVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserEqeqinfoServiceImpl implements UserEqEqinfoService {
@Autowired
private UserEqEqInfoMapper userEqEqInfoMapper;

    @Override
    public List<UserEqAndEqInfo> select(String shrId) {
        return userEqEqInfoMapper.select(shrId);
    }
    //根据审核人id查询待审核
    @Override
    public List<UserEqVo> findUserEqVo(String shrId, String state) {
        return userEqEqInfoMapper.findUserEqVo(shrId,state);
    }
    //根据审核人id查询待审核数量
    @Override
    public int findByShrIdEqDshCount(String shrId, String state) {
        return userEqEqInfoMapper.findByShrIdEqDshCount(shrId, state);
    }
    //根据用户id查询待审核
    @Override
    public List<UserEqVo> findUserEqVoY(String userId, String state) {
        return userEqEqInfoMapper.findUserEqVoY(userId, state);
    }

}
