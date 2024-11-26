package umc.test.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umc.test.validation.validator.ExistMemberValidator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ExistMemberValidator.class)
public @interface ExistMember {
    String message() default "존재하지 않는 회원입니다";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
