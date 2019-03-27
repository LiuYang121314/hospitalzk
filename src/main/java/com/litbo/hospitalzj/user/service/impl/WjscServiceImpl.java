package com.litbo.hospitalzj.user.service.impl;

import com.litbo.hospitalzj.user.bean.Wjsc;
import com.litbo.hospitalzj.user.dao.WjscDao;
import com.litbo.hospitalzj.user.service.WjscService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//文件上传业务层
@Service
public class WjscServiceImpl implements WjscService {
    @Autowired
    private WjscDao wjscDao;
    @Override
    public void insert(Wjsc wjsc) {
        wjscDao.insert(wjsc);
    }

    @Override
    public void delete(Integer id) {
        wjscDao.delete(id);
    }
    //sourceType供应商，验收
    //sourceId来源id，httongid
    //文件类型
    @Override
    public List<Wjsc> select(Integer sourceType, Integer sourceId, Integer type) {
        return wjscDao.select(sourceType, sourceId, type);
    }
}
