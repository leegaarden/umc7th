package umc.test.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.test.repository.MemberRepository.MemberRepository;
import umc.test.validation.annotation.ExistMember;

@Component
@RequiredArgsConstructor
public class ExistMemberValidator implements ConstraintValidator<ExistMember, Long> {
    private final MemberRepository memberRepository;

    @Override
    public boolean isValid(Long memberId, ConstraintValidatorContext context) {
        if (memberId == null) return false;
        boolean exists = memberRepository.existsById(memberId);
        if (!exists) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("MEMBER_NOT_FOUND")
                    .addConstraintViolation();
            return false;
        }
        return true;
    }
}
