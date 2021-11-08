package com.simple.hystrixservice.filter;

import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

@Component
public class CacheFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // 每个请求前都初始化HystrixRequestContext，否则Hystrix的缓存功能将不能使用
        HystrixRequestContext context = HystrixRequestContext.initializeContext();
        try {
            chain.doFilter(request, response);
        }
        finally {
            // 每个请求完成后都关闭HystrixRequestContext
            context.close();
        }

    }
}
