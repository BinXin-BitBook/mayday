package com.sunshine.smile.config;

import com.sunshine.smile.config.thymeleaf.dialect.ThSysDialect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Thymeleaf配置
 * 
 * @author :
 * @createDate :
 * 
 */
@Configuration
public class ThymeleafDialectConfig {
	@Bean
	public ThSysDialect thSysDialect() {
		return new ThSysDialect();
	}
}
