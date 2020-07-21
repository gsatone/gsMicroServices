package com.gjs.rgf.common.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.gjs.rgf.filter.ProductServiceInterceptor;

@SuppressWarnings("deprecation")
@Component
public class ProductServiceInterceptorAppConfig extends WebMvcConfigurerAdapter {

	@Autowired
	ProductServiceInterceptor productServiceInterceptor;
	
	public void addInterceptors(InterceptorRegistry registry ) {
		registry.addInterceptor(productServiceInterceptor);
		
	}
}
