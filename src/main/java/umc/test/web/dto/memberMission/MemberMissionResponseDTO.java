package umc.test.web.dto.memberMission;

import lombok.Builder;
import lombok.Getter;
import umc.test.domain.enums.MissionStatus;

import java.time.LocalDateTime;

public class MemberMissionResponseDTO {

    @Getter
    @Builder
    public static class ChallengeMissionResDTO {
        private Long memberMissionId;
        private String memberName;
        private String missionSpec;
        private MissionStatus status;
        private Integer reward;
        private LocalDateTime createdAt;
    }
}
