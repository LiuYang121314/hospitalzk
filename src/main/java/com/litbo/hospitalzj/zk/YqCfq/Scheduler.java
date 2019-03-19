package com.litbo.hospitalzj.zk.YqCfq;

import com.litbo.hospitalzj.zk.domian.Yq;
import com.litbo.hospitalzj.zk.mapper.YqMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.List;

@Component
public class Scheduler {
    @Autowired
    YqMapper yqMapper;
    //每隔2秒执行一次
    @Scheduled(fixedRate = 2000)
    public void testTasks() {
        List<Yq> data = yqMapper.selectTime();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(data.get(0).getJcyqJzTime());
            calendar.add(Calendar.MONTH, 10);
            System.out.println("定时任务执行时间：" + calendar.getTime());
        }

    }

  /*  //每天3：05执行
    @Scheduled(cron = "0 05 03 ? * *")
    public void testTasks() {
        System.out.println("定时任务执行时间：" + dateFormat.format(new Date()));
    }*/
