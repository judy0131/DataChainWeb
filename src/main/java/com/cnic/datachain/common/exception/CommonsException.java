package com.cnic.datachain.common.exception;

@SuppressWarnings("serial")
public class CommonsException extends RuntimeException {

	/**
	 * 构造 CommonsRuntimeException 异常对象
	 */
	public CommonsException() {
		super();
	}

	/**
	 * 构造 CommonsRuntimeException 异常对象
	 * 
	 * @param message 异常信息
	 */
	public CommonsException(String message) {
		super(message);
	}

	/**
	 * 构造 CommonsRuntimeException 异常对象
	 * 
	 * @param cause Throwable
	 */
	public CommonsException(Throwable cause) {
		super(cause);
	}

	/**
	 * 构造 CommonsRuntimeException 异常对象
	 * 
	 * @param message 异常信息
	 * @param cause Throwable
	 */
	public CommonsException(String message, Throwable cause) {
		super(message, cause);
	}
}
