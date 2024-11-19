package umc.test.web.dto.mission;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

import java.time.LocalDate;

public class MissionRequestDTO {

    @Getter
    public static class AddMissionReqDTO {
        @NotNull(message = "가게 ID는 필수입니다")
        private Long storeId;

        @NotNull(message = "미션 보상은 필수입니다")
        @Min(value = 0, message = "보상은 0 이상이어야 합니다")
        private Integer reward;

        @NotNull(message = "미션 마감일은 필수입니다")
        @Future(message = "마감일은 현재보다 미래여야 합니다")
        private LocalDate deadline;

        @NotNull(message = "미션 설명은 필수입니다")
        @Size(min = 10, message = "미션 설명은 최소 10자 이상이어야 합니다")
        private String missionSpec;
    }
}
