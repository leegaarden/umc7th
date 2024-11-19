package umc.test.service.ReviewService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.test.apiPayload.code.status.ErrorStatus;
import umc.test.apiPayload.exception.handler.MemberHandler;
import umc.test.apiPayload.exception.handler.StoreHandler;
import umc.test.converter.ReviewConverter;
import umc.test.domain.Member;
import umc.test.domain.Review;
import umc.test.domain.Store;
import umc.test.repository.MemberRepository.MemberRepository;
import umc.test.repository.ReviewRepository;
import umc.test.repository.StoreRepository.StoreRepository;
import umc.test.web.dto.review.ReviewRequestDTO;

@Service
@RequiredArgsConstructor
public class ReviewCommandServiceImpl implements ReviewCommandService {
    private final ReviewRepository reviewRepository;
    private final MemberRepository memberRepository;
    private final StoreRepository storeRepository;

    @Override
    @Transactional
    public Review createReview(ReviewRequestDTO.AddReviewReqtDTO request) {
        Member member = memberRepository.findById(request.getMemberId())
                .orElseThrow(() -> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));

        Store store = storeRepository.findById(request.getStoreId())
                .orElseThrow(() -> new StoreHandler(ErrorStatus.STORE_NOT_FOUND));

        Review review = ReviewConverter.toReview(request, member, store);
        return reviewRepository.save(review);
    }
}