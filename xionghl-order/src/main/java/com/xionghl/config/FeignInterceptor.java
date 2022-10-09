package com.xionghl.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * @Author:xionghl
 * @Date:2022/10/9 21:22
 */
@Component
public class FeignInterceptor implements RequestInterceptor {

    /**
     * 拦截器方法
     *
     * @param requestTemplate
     */
    @Override
    public void apply(RequestTemplate requestTemplate) {
        /*
         * 获取原线程的request对象的请求头中的token
         * RequestContextHolder.getRequestAttributes()：获取request原始的请求头对象
         * 接口类RequestAttributes不能使用，所以强转为ServletRequestAttributes类型
         */

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        if (attributes != null) {
            //获取原Request对象
            HttpServletRequest request = attributes.getRequest();
            //把原request的请求头的所有参数都拿出来
            Enumeration<String> headerNames = request.getHeaderNames();
            while (headerNames.hasMoreElements()) {
                //获取每个请求头参数的名字 头文件key
                String name = headerNames.nextElement();
                //获取值 头文件value
                String value = request.getHeader(name);
                //放到feign调用对象的request中去
                if ("token".equals(name)) {
                    requestTemplate.header("token", value);
                } else {
                    requestTemplate.header(name, value);
                    requestTemplate.header("name", "xhl");
                }
            }
        }


    }
}
