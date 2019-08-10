package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 
 * @author
 *
 * @MapperScan：指定要扫描的Mapper类的包的路径
 *
 */
@SpringBootApplication
@MapperScan("com.sunshine.smile.mapper")
@EnableTransactionManagement
@EnableCaching
public class Application {
	public static void main(String[] args) { 
		SpringApplication.run(Application.class, args);
	}

}
