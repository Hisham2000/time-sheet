package com.example.Back.annotation;

import com.example.Back.annotation.implementation.EntityExistsValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EntityExistsValidator.class)
@Documented
public @interface EntityExists {
    String message() default "Entity with provided Property does not exist";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    Class<?> entityClass();
    String propertyName();
}
