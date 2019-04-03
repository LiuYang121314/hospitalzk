package com.litbo.hospitalzj.supplier.mapper;


import com.litbo.hospitalzj.supplier.entity.District;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 省市区数据的持久层接口
 */
@Mapper
public interface DistrictMapper {

	/**
	 * 根据父级代号获取子级的省/市/区的列表
	 * @param parent 父级代号，如果需要获取省的列表，则父级代号为86
	 * @return 省/市/区的列表
	 */
	@Select("SELECT id, parent, code, name FROM t_dict_district WHERE parent=#{parent} ORDER BY code")
	List<District> findByParent(String parent);

	/**
	 * 根据代号获取省/市/区的详情
	 * @param code 省/市/区的代号
	 * @return 省/市/区的详情，如果没有匹配的数据，则返回null
	 */
	@Select("SELECT id, parent, code, name FROM t_dict_district WHERE code=#{code}")
	District findByCode(String code);
	
}
