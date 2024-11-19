package umc.test.service.MemberMissionService;

import umc.test.domain.mapping.MemberMission;
import umc.test.web.dto.memberMission.MemberMissionRequestDTO;

public interface MemberMissionCommandService {
    MemberMission createMemberMission(MemberMissionRequestDTO.ChallengeMissionReqDTO request);
}