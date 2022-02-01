package perscholas.validation;

import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailUniqueImpl  implements ConstraintValidator<EmailUnique, String> {

    @Override
    public void initialize(EmailUnique constraintAnnotation) {


    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if (StringUtils.isEmpty(value)) {
            return true;
        }


        boolean passes = !StringUtils.equals(value, "a@b.com");
        return (passes);
    }
}