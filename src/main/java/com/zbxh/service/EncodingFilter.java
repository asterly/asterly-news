package com.zbxh.service;

import java.io.IOException;  

import javax.servlet.Filter;  
import javax.servlet.FilterChain;  
import javax.servlet.FilterConfig;  
import javax.servlet.ServletException;  
import javax.servlet.ServletRequest;  
import javax.servlet.ServletResponse;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import javax.servlet.http.HttpSession;  
  
public class EncodingFilter implements Filter {  
  
    public void init(FilterConfig filterConfig) throws ServletException {  
  
    }  
  
   
    public void doFilter(ServletRequest request, ServletResponse response,  
            FilterChain chain) throws IOException, ServletException {  
        // 获得在下面代码中要用的request,response对象  
        request.setCharacterEncoding("UTF-8");  
        response.setCharacterEncoding("UTF-8");  
        chain.doFilter(request, response);  
    }  
  
      
    public void destroy() {  
  
    }  
  
}