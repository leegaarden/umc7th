package umc.test.service.StoreService;

import jakarta.transaction.Transactional;
import umc.test.domain.Store;
import umc.test.web.dto.store.StoreRequestDTO;

public interface StoreCommandService {
    Store createStore(StoreRequestDTO request);

    @Transactional
    Store createStore(StoreRequestDTO.AddStoreReqDTO request);
}