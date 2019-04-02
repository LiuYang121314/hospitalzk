package com.litbo.hospitalzj.quality.service.impl;

import com.litbo.hospitalzj.quality.entity.EqXeq;
import com.litbo.hospitalzj.quality.mapper.EqXeqMapper;
import com.litbo.hospitalzj.quality.service.EqXeqService;
import com.litbo.hospitalzj.supplier.service.exception.InsertException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EqXeqServiceImpl implements EqXeqService {
    @Autowired
    private EqXeqMapper eqXeqMapper;

    @Override
    public void update(EqXeq eqXeq) {
        eqXeqMapper.update(eqXeq);
    }

    @Override
    public void insert(EqXeq eqXeq) {
        EqXeq data=eqXeqMapper.findByName(eqXeq.getEqName());
        if(data!=null){
            throw new InsertException("此条信息已存在");
        }
        eqXeqMapper.insert(eqXeq);
    }

    @Override
    public void delete(Integer id) {
        eqXeqMapper.delete(id);
    }

    @Override
    public List<EqXeq> all() {
        return eqXeqMapper.all();
    }

    @Override
    public List<EqXeq> findEqXeqLike(String data) {
        return eqXeqMapper.findEqXeqLike(data);
    }


}
