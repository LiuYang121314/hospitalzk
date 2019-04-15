package com.litbo.hospitalzj.supplier.service.impl;

import com.litbo.hospitalzj.supplier.entity.SuInfo;
import com.litbo.hospitalzj.supplier.mapper.SuInfoMapper;
import com.litbo.hospitalzj.supplier.service.SuInfoService;
import com.litbo.hospitalzj.supplier.service.exception.InsertException;
import com.litbo.hospitalzj.supplier.service.exception.PasswordNotMatchException;
import com.litbo.hospitalzj.supplier.service.exception.UpdateException;
import com.litbo.hospitalzj.supplier.service.exception.UserNotFoundException;
import com.litbo.hospitalzj.supplier.vo.SuInfoAndZzInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;

import javax.mail.MessagingException;

@Service
public class SuInfoServiceImpl implements SuInfoService {
    @Autowired
    private SuInfoMapper suInfoMapper;
    @Autowired
    private JavaMailSender mailSender; //自动注入的Bean

    @Value("${spring.mail.username}")
    private String Sender; //读取配置文件中的参数
    @Override
    public SuInfo login(String suMc, String password)
            throws UserNotFoundException, PasswordNotMatchException {
        // 根据参数suMc查询用户数据
        SuInfo data = suInfoMapper.findSuByMc(suMc);
        // 判断用户数据是否为null
        if (data == null) {
            // 是：为null，用户名不存在，则抛出UserNotFoundException
            throw new UserNotFoundException(
                    "登录失败！您尝试登录的企业或公司不存在！请注册");
        }
        if (password.equals(data.getPassword())) {
            System.out.println(data);
            return data;
        }else {
            // 否：不匹配，密码错误，则抛出PasswordNotMatchException
            throw new PasswordNotMatchException(
                    "登录失败！资格证号码错误！");
        }
    }
    @Override
    public void insert(SuInfo suInfo) {
        SuInfo data=suInfoMapper.findSuByMc(suInfo.getSuMc());
        if(data!=null){
            throw new InsertException("此公司已存在，请使用用户名，密码登陆");
        }
        suInfoMapper.insert(suInfo);
    }

    @Override
    public void delete(Integer suId, Integer isDelete) {
        suInfoMapper.delete(suId,isDelete);
    }

    @Override
    public void update(SuInfo suInfo) {
        SuInfo data=suInfoMapper.findSuByMc(suInfo.getSuMc());
        if(data!=null){
            throw new UpdateException("此公司已存在，请重新修改");
        }
        suInfoMapper.update(suInfo);
    }

    @Override
    public void updateState(Integer suId, Integer state) {
        suInfoMapper.updateState(suId,state);
    }

    @Override
    public List<SuInfo> selectAll() {
        return suInfoMapper.selectAll();
    }

    @Override
    public SuInfoAndZzInfo findSuById(Integer suId) {
        return suInfoMapper.findSuById(suId);
    }

    @Override
    public List<SuInfo> findBySuMcLike(String suMc) {
        return suInfoMapper.findBySuMcLike(suMc);
    }

    @Override
    public Integer count(Integer state) {
        return suInfoMapper.count(state);
    }

    @Override
    public List<SuInfo> findSuByState(Integer state) {
        return suInfoMapper.findSuByState(state);
    }

    @Override
    public void updatePwd(Integer suId, String password) {
        suInfoMapper.updatePwd(suId,password);
    }
    /**
	 * 发送用户以及密码
	 * @throws MessagingException 
	 */
	@Override
	public void sendEmail(String suMc,String email,String password){
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(Sender);
		message.setTo(email); 
		message.setSubject("主题:南方医院账户密码验证");
		message.setText("您的医院系统登录用户名是"+suMc+","
				+ "登录密码是"+password+",请妥善管理！"
				+ "如有遗失，请联系系统管理员，谢谢合作！！！");
		mailSender.send(message);
	}
}
