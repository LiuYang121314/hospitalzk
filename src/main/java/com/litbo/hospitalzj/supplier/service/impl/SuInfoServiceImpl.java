package com.litbo.hospitalzj.supplier.service.impl;

import com.litbo.hospitalzj.supplier.entity.SuInfo;
import com.litbo.hospitalzj.supplier.mapper.SuInfoMapper;
import com.litbo.hospitalzj.supplier.service.SuInfoService;
import com.litbo.hospitalzj.supplier.service.exception.InsertException;
import com.litbo.hospitalzj.supplier.service.exception.PasswordNotMatchException;
import com.litbo.hospitalzj.supplier.service.exception.UpdateException;
import com.litbo.hospitalzj.supplier.service.exception.UserNotFoundException;
import com.litbo.hospitalzj.supplier.vo.SuInfoAndZzInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuInfoServiceImpl implements SuInfoService {
    @Autowired
    private SuInfoMapper suInfoMapper;
    @Override
    public SuInfo login(String suMc, String password)
            throws UserNotFoundException, PasswordNotMatchException {
        // 根据参数suMc查询用户数据
        SuInfo data = suInfoMapper.findSuByMc(suMc);
        // 判断用户数据是否为null
        if (data == null) {
            // 是：为null，用户名不存在，则抛出UserNotFoundException
            throw new UserNotFoundException(
                    "登录失败！您尝试登录的企业或公司不存在！请注册");
        }
        if (password.equals(data.getPassword())) {
            return data;
        }else {
            // 否：不匹配，密码错误，则抛出PasswordNotMatchException
            throw new PasswordNotMatchException(
                    "登录失败！资格证号码错误！");
        }
    }
    @Override
    public void insert(SuInfo suInfo) {
        SuInfo data=suInfoMapper.findSuByMc(suInfo.getSuMc());
        if(data!=null){
            throw new InsertException("此公司已存在，请使用用户名，密码登陆");
        }
        suInfoMapper.insert(suInfo);
    }

    @Override
    public void delete(Integer suId, Integer isDelete) {
        suInfoMapper.delete(suId,isDelete);
    }

    @Override
    public void update(SuInfo suInfo) {
        SuInfo data=suInfoMapper.findSuByMc(suInfo.getSuMc());
        if(data!=null){
            throw new UpdateException("此公司已存在，请重新修改");
        }
        suInfoMapper.update(suInfo);
    }

    @Override
    public void updateState(Integer suId, Integer state) {
        suInfoMapper.updateState(suId,state);
    }

    @Override
    public List<SuInfo> selectAll() {
        return suInfoMapper.selectAll();
    }

    @Override
    public SuInfoAndZzInfo findSuById(Integer suId) {
        return suInfoMapper.findSuById(suId);
    }

    @Override
    public List<SuInfo> findBySuMcLike(String suMc) {
        return suInfoMapper.findBySuMcLike(suMc);
    }

    @Override
    public Integer count(Integer state) {
        return suInfoMapper.count(state);
    }

    @Override
    public List<SuInfo> findSuByState(Integer state) {
        return suInfoMapper.findSuByState(state);
    }

    @Override
    public void updatePwd(Integer suId, String password) {
        suInfoMapper.updatePwd(suId,password);
    }
}
