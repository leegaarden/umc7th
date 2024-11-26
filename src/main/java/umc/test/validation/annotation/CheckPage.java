package umc.test.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umc.test.validation.validator.CheckPageValidator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CheckPageValidator.class)
public @interface CheckPage {
    String message() default "페이지 번호가 유효하지 않습니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}