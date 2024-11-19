package umc.test.web.dto.review;

import lombok.Builder;
import lombok.Getter;
import umc.test.domain.Review;

import java.time.LocalDateTime;

public class ReviewResponseDTO {

    @Getter
    @Builder
    public static class AddReviewResDTO {
        private Long reviewId;
        private String title;
        private Float score;
        private String storeName;
        private String memberName;
        private LocalDateTime createdAt;
    }

}
