package org.example;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/*")    // 모든 request 에 대해서 필터가 동작.
public class TestFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // System.out.println("(요청 후) 컨트롤러의 서비스 메서드 실행 전 수행할 필터 작업");

        // 한글 인코딩 작업을 하면 한글이 깨지지 않는다.
        servletRequest.setCharacterEncoding("UTF-8");
        filterChain.doFilter(servletRequest, servletResponse);  // controller -> service 로 넘어갈 때, filtering 작업을 하게 됌.

        // System.out.println("(응답 전) 컨트롤러의 서비스 메서드 실행 후 수행할 필터 작업");
    }

    @Override
    public void destroy() {

    }
}
