package com.litbo.hospitalzj.zk.service.impl;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Calendar;

import com.litbo.hospitalzj.supplier.service.exception.InsertException;
import com.litbo.hospitalzj.supplier.service.exception.NotFoundException;
import javafx.scene.input.DataFormat;
import org.apache.ibatis.annotations.Param;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.litbo.hospitalzj.zk.domian.EqInfo;
import com.litbo.hospitalzj.zk.domian.Yq;
import com.litbo.hospitalzj.zk.mapper.YqMapper;
import com.litbo.hospitalzj.zk.service.YqService;

@Service
public class YqServiceImpl implements YqService{

	@Autowired
	YqMapper yqMapper;

	@Override
	public List<Yq> findByUserId(String userId) {
		return yqMapper.findByUserId(userId);
	}

	@Override
	public List<Yq> findNotByUserId(String userId) {
		return yqMapper.findNotByUserId(userId);
	}

	@Override
	public void insert(Yq yq) {
		yqMapper.insert(yq);
	}

	@Override
	public void delete(String yqId) {
		yqMapper.delete(yqId);
	}

	@Override
	public List<Yq> findAll() {
		return yqMapper.findAll();
	}

	@Override
	public void update(Yq yq) {
		yqMapper.update(yq);
	}

	@Override
	public void deleteBatch(String[] yqId) {
		for(int i=0;i<yqId.length;i++){
			yqMapper.delete(yqId[i]);
		}
	}

	@Override
	public List<Yq> select(Integer eqId) {
		return yqMapper.select(eqId);
	}

	@Override
	public EqInfo selectEqInfo(String eqDah) {
		EqInfo data=yqMapper.selectEqInfo(eqDah);
		if(data==null){
			throw new NotFoundException("您查询的设备不存在");
		}
		return yqMapper.selectEqInfo(eqDah);
	}
	/*@Override
        public List<Yq> selectEqYq(String eqDah) {
            return yqMapper.selectEqYq(eqDah);
        }*/
	//用户查看仪器表数据
	//电器数据
	@Override
	public List<Yq> selectEqYqByEqId(Integer eqId, String jcyqName) {
		return yqMapper.selectEqYqByEqId(eqId, jcyqName);
	}
	//除电器意外的数据
	@Override
	public List<Yq> selectEqYqNotDqByEqId(Integer eqId, String jcyqName) {
		return yqMapper.selectEqYqNotDqByEqId(eqId, jcyqName);
	}


	//根据设备Id查询出设备以及仪器
	@Override
	public EqInfo selectEqInfoByEqid(Integer eqId) {
		return yqMapper.selectEqInfoByEqid(eqId);
	}
	@Override
	public List<Yq> selectEqYqByEqid(Integer eqId) {
		return yqMapper.selectEqYqByEqid(eqId);
	}

	//管理员查看通过设备ID查询设备检测仪器
	//查看非电气仪器表
	@Override
	public List<Yq> selectYqNotDqByEqId(Integer eqId,String jcyqName) {
		return yqMapper.selectYqNotDqByEqId(eqId,jcyqName);
	}
	//查看电气仪器表
	@Override
	public List<Yq> selectYqDqByEqId(Integer eqId,String jcyqName) {
		return yqMapper.selectYqDqByEqId(eqId,jcyqName);
	}

	@Override
	public List<Yq> selectYqByEqId(Integer eqId) {
		return yqMapper.selectYqByEqId(eqId);
	}

	@Override
	public List<Yq>  selectTime(){
		/*List<Yq> data = yqMapper.selectTime();
		Calendar calendar = Calendar.getInstance();
		for (int i = 0; i < data.size(); i++) {
			calendar.setTime(data.get(0).getJcyqJzTime());
			calendar.add(Calendar.MONTH, 10);
			//定义开始时间
			Date startDate = calendar.getTime();
			//定义结束时间，在开始时间之后10秒
			Date endDate = new Date(startDate.getTime() + 12*60*60 * 1000);
			SchedulerFactory sf = new StdSchedulerFactory();
			Scheduler sched = sf.getScheduler();
			//触发器
			Trigger trigger = TriggerBuilder.newTrigger()
					.withIdentity("triggerName", "triggerGroup")
					.startAt(startDate)  //在指定的时间开始执行
					.endAt(endDate)      //在指定的时间结束执行
					.withSchedule(SimpleScheduleBuilder
							.simpleSchedule()
							.withRepeatCount(10)  //执行10次

					).build();
			sched.scheduleJob(job, trigger);
			sched.start();
		}*/
		return null;
	}

}
