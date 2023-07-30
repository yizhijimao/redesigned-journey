package com.qf.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class SwaggerConfig {
    /**Swagger会帮助我们生成文档接口文件
    1:配置生成的文档接口
    2：配置生成规则
     */

    /**
     * Docket用来封装接口文档信息，注意要把它放进spring容器中
     * @return
    Docket 是一个用于配置和构建 Swagger 文档的类，通常用于 Spring Boot 项目中。它是 springfox-swagger 库提供的一个核心组件
     */
    @Bean
    public Docket getDocket(){

        //创建封面信息对象
        ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();
        apiInfoBuilder.title("<风靡商城>后端文档接口说明")
                .description("此文档详细说明了风靡商城项目后端接口规范。。。。。。")
                .version("2.0.1")
                .contact(new Contact("代广豪","www.sumiko.com","www.xtyamnmn@gmail.com"));
        //创建完的信息对象在放入docket里
        ApiInfo apiInfo = apiInfoBuilder.build();


        //创建文档对象并指定文档放个
        Docket docket = new Docket(DocumentationType.SWAGGER_2)//指定文档风格
                        .apiInfo(apiInfo)//指定文档中的封面信息
                       .select()
                       .apis(RequestHandlerSelectors.basePackage("com.qf.Controller"))//指定对哪些包路径下的类生成文档
                       //.paths(PathSelectors.regex("/user/"))//指定到顶是为哪个具体的类的请求来生成文档
                       //如果想要所有类的请求都有文档接口的话，就使用下面的any()方法
                       .paths(PathSelectors.any())
                       .build();

        return docket;

    }



}
