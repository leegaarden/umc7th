package umc.test.service.MemberMissionService;

import org.springframework.data.domain.Page;
import umc.test.domain.mapping.MemberMission;

public interface MemberMissionQueryService {
    Page<MemberMission> getMyMissionList(Long memberId, Integer page);
}
