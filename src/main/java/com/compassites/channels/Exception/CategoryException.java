package com.compassites.channels.Exception;

public class CategoryException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String errorMessage;

	public String getErrorMessage() {
		return errorMessage;
	}

	public CategoryException() {
		super();
	}

	public CategoryException(String errorMessage) {
		super(errorMessage);
		this.errorMessage = errorMessage;
	}
}
