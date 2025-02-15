package com.example.myapp.commons;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;

public class HttpMethodOverrideFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String methodOverride = httpRequest.getHeader("X-HTTP-Method-Override");

        if (methodOverride != null && !methodOverride.isEmpty()) {
            // HTTP 메서드를 오버라이드하는 래퍼를 생성
            HttpServletRequestWrapper wrapper = new HttpServletRequestWrapper(httpRequest) {
                @Override
                public String getMethod() {
                    return methodOverride; // X-HTTP-Method-Override 헤더의 값으로 HTTP 메서드를 변경
                }
            };
            chain.doFilter(wrapper, response); // 래퍼를 다음 필터로 전달
        } else {
            chain.doFilter(request, response); // 기존 요청을 그대로 전달
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // 초기화 코드가 필요하지 않으면 이 메서드는 비워 둘 수 있습니다.
    }

    @Override
    public void destroy() {
        // 필터 종료 시 정리해야 할 리소스가 있다면 이 메서드를 구현할 수 있습니다.
    }
}