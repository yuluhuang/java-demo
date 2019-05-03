/**
 * @Title
 * @Project java-tutorial
 * @Package com.yuluhuang.quartz
 * @Description RESTful API文档
 * @author ylh
 * @date 2018-07-18 17:08
 * @version
 */
package com.yuluhuang.quartz;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author ylh
 * @Description RESTful API文档
 * @date 2018-07-18 17:08
 */
@Configurable
@EnableSwagger2
@EnableAutoConfiguration
public class Swagger2 {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.yuluhuang.quartz"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("使用Swagger2构建RESTful APIs")
                .description("使用Swagger2构建RESTful APIs")
                .termsOfServiceUrl("http://127.0.0.1:8080/")
                .contact("")
                .version("1.0")
                .build();
    }
}
