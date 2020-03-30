package com.wowo.ffms.annotations;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

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
//修饰的范围是成员变量
@Target({ ElementType.FIELD})
//该注解被保留的时间长短 RUNTIME:在运行时有效
@Retention(RetentionPolicy.RUNTIME)
//指定校验逻辑处理的Class
@Constraint(validatedBy = IsIdCardVaildValidator.class)
public @interface IsIdCardVaild {
    String message() default "";
    Class< ? >[] groups() default { };
    Class< ? extends Payload>[] payload() default { };
}
