package umc.test.converter;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import umc.test.apiPayload.code.status.ErrorStatus;
import umc.test.apiPayload.exception.GeneralException;
import umc.test.domain.FoodCategory;
import umc.test.domain.Member;
import umc.test.domain.enums.Gender;
import umc.test.domain.enums.MemberStatus;
import umc.test.domain.mapping.MemberPrefer;
import umc.test.web.dto.member.MemberRequestDTO;
import umc.test.web.dto.member.MemberResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Component
public class MemberConverter {


    public static MemberResponseDTO.JoinResultDTO toJoinResultDTO(Member member){
        return MemberResponseDTO.JoinResultDTO.builder()
                .memberId(member.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Member toMember(MemberRequestDTO.JoinDto request) {
        Gender gender = switch (request.getGender()) {
            case 1 -> Gender.MALE;
            case 2 -> Gender.FEMALE;
            case 3 -> Gender.NONE;
            default -> throw new GeneralException(ErrorStatus.INVALID_GENDER_VALUE);
        };

        Member member = Member.builder()
                .address(request.getAddress())
                .specAddress(request.getSpecAddress())
                .gender(gender)
                .name(request.getName())
                .status(MemberStatus.ACTIVE)  // 기본 상태 설정
                .memberPreferList(new ArrayList<>())
                .build();

        return member;
    }
}