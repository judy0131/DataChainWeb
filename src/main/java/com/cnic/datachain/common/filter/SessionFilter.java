package com.cnic.datachain.common.filter;

import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Qiu on 2015/11/6.
 */
public class SessionFilter extends OncePerRequestFilter {

    public void doFilterInternal(HttpServletRequest request,
                                 HttpServletResponse response, FilterChain filterChain)
        throws ServletException, IOException{
        String[] notFilter = new String[] {"/login", "/doLogin"};
        String url = request.getRequestURI();
        if(checkUrl(notFilter, url)){
            Object object = request.getSession().getAttribute("access");
            if(null == object){
                response.sendRedirect(request.getContextPath() + "/login");
            }
            else {
                filterChain.doFilter(request, response);
            }
        }
        else {
            filterChain.doFilter(request, response);
        }

    }

    public boolean checkUrl(String[] notFilter, String url){
        //url以css和js结尾的不进行拦截
        if(url.endsWith(".css") || url.endsWith(".js")){
            return false;
        }
        //含有notFilter中的任何一个则不进行拦截
        for (String s : notFilter) {
            if (url.indexOf(s) != -1) {
                return false;
            }
        }
        return true;
    }
}
