package com.ymatou.demo1.configuration;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ImportResource("classpath:spring/context.xml")
public class ServiceConfiguration implements WebMvcConfigurer{
	
	@Bean
	public Mapper dozer() {
		Mapper mapper = new DozerBeanMapper();
		return mapper;
	}
	
}
