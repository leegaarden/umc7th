package umc.test.converter;

import org.springframework.stereotype.Component;
import umc.test.domain.Mission;
import umc.test.domain.Store;
import umc.test.web.dto.mission.MissionRequestDTO;
import umc.test.web.dto.mission.MissionResponseDTO;

import java.util.ArrayList;

@Component
public class MissionConverter {
    public static Mission toMission(MissionRequestDTO.AddMissionReqDTO request, Store store) {
        return Mission.builder()
                .store(store)
                .reward(request.getReward())
                .deadline(request.getDeadline())
                .missionSpec(request.getMissionSpec())
                .memberMissionList(new ArrayList<>())
                .build();
    }

    public static MissionResponseDTO.AddMissionResDTO toMissionResponseDTO(Mission mission) {
        return MissionResponseDTO.AddMissionResDTO.builder()
                .missionId(mission.getId())
                .storeName(mission.getStore().getName())
                .reward(mission.getReward())
                .deadline(mission.getDeadline())
                .missionSpec(mission.getMissionSpec())
                .createdAt(mission.getCreatedAt())
                .build();
    }
}