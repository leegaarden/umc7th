package umc.test.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.test.apiPayload.code.status.ErrorStatus;
import umc.test.apiPayload.exception.handler.InvalidPageHandler;
import umc.test.validation.annotation.CheckPage;

@Component
@RequiredArgsConstructor
public class CheckPageValidator implements ConstraintValidator<CheckPage, Integer> {

    @Override
    public boolean isValid(Integer page, ConstraintValidatorContext context) {
        if (page == null || page <= 0) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.INVALID_PAGE_NUMBER.toString())
                    .addConstraintViolation();
            return false;
        }
        return true;
    }

    public static int convertToPageable(Integer page) {
        return page - 1;
    }
}