package org.sangaizhi.blog.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages = "org.sangaizhi.*")
@EnableScheduling
@EnableTransactionManagement
@MapperScan("org.sangaizhi.blog.dao")
@PropertySource("classpath:blog.properties")
public class BlogAdminApplication {

	private static Logger logger = LoggerFactory.getLogger(BlogAdminApplication.class);

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(BlogAdminApplication.class, args);
		if (logger.isInfoEnabled()) {
			String[] activeProfiles = ctx.getEnvironment().getActiveProfiles();
			for (String profile : activeProfiles) {
				logger.info("=============== Spring Boot 使用profile为:{} ===============", profile);
			}
		}
	}
}
