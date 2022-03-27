package com.medSoft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;

//import de.codecentric.boot.admin.server.config.EnableAdminServer;

@SpringBootApplication
@EnableDiscoveryClient
//@EnableSwagger2
//@EnableAdminServer
@OpenAPIDefinition(info = @Info(title = "MedSoft API", version = "1.0", description = "MedSoft Api Information"))
@SecurityScheme(name = "medSoftApi", scheme = "basic", type = SecuritySchemeType.HTTP, in = SecuritySchemeIn.HEADER)
public class MedSoftApplication {

	public static void main(String[] args) {
		SpringApplication.run(MedSoftApplication.class, args);
	}

//	@Bean
//	public Docket api() {
//		return new Docket(DocumentationType.SWAGGER_2).select().paths(PathSelectors.any())
//				.apis(RequestHandlerSelectors.basePackage("com.medSoft")).build().apiInfo(apiInfo());
//	}
//
//	private ApiInfo apiInfo() {
//		return new ApiInfo("MedSoft", "Api Documentation", "1.0", "urn:tos",
//				new Contact("Mukundkumar Jha", "www.medsoftTechnologies.com", "contactus@medsoftTechnologies.com"),
//				"Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0", new ArrayList<VendorExtension>());
//	}

}
