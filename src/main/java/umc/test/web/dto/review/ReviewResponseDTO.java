package umc.test.web.dto.review;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.test.domain.Review;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Builder
@Getter
public class ReviewResponseDTO {


    @Getter
    @Builder
    @Schema(title = "REVIEW_RES_01 : 리뷰 추가 응답 DTO")
    public static class AddReviewResDTO {
        private Long reviewId;
        private String title;
        private Float score;
        private String storeName;
        private String memberName;
        private LocalDateTime createdAt;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(title = "REVIEW_RES_02 : 리뷰 보기 목록 응답 DTO")
    public static class ReviewPreViewListDTO {
        List<ReviewPreViewDTO> reviewList;
        Integer listSize;
        Integer totalPage;
        Long totalElements;
        Boolean isFirst;
        Boolean isLast;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(title = "REVIEW_RES_03 : 리뷰 보기 응답 DTO")
    public static class ReviewPreViewDTO {
        String ownerNickname;
        Float score;
        String body;
        LocalDate createdAt;
    }
}
