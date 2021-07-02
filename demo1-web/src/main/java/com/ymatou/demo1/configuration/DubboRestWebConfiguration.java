package com.ymatou.demo1.configuration;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContextListener;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.alibaba.dubbo.remoting.http.servlet.BootstrapListener;
import com.alibaba.dubbo.remoting.http.servlet.DispatcherServlet;

import io.swagger.jaxrs.listing.ApiListingResource;
import springfox.documentation.swagger.web.InMemorySwaggerResourcesProvider;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

/**
 * 
 * @author huangjie
 * 
 */

@Configuration
public class DubboRestWebConfiguration extends SpringBootServletInitializer {
	
    @Bean
    public ServletContextListener bootstrapListener() {
        return new BootstrapListener();
    }

//    @Bean
//    public DispatcherServlet dispatcherServlet() {
//        return new DispatcherServlet();
//    }
   
    
    
    /**
     * 兼容dubbo rest，注册处理dubbo rest协议的servlet(/api/*)，如果是spring mvc，建议注释本方法
     * @return
     */
    @Bean
    public ServletRegistrationBean restServlet(){

    	DispatcherServlet dispatcherServlet = new DispatcherServlet();
        //用ServletRegistrationBean包装servlet
        ServletRegistrationBean registrationBean
                = new ServletRegistrationBean(dispatcherServlet);
        registrationBean.setLoadOnStartup(2);
        //指定urlmapping
        registrationBean.addUrlMappings("/api/*");
        //指定name，如果不指定默认为dispatcherServlet
        registrationBean.setName("dubboRest");
        return registrationBean;
    }

    
    /**
     * dubbo rest swagger接口定义
     * @param defaultResourcesProvider
     * @return
     */
    @Primary
   	@Bean
   	public SwaggerResourcesProvider swaggerResourcesProvider(
   			InMemorySwaggerResourcesProvider defaultResourcesProvider) {
   		return () -> {
   			SwaggerResource wsResource = new SwaggerResource();
   			wsResource.setName("demoFacade");
   			wsResource.setSwaggerVersion("2.0");
   			wsResource.setLocation("/swagger-doc");
   			wsResource.setUrl("/swagger-doc");
   			List<SwaggerResource> resources = new ArrayList<>(defaultResourcesProvider.get());
   			resources.add(wsResource);
   			return resources;
   		};
   	}
    
   
}
