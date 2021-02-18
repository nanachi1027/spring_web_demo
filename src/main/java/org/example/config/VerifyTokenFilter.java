package org.example.config;

import org.example.service.TokenService;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * @Author: Mae
 * @Date: 2021/2/18 2:58 上午
 */
public class VerifyTokenFilter extends GenericFilterBean {
    private final TokenService tokenService;

    public VerifyTokenFilter(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

    }
}
