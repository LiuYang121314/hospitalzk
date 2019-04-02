package com.litbo.hospitalzj.zk.service.impl;

import com.litbo.hospitalzj.zk.domian.YqJxjl;
import com.litbo.hospitalzj.zk.mapper.YqJxjlMapper;
import com.litbo.hospitalzj.zk.service.YqEqService;
import com.litbo.hospitalzj.zk.service.YqJxjlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class YqJxjlServiceImpl implements YqJxjlService {
    @Autowired
    private YqJxjlMapper yqJxjlMapper;
    @Override
    public List<YqJxjl> selectAll() {
        return yqJxjlMapper.selectAll();
    }

    @Override
    public void insert(YqJxjl yqJxjl) {
        yqJxjlMapper.insert(yqJxjl);
    }

    @Override
    public void update(YqJxjl yqJxjl) {
        yqJxjlMapper.update(yqJxjl);
    }

    @Override
    public void updateState(Integer state, Integer id) {
        yqJxjlMapper.updateState(state,id);
    }

    @Override
    public List<YqJxjl> selectNew() {
        List<YqJxjl> data=yqJxjlMapper.selectAll();
        List<YqJxjl> newYqJxjl=new ArrayList<YqJxjl>();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
        for(YqJxjl yqJxjl:data){
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(yqJxjl.getYqJxtime());
            calendar.add(Calendar.MONTH, 10);
            Date time=calendar.getTime();
        }
        return null;
    }
}
