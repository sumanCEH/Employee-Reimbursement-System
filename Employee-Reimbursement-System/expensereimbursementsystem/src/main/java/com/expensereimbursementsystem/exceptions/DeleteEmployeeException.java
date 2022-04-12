package com.expensereimbursementsystem.exceptions;

public class DeleteEmployeeException extends Exception {


	public DeleteEmployeeException(String message) {
		super(message);
	}

	public DeleteEmployeeException(Throwable cause) {
		super(cause);
	}

	public DeleteEmployeeException(String message, Throwable cause) {
		super(message, cause);
	}

	public DeleteEmployeeException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
