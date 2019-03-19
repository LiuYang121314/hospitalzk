package com.litbo.hospitalzj.zk.YqCfq;

import com.litbo.hospitalzj.zk.domian.Yq;
import com.litbo.hospitalzj.zk.mapper.YqMapper;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Myjob implements Job {

    @Autowired
    public YqMapper yqMapper;
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException{
        List<Yq> data = yqMapper.selectTime();
        Calendar calendar = Calendar.getInstance();
        for (int i = 0; i < data.size(); i++) {
            calendar.setTime(data.get(i).getJcyqJzTime());
            calendar.add(Calendar.MONTH, 10);
            System.out.println();
        }


    }


}
