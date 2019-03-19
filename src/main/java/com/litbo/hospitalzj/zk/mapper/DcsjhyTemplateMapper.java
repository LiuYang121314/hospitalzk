package com.litbo.hospitalzj.zk.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.litbo.hospitalzj.zk.domian.DcsjhyTemplate;

@Mapper
public interface DcsjhyTemplateMapper {

	@Insert("insert into dcsjhy_template (dcsjhy_templateid,xl_test1,xl_wc) values "+
	"(UUID(),#{xlTest1},#{xlWc})")
	
//	@Insert("insert into eq_cs (sbcs_name,sbcs_pwd,sbcs_address,sbcs_lxdh1,sbcs_Certificate,sbcs_creditcode,sbcs_Certificatep,sbcs_creditcodep) value "
//			+ "(#{sbcsName},#{sbcsPwd},#{sbcsAddress},#{sbcsLxdh1},#{sbcsCertificate},#{sbcsCreditcode},#{sbcsCertificatep},#{sbcsCreditcodep})")
	void insert(DcsjhyTemplate dt);

	@Delete("delete from dcsjhy_template where dcsjhy_templateid = #{dcTemplateId}")
	void delete(String id);

	@Select("select dcsjhy_templateid as dcTemplateId from dcsjhy_template")
	List<DcsjhyTemplate> findAll();

	
}
