package com.litbo.hospitalzj.supplier.service.impl;

import com.litbo.hospitalzj.supplier.entity.SuInfo;
import com.litbo.hospitalzj.supplier.mapper.SuInfoMapper;
import com.litbo.hospitalzj.supplier.service.SuInfoService;
import com.litbo.hospitalzj.supplier.service.exception.InsertException;
import com.litbo.hospitalzj.supplier.service.exception.UpdateException;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuInfoServiceImpl implements SuInfoService {
    @Autowired
    private SuInfoMapper suInfoMapper;
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
    public List<SuInfo> selectAll(@Param("offset")Integer offset, @Param("count") Integer count) {
        return suInfoMapper.selectAll(offset,count);
    }

    @Override
    public SuInfo findSuById(Integer suId) {
        return suInfoMapper.findSuById(suId);
    }

    @Override
    public List<SuInfo> findBySuMcLike(String suMc) {
        return suInfoMapper.findBySuMcLike(suMc);
    }
}
