package com.wowo.ffms.utils;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * 拦截器，登录检查
 */

@Component
public class LoginHandlerInterceptor implements HandlerInterceptor {
    // 目标方法执行之前
    //private List<String> url = new ArrayList();
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object user = request.getSession().getAttribute("loginUser");
        // 如果获取的request的session中的loginUser参数为空（未登录），就返回登录页，否则放行访问
        if (user == null) {
            // 未登录，给出错误信息，
            request.setAttribute("msg","无权限请先登录");
            // 获取request返回页面到登录页
            request.getRequestDispatcher("/login.html").forward(request, response);
            return false;
        } else {
            // 已登录，放行
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
//    public List<String> getUrl(){
//        url.add("/login");      //登录页
//        url.add("/login.html");   //登录action URL
//        //网站静态资源
//        url.add("/css/**");
//        url.add("/js/**");
//        url.add("/images/**");
//        url.add("/bootstrap-3.3.7-dist/**");
//        url.add("/echarts/**");
//        return url;
//    }
}
