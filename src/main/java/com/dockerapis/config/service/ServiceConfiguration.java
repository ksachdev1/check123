package com.dockerapis.config.service;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.dockerapis.model.mongodb.IpPoolRequest;

@Configuration
@ComponentScan(basePackages = { "com.dockerapis.config.*",
		"com.dockerapis.rest.controller.*" })
public class ServiceConfiguration {
	Logger	logger	= Logger.getLogger(ServiceConfiguration.class);

	@Bean
	public IpPoolRequest ipPoolRequest() throws Exception {
		/*if (true)
			throw new Exception("over");*/
		logger.error("Init the IpPool bean");
		return new IpPoolRequest();
	}
}
