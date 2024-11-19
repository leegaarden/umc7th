package umc.test.service.MemberMissionService;


import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.test.apiPayload.code.status.ErrorStatus;
import umc.test.apiPayload.exception.handler.MemberHandler;
import umc.test.apiPayload.exception.handler.MissionHandler;
import umc.test.converter.MemberMissionConverter;
import umc.test.domain.Member;
import umc.test.domain.Mission;
import umc.test.domain.mapping.MemberMission;
import umc.test.repository.MemberRepository.MemberMissionRepository;
import umc.test.repository.MemberRepository.MemberRepository;
import umc.test.repository.MissionRepository;
import umc.test.web.dto.memberMission.MemberMissionRequestDTO;

@Service
@RequiredArgsConstructor
public class MemberMissionCommandServiceImpl implements MemberMissionCommandService {
    private final MemberMissionRepository memberMissionRepository;
    private final MemberRepository memberRepository;
    private final MissionRepository missionRepository;

    @Override
    @Transactional
    public MemberMission createMemberMission(MemberMissionRequestDTO.ChallengeMissionReqDTO request) {
        Member member = memberRepository.findById(request.getMemberId())
                .orElseThrow(() -> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));

        Mission mission = missionRepository.findById(request.getMissionId())
                .orElseThrow(() -> new MissionHandler(ErrorStatus.MISSION_NOT_FOUND));

        MemberMission memberMission = MemberMissionConverter.toMemberMission(request, member, mission);
        return memberMissionRepository.save(memberMission);
    }
}