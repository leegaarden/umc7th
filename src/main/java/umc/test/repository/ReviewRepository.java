package umc.test.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import umc.test.domain.Member;
import umc.test.domain.Review;
import umc.test.domain.Store;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    // List<Review> findAllByStoreId(Long storeId);

    // 가게에 있는 리뷰 조회
    @Query("SELECT r FROM Review r WHERE r.store = :store")
    Page<Review> findAllByStore(@Param("store") Store store, Pageable pageable);

    // 사용자가 작성한 리뷰 조회
    Page<Review> findAllByMemberOrderByCreatedAtDesc(Member member, Pageable pageable);
}
