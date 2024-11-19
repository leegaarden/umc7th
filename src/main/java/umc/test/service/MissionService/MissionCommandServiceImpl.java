package umc.test.service.MissionService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.test.apiPayload.code.status.ErrorStatus;
import umc.test.apiPayload.exception.handler.StoreHandler;
import umc.test.converter.MissionConverter;
import umc.test.domain.Mission;
import umc.test.domain.Store;
import umc.test.repository.MissionRepository;
import umc.test.repository.StoreRepository.StoreRepository;
import umc.test.web.dto.mission.MissionRequestDTO;

@Service
@RequiredArgsConstructor
public class MissionCommandServiceImpl implements MissionCommandService {
    private final MissionRepository missionRepository;
    private final StoreRepository storeRepository;

    @Override
    @Transactional
    public Mission createMission(MissionRequestDTO.AddMissionReqDTO request) {
        Store store = storeRepository.findById(request.getStoreId())
                .orElseThrow(() -> new StoreHandler(ErrorStatus.STORE_NOT_FOUND));

        Mission mission = MissionConverter.toMission(request, store);
        return missionRepository.save(mission);
    }

    @Override
    public Mission createMission(MissionRequestDTO request) {
        return null;
    }
}