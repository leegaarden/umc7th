package umc.test.web.dto.store;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

public class StoreResponseDTO {

    @Getter
    @Builder
    public static class AddStoreResDTO {
        private Long storeId;
        private String name;
        private String address;
        private String regionName;
        private LocalDateTime createdAt;
    }
}
