package com.wowo.ffms.utils;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Hashtable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 版权：(C) 版权所有 2000-2019 上海天好电子商务股份有限公司苏州分公司
 * <简述> 身份证号工具类
 * <详细描述>
 *
 * @author sunqiming
 * @version V1.0
 * @see
 * @since
 */
public class IdcardUtils {

    /**
     * @Fields LOGGER : 日志
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(IdcardUtils.class);

    /**
     * <简述> 验证身份证号是否合法
     * <详细描述>
     * @author sunqiming
     * @param idcard String 身份证号
     * @return boolean
    */
    public static boolean checkIdcardIsLegal(String idcard) {
        if (StringUtils.isNotBlank(idcard)) {
            String[] wf = { "1", "0", "x", "9", "8", "7", "6", "5", "4", "3", "2" };
            String[] checkCode = { "7", "9", "10", "5", "8", "4", "2", "1", "6", "3", "7", "9", "10", "5", "8", "4", "2" };
            String iDCardNo = "";
            try {
                // 判断号码的长度15位或18位
                if (idcard.length() != 15 && idcard.length() != 18) {
                    return false;
                }
                if (idcard.length() == 18) {
                    iDCardNo = idcard.substring(0, 17);
                } else if (idcard.length() == 15) {
                    iDCardNo = idcard.substring(0, 6) + "19" + idcard.substring(6, 15);
                }
                if (!isStrNum(iDCardNo)) {
                    return false;
                }
                // 判断出生年月
                // 年份
                String strYear = iDCardNo.substring(6, 10);
                // 月份
                String strMonth = iDCardNo.substring(10, 12);
                // 月份
                String strDay = iDCardNo.substring(12, 14);
                if (!isStrDate(strYear + "-" + strMonth + "-" + strDay)) {
                    return false;
                }
                GregorianCalendar gc = new GregorianCalendar();
                SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
                if ((gc.get(Calendar.YEAR) - Integer.parseInt(strYear)) > 150 || (gc.getTime().getTime() - s.parse(strYear + "-" + strMonth + "-" + strDay).getTime()) < 0) {
                    return false;
                }
                if (Integer.parseInt(strMonth) > 12 || Integer.parseInt(strMonth) == 0) {
                    return false;
                }
                if (Integer.parseInt(strDay) > 31 || Integer.parseInt(strDay) == 0) {
                    return false;
                }
                // 判断地区码
                Hashtable h = GetAreaCode();
                if (h.get(iDCardNo.substring(0, 2)) == null) {
                    return false;
                }
                // 判断最后一位
                int theLastOne = 0;
                for (int i = 0; i < 17; i++) {
                    theLastOne = theLastOne + Integer.parseInt(String.valueOf(iDCardNo.charAt(i))) * Integer.parseInt(checkCode[i]);
                }
                int modValue = theLastOne % 11;
                String strVerifyCode = wf[modValue];
                iDCardNo = iDCardNo + strVerifyCode;
                if (idcard.length() == 18 && !iDCardNo.equals(idcard)) {
                    return false;
                }
            } catch (Exception e){
                LOGGER.error(e.getMessage(), e);
            }
        }
        return true;
    }

    /**
     * <简述> 地区代码
     * <详细描述>
     * @author sunqiming
     * @return Hashtable
    */
    private static Hashtable GetAreaCode() {
        Hashtable hashtable = new Hashtable();
        hashtable.put("11", "北京");
        hashtable.put("12", "天津");
        hashtable.put("13", "河北");
        hashtable.put("14", "山西");
        hashtable.put("15", "内蒙古");
        hashtable.put("21", "辽宁");
        hashtable.put("22", "吉林");
        hashtable.put("23", "黑龙江");
        hashtable.put("31", "上海");
        hashtable.put("32", "江苏");
        hashtable.put("33", "浙江");
        hashtable.put("34", "安徽");
        hashtable.put("35", "福建");
        hashtable.put("36", "江西");
        hashtable.put("37", "山东");
        hashtable.put("41", "河南");
        hashtable.put("42", "湖北");
        hashtable.put("43", "湖南");
        hashtable.put("44", "广东");
        hashtable.put("45", "广西");
        hashtable.put("46", "海南");
        hashtable.put("50", "重庆");
        hashtable.put("51", "四川");
        hashtable.put("52", "贵州");
        hashtable.put("53", "云南");
        hashtable.put("54", "西藏");
        hashtable.put("61", "陕西");
        hashtable.put("62", "甘肃");
        hashtable.put("63", "青海");
        hashtable.put("64", "宁夏");
        hashtable.put("65", "新疆");
        hashtable.put("71", "台湾");
        hashtable.put("81", "香港");
        hashtable.put("82", "澳门");
        hashtable.put("91", "国外");
        return hashtable;
    }

    /**
     * <简述> 判断字符串是否为数字
     * <详细描述>
     * @author sunqiming
     * @param str String 目标字符串
     * @return boolean
    */
    private static boolean isStrNum(String str) {
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);
        if (isNum.matches()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * <简述> 判断字符串是否为日期格式
     * <详细描述>
     * @author sunqiming
     * @param strDate String 目标字符串
     * @return boolean
    */
    public static boolean isStrDate(String strDate) {
        Pattern pattern = Pattern.compile("^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))(\\s(((0?[0-9])|([1-2][0-3]))\\:([0-5]?[0-9])((\\s)|(\\:([0-5]?[0-9])))))?$");
        Matcher m = pattern.matcher(strDate);
        if (m.matches()) {
            return true;
        } else {
            return false;
        }
    }
}
