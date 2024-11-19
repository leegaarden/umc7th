package umc.test.web.dto.store;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

public class StoreRequestDTO {

    @Getter
    public static class AddStoreReqDTO {
        @NotNull(message = "가게 이름은 필수입니다")
        @Size(min = 1, max = 50, message = "가게 이름은 1-50자 사이여야 합니다")
        private String name;

        @NotNull(message = "주소는 필수입니다")
        @Size(min = 1, max = 50, message = "주소는 1-50자 사이여야 합니다")
        private String address;

        @NotNull(message = "지역 ID는 필수입니다")
        private Long regionId;
    }
}
