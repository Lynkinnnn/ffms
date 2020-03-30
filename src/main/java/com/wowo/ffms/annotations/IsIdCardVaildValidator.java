package com.wowo.ffms.annotations;

import com.wowo.ffms.utils.IdcardUtils;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 版权：(C) 版权所有 2000-2019 上海天好电子商务股份有限公司苏州分公司
 * <简述> 判断身份证号是否规范
 * <详细描述>
 *
 * @author lingjian
 * @version $
 * @see
 * @since
 */
public class IsIdCardVaildValidator implements ConstraintValidator<IsIdCardVaild, String> {

    @Override
    public void initialize(IsIdCardVaild constraint) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (StringUtils.isNotBlank(value)) {
            if (!IdcardUtils.checkIdcardIsLegal(value)) {
                return false;
            }
        }
        return true;
    }
}
