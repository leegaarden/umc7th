package umc.test.web.dto.member;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import umc.test.validation.annotation.ExistCategories;

import java.util.List;

public class MemberRequestDTO {

    @Getter
    public static class JoinDto {
        @NotNull
        @Schema(description = "이름은 필수입니다", example = "이정원")
        private String name;

        @NotNull
        @Schema(description = "성별은 1(남), 2(여), 3(기타) 중 하나여야 합니다", example = "2")
        private Integer gender;

        @NotNull
        @Schema(description = "태어난 연도를 입력해 주세요.", example = "2002")
        private Integer birthYear;

        @NotNull
        @Schema(description = "태어난 월을 입력해 주세요.", example = "08")
        private Integer birthMonth;

        @NotNull
        @Schema(description = "태어난 일을 입력해 주세요.", example = "17")
        private Integer birthDay;

        @NotNull
        @Schema(description = "주소지를 입력해 주세요.", example = "서울시 광진구")
        @Size(min = 5, max = 12)
        private String address;

        @NotNull
        @Schema(description = "상세 주소를 입력해 주세요.", example = "중곡동")
        @Size(min = 5, max = 12)
        private String specAddress;

        @NotNull
        @ExistCategories
        private List<Long> preferCategory;
    }

}