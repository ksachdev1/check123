package com.dockerapis.web;

import javax.servlet.Filter;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.dockerapis.config.service.ServiceConfiguration;
import com.dockerapis.config.web.WebConfiguration;

public class DockerApplicationInitializer extends
		AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] {ServiceConfiguration.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] {WebConfiguration.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[]{"/"};
	}
	@Override
	protected Filter[] getServletFilters() {
		return null;
	}
}
