package umc.test.web.dto.memberMission;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import umc.test.validation.annotation.NotDuplicateMission;

public class MemberMissionRequestDTO {

    @Getter
    public static class ChallengeMissionReqDTO {
        @NotNull(message = "회원 ID는 필수입니다")
        private Long memberId;

        @NotNull(message = "미션 ID는 필수입니다")
        @NotDuplicateMission
        private Long missionId;
    }
}
