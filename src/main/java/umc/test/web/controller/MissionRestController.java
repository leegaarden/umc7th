package umc.test.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.test.apiPayload.ApiResponse;
import umc.test.converter.MissionConverter;
import umc.test.domain.Mission;
import umc.test.service.MissionService.MissionCommandService;
import umc.test.web.dto.mission.MissionRequestDTO;
import umc.test.web.dto.mission.MissionResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/missions")
public class MissionRestController {
    private final MissionCommandService missionCommandService;

    @PostMapping("add-mission")
    public ApiResponse<MissionResponseDTO.AddMissionResDTO> createMission(@Valid @RequestBody MissionRequestDTO.AddMissionReqDTO request) {
        Mission mission = missionCommandService.createMission(request);
        return ApiResponse.onSuccess(MissionConverter.toMissionResponseDTO(mission));
    }
}