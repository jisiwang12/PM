package cn.gsq.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间和字符串相互转化
 */
public class DateUtil {

    public static String  DateToStr(Date date,String format) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        String time = simpleDateFormat.format(date);
        return time;
    }

    public static Date StrToDate(String time) throws ParseException {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        Date parse = simpleDateFormat.parse(time);
        return parse;
    }
}
