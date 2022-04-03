package com.hello.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class Resourcenotfound extends RuntimeException {

	private static final long serialVersionUID = -3654472543270724461L;
	
	public Resourcenotfound(String message) {
		super(message);
	}

}
