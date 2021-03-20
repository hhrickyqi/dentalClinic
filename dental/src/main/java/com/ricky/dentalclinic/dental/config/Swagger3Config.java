package com.ricky.dentalclinic.dental.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * SwaggeruiAPI文档的配置
 */
@Configuration
@EnableOpenApi
public class Swagger3Config {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                .select()
                /*.apis(RequestHandlerSelectors.basePackage("com.ricky.dentalclinic.dental.controller"))
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))*/
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build()
                //添加登录认证
                .securitySchemes(securitySchemes())
                .securityContexts(securityContexts());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("牙科诊所信息管理系统API")
                .description("牙科诊所信息管理系统API")
                .version("1.0")
                .build();
    }

    private List<SecurityScheme> securitySchemes() {
        //设置请求头信息
        ApiKey apiKey = new ApiKey("Authorization", "Authorization", "header");
        return Collections.singletonList(apiKey);
    }

    private List<SecurityContext> securityContexts() {
        //设置需要登录认证的路径
        List<SecurityContext> result = new ArrayList<>();
        result.add(getContextByPath("/user/getPersonalInfo"));
        result.add(getContextByPath("/user/easyUpdatePassword"));
        result.add(getContextByPath("/user/updateInfo"));
        result.add(getContextByPath("/file/.*"));
        result.add(getContextByPath("/case/.*"));
        result.add(getContextByPath("/caseRecord/.*"));
        return result;
    }

    private SecurityContext getContextByPath(String pathRegex){
        return SecurityContext.builder()
                .securityReferences(defaultAuth())
                .forPaths(PathSelectors.regex(pathRegex))
                .build();
    }

    private List<SecurityReference> defaultAuth() {
        List<SecurityReference> result = new ArrayList<>();
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        result.add(new SecurityReference("Authorization", authorizationScopes));
        return result;
    }
}
