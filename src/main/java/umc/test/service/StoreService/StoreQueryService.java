package umc.test.service.StoreService;

import org.springframework.data.domain.Page;
import umc.test.domain.Review;
import umc.test.domain.Store;

import java.util.List;
import java.util.Optional;

public interface StoreQueryService {

    Optional<Store> findStore(Long id);
    List<Store> findStoresByNameAndScore(String name, Float score);
    Page<Review> getReviewList(Long StoreId, Integer page);
}