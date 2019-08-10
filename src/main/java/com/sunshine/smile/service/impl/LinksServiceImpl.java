package com.sunshine.smile.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunshine.smile.mapper.generator.LinkMapper;
import com.sunshine.smile.model.domain.Link;
import com.sunshine.smile.service.LinksService;

/**
 * @author :
 * @createDate : 创建时间：
 * 
 */
@Service
@Transactional(rollbackFor = RuntimeException.class)
public class LinksServiceImpl implements LinksService {

	private static final String LINKS_CACHE_KEY = "'link'";

	private static final String LINKS_CACHE_NAME = "links";

	@Autowired
	private LinkMapper linkMapper;

	@Override
	@Cacheable(value = LINKS_CACHE_NAME, key = LINKS_CACHE_KEY)
	public List<Link> findLinks() {
		return linkMapper.selectByExample(null);
	}

	@Override
	public Link findByLindId(int linkId) {
		return linkMapper.selectByPrimaryKey(linkId);
	}

	@Override
	@CacheEvict(value = LINKS_CACHE_NAME, allEntries = true, beforeInvocation = true)
	public void save(Link link) throws Exception {
		linkMapper.insert(link);
	}

	@Override
	@CacheEvict(value = LINKS_CACHE_NAME, allEntries = true, beforeInvocation = true)
	public void update(Link link) {
		linkMapper.updateByPrimaryKeySelective(link);
	}

	@Override
	@CacheEvict(value = LINKS_CACHE_NAME, allEntries = true, beforeInvocation = true)
	public void remove(int linkId) {
		linkMapper.deleteByPrimaryKey(linkId);
	}

}
