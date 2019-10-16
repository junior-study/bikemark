package com.jrstudy.bikemark.interceptor;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ConcurrentTxCountInterceptor extends HandlerInterceptorAdapter {

    private final Counter counter;

    public ConcurrentTxCountInterceptor(MeterRegistry meterRegistry) {
        this.counter = meterRegistry.counter("transaction.current.count");
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        counter.increment();
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        counter.increment(-1d);
    }
}
