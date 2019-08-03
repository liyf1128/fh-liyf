package com.fh.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/*@Configuration
@EnableWebMvc*/
/*@EnableSwagger2
public class Swagger2Config {

    private String version = "1.0";
    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("business-api")
                .genericModelSubstitutes(DeferredResult.class)
                .forCodeGeneration(false)
                .select()// 选择哪些路径和API会生成document
                .apis(RequestHandlerSelectors.any())// 对所有api进行监控
                .paths(PathSelectors.any())// 对所有路径进行监控
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo(){
        ApiInfo apiInfo = new ApiInfoBuilder()
                .title("图书接口API")
                .description("图书api")
                .termsOfServiceUrl("")
                .version(version)
                .build();
        return apiInfo;
    }


}*/
