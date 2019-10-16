package com.jrstudy.bikemark.config;

import com.jrstudy.bikemark.filter.WebAppCorsFilter;
import com.jrstudy.bikemark.interceptor.ConcurrentTxCountInterceptor;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private MeterRegistry meterRegistry;

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new ConcurrentTxCountInterceptor(meterRegistry));
    }

    @Bean
    public WebAppCorsFilter corsFilter() {
        return new WebAppCorsFilter();
    }

}
