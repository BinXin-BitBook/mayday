package com.sunshine.smile.service;

import com.github.pagehelper.PageInfo;
import com.sunshine.smile.model.domain.Log;

/**
 * @author :
 * @createDate :
 */
public interface LogService {
	/**
	 * 保存日志
	 * 
	 * @param log
	 */
	void save(Log log);

	/**
	 * 分页查询日志
	 * 
	 * @param page
	 * @param limit
	 * @return
	 */
	PageInfo<Log> findLogs(int page, int limit);

	/**
	 * 删除所有日志
	 */
	void clear();
}
