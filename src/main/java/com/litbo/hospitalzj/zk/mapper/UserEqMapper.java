package com.litbo.hospitalzj.zk.mapper;

import com.litbo.hospitalzj.checklist.domain.Dqjc;
import com.litbo.hospitalzj.sf.entity.User;

import java.util.List;

import com.litbo.hospitalzj.zk.vo.MonthCount;
import org.apache.ibatis.annotations.*;

import com.litbo.hospitalzj.zk.domian.UserEq;
import com.litbo.hospitalzj.zk.vo.UserEqVo;


@Mapper
public interface UserEqMapper {

	@Insert("insert into user_eq (id, user_id, sh_eqid,state,shr_id) value ("
			+ "#{id}, #{userId},#{shEqid},#{state},#{shrId})")
	void insertBatchByShEqid(UserEq userEq);
	@Select("select * from s_user where user_id=#{userId}")
	User findUserRole(String userId);
	
	//检测设备成功与不成功
	@Update("update user_eq set state=#{state} where jc_eqid=#{jceqId} and user_id=#{userId}")
	void setEqStateNotIs(@Param("jceqId")String jceqId,@Param("userId")String userId,@Param("state")String state);

	
	@Update("update user_eq set state=#{userEqState} where " +
			"user_id in(select user_id from ndjh where state=#{state} and ndjh_id=#{ndjhId}) " +
			"AND jc_eqid in(select jc_eqid from ndjh where state=#{state} and ndjh_id=#{ndjhId})")
	void updateState(@Param("ndjhId")Integer ndjhId,@Param("userEqState") String userEqState,@Param("state") String state);
	
	@Insert("insert into user_eq (id, user_id, jc_eqid,date,ndjh_id,state,shr_id) value ("
			+ "#{id}, #{userId},#{jcEqid},#{date},#{ndjhId},#{state},#{shrId})")
	void insertBatchByJcEqid(UserEq userEq);

	@Delete("delete from user_eq where user_id = #{userId} AND sh_eqid = #{shEqid}")
	void deleteBatchByShEqid(@Param("userId") String userId,@Param("shEqid") String shEqid);

	@Delete("delete from user_eq where user_id = #{userId} AND jc_eqid = #{jcEqid}")
	void deleteBatchByJcEqid(@Param("userId") String userId, @Param("jcEqid") String jcEqid);

	@Update("update user_eq set state='待审核' where user_id=#{userId} and jc_eqid=#{eqId}")
	void setJcEqState2(@Param("userId") String userId, @Param("eqId") String eqId);

	@Update("update user_eq set state='待审核' where sh_eqid=#{eqId}")
	void setShEqState2(@Param("eqId") String eqId);

	@Update("update user_eq set state='审核不通过' where user_id=#{userId} and sh_eqid=#{eqId}")
	void setEqState3(@Param("userId") String userId, @Param("eqId") String eqId);

	@Update("update user_eq set state='审核通过' where user_id=#{userId} and jc_eqid=#{eqId}")
	void setEqState4(@Param("userId") String userId, @Param("eqId") String eqId);
	@Update("update user_eq set state='待上传' where user_id=#{userId} and jc_eqid=#{eqId}")
	void setEqState5(@Param("userId") String userId, @Param("eqId") String eqId);
	@Update("update user_eq set state='审核中' where user_id=#{userId} and jc_eqid=#{eqId}")
	void setEqState6(@Param("userId") String userId, @Param("eqId") String eqId);
	//4:待上报and审核上报不通过/审核成功
	@Select("SELECT e.eq_mc,u.state,u.jc_eqid,yq.jcyq_name\r\n" + 
			"FROM user_eq u left join eq_info e on u.jc_eqid =e.eq_id left join yq_eq y on y.eq_id=e.eq_id left join yq on yq.jcyq_id=y.jcyq_id where u.user_id=#{userId} and u.state=#{state} or u.state=#{shState}")
	List<UserEqVo> findUserEq(@Param("userId")String userId,@Param("state")String state,@Param("shState")String shState);
	//待上报，待审核，审核完成，审核不通过
	/*@Select("SELECT e.eq_mc,u.state,u.jc_eqid FROM user_eq u left join eq_info e on u.jc_eqid =e.eq_id where u.user_id=#{userId} and u.state=#{state}")*/
	@Select("SELECT e.*,u.state,u.jc_eqid FROM user_eq u left join eq_info e on u.jc_eqid =e.eq_id  where u.user_id=#{userId} and u.state=#{state}")
	List<UserEqVo> findUserEqVo(@Param("userId")String userId,@Param("state")String state);
	@Select(" select date_format(date,'%c') as month,count(*) as count  " +
			"from user_eq where ndjh_id=#{ndjhId} group by month")
	List<MonthCount> count(@Param("ndjhId") Integer ndjhId);

	//查询审核不成功个数
	@Select("select count(*) from user_eq\n" +
			"where user_id=#{userId} and state=#{state}")
	Integer findByUserIdState(@Param("userId")String userId, @Param("state")String state);
	
}
