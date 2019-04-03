package com.litbo.hospitalzj.supplier.service;

import com.litbo.hospitalzj.supplier.entity.JgLx;
import com.litbo.hospitalzj.supplier.entity.QyLx;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface JgLxService {
	List<JgLx> findAll(@Param("offset") Integer offset, @Param("count") Integer count);
	void insert(JgLx qyLx);
	void update(JgLx qyLx);
	List<JgLx> findByJgLxNameLike(@Param("jgLx") String jgLx);
	void delete(Integer jgId);
}
