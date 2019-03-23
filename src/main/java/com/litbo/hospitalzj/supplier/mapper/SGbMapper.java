package com.litbo.hospitalzj.supplier.mapper;

import com.litbo.hospitalzj.supplier.entity.EqYt;
import com.litbo.hospitalzj.supplier.entity.SGb;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 国别持久层接口
 * @author 刘洋
 *
 */
@Mapper
public interface SGbMapper {
	@Select("SELECT * from s_gb")
	List<SGb> select();
	//模糊查询
	@Select("SELECT * FROM s_gb WHERE eqyt_name LIKE '%${gb}%'")
	List<SGb> findGbLike(@Param("gb")String gb);
}
