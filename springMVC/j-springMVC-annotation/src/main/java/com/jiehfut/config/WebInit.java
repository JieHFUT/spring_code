package com.jiehfut.config;

import jakarta.servlet.Filter;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * ClassName: WebInit
 * Package: com.jiehfut.config
 * Description:
 * web工程的初始化类，用来代替 web.xml
 *
 * @Author jieHFUT
 * @Create 2024/12/9 0:45
 * @Version 1.0
 */
public class WebInit extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        // 配置当前的根配饰，即指定 spring 的配置类
        // return new Class[0];
        return new Class[]{SpringConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        // 指定 springMVC 的配置类
        // return new Class[0];
        return new Class[]{WebConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        // DispatcherServlet 的映射路径，即为 url-pattern
        // return new String[0];
        return new String[]{"/"};
    }


    // 注册过滤器
    @Override
    protected Filter[] getServletFilters() {
        // return super.getServletFilters();
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceResponseEncoding(true);

        HiddenHttpMethodFilter hiddenHttpMethodFilter = new HiddenHttpMethodFilter();

        return new Filter[]{characterEncodingFilter, hiddenHttpMethodFilter};
    }



}
