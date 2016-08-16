package com.cnic.datachain.common.util;

import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by duyuanyuan on 2015/12/5.
 * good day commander!
 */
public class FormatUtil {

    public static String formatToNormalUnitB(BigDecimal digit) {
        DecimalFormat df = new DecimalFormat("0.00");
        BigDecimal unit = BigDecimal.valueOf(1024);
        String[] unitArr = new String[]{"B","KB","MB","GB","TB","PB","EB","ZB","YB"};
        int index = 0;
        while(digit.intValue() != 0 && digit.intValue() > 1024) {
            digit = digit.divide(unit);
            index++;
        }
        return df.format(digit) + unitArr[index];
    }

    public static String formatToNormalDigit(BigDecimal digit) {
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(digit);
    }

    public static Locale getClientLocale(HttpServletRequest request) {
        String defualtLanguage = PropertyUtil.getInstance().getPropertyValue("static.defaultLanguage");
        Locale locale = (Locale) request.getSession().getAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME);
        if(locale==null) {
            locale = new Locale(defualtLanguage);
        }
        return locale;
    }

    public static String getI18nString(Locale locale, String s) {
        ResourceBundle rb = ResourceBundle.getBundle("messages", locale);
        String result = rb.getString(s);
        return result;
    }

}
