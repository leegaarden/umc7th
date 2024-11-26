package umc.test.web.dto.memberMission;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.test.domain.enums.MissionStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class MemberMissionResponseDTO {

    @Getter
    @Builder
    @Schema(title = "MEMBERMISSION_RES_01 : 미션 도전 응답 DTO")
    public static class ChallengeMissionResDTO {
        private Long memberMissionId;
        private String memberName;
        private String missionSpec;
        private MissionStatus status;
        private Integer reward;
        private LocalDateTime createdAt;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(title = "MEMBERMISSION_RES_02 : 내 미션 목록 조회 응답 DTO")
    public static class MemberMissionPreViewListDTO {
        @Schema(description = "미션 목록")
        List<MemberMissionPreViewDTO> memberMissionList;
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
    @Schema(title = "MEMBERMISSION_RES_03 : 내 미션 조회 응답 DTO")
    public static class MemberMissionPreViewDTO {
        @Schema(description = "가게 이름")
        String storeName;
        @Schema(description = "미션 내용")
        String missionSpec;
        @Schema(description = "미션 상태")
        MissionStatus status;
        @Schema(description = "보상 포인트")
        Integer reward;
        @Schema(description = "마감일")
        LocalDate deadline;
        @Schema(description = "미션 시작일")
        LocalDateTime createdAt;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(title = "MEMBERMISSION_RES_04 : 미션 완료 응답 DTO")
    public static class MissionCompleteResultDTO {
        @Schema(description = "변경된 미션 상태")
        MissionStatus missionStatus;
        @Schema(description = "변경 시각")
        LocalDateTime updatedAt;
    }
}
