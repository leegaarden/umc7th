package umc.test.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.test.apiPayload.ApiResponse;
import umc.test.converter.MemberMissionConverter;
import umc.test.domain.mapping.MemberMission;
import umc.test.service.MemberMissionService.MemberMissionCommandService;
import umc.test.web.dto.memberMission.MemberMissionRequestDTO;
import umc.test.web.dto.memberMission.MemberMissionResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member-missions")
public class MemberMissionRestController {
    private final MemberMissionCommandService memberMissionCommandService;

    @PostMapping("/challenge")
    public ApiResponse<MemberMissionResponseDTO.ChallengeMissionResDTO> createMemberMission(@Valid @RequestBody MemberMissionRequestDTO.ChallengeMissionReqDTO request) {
        MemberMission memberMission = memberMissionCommandService.createMemberMission(request);
        return ApiResponse.onSuccess(MemberMissionConverter.toMemberMissionResponseDTO(memberMission));
    }
}