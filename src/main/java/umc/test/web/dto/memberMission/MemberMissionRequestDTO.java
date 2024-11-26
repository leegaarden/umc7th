package umc.test.web.dto.memberMission;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.test.validation.annotation.ExistMemberMission;
import umc.test.validation.annotation.NotDuplicateMission;

public class MemberMissionRequestDTO {

    @Getter
    @Schema(title = "MEMBERMISSION_REQ_01 : 미션 도전 요청 DTO")
    public static class ChallengeMissionReqDTO {
        @NotNull(message = "회원 ID는 필수입니다")
        private Long memberId;

        @NotNull(message = "미션 ID는 필수입니다")
        @NotDuplicateMission
        private Long missionId;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(title = "MEMBERMISSION_REQ_02 : 미션 완료 요청 DTO")
    public static class MissionCompleteDTO {
        @NotNull(message = "멤버 미션 ID는 필수입니다")
        @ExistMemberMission
        Long memberMissionId;
    }
}
