package com.wowo.ffms.annotations;

import com.wowo.ffms.utils.DaysToDateUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 版权：(C) 版权所有 2000-2019 上海天好电子商务股份有限公司苏州分公司
 * <简述> 判断日期是否规范
 * <详细描述>
 *
 * @author lingjian
 * @version $
 * @see
 * @since
 */
public class IsVaildDateValidator implements ConstraintValidator<IsVaildDate, String> {

    /**
     * 日志
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(IsVaildDateValidator.class);


    @Override
    public void initialize(IsVaildDate constraint) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if (StringUtils.isNotBlank(value)) {
            try {
                //DateUtils.str2Date(value, "yyyy年MM月dd日");
                //sdf.parse(s);
                DaysToDateUtils.formatExcelDate(Integer.parseInt(value));
                return true;
            } catch (Exception e) {
                LOGGER.error(e.getMessage(), e);
                return false;
            }
        }
        return true;
    }
}
