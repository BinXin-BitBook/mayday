package com.sunshine.smile.mapper.custom;

import org.apache.ibatis.annotations.Param;

/**
* @author
* @createDate 创建时间：
* 
*/
public interface ThemeMapperCustom {

	void updateStatus(@Param(value="status")int status,@Param(value="id") int id);

}
