package umc.test.service.MissionService;

import org.springframework.data.domain.Page;
import umc.test.domain.Mission;

public interface MissionQueryService {
    Page<Mission> getMissionList(Long storeId, Integer page);
}
