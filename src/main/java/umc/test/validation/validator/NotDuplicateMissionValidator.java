package umc.test.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.test.repository.MemberRepository.MemberMissionRepository;
import umc.test.validation.annotation.NotDuplicateMission;
import umc.test.domain.enums.MissionStatus;

@Component
@RequiredArgsConstructor
public class NotDuplicateMissionValidator implements ConstraintValidator<NotDuplicateMission, Long> {
    private final MemberMissionRepository memberMissionRepository;

    @Override
    public boolean isValid(Long missionId, ConstraintValidatorContext context) {
        if (missionId == null) return false;
        return !memberMissionRepository.existsByMissionIdAndStatus(missionId, MissionStatus.CHALLENGING);
    }
}