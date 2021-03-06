package com.litbo.hospitalzj.supplier.mapper;

import java.util.List;

import com.litbo.hospitalzj.quality.entity.EqPm;
import org.apache.ibatis.annotations.*;

import com.litbo.hospitalzj.supplier.entity.EqFj;

@Mapper
public interface EqFjMapper {
	/*@Insert(
		 "insert into eq_fj(eq_fjid,eq_ids,eq_fjmc,eq_fjxh,eq_fjsl,eq_fjdw,eq_fjsccs,eq_fjccbh,bz) values "
		 + "<foreach collection='eqFjs' item='item' open='(' close=')' index='index' separator=','> "
		 + "(#{item.eqFjId},#{item.eqIds},#{item.eqFjmc},#{item.eqFjxh},#{item.eqFjsl},"
		 + "#{item.eqFjdw},#{item.eqFjsccs},#{item.eqFjccbh},#{item.bz})"
		 + "</foreach>")
		int insertCollectList(@Param(value = "eqFjs") List<EqFj> eqFjs);*/
	@Insert("insert into eq_fj(eq_fjid,eq_ids,eq_fjmc,eq_fjxh,eq_fjsl,eq_fjdw,eq_fjsccs,eq_fjccbh,bz) value "
			+ "(#{eqFjId},#{eqIds},#{eqFjmc},#{eqFjxh},#{eqFjsl},#{eqFjdw},#{eqFjsccs},#{eqFjccbh},#{bz})")
	Integer insertEqFj(EqFj eqfj);
	
	@Select("select eq_fjid as eqFjId,eq_ids as eqIds,eq_fjmc eqFjmc,eq_fjxh eqFjxh,eq_fjsl eqFjsl,eq_fjdw eqFjdw,eq_fjsccs eqFjsccs,eq_fjccbh eqFjccbh,bz from eq_fj where eq_ids=#{eqIds}")
	List<EqFj> selectEqFj(Integer eqIds);

	@Select("select * from eq_fj where eq_fjid=#{eqFjId}")
	EqFj selectById(Integer eqFjId);
	@Update("update eq_fj set eq_fjxh=#{eqFjxh},eq_fjsl=#{eqFjsl},eq_fjdw=#{eqFjdw},"
			+ "eq_fjsccs=#{eqFjsccs},eq_fjccbh=#{eqFjccbh},bz=#{bz} where eq_fjmc=#{eqFjmc}")
	Integer updataInfo(EqFj eqfj);
	@Delete("delete from eq_fj where eq_fjid=#{eqFjid}")
	Integer delete(Integer eqFjid);
}
