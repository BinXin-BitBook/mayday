package com.sunshine.smile.mapper.custom;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.sunshine.smile.model.domain.Options;

/**
 * @author :
 * @createDate :
 * 
 */
public interface OptionsMapperCustom {
	/**
	 * 保存
	 * 
	 * @param map
	 */
	void saveMap(@Param("map") Map<String, Object> map);

	/**
	 * 所有设置选项
	 * 
	 * @return map
	 */
	List<Options> selectMap();

}
