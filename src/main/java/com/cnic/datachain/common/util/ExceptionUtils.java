package com.cnic.datachain.common.util;

import com.cnic.datachain.common.exception.CommonsException;
import org.springframework.dao.DataAccessException;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import java.io.PrintWriter;
import java.io.StringWriter;


/**
 * 异常信息处理工具类
 */
public abstract class ExceptionUtils {

	/**
	 * 将 CheckedException 转换为 UnCheckedException.
	 * 
	 * @see CommonsException
	 * @return RuntimeException 运行时异常
	 */
	public static RuntimeException unchecked(Throwable t) {
		if (t instanceof RuntimeException) {
			return (RuntimeException) t;
		} else {
			return new CommonsException(t.getMessage(), t);
		}
	}

	/**
	 * 包装所有 Exception 为 CommonsRuntimeException
	 * 
	 * @param t Throwable
	 * @return CommonsRuntimeException
	 */
	public static RuntimeException wrap(Throwable t) {
		return new CommonsException(t);
	}

	/**
	 * 包装所有 Exception 为 CommonsRuntimeException
	 * 
	 * @param message 异常信息
	 * @param t Throwable
	 * @return CommonsRuntimeException
	 */
	public static RuntimeException wrap(String message, Throwable t) {
		return new CommonsException(message, t);
	}

	/**
	 * 将异常信息转换为字符串
	 * 
	 * @param t Throwable
	 * @return 异常信息字符串
	 */
	public static String exceptionToString(Throwable t) {
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw, true);
		t.printStackTrace(pw);
		pw.flush();
		pw.close();
		return sw.toString();
	}

	/**
	 * 将异常链中所有异常信息合并为字符串
	 * 
	 * @param t Throwable
	 * @return 异常信息字符串
	 */
	public static String exceptionChainToString(Throwable t) {
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw, true);
		while (t != null) {
			t.printStackTrace(pw);
			t = t.getCause();
		}
		pw.flush();
		pw.close();
		return sw.toString();
	}

	/**
	 * 将基本异常信息与底层异常信息合并输出
	 * 
	 * @param message 基本异常信息
	 * @param cause 底层异常信息
	 * @return 异常信息字符串
	 */
	public static String buildMessage(String message, Throwable cause) {
		if (cause != null) {
			cause = getRootCause(cause);
			StringBuilder buf = new StringBuilder();
			if (message != null) {
				buf.append(message).append("; ");
			}
			buf.append("<--- ").append(cause);
			return buf.toString();
		} else {
			return message;
		}
	}

	/**
	 * 获取底层异常信息
	 * 
	 * @param throwable Throwable
	 * @return Throwable
	 */
	public static Throwable getRootCause(Throwable throwable) {
		Throwable cause = throwable.getCause();
		if (cause == null) {
			return throwable;
		}
		throwable = cause;
		while ((throwable = throwable.getCause()) != null) {
			cause = throwable;
		}
		return cause;
	}


    public static String judgeExceptionType(Exception e) {
        if(e instanceof MaxUploadSizeExceededException) {
            return "EXCEPTION_UPLOAD_FILE_TOO_LARGE";
        } else if(e instanceof DataAccessException) {
            return "EXCEPTION_DATA_ACCESS_ERROR";
        }
        return "EXCEPTION_UNKNOWN_ERROR";
    }

}
