package com.sorting.sortingpayload.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = KeysValueMatchValidator.class)
public @interface KeysValueMatch {
    String message() default "Key(s) not available in the Payload";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
