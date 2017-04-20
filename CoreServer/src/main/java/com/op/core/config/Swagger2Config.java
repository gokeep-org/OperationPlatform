package com.op.core.config;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;

import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @author 程序猿DD
 * @version 1.0.0
 * @date 16/4/18 下午12:02.
 * @blog http://blog.didispace.com
 */
//@Configuration
//@EnableSwagger2
public class Swagger2Config {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.op.core.rest"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("OperationPlatform API")
                .description("详情请联系作者 徐宁：1748373312@qq.com")
                .termsOfServiceUrl("https://github.com/smartning")
                .contact("徐宁")
                .version("1.0")
                .build();

    }

    @Bean
    public Docket restConfig() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("jax-rs").apiInfo(apiInfo()).forCodeGeneration(true)
                .pathMapping("/").select().paths(paths())
                .build().useDefaultResponseMessages(false);
    }

    // 请求url匹配，支持and or，可以过滤筛选
    private Predicate<String> paths() {
        return or(regex("/.*"), regex("/rest/.*")); //
    }

}
