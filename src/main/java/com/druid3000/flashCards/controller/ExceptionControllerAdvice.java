package com.druid3000.flashCards.controller;

import com.druid3000.flashCards.dto.ProblemDetail;
import com.druid3000.flashCards.exception.ResourceNotFoundException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ExceptionControllerAdvice {

	private static final String APPLICATION_PROBLEM_JSON = "application/problem+json";

	@ExceptionHandler(ResourceNotFoundException.class)
	public HttpEntity<ProblemDetail> handleResourceNotFoundException(
			ResourceNotFoundException e, final HttpServletRequest request) {

		final ProblemDetail problem = new ProblemDetail("Resource not found", e.getMessage());
		problem.setStatus(HttpStatus.NOT_FOUND.value());
		problem.setInstance(request.getRequestURI());

		return new ResponseEntity<>(problem, overrideContentType(), HttpStatus.NOT_FOUND);
	}

//	@ExceptionHandler(BookException.class)
//	public HttpEntity<ProblemDetail> handleResourceNotFoundException(
//			BookException e, final HttpServletRequest request) {
//
//		final ProblemDetail problem = new ProblemDetail("Not enough seats", e.getMessage());
//		problem.setStatus(HttpStatus.NOT_FOUND.value());
//		problem.setInstance(request.getRequestURI());
//
//		return new ResponseEntity<>(problem, overrideContentType(), HttpStatus.NOT_FOUND);
//	}

	private static HttpHeaders overrideContentType() {
		final HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.set("Content-Type", APPLICATION_PROBLEM_JSON);
		return httpHeaders;
	}
}
