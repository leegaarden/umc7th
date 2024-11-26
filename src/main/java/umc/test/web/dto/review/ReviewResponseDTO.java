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

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(title = "REVIEW_RES_04 : 내 리뷰 목록 응답 DTO")
    public static class MyReviewPreViewListDTO {
        @Schema(description = "리뷰 목록")
        List<MyReviewPreViewDTO> reviewList;
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
    @Schema(title = "REVIEW_RES_05 : 내 리뷰 응답 DTO")
    public static class MyReviewPreViewDTO {
        @Schema(description = "가게 이름")
        String storeName;
        @Schema(description = "리뷰 제목")
        String title;
        @Schema(description = "평점")
        Float score;
        @Schema(description = "작성일")
        LocalDate createdAt;
    }
}
