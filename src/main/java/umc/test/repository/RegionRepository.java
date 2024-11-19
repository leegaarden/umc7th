package umc.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.test.domain.Region;

public interface RegionRepository extends JpaRepository<Region, Long> {
}
