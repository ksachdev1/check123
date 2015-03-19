package com.dockerapis.config.mongodb;


import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoFactoryBean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.dockerapis.rest.model.ippool.IpPoolCreateRepositoryIf;
import com.dockerapis.rest.model.ippool.IpPoolCreateRepositoryImpl;

@Configuration
@EnableMongoRepositories(basePackages = "com.dockerapis.model.*")
public class MongoConfiguation {
	Logger	logger	= Logger.getLogger(MongoConfiguation.class);
	
	public static final String DB_NAME = "dockerDB";
	
	@Bean
	public MongoTemplate mongoTemplate() throws Exception {
		logger.info("Create MongoTemplateBean");
		return new MongoTemplate(mongoFactoryBean().getObject(), DB_NAME);
	}
	
	@Bean
	public MongoFactoryBean mongoFactoryBean() throws Exception {
		return new MongoFactoryBean();
	}
	
	@Bean
	public IpPoolCreateRepositoryIf ipPoolCreateRepositoryIf() {
		return new IpPoolCreateRepositoryImpl();
	}
}
