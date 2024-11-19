package umc.test.converter;

import org.springframework.stereotype.Component;
import umc.test.domain.Region;
import umc.test.domain.Store;
import umc.test.web.dto.store.StoreRequestDTO;
import umc.test.web.dto.store.StoreResponseDTO;

import java.util.ArrayList;

@Component
public class StoreConverter {

    public static Store toStore(StoreRequestDTO.AddStoreReqDTO request, Region region) {
        return Store.builder()
                .name(request.getName())
                .address(request.getAddress())
                .region(region)
                .score(0.0f)  // 초기 점수
                .reviewList(new ArrayList<>())
                .build();
    }

    public static StoreResponseDTO.AddStoreResDTO toStoreResponseDTO(Store store) {
        return StoreResponseDTO.AddStoreResDTO.builder()
                .storeId(store.getId())
                .name(store.getName())
                .address(store.getAddress())
                .regionName(store.getRegion().getName())
                .createdAt(store.getCreatedAt())
                .build();
    }
}
