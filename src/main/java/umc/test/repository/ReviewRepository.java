package umc.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.test.domain.Review;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findAllByStoreId(Long storeId);
}
