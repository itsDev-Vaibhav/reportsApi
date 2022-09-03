package org.jrtp.reports.app.config;

import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author vaibhav
 *@date 29-Aug-2022
 * 
 */

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	public Docket docket() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("org.jrtp.reports.web.controller"))
				.paths(PathSelectors.any())
				.build();
	}

}
