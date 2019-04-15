package com.litbo.hospitalzj.zk.mapper;

import java.util.List;

import org.apache.ibatis.annotations.*;

import com.litbo.hospitalzj.zk.domian.EqInfo;
import com.litbo.hospitalzj.zk.domian.Yq;

@Mapper
public interface YqMapper {

	@Select("SELECT * FROM yq WHERE jcyq_id IN(SELECT yq_id FROM yq_role WHERE user_id=#{1})")
	List<Yq> findByUserId(String userId);

	@Select("SELECT * FROM yq WHERE jcyq_id NOT IN(SELECT yq_id FROM yq_role WHERE user_id=#{1})")
	List<Yq> findNotByUserId(String userId);

	@Select("SELECT * FROM yq WHERE jcyq_name LIKE '%${jcyqName}%'")
	List<Yq> findYqByYqName(@Param("jcyqName") String jcyqName);

	@Select("select * from yq")
	List<Yq> findAll();

	@Delete("delete from yq where jcyq_id=#{jcyqId}")
	void delete(String yqId);
	
	@Update(
	 "update yq "
      +"set jcyq_name = #{jcyqName,jdbcType=VARCHAR},"
      +"jcyq_xh = #{jcyqXh,jdbcType=VARCHAR},"
      +"jcyq_xzzq_time = #{jcyqXzzqTime,jdbcType=VARCHAR},"
      +"jcyq_dah = #{jcyqDah,jdbcType=VARCHAR},"
      +"jcyq_bh = #{jcyqBh,jdbcType=VARCHAR},"
      +"jcyq_cj_id = #{jcyqCjId,jdbcType=INTEGER},"
      +"jcyq_qy_time = #{jcyqQyTime,jdbcType=TIMESTAMP},"
      +"jcyq_ks_id = #{jcyqKsId,jdbcType=INTEGER},"
      +"jcyq_cf = #{jcyqCf,jdbcType=VARCHAR},"
      +"jcyq_url = #{jcyqUrl,jdbcType=VARCHAR},"
      +"jcyq_jz_time = #{jcyqJzTime,jdbcType=TIMESTAMP},"
      +"mb_id = #{mbId,jdbcType=INTEGER} "
      +"where jcyq_id = #{jcyqId,jdbcType=VARCHAR}")
	
	void update(Yq yq);

	@Insert(
	  "insert into yq (jcyq_id, jcyq_name, jcyq_xh," 
	  +"jcyq_xzzq_time, jcyq_dah, jcyq_bh," 
	  +"jcyq_cj_id, jcyq_qy_time, jcyq_ks_id," 
	  +"jcyq_cf, jcyq_url, jcyq_jz_time," 
	  +"mb_id)values (UUID(), #{jcyqName,jdbcType=VARCHAR}, #{jcyqXh,jdbcType=VARCHAR}," 
	  +"#{jcyqXzzqTime,jdbcType=VARCHAR}, #{jcyqDah,jdbcType=VARCHAR}, #{jcyqBh,jdbcType=VARCHAR}," 
	  +"#{jcyqCjId,jdbcType=INTEGER}, #{jcyqQyTime,jdbcType=TIMESTAMP}, #{jcyqKsId,jdbcType=INTEGER}," 
	  +"#{jcyqCf,jdbcType=VARCHAR}, #{jcyqUrl,jdbcType=VARCHAR}, #{jcyqJzTime,jdbcType=TIMESTAMP}," 
	  +"#{mbId,jdbcType=INTEGER})")
	@Options(useGeneratedKeys = true, keyProperty = "jcyqId", keyColumn = "jcyq_id")
	void insert(Yq yq);

	@Select("select * from yq WHERE jcyq_id IN( SELECT jcyq_id FROM yq_eq WHERE eq_id=(SELECT eq_id FROM eq_info WHERE eq_dah=#{dah}))")
	List<Yq> findByDah(String dah);

	@Select("SELECT yq.* from  yq_eq y left join yq on y.jcyq_id=yq.jcyq_id where eq_id=#{eqId}")
	List<Yq> select(Integer eqId);
	//根据档案号查询出设备以及仪器
	@Select("SELECT * FROM eq_info where eq_dah=#{eqDah}")
	EqInfo selectEqInfo(String eqDah);
	/*@Select("SELECT yq.* FROM eq_info e left join yq_pm y on e.eq_pm_id=y.eq_pm_id left join yq on y.yq_id=yq.jcyq_id where e.eq_dah=#{eqDah}")
	List<Yq> selectEqYq(String eqDah);*/
    //用户查看仪器表
	//除电器意外的数据
	@Select("SELECT yq.* FROM eq_info e left join yq_pm y on e.eq_pm_id=y.eq_pm_id left join yq on y.yq_id=yq.jcyq_id where yq.jcyq_name <> #{jcyqName} and e.eq_id=#{eqId}")
	List<Yq> selectEqYqNotDqByEqId(@Param("eqId") Integer eqId,@Param("jcyqName") String jcyqName);
	//电器数据
	@Select("SELECT yq.* FROM eq_info e left join yq_pm y on e.eq_pm_id=y.eq_pm_id left join yq on y.yq_id=yq.jcyq_id where yq.jcyq_name = #{jcyqName} and e.eq_id=#{eqId}")
	List<Yq> selectEqYqByEqId(@Param("eqId") Integer eqId,@Param("jcyqName") String jcyqName);

	//根据设备Id查询出设备以及仪器
	@Select("SELECT * FROM eq_info where eq_id=#{eqId}")
	EqInfo selectEqInfoByEqid(Integer eqId);
	@Select("SELECT yq.* FROM eq_info e left join yq_pm y on e.eq_pm_id=y.eq_pm_id left join yq on y.yq_id=yq.jcyq_id where eq_id=#{eqId}")
	List<Yq> selectEqYqByEqid(Integer eqId);

	//根据设备id查询设备所关联的仪器
	@Select("SELECT yq.* FROM yq_eq y left join yq on y.jcyq_id=yq.jcyq_id where eq_id=#{eqId}")
	List<Yq> selectYqByEqId(@Param("eqId") Integer eqId);

	//管理员查看通过设备ID查询设备检测仪器
	//查看非电气仪器表
	@Select("SELECT yq.* FROM yq_eq y left join yq on y.jcyq_id=yq.jcyq_id where  yq.jcyq_name <> #{jcyqName} and eq_id=#{eqId}")
	List<Yq> selectYqNotDqByEqId(@Param("eqId") Integer eqId,@Param("jcyqName") String jcyqName);
	//查看电气仪器表
	@Select("SELECT yq.* FROM yq_eq y left join yq on y.jcyq_id=yq.jcyq_id where  yq.jcyq_name=#{jcyqName} and eq_id=#{eqId}")
	List<Yq> selectYqDqByEqId(@Param("eqId") Integer eqId,@Param("jcyqName") String jcyqName);
	@Select("select * from yq")
	List<Yq> selectTime();
}
