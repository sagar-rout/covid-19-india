package com.rout.covid19india.validation;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author sagar_rout@hotmail.com
 */
@Target({METHOD, FIELD, PARAMETER, TYPE_USE})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {ServerGeneratedValue.Validator.class})
public @interface ServerGeneratedValue {

    String message() default "'${validatedValue}' cannot be set, property is generated on the server side.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    class Validator implements ConstraintValidator<ServerGeneratedValue, Object> {
        @Override
        public void initialize(ServerGeneratedValue parameters) {
        }
        @Override
        public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {
            return value == null;
        }
    }
}