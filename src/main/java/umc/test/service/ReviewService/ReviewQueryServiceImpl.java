package umc.test.service.ReviewService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.test.apiPayload.code.status.ErrorStatus;
import umc.test.apiPayload.exception.handler.MemberHandler;
import umc.test.domain.Member;
import umc.test.domain.Review;
import umc.test.repository.MemberRepository.MemberRepository;
import umc.test.repository.ReviewRepository;
import umc.test.validation.validator.CheckPageValidator;

@Service
@RequiredArgsConstructor
public class ReviewQueryServiceImpl implements ReviewQueryService {
    private final ReviewRepository reviewRepository;
    private final MemberRepository memberRepository;

    @Override
    @Transactional(readOnly = true)
    public Page<Review> getMyReviewList(Long memberId, Integer page) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));

        return reviewRepository.findAllByMemberOrderByCreatedAtDesc(
                member,
                PageRequest.of(CheckPageValidator.convertToPageable(page), 10));
    }
}
