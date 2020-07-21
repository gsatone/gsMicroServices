package com.gjs.rgf.Exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.gjs.rgf.Exception.ProductNotfoundException;

@RestControllerAdvice
public class ProductExceptionController {
	
	@ExceptionHandler(value=ProductNotfoundException.class)
	public ResponseEntity<Object> exception (ProductNotfoundException exception){
		return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
	}
	
}
