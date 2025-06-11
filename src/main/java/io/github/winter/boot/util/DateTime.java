package io.github.winter.boot.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期时间
 *
 * @author changebooks@qq.com
 */
public final class DateTime {

    public static final String PATTERN = "yyyy-MM-dd HH:mm:ss";
    public static final String PATTERN_WITHOUT_SECOND = "yyyy-MM-dd HH:mm";
    public static final String PATTERN_WITHOUT_TIME = "yyyy-MM-dd";
    public static final String PATTERN_SLASH = "yyyy/MM/dd HH:mm:ss";
    public static final String PATTERN_SLASH_WITHOUT_SECOND = "yyyy/MM/dd HH:mm";
    public static final String PATTERN_SLASH_WITHOUT_TIME = "yyyy/MM/dd";

    private DateTime() {
    }

    /**
     * 当前时间戳，单位：秒
     *
     * @return timestamp
     */
    public static int currentTimeSecond() {
        return (int) (System.currentTimeMillis() / 1000L);
    }

    /**
     * 当前时间，yyyy-MM-dd HH:mm:ss
     *
     * @return eg: "2022-02-22 22:22:22"
     */
    public static String now() {
        return format(new Date());
    }

    /**
     * Date format yyyy-MM-dd HH:mm:ss
     *
     * @param date the {@link Date} instance
     * @return eg: "2022-02-22 22:22:22"
     */
    public static String format(Date date) {
        return format(date, PATTERN);
    }

    /**
     * Date parse yyyy-MM-dd HH:mm:ss
     *
     * @param source eg: "2022-02-22 22:22:22"
     * @return a {@link Date} instance
     * @throws ParseException 解析失败
     */
    public static Date parse(String source) throws ParseException {
        return parse(source, PATTERN);
    }

    /**
     * Date to String
     *
     * @param date    the {@link Date} instance
     * @param pattern eg: "yyyy-MM-dd HH:mm:ss", "yyyy/MM/dd HH:mm:ss", ...
     * @return eg: "2022-02-22 22:22:22", "2022/02/22 22:22", ...
     */
    public static String format(Date date, String pattern) {
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        return formatter.format(date);
    }

    /**
     * String to Date
     *
     * @param source  eg: "2022-02-22 22:22:22", "2022/02/22 22:22", ...
     * @param pattern eg: "yyyy-MM-dd HH:mm:ss", "yyyy/MM/dd HH:mm:ss", ...
     * @return a {@link Date} instance
     * @throws ParseException 解析失败
     */
    public static Date parse(String source, String pattern) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        return formatter.parse(source);
    }

}
