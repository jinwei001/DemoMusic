package com.ys.music.utils;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger2 配置类
 */
@EnableSwagger2
@Configuration
public class SwaggerConfig {
    @Bean
    public Docket swaggerPluginConfig(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())                     //Api文档描述
                .select()                               //选择哪些路径和Api会生成文档
//                .apis(RequestHandlerSelectors.basePackage("com.ys.music.controller"))
                // 扫描所有有注解的api，用这种方式更灵活
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                // 扫描指定包中的swagger注解
                // .apis(RequestHandlerSelectors.basePackage("com.ruoyi.project.tool.swagger"))
                // 扫描所有 .apis(RequestHandlerSelectors.any())
                //对指定路径下Api进行监控
                .paths(PathSelectors.any())             //对所有路径进行监控
                .build();
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("Spring Boot中使用Swagger")
                .description("API 接口文档")
                .version("1.0.0")
                .build();
    }
}