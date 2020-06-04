package com.evan.wj.interceptor;

import org.apache.commons.lang.StringUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        String contextPath = session.getServletContext().getContextPath();
        String[] requireWhitePath = new String[]{
                "index"
        };
        String requestURI = request.getRequestURI();
        String page = StringUtils.remove(requestURI, contextPath + "/");
        for (String path:requireWhitePath) {
            if (page.equals(page)){
                return true;
            }
        }
        Object user = session.getAttribute("user");
        if (ObjectUtils.isEmpty(user)){
            response.sendRedirect("login");
            return false;
        }
        return true;
    }
}
