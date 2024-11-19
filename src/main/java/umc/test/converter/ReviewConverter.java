package umc.test.converter;

import org.springframework.stereotype.Component;
import umc.test.domain.Member;
import umc.test.domain.Review;
import umc.test.domain.Store;
import umc.test.web.dto.review.ReviewRequestDTO;
import umc.test.web.dto.review.ReviewResponseDTO;

import java.util.ArrayList;

@Component
public class ReviewConverter {
    public static Review toReview(ReviewRequestDTO.AddReviewReqtDTO request, Member member, Store store) {
        return Review.builder()
                .title(request.getTitle())
                .score(request.getScore())
                .member(member)
                .store(store)
                .reviewImageList(new ArrayList<>())
                .build();
    }

    public static ReviewResponseDTO.AddReviewResDTO toReviewResponseDTO(Review review) {
        return ReviewResponseDTO.AddReviewResDTO.builder()
                .reviewId(review.getId())
                .title(review.getTitle())
                .score(review.getScore())
                .storeName(review.getStore().getName())
                .memberName(review.getMember().getName())
                .createdAt(review.getCreatedAt())
                .build();
    }
}