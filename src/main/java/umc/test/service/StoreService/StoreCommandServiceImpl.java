package umc.test.service.StoreService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.test.apiPayload.exception.handler.RegionHandler;
import umc.test.converter.StoreConverter;
import umc.test.domain.Region;
import umc.test.domain.Store;
import umc.test.repository.RegionRepository;
import umc.test.repository.StoreRepository.StoreRepository;
import umc.test.web.dto.store.StoreRequestDTO;
import umc.test.apiPayload.code.status.ErrorStatus;

@Service
@RequiredArgsConstructor
public class StoreCommandServiceImpl implements StoreCommandService {

    private final StoreRepository storeRepository;
    private final RegionRepository regionRepository;

    @Override
    public Store createStore(StoreRequestDTO request) {
        return null;
    }

    @Override
    @Transactional
    public Store createStore(StoreRequestDTO.AddStoreReqDTO request) {
        Region region = regionRepository.findById(request.getRegionId())
                .orElseThrow(() -> new RegionHandler(ErrorStatus.REGION_NOT_FOUND));

        Store store = StoreConverter.toStore(request, region);
        return storeRepository.save(store);
    }
}