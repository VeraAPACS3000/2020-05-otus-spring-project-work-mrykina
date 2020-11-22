package ru.otus.spring.FinancialDistribution.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
//http://localhost:8080/swagger-ui/

@Configuration
@EnableSwagger2
public class SwaggerConfig {

   @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("ru.otus.spring.FinancialDistribution.restcontrollers"))
                .build()
              //  .securityContexts(Arrays.asList(securityContext()))
             //   .securitySchemes(Arrays.asList(basicAuthScheme()))
                .apiInfo(apiInfo());
    }

    private SecurityContext securityContext() {
        return SecurityContext.builder()
                .securityReferences(Arrays.asList(basicAuthReference()))
                .build();
    }

   private SecurityScheme basicAuthScheme() {
        return new BasicAuth("basicAuth");
    }

    private SecurityReference basicAuthReference() {
        return new SecurityReference("basicAuth", new AuthorizationScope[0]);
    }

	private ApiInfo apiInfo() {
        Contact contact = new Contact("Vera Mrykina", "", "LeraZoom@yahoo.com");
        return new ApiInfoBuilder().title("API by Mrykina")
                .description("API Project Financial Distribution")
                .termsOfServiceUrl("https://otus.ru")
                .contact(contact).version("1.0").build();
    }

}