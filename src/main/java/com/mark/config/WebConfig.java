package com.mark.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.validation.Validator;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.*;

import java.util.List;

/**
 * Created by mark on 2017/9/2.
 */
@EnableAutoConfiguration
public class WebConfig extends WebMvcConfigurerAdapter {

    /**
     * 请求地址匹配规则
     *
     * @param configurer
     */
    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer.setUseSuffixPatternMatch(false);//设置是否是后缀模式匹配，如“/user”是否匹配/user.*，默认真即匹配；
        configurer.setUseTrailingSlashMatch(true);//设置是否自动后缀路径模式匹配，如“/user”是否匹配“/user/”，默认真即匹配；
    }

    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
    }

    public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
    }

    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
    }

    public void addFormatters(FormatterRegistry registry) {
    }

    public void addInterceptors(InterceptorRegistry registry) {
    }

    public void addResourceHandlers(ResourceHandlerRegistry registry) {
    }

    public void addCorsMappings(CorsRegistry registry) {
    }

    public void addViewControllers(ViewControllerRegistry registry) {
    }

    public void configureViewResolvers(ViewResolverRegistry registry) {
    }

    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
    }

    public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> returnValueHandlers) {
    }

    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
    }

    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
    }

    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {
    }

    public void extendHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {
    }

    public Validator getValidator() {
        return null;
    }

    public MessageCodesResolver getMessageCodesResolver() {
        return null;
    }
}
