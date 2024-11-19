package umc.test.service.MissionService;

import jakarta.transaction.Transactional;
import umc.test.domain.Mission;
import umc.test.web.dto.mission.MissionRequestDTO;

public interface MissionCommandService {
    @Transactional
    Mission createMission(MissionRequestDTO.AddMissionReqDTO request);

    Mission createMission(MissionRequestDTO request);
}