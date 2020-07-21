package com.gjs.rgf.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

@Component
public class WebCorsFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest servletRequest = (HttpServletRequest) request;
		ServletResponse servletResponse = (HttpServletResponse) response;
		
	
		
		System.out.println("LocalName :" + request.getLocalName());
		System.out.println("RemoteAddr :" + request.getRemoteAddr());
		System.out.println("RemoteHost :" + request.getRemoteHost());
		
		chain.doFilter(servletRequest, servletResponse);

		
	}
	
	public void destroy() {}
	
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

}
