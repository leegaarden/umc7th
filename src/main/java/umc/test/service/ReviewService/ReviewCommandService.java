package umc.test.service.ReviewService;
import umc.test.domain.Review;
import umc.test.web.dto.review.ReviewRequestDTO;

public interface ReviewCommandService {
    Review createReview(ReviewRequestDTO.AddReviewReqtDTO request);
}

