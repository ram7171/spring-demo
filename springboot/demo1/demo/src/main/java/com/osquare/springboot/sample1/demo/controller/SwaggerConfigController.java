package com.osquare.springboot.sample1.demo.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * this swagger config will give the additional url
 * /v2/api-docs
 	/configuration/ui
 	/configuration/security
 	/swagger-resources
 	/swagger-ui.html
 * @author ram
 *
 */

@Configuration
@EnableSwagger2
public class SwaggerConfigController {
	
	private static final Contact DEFAULT_CONTACT = new Contact("contact@osquaretech.com", "modified content", "modified description");
    private static final ApiInfo DEFAULT = new ApiInfo("Awesome API", "Awesome API", "1.0", "urn:tos",
	          DEFAULT_CONTACT, "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0", new ArrayList<VendorExtension>());
    private static final Set<String> DEFAULT_PRODUCE_AND_CONSUME = new HashSet<>(Arrays.asList("application/json","application/xml"));

	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(DEFAULT).produces(DEFAULT_PRODUCE_AND_CONSUME).consumes(DEFAULT_PRODUCE_AND_CONSUME);
	}
}
