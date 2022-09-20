package com.luckk.lizzie.springsecurity.filter;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JWTAuthenticationFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //从request内部获取jwt

//        解析jwt


//        尝试获取用户信息


//        用户信息封装放入到ContextHolder当中
        SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(null,null,null));
        filterChain.doFilter(request,response);


    }
}
