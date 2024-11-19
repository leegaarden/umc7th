package umc.test.web.dto.mission;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class MissionResponseDTO {

    @Getter
    @Builder
    public static class AddMissionResDTO {
        private Long missionId;
        private String storeName;
        private Integer reward;
        private LocalDate deadline;
        private String missionSpec;
        private LocalDateTime createdAt;
    }
}
