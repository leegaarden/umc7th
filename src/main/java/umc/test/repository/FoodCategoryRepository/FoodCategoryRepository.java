package umc.test.repository.FoodCategoryRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.test.domain.FoodCategory;

public interface FoodCategoryRepository extends JpaRepository<FoodCategory, Long> {
}
