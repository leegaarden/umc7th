package umc.test.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.test.apiPayload.ApiResponse;
import umc.test.converter.MemberConverter;
import umc.test.domain.Member;
import umc.test.service.MemberService.MemberCommandService;
import umc.test.web.dto.member.MemberRequestDTO;
import umc.test.web.dto.member.MemberResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/users")
public class MemberRestController {

    private final MemberCommandService memberCommandService;

    // 회원가입
    @PostMapping("/sign-up")
    public ApiResponse<MemberResponseDTO.JoinResultDTO> join
            (@RequestBody @Valid MemberRequestDTO.JoinDto request){
        Member member = memberCommandService.joinMember(request);
        return ApiResponse.onSuccess(MemberConverter.toJoinResultDTO(member));
    }

    // 미션 도전하기
}