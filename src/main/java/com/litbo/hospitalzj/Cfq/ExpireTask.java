package com.litbo.hospitalzj.Cfq;

import com.litbo.hospitalzj.sf.service.UserService;
import com.litbo.hospitalzj.zk.domian.Yq;
import com.litbo.hospitalzj.zk.domian.YqTsls;
import com.litbo.hospitalzj.zk.mapper.YqTslsMapper;
import com.litbo.hospitalzj.zk.service.YqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

public class ExpireTask {
    @Autowired
    private UserService userService;
    @Autowired
    private YqService yqService;
    @Autowired
    private YqTslsMapper yqTslsMapper;
    //每天早上0点执行
    @Scheduled(cron = "0 0 10,14,16 * * ? ")
    public void productExpire() {
        //距离到期还有2个月提醒
        String twoMonthExpireDate = DateUtil.addTwoMonth();
        dealExpireYq(twoMonthExpireDate);

    }
    private void dealExpireYq(String expireDate){
        List<Yq> data=yqService.selectTime();
        YqTsls yqTsls=new YqTsls();
        for(Yq yq:data){
          Calendar calendar = Calendar.getInstance();
          calendar.setTime(yq.getJcyqJzTime());
          calendar.add(Calendar.MONTH, 12);
          yqTsls.setYqExpireDate(calendar.getTime());
          yqTsls.setYqName(yq.getJcyqName());
          yqTsls.setPushMsg("您的检测仪器时间：" + yq.getJcyqName() + "，将于" + calendar.getTime() + "即将过期，请及时处理！");
          yqTslsMapper.insert(yqTsls);
      }
    }
    @Scheduled(cron = "0 0 12,15,17 * * ? ")
    public void pushMsgExpire() {
        List<Yq> data=yqService.selectTime();
        YqTsls yqTsls=new YqTsls();
        for(Yq yq:data) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(yq.getJcyqJzTime());
            calendar.add(Calendar.MONTH, 12);
            //推送消息只存在1天，根据到期时间将数据删除
            yqTslsMapper.delete(calendar.getTime());
        }
    }
}
