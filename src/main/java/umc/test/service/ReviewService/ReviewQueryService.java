package umc.test.service.ReviewService;

import org.springframework.data.domain.Page;
import umc.test.domain.Review;

public interface ReviewQueryService {
    Page<Review> getMyReviewList(Long memberId, Integer page);
}
