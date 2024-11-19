package umc.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.test.domain.Mission;

import java.util.List;

public interface MissionRepository extends JpaRepository<Mission, Long> {
    List<Mission> findAllByStoreId(Long storeId);
}
