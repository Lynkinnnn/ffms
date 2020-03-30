//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.wowo.ffms.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;
import org.apache.commons.lang3.StringUtils;

public class DateUtils {
    public static final long ONE_DAY_MILLIS = 86400000L;
    public static final String DATE_FORMAT_YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_FORMAT_YYYY_MM_DD = "yyyy-MM-dd";
    protected static SimpleDateFormat format;

    public DateUtils() {
    }

    public static String formatDate(long time, String style) {
        Date date = new Date(time);
        SimpleDateFormat outFormat = new SimpleDateFormat(style);
        return outFormat.format(date);
    }

    public static String formatDate(Date date) {
        if (date == null) {
            return "";
        } else {
            SimpleDateFormat outFormat = new SimpleDateFormat("yyyy-MM-dd");
            return outFormat.format(date);
        }
    }

    public static String formatDate(Date date, String fromat) {
        if (date == null) {
            return "";
        } else {
            SimpleDateFormat outFormat = new SimpleDateFormat(fromat);
            return outFormat.format(date);
        }
    }

    public static String formatDateTime(Date date) {
        SimpleDateFormat outFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return outFormat.format(date);
    }

    public static Date str2Date(String dt, String format) {
        SimpleDateFormat df = new SimpleDateFormat(format);
        Date date = null;

        try {
            date = df.parse(dt);
            return date;
        } catch (ParseException var5) {
            return date;
        }
    }

    public static int getYear() {
        Calendar cld = Calendar.getInstance();
        cld.setTime(new Date());
        return cld.get(1);
    }

    public static int getMonth() {
        Calendar cld = Calendar.getInstance();
        cld.setTime(new Date());
        return cld.get(2) + 1;
    }

    public static int getDay() {
        Calendar cld = Calendar.getInstance();
        cld.setTime(new Date());
        return cld.get(5);
    }

    public static int getHour() {
        Calendar cld = Calendar.getInstance();
        cld.setTime(new Date());
        return cld.get(11);
    }

    public static int getYear(long t) {
        Calendar cld = Calendar.getInstance();
        if (t > 0L) {
            cld.setTime(new Date(t));
        }

        return cld.get(1);
    }

    public static int getMonth(long t) {
        Calendar cld = Calendar.getInstance();
        if (t > 0L) {
            cld.setTime(new Date(t));
        }

        return cld.get(2) + 1;
    }

    public static int getDay(long t) {
        Calendar cld = Calendar.getInstance();
        if (t > 0L) {
            cld.setTime(new Date(t));
        }

        return cld.get(5);
    }

    public static int getHour(long t) {
        Calendar cld = Calendar.getInstance();
        if (t > 0L) {
            cld.setTime(new Date(t));
        }

        return cld.get(11);
    }

    public static int getMinute(long t) {
        Calendar cld = Calendar.getInstance();
        if (t > 0L) {
            cld.setTime(new Date(t));
        }

        return cld.get(12);
    }

    public static int getSecond(long t) {
        Calendar cld = Calendar.getInstance();
        if (t > 0L) {
            cld.setTime(new Date(t));
        }

        return cld.get(13);
    }

    public static int getYear(Date date) {
        Calendar cld = Calendar.getInstance();
        cld.setTime(date);
        return cld.get(1);
    }

    public static int getMonth(Date date) {
        Calendar cld = Calendar.getInstance();
        cld.setTime(date);
        return cld.get(2) + 1;
    }

    public static int getDay(Date date) {
        Calendar cld = Calendar.getInstance();
        cld.setTime(date);
        return cld.get(5);
    }

    public static int getHour(Date date) {
        Calendar cld = Calendar.getInstance();
        cld.setTime(date);
        return cld.get(11);
    }

    public static int getMinute(Date date) {
        Calendar cld = Calendar.getInstance();
        cld.setTime(date);
        return cld.get(12);
    }

    public static int getSecond(Date date) {
        Calendar cld = Calendar.getInstance();
        cld.setTime(date);
        return cld.get(13);
    }

    public static String toGMTString(Date dt) {
        DateFormat df = new SimpleDateFormat("EEE, d-MMM-yyyy HH:mm:ss z", Locale.ENGLISH);
        df.setTimeZone(TimeZone.getTimeZone("GMT"));
        return df.format(dt);
    }

    public static void main(String[] args) throws Exception {
        toGMTString(new Date());
    }

    public static Date addDays(Date date, int days) {
        return org.apache.commons.lang3.time.DateUtils.addDays(date, days);
    }

    public static Date addMilliseconds(Date date, int Milliseconds) {
        return org.apache.commons.lang3.time.DateUtils.addMilliseconds(date, Milliseconds);
    }

    public static Date addSeconds(Date date, int Seconds) {
        return org.apache.commons.lang3.time.DateUtils.addSeconds(date, Seconds);
    }

    public static Date addMinutes(Date date, int Minutes) {
        return org.apache.commons.lang3.time.DateUtils.addMinutes(date, Minutes);
    }

    public static Date addHours(Date date, int Hours) {
        return org.apache.commons.lang3.time.DateUtils.addHours(date, Hours);
    }

    public static Date addYears(Date date, int years) {
        return org.apache.commons.lang3.time.DateUtils.addYears(date, years);
    }

