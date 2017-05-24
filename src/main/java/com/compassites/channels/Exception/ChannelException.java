package com.compassites.channels.Exception;

public class ChannelException extends Exception{
private static final long serialVersionUID = 1L;
	
	private String errorMessage;

	public String getErrorMessage() {
		return errorMessage;
	}

	public ChannelException() {
		super();
	}

	public ChannelException(String errorMessage) {
		super(errorMessage);
		this.errorMessage = errorMessage;
	}
}
