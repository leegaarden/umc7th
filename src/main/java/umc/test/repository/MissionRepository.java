package umc.test.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.test.domain.Mission;
import umc.test.domain.Store;

import java.util.List;

public interface MissionRepository extends JpaRepository<Mission, Long> {
    List<Mission> findAllByStoreId(Long storeId);

    // 가게 별 미션 목록 조회
    Page<Mission> findAllByStoreOrderByCreatedAtDesc(Store store, Pageable pageable);
}
