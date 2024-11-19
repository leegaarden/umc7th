package umc.test.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umc.test.validation.validator.NotDuplicateMissionValidator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NotDuplicateMissionValidator.class)
public @interface NotDuplicateMission {
    String message() default "이미 도전 중인 미션입니다";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
