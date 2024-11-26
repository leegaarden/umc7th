package umc.test.service.MemberMissionService;

import umc.test.domain.mapping.MemberMission;
import umc.test.web.dto.memberMission.MemberMissionRequestDTO;

public interface MemberMissionCommandService {
    MemberMission createMemberMission(MemberMissionRequestDTO.ChallengeMissionReqDTO request);
    
    // 내 미션 완료하기
    MemberMission completeMission(Long memberMissionId);
}