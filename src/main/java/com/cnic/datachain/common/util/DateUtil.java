package com.cnic.datachain.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by Flora on 2015/11/19.
 */
public class DateUtil {

    /**
     * 将String型格式化,比如想要将2011-11-11格式化成2011年11月11日,就StringPattern("2011-11-11","yyyy-MM-dd","yyyy年MM月dd日").
     * @param date String 想要格式化的日期
     * @param oldPattern String 想要格式化的日期的现有格式
     * @param newPattern String 想要格式化成什么格式
     * @return String
     */
    public final String StringPattern(String date, String oldPattern, String newPattern) {
        if (date == null || oldPattern == null || newPattern == null)
            return "";
        SimpleDateFormat sdf1 = new SimpleDateFormat(oldPattern) ;        // 实例化模板对象
        SimpleDateFormat sdf2 = new SimpleDateFormat(newPattern) ;        // 实例化模板对象
        Date d = null ;
        try{
            d = sdf1.parse(date) ;   // 将给定的字符串中的日期提取出来
        }catch(Exception e){            // 如果提供的字符串格式有错误，则进行异常处理
            e.printStackTrace() ;       // 打印异常信息
        }
        return sdf2.format(d);
    }

    public static String utc2Local(String utcTime, String utcTimePatten,
                                   String localTimePatten) {
        SimpleDateFormat utcFormater = new SimpleDateFormat(utcTimePatten);
        utcFormater.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date gpsUTCDate = null;
        try {
            gpsUTCDate = utcFormater.parse(utcTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        SimpleDateFormat localFormater = new SimpleDateFormat(localTimePatten);
        localFormater.setTimeZone(TimeZone.getDefault());
        String localTime = localFormater.format(gpsUTCDate.getTime());
        return localTime;
    }

}
