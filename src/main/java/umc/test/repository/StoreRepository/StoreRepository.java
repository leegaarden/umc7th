package umc.test.repository.StoreRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.test.domain.Store;

public interface StoreRepository extends JpaRepository<Store, Long>, StoreRepositoryCustom {

    boolean existsByNameAndAddress(String name, String address);
}