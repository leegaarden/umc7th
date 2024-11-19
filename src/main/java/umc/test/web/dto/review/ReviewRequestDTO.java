package umc.test.web.dto.review;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import org.hibernate.validator.constraints.Range;
import umc.test.validation.annotation.ExistStore;

public class ReviewRequestDTO {

    @Getter
    public static class AddReviewReqtDTO {
        @NotNull(message = "제목은 필수입니다")
        private String title;

        @NotNull(message = "평점은 필수입니다")
        @Range(min = 0, max = 5, message = "평점은 0-5 사이여야 합니다")
        private Float score;

        @NotNull(message = "회원 ID는 필수입니다")
        private Long memberId;

        @ExistStore
        @NotNull(message = "가게 ID는 필수입니다")
        private Long storeId;
    }

}