    public static Date addMonths(Date date, int months) {
        return org.apache.commons.lang3.time.DateUtils.addMonths(date, months);
    }

    public static Date addWeeks(Date date, int weeks) {
        return org.apache.commons.lang3.time.DateUtils.addWeeks(date, weeks);
    }

    public static Date getWeekStart() {
        Calendar cal = new GregorianCalendar();
        int day_of_week = cal.get(7) - 2;
        cal.add(5, -day_of_week);
        return cal.getTime();
    }

    public static Date getMonthStart() {
        Calendar cal = new GregorianCalendar();
        int dayOfMonth = cal.get(5);
        cal.add(5, -dayOfMonth + 1);
        return cal.getTime();
    }

    public static Date getQuarterStart() {
        int jd_start_month = 3 * ((getMonth() - 1) / 3) + 1;
        Calendar cal = new GregorianCalendar(getYear(), jd_start_month - 1, 1);
        return cal.getTime();
    }

    public static Date getYearStart() {
        Calendar cal = new GregorianCalendar(getYear(), 0, 1);
        return cal.getTime();
    }

    public static Date getTodayStart() {
        Calendar cal = new GregorianCalendar(getYear(), getMonth() - 1, getDay());
        return cal.getTime();
    }

    public static boolean checkLeapyear(int year) {
        boolean isLeapyear = false;
        if (year % 4 == 0 && year % 100 != 0) {
            isLeapyear = true;
        }

        if (year % 400 == 0) {
            isLeapyear = true;
        } else if (year % 4 != 0) {
            isLeapyear = false;
        }

        return isLeapyear;
    }

    public static int getDaysOfmonth(int month, int year) {
        int Dates = 0;
        if (month < 0 || month > 12) {
            System.out.println("month Error");
        }

        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            Dates = 31;
        }

        if (month == 2 && checkLeapyear(year)) {
            Dates = 29;
        }

        if (month == 2 && !checkLeapyear(year)) {
            Dates = 28;
        }

        if (month == 4 || month == 6 || month == 9 || month == 11) {
            Dates = 30;
        }

        return Dates;
    }

    public long getTime(String dateString) {
        try {
            long longtime = format.parse(dateString).getTime();
            return longtime;
        } catch (ParseException var7) {
            try {
                Date parsedDate = org.apache.commons.lang3.time.DateUtils.parseDate(dateString, new String[]{"yyyy/MM/dd", "yyyy.MM.dd HH:mm:ss", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy年MM月dd日", "yyyy年MM月dd日HH", "yyyy年MM月dd日HH:mm", "yyyy年MM月dd日HH:mm:ss", "yyyy年MM月dd日HH时", "yyyy年MM月dd日HH时mm分", "yyyy年MM月dd日HH时mm分ss秒", "yyyyMMdd", "yyyyMMddHHmmss", "yyyyMMddHHmm", "yyyyMMddHH", "MMM dd yyyy HH:mm:ss. zzz", "MMM dd yyyy HH:mm:ss zzz", "dd.MM.yyyy HH:mm:ss zzz", "dd MM yyyy HH:mm:ss zzz", "dd.MM.yyyy; HH:mm:ss", "dd.MM.yyyy HH:mm:ss", "dd.MM.yyyy zzz", "EEE MMM dd HH:mm:ss yyyy", "EEE MMM dd HH:mm:ss yyyy zzz", "EEE MMM dd HH:mm:ss zzz yyyy", "EEE, MMM dd HH:mm:ss yyyy zzz", "EEE, dd MMM yyyy HH:mm:ss zzz", "EEE,dd MMM yyyy HH:mm:ss zzz", "EEE, dd MMM yyyy HH:mm:sszzz", "EEE, dd MMM yyyy HH:mm:ss", "EEE, dd-MMM-yy HH:mm:ss zzz", "yyyy/MM/dd HH:mm:ss.SSS zzz", "yyyy/MM/dd HH:mm:ss.SSS", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm:ss zzz"});
                long result = parsedDate.getTime();
                return result;
            } catch (ParseException var6) {
                var6.printStackTrace();
                return -1L;
            }
        }
    }

    public static long[] getTime(long start, long end) {
        long i = end - start;
        long day = i / 86400000L;
        long h = i % 86400000L / 3600000L;
        long m = i % 3600000L / 60000L;
        long s = i % 3600000L / 1000L;
        return new long[]{day, h, m, s};
    }

    public static String getTimeDesc(long start, long end) {
        long[] it = getTime(start, end);
        String d = "";
        if (it[0] != 0L) {
            d = d + it[0] + "天";
        }

        if (it[1] != 0L) {
            d = d + it[1] + "时";
        }

        if (it[2] != 0L) {
            d = d + it[2] + "分";
        }

        if (StringUtils.isEmpty(d)) {
            d = it[3] + "秒";
        }

        return d;
    }

    public static String getTimeDesc(Date timing_start, Date timing_end) {
        return timing_start != null && timing_end != null ? getTimeDesc(timing_start.getTime(), timing_end.getTime()) : "";
    }

    static {
        format = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", Locale.US);
        format.setTimeZone(TimeZone.getTimeZone("GMT"));
    }
}
