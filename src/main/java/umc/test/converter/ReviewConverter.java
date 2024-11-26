package umc.test.converter;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import umc.test.domain.Member;
import umc.test.domain.Review;
import umc.test.domain.Store;
import umc.test.web.dto.review.ReviewRequestDTO;
import umc.test.web.dto.review.ReviewResponseDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public static ReviewResponseDTO.ReviewPreViewDTO toReviewPreViewDTO(Review review){
        return ReviewResponseDTO.ReviewPreViewDTO.builder()
                .ownerNickname(review.getMember().getName())
                .score(review.getScore())
                .createdAt(review.getCreatedAt().toLocalDate())
                .body(review.getTitle())
                .build();
    }
    public static ReviewResponseDTO.ReviewPreViewListDTO toReviewPreViewListDTO(Page<Review> reviewList){
        List<ReviewResponseDTO.ReviewPreViewDTO> reviewPreViewDTOList = reviewList.stream()
                .map(ReviewConverter::toReviewPreViewDTO)
                .collect(Collectors.toList());

        return ReviewResponseDTO.ReviewPreViewListDTO.builder()
                .isLast(reviewList.isLast())
                .isFirst(reviewList.isFirst())
                .totalPage(reviewList.getTotalPages())
                .totalElements(reviewList.getTotalElements())
                .listSize(reviewPreViewDTOList.size())
                .reviewList(reviewPreViewDTOList)
                .build();
    }

    // 내가 쓴 리뷰 목록 조회
    public static ReviewResponseDTO.MyReviewPreViewDTO toMyReviewPreViewDTO(Review review) {
        return ReviewResponseDTO.MyReviewPreViewDTO.builder()
                .storeName(review.getStore().getName())
                .title(review.getTitle())
                .score(review.getScore())
                .createdAt(review.getCreatedAt().toLocalDate())
                .build();
    }

    // 내가 쓴 리뷰
    public static ReviewResponseDTO.MyReviewPreViewListDTO toMyReviewPreViewListDTO(Page<Review> reviewList) {
        List<ReviewResponseDTO.MyReviewPreViewDTO> reviewPreViewDTOList = reviewList.stream()
                .map(ReviewConverter::toMyReviewPreViewDTO)
                .collect(Collectors.toList());

        return ReviewResponseDTO.MyReviewPreViewListDTO.builder()
                .reviewList(reviewPreViewDTOList)
                .listSize(reviewPreViewDTOList.size())
                .totalPage(reviewList.getTotalPages())
                .totalElements(reviewList.getTotalElements())
                .isFirst(reviewList.isFirst())
                .isLast(reviewList.isLast())
                .build();
    }
}