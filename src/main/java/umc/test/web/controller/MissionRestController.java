package umc.test.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import umc.test.apiPayload.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.test.converter.MissionConverter;
import umc.test.domain.Mission;
import umc.test.service.MissionService.MissionCommandService;
import umc.test.service.MissionService.MissionQueryServiceImpl;
import umc.test.validation.annotation.CheckPage;
import umc.test.validation.annotation.ExistStore;
import umc.test.web.dto.mission.MissionRequestDTO;
import umc.test.web.dto.mission.MissionResponseDTO;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("api/v1/missions")
public class MissionRestController {
    private final MissionCommandService missionCommandService;
    private final MissionQueryServiceImpl missionQueryService;

    // 미션 추가
    @PostMapping("add-mission")
    public ApiResponse<MissionResponseDTO.AddMissionResDTO> createMission(@Valid @RequestBody MissionRequestDTO.AddMissionReqDTO request) {
        Mission mission = missionCommandService.createMission(request);
        return ApiResponse.onSuccess(MissionConverter.toMissionResponseDTO(mission));
    }

    @Operation(summary = "가게 미션 목록 조회 API", description = "특정 가게의 미션 목록을 조회합니다.")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "ERROR_PAGE_4001", description = "페이지 번호가 유효하지 않습니다.",
                    content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "STORE_404", description = "존재하지 않는 가게입니다.",
                    content = @Content(schema = @Schema(implementation = ApiResponse.class)))
    })
    @Parameters({
            @Parameter(name = "storeId", description = "가게의 아이디입니다."),
            @Parameter(name = "page", description = "페이지 번호(1부터 시작)", example = "1")
    })
    @GetMapping("/stores/{storeId}")
    public ApiResponse<MissionResponseDTO.MissionPreViewListDTO> getMissionList(
            @ExistStore @PathVariable(name = "storeId") Long storeId,
            @CheckPage @RequestParam(name = "page") Integer page) {
        Page<Mission> missionList = missionQueryService.getMissionList(storeId, page);
        return ApiResponse.onSuccess(MissionConverter.toMissionPreViewListDTO(missionList));
    }
}