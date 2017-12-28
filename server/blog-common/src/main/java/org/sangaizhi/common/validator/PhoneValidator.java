package org.sangaizhi.common.validator;

import org.apache.commons.lang3.StringUtils;
import org.sangaizhi.common.util.RegularUtil;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 电话号码验证器
 * @author sangaizhi
 * @date 2017/9/24
 */
public class PhoneValidator implements ConstraintValidator<Phone, String>{
    @Override
    public void initialize(Phone phone) {

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if(StringUtils.isBlank(s)){
            return true;
        }
        if(RegularUtil.checkMobile(s)){
            return true;
        }
        return false;
    }
}
