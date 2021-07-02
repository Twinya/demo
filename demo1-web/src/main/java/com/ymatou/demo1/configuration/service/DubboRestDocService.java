package com.ymatou.demo1.configuration.service;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ymatou.demo1.facade.impl.DemoFacadeImpl;

import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;
import io.swagger.models.Info;
import io.swagger.models.Swagger;

@RestController
public class DubboRestDocService extends Application {

	// private volatile OpenApiContext openApiContext; // 注入刚才的config bean

	/*
	 * @GetMapping("/swagger-doc") public String doc(){ if (openApiContext == null)
	 * { openApiContext = this.openApiContext(); }
	 * 
	 * boolean pretty = false; // json是否美化
	 * 
	 * OpenAPI oas = openApiContext.read(); // oas里面包含了所有的文档内容 try { // 格式化oas的内容
	 * String result = pretty ? Json.pretty(oas) :
	 * Json.mapper().writeValueAsString(oas);
	 * 
	 * return result; } catch (JsonProcessingException e) { e.printStackTrace(); }
	 * return ""; }
	 */
	@ResponseBody
	@GetMapping("/swagger-doc") 
	public Swagger doc() {
		ApiListingResource listing = new ApiListingResource();
		
		Response rsp = listing.getListing(this, null, null, null, "");
		if (rsp.getStatus() != Status.OK.getStatusCode()) {
			Info info = new Info();
			info.setDescription("swagger doc error.");
			Swagger swagger = new Swagger();
			swagger.setInfo(info);
			return swagger;
		}
		return (Swagger)rsp.getEntity();
	}
	
	@Bean
    public ApiListingResource apiListingResource() {
    	return new ApiListingResource();
    }

	@PostConstruct
	public void init() {
		BeanConfig conf = new BeanConfig();
		conf.setTitle("demo API");
		conf.setDescription("demo ");
		conf.setVersion("1.0.0");
		conf.setHost("localhost:8889");
		conf.setBasePath("/swagger-doc");
		conf.setSchemes(new String[] { "http" });
		conf.setResourcePackage("com.ymatou.demo1.facade");
		conf.setScan(true);
	}

	@Override 
	public Set<Class<?>> getClasses() {
		Set<Class<?>> resources = new HashSet<>(); 
		resources.add(SwaggerSerializers.class); 
		return resources; 
	}

/*
 * private OpenApiContext openApiContext() { List<Package> resources = new
 * ArrayList<>(); resources.add(Package.getPackage("com.ymatou.demo1.facade"));
 * 
 * // 仅抓取有tag注解的路径 Collection beanList =
 * SpringContextHolder.getApplicationContext().getBeansWithAnnotation(Tag.class)
 * .values(); resources.addAll(beanList);
 * 
 * OpenApiContext openApiContext = null; if (!resources.isEmpty()) { // init
 * context try { SwaggerConfiguration oasConfig = new SwaggerConfiguration()
 * .resourcePackages(resources.stream().map(Package::getName).collect(Collectors
 * .toSet()));
 * 
 * openApiContext = new
 * JaxrsOpenApiContextBuilder().openApiConfiguration(oasConfig).buildContext(
 * true); } catch (OpenApiConfigurationException e) { throw new
 * RuntimeException(e.getMessage(), e); } }
 * 
 * return openApiContext; }
 */
}
