package com.litbo.hospitalzj.hospital.service.impl;

import com.litbo.hospitalzj.hospital.entity.EqDhdj;
import com.litbo.hospitalzj.hospital.mapper.EqDhdjMapper;
import com.litbo.hospitalzj.hospital.service.EqDhdjService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EqDhdjServiceImpl implements EqDhdjService {
    @Autowired
    private EqDhdjMapper eqDhdjMapper;
    @Override
    public void insert(EqDhdj eqDhdj) {
        eqDhdjMapper.insert(eqDhdj);
    }
}
