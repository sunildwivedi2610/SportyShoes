package com.sportyshoes.exception;

import org.springframework.stereotype.Controller;

@Controller
public class GlobalException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public GlobalException() {
		super();
	}
	public GlobalException(String message) {
		super(message);
	}

}
