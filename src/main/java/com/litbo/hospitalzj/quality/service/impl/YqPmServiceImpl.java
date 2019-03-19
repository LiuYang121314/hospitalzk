package com.litbo.hospitalzj.quality.service.impl;

import com.litbo.hospitalzj.quality.entity.YqPm;
import com.litbo.hospitalzj.quality.mapper.YqPmMapper;
import com.litbo.hospitalzj.quality.service.YqPmService;
import com.litbo.hospitalzj.service.exception.InsertException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 仪器品名业务层
 */
@Service
public class YqPmServiceImpl implements YqPmService {
    @Autowired
    private YqPmMapper yqPmMapper;

    @Override
    public void insert(YqPm yqPm) {
        YqPm data=yqPmMapper.selectById(yqPm.getYqId(),yqPm.getEqPmId());
        if(data!=null){
            throw new InsertException("仪器品名已关联");
        }
        yqPmMapper.insert(yqPm);
    }

    @Override
    public void delete(String yqId, String eqPmId) {
        yqPmMapper.delete(yqId, eqPmId);
    }

}
