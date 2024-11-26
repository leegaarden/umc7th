package umc.test.web.dto.mission;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class MissionResponseDTO {

    @Getter
    @Builder
    @Schema(title = "MISSION_RES_01 : 미션 추가 응답 DTO")
    public static class AddMissionResDTO {
        private Long missionId;
        private String storeName;
        private Integer reward;
        private LocalDate deadline;
        private String missionSpec;
        private LocalDateTime createdAt;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(title = "MISSION_RES_02 : 미션 목록 응답 DTO")
    public static class MissionPreViewListDTO {
        @Schema(description = "미션 목록")
        List<MissionPreViewDTO> missionList;
        @Schema(description = "리스트 크기")
        Integer listSize;
        @Schema(description = "전체 페이지 수")
        Integer totalPage;
        @Schema(description = "전체 원소 수")
        Long totalElements;
        @Schema(description = "첫 페이지 여부")
        Boolean isFirst;
        @Schema(description = "마지막 페이지 여부")
        Boolean isLast;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(title = "MISSION_RES_03 : 미션 조회 응답 DTO")
    public static class MissionPreViewDTO {
        @Schema(description = "미션 보상")
        Integer reward;
        @Schema(description = "미션 설명")
        String missionSpec;
        @Schema(description = "마감일")
        LocalDate deadline;
        @Schema(description = "작성일")
        LocalDateTime createdAt;
    }
}
