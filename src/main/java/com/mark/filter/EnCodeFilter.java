package com.mark.filter;

import com.mark.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingResponseWrapper;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by mark on 2017/9/13.
 */
@Component
public class EnCodeFilter extends OncePerRequestFilter {

    @Autowired
    TestService testService;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
//        ParameterResponseWrapper resp = new ParameterResponseWrapper((HttpServletResponse) response);
        testService.exeService();;


        System.out.println("每次请求前被拦截");
        filterChain.doFilter(httpServletRequest, httpServletResponse);
        System.out.println("每次请求后被拦截");
//
//
//        PrintWriter printWriter=httpServletResponse.getWriter();
//
//        ;
//        System.out.println("return : "+printWriter.toString());

    }
}
