package com.cnic.datachain.common.handler;

import com.alibaba.fastjson.JSON;
import com.cnic.datachain.common.util.DateUtils;
import com.cnic.datachain.common.util.ExceptionUtils;
import com.cnic.datachain.common.util.FormatUtil;
import com.cnic.datachain.entity.RequestResult;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.Locale;


/**
 * spring MVC 通用异常处理
 */
public class CommonsExceptionHandler implements HandlerExceptionResolver {

	private static Logger _logger = LoggerFactory.getLogger(CommonsExceptionHandler.class);

	private String _errorPage;

	public void setErrorPage(String errorPage) {
		_errorPage = errorPage;
	}

	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

		String message = ex.getMessage();
        Locale locale = request.getLocale();

		_logger.error(message, ex);

        String messageKey = ExceptionUtils.judgeExceptionType(ex);
        String date = DateUtils.getDateTimeString(new Date());
        String className = handler!=null?handler.getClass().getName():"unknown";
        String messages = FormatUtil.getI18nString(locale, messageKey);
        String stackMessage = ExceptionUtils.exceptionChainToString(ex);
        String errorUrl = request.getRequestURI();
        RequestResult requestResult = new RequestResult(false, messages, date, errorUrl, className, stackMessage);

        //Ajax请求异常处理
        if ((request.getHeader("x-requested-with") != null && (request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest"))) || (request.getContentType()!=null && request.getContentType().startsWith("multipart/form-data"))){
            String result = JSON.toJSONString(requestResult);
            try {
                response.setContentType("application/json;charset=utf-8");
                response.getWriter().print(result);
                response.flushBuffer();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
        //页面异常处理
        else {
            ModelAndView mv =  new ModelAndView(StringUtils.isNotEmpty(_errorPage) ? _errorPage : "error/500");
            mv.addObject("requestResult", requestResult);
            return mv;
        }
	}


}
