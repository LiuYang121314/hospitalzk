package com.litbo.hospitalzj.supplier.service;

import com.litbo.hospitalzj.supplier.entity.SgdjHw;
import org.apache.ibatis.annotations.Param;

public interface SgdjHwService {
	SgdjHw selectSgdjHw(Integer htIds);
	Integer InsertSgdjHw(SgdjHw sgdjHw);
	Integer updateInfo(SgdjHw sgdjHw);
	//上传外观图片
    int updateURL(Integer htIds, String path);
	String[] showImages(Integer htIds);
	/*int updateWjURL( Integer htIds, @Param("path") String path);*/
}
