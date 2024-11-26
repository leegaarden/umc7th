package umc.test.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.test.repository.MemberRepository.MemberMissionRepository;
import umc.test.validation.annotation.ExistMemberMission;

@Component
@RequiredArgsConstructor
public class ExistMemberMissionValidator implements ConstraintValidator<ExistMemberMission, Long> {
    private final MemberMissionRepository memberMissionRepository;

    @Override
    public boolean isValid(Long memberMissionId, ConstraintValidatorContext context) {
        if (memberMissionId == null) return false;
        boolean exists = memberMissionRepository.existsById(memberMissionId);
        if (!exists) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("MEMBER_MISSION_NOT_FOUND")
                    .addConstraintViolation();
            return false;
        }
        return true;
    }
}