package umc.test.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.test.apiPayload.ApiResponse;
import umc.test.converter.MemberMissionConverter;
import umc.test.domain.mapping.MemberMission;
import umc.test.service.MemberMissionService.MemberMissionCommandService;
import umc.test.service.MemberMissionService.MemberMissionQueryService;
import umc.test.validation.annotation.CheckPage;
import umc.test.validation.annotation.ExistMember;
import umc.test.validation.annotation.ExistMemberMission;
import umc.test.web.dto.memberMission.MemberMissionRequestDTO;
import umc.test.web.dto.memberMission.MemberMissionResponseDTO;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("api/v1/member-missions")
public class MemberMissionRestController {
    private final MemberMissionCommandService memberMissionCommandService;
    private final MemberMissionQueryService memberMissionQueryService;

    @PostMapping("/challenge")
    public ApiResponse<MemberMissionResponseDTO.ChallengeMissionResDTO> createMemberMission(@Valid @RequestBody MemberMissionRequestDTO.ChallengeMissionReqDTO request) {
        MemberMission memberMission = memberMissionCommandService.createMemberMission(request);
        return ApiResponse.onSuccess(MemberMissionConverter.toMemberMissionResponseDTO(memberMission));
    }

    // 내가 진행 중인 미션 목록 조회
    @Operation(summary = "내 미션 목록 조회 API", description = "사용자의 진행 중인 미션 목록을 조회합니다.")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "ERROR_PAGE_4001", description = "페이지 번호가 유효하지 않습니다.",
                    content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "MEMBER_404", description = "존재하지 않는 회원입니다.",
                    content = @Content(schema = @Schema(implementation = ApiResponse.class)))
    })
    @Parameters({
            @Parameter(name = "memberId", description = "회원의 아이디입니다."),
            @Parameter(name = "page", description = "페이지 번호(1부터 시작)", example = "1")
    })
    @GetMapping("/my/{memberId}")
    public ApiResponse<MemberMissionResponseDTO.MemberMissionPreViewListDTO> getMyMissionList(
            @ExistMember @PathVariable(name = "memberId") Long memberId,
            @CheckPage @RequestParam(name = "page") Integer page) {
        Page<MemberMission> memberMissionList = memberMissionQueryService.getMyMissionList(memberId, page);
        return ApiResponse.onSuccess(MemberMissionConverter.toMemberMissionPreViewListDTO(memberMissionList));
    }

    // 미션 완료하기
    @Operation(summary = "미션 완료 처리 API", description = "진행 중인 미션을 완료 상태로 변경합니다.")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "MISSION404", description = "존재하지 않는 미션입니다.",
                    content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "MISSION400", description = "진행 중인 미션이 아닙니다.",
                    content = @Content(schema = @Schema(implementation = ApiResponse.class)))
    })
    @PatchMapping("/complete")
    public ApiResponse<MemberMissionResponseDTO.MissionCompleteResultDTO> completeMission(
            @RequestBody @Valid MemberMissionRequestDTO.MissionCompleteDTO request) {
        MemberMission memberMission = memberMissionCommandService.completeMission(request.getMemberMissionId());
        return ApiResponse.onSuccess(MemberMissionConverter.toMissionCompleteResultDTO(memberMission));
    }

}