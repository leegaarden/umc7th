package umc.test.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.test.apiPayload.ApiResponse;
import umc.test.converter.StoreConverter;
import umc.test.domain.Store;
import umc.test.service.StoreService.StoreCommandService;
import umc.test.web.dto.store.StoreRequestDTO;
import umc.test.web.dto.store.StoreResponseDTO;


@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/stores")
public class StoreRestController {

    private final StoreCommandService storeCommandService;

    // 특정 지역에 가게 추가
    @PostMapping
    public ApiResponse<StoreResponseDTO.AddStoreResDTO> createStore(@Valid @RequestBody StoreRequestDTO.AddStoreReqDTO request) {

        Store store = storeCommandService.createStore(request);
        return ApiResponse.onSuccess(StoreConverter.toStoreResponseDTO(store));
    }
}
