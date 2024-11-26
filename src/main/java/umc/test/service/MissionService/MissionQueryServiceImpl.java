package umc.test.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import umc.test.apiPayload.code.status.ErrorStatus;
import umc.test.apiPayload.exception.handler.StoreHandler;
import umc.test.domain.Mission;
import umc.test.domain.Store;
import umc.test.repository.MissionRepository;
import umc.test.repository.StoreRepository.StoreRepository;
import umc.test.validation.validator.CheckPageValidator;

@Service
@RequiredArgsConstructor
@Validated
public class MissionQueryServiceImpl implements MissionQueryService {
    private final MissionRepository missionRepository;
    private final StoreRepository storeRepository;

    @Override
    @Transactional(readOnly = true)
    public Page<Mission> getMissionList(Long storeId, Integer page) {
        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new StoreHandler(ErrorStatus.STORE_NOT_FOUND));

        return missionRepository.findAllByStoreOrderByCreatedAtDesc(
                store,
                PageRequest.of(CheckPageValidator.convertToPageable(page), 10));
    }
}