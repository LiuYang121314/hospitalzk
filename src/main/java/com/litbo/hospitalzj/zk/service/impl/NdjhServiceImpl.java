package com.litbo.hospitalzj.zk.service.impl;

import com.litbo.hospitalzj.zk.Enum.EnumProcess2;
import com.litbo.hospitalzj.zk.domian.Ndjh;
import com.litbo.hospitalzj.zk.mapper.NdjhMapper;
import com.litbo.hospitalzj.zk.mapper.UserEqMapper;
import com.litbo.hospitalzj.zk.service.NdjhService;
import com.litbo.hospitalzj.zk.vo.MonthCount;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NdjhServiceImpl implements NdjhService {
    @Autowired
    private NdjhMapper ndjhMapper;
    @Autowired
    private UserEqMapper userEqMapper;
    @Override
    public Ndjh selectNdjh(Integer ndjhId) {
        return ndjhMapper.selectNdjh(ndjhId);
    }

    @Override
    public void insertNdjh(Ndjh ndjh) {

        ndjhMapper.insertNdjh(ndjh);
    }

    @Override
    public void deletENdjh(Integer ndjhId) {
        ndjhMapper.deletENdjh(ndjhId);
    }

    @Override
    public List<Ndjh> selectByShrId(String shrId,String state) {
        return ndjhMapper.selectByShrId(shrId,state);
    }

    @Override
    public List<Ndjh> selectByUserId(String userId) {
        return ndjhMapper.selectByUserId(userId);
    }

    @Override
    public void update(Integer ndjhId, String state) {
        ndjhMapper.update(ndjhId,state);
    }

	@Override
	public List<Ndjh> selectByUserIdAndState(String userId, String state) {
		return ndjhMapper.selectByUserIdAndState(userId, state);
	}

	@Override
	public void updateMonth(Integer ndjhId) {
        Ndjh ndjh =new Ndjh();
        ndjh.setNdjhId(ndjhId);
        List<MonthCount> data=userEqMapper.count(ndjhId);
       for (int i = 0; i < data.size(); i++) {
           if(data.get(i).getMonth().equals("1")){
               ndjh.setNdjh1sj(data.get(i).getCount());
           }else if(data.get(i).getMonth().equals("2")) {
               ndjh.setNdjh2sj(data.get(i).getCount());
           }else if(data.get(i).getMonth().equals("3")) {
               ndjh.setNdjh3sj(data.get(i).getCount());
           }else if(data.get(i).getMonth().equals("4")) {
               ndjh.setNdjh4sj(data.get(i).getCount());
           }else if(data.get(i).getMonth().equals("5")) {
               ndjh.setNdjh5sj(data.get(i).getCount());
           }else if(data.get(i).getMonth().equals("6")) {
               ndjh.setNdjh6sj(data.get(i).getCount());
           }else if(data.get(i).getMonth().equals("7")) {
               ndjh.setNdjh7sj(data.get(i).getCount());
           }else if(data.get(i).getMonth().equals("8")) {
               ndjh.setNdjh8sj(data.get(i).getCount());
           }else if(data.get(i).getMonth().equals("9")) {
               ndjh.setNdjh9sj(data.get(i).getCount());
           }else if(data.get(i).getMonth().equals("10")) {
               ndjh.setNdjh10sj(data.get(i).getCount());
           }else if(data.get(i).getMonth().equals("11")) {
               ndjh.setNdjh11sj(data.get(i).getCount());
           }else if(data.get(i).getMonth().equals("12")) {
               ndjh.setNdjh12sj(data.get(i).getCount());
           }
       }
    ndjhMapper.updateMonth(ndjh);
	}
    //用户查询年度计划中各状态数量
    @Override
    public Integer jhCount(String userId, String state) {
        return ndjhMapper.jhCount(userId,state);
    }
    //管理员根据用户品名关联表和年度计划表查询待审核数量
    @Override
    public Integer dshCount(String shrId, String state) {
        return ndjhMapper.dshCount(shrId, state);
    }

    @Override
    public void updateNdjh(Ndjh ndjh) {
        ndjhMapper.updateNdjh(ndjh);
    }

}
