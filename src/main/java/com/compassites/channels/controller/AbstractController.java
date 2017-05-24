package com.compassites.channels.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.compassites.channels.Exception.AgeGroupException;
import com.compassites.channels.Exception.CategoryException;
import com.compassites.channels.Exception.ChannelException;
import com.compassites.channels.model.ErrorResource;

@ControllerAdvice
public class AbstractController {
	private static Logger logger = Logger.getLogger(AbstractController.class);
	
	@ExceptionHandler(AgeGroupException.class)
	@ResponseBody
	public ResponseEntity<ErrorResource> AgeGroupException(
			HttpServletRequest req, Exception e) {
		ErrorResource error = new ErrorResource();
		error.setStatus(400);
		error.setErrorCode(400);
		error.setErrorMsg(e.getMessage());

		logger.error("Age Group Exception ", e);

		return new ResponseEntity<ErrorResource>(error,
				HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(CategoryException.class)
	@ResponseBody
	public ResponseEntity<ErrorResource> CategoryException(
			HttpServletRequest req, Exception e) {
		ErrorResource error = new ErrorResource();
		error.setStatus(400);
		error.setErrorCode(400);
		error.setErrorMsg(e.getMessage());

		logger.error("Category Exception ", e);

		return new ResponseEntity<ErrorResource>(error,
				HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(ChannelException.class)
	@ResponseBody
	public ResponseEntity<ErrorResource> ChannelException(
			HttpServletRequest req, Exception e) {
		ErrorResource error = new ErrorResource();
		error.setStatus(400);
		error.setErrorCode(400);
		error.setErrorMsg(e.getMessage());

		logger.error("Channel Exception ", e);

		return new ResponseEntity<ErrorResource>(error,
				HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
