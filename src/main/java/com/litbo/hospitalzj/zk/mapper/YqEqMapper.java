package com.litbo.hospitalzj.zk.mapper;

import com.litbo.hospitalzj.zk.vo.YqEqVo;
import org.apache.ibatis.annotations.*;

import com.litbo.hospitalzj.zk.domian.Yq;
import com.litbo.hospitalzj.zk.domian.YqEq;

import java.util.List;

@Mapper
public interface YqEqMapper {

	@Insert("insert into yq_eq (id, jcyq_id, eq_id,state,type) value ("
			+ "#{id}, #{jcyqId},#{eqId},#{state},#{type})")
	void insert(YqEq yqEq);
	@Update("update yq_eq set state=#{state} where jcyq_id=#{jcyqId} and eq_id=#{eqId}")
	void updateState(@Param("jcyqId") String jcyqId, @Param("eqId") String eqId,@Param("state") Integer  state);
	@Update("update yq_eq set type=#{type} where jcyq_id=#{jcyqId} and eq_id=#{eqId}")
	void updateType(@Param("jcyqId") String jcyqId, @Param("eqId") String eqId,@Param("type") String  type);
	@Update("update yq_eq set type=#{type} where eq_id=#{eqId}")
	void updateAllType(@Param("eqId") String eqId,@Param("type") String  type);
	@Delete("delete from yq_eq where jcyq_id = #{jcyqId} AND eq_id = #{eqId}")
	void delete(@Param("jcyqId") String jcyqId, @Param("eqId") String eqId);
	@Select("SELECT y.*,e.eq_mc from  yq_eq y left join eq_info e on y.eq_id=e.eq_id where jcyq_id=#{jcyqId}")
	YqEq selectEqId(String jcyqId);
	@Select("SELECT count(*) from  yq_eq where eq_id=#{eqId} and state=#{state}")
	Integer selectStateNot(@Param("eqId") String eqId, @Param("state") Integer state);
	@Select("SELECT count(*) from  yq_eq where eq_id=#{eqId} and type=#{type}")
	Integer selectTypeNot(@Param("eqId") String eqId, @Param("type") String type);
	@Select("select yq.*,e.eq_mc,e.eq_dah " +
			"from user_eq u left join eq_info e on u.jc_eqid=e.eq_id " +
			"left join yq_eq y on u.jc_eqid=y.eq_id " +
			"left join yq on y.jcyq_id=yq.jcyq_id " +
			"where u.user_id=#{userId} and y.state=#{state}")
	List<YqEqVo> selectYqEq(@Param("userId") String userId, @Param("state") Integer state);
}
