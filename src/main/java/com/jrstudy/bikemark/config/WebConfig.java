package com.jrstudy.bikemark.config;

import com.jrstudy.bikemark.filter.WebAppCorsFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class WebConfig implements WebMvcConfigurer {


    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
    }

    @Bean
    public WebAppCorsFilter corsFilter() {
        return new WebAppCorsFilter();
    }

}
