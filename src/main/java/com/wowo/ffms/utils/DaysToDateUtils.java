package com.wowo.ffms.utils;



import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 版权：(C) 版权所有 2000-2019 上海天好电子商务股份有限公司苏州分公司
 * <简述> 天数转日期
 * <详细描述>
 *
 * @author lingjian
 * @version $
 * @see
 * @since
 */
public class DaysToDateUtils {
    public static String formatExcelDate(int day) {
        Calendar calendar = new GregorianCalendar(1900, 0, -1);
        Date gregorianDate = calendar.getTime();
        String formatExcelDate = DateUtils.formatDate(DateUtils.addDays(gregorianDate, day), DateUtils.DATE_FORMAT_YYYY_MM_DD);
        return formatExcelDate;
    }
}
