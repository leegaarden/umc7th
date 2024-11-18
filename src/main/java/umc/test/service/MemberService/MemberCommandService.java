package umc.test.service.MemberService;

import umc.test.domain.Member;
import umc.test.web.dto.member.MemberRequestDTO;

public interface MemberCommandService {
    Member joinMember(MemberRequestDTO.JoinDto request);
}
