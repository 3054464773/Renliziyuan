package com.trkj.renliziyuangl.config;


import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Slf4j
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
                //设置孕允许跨域的路径
            registry.addMapping("/**")
                    //设置允许跨域请求的域名
                    .allowedOrigins("*")
                    //是否允许cookie
                    .allowCredentials(true)
                    //设置允许请求的方法
                    .allowedMethods("GET","POST","PUT","DELETE")
                    //设置允许headr的属性
                    .allowedHeaders("*")
                    .maxAge(3600);
    }
}