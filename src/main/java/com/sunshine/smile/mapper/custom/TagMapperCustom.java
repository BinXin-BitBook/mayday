package com.sunshine.smile.mapper.custom;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * @author :
 * @createDate :
 */
public interface TagMapperCustom {

	List<Integer> selectByarticleId(Integer id);

	void delete(@Param(value = "list") List<Integer> tagList, @Param(value = "articleId") Integer articleId);

}
