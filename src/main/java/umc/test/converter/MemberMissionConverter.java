package umc.test.converter;

import org.springframework.stereotype.Component;
import umc.test.domain.Member;
import umc.test.domain.Mission;
import umc.test.domain.enums.MissionStatus;
import umc.test.domain.mapping.MemberMission;
import umc.test.web.dto.memberMission.MemberMissionRequestDTO;
import umc.test.web.dto.memberMission.MemberMissionResponseDTO;

@Component
public class MemberMissionConverter {
    public static MemberMission toMemberMission(MemberMissionRequestDTO.ChallengeMissionReqDTO request, Member member, Mission mission) {
        return MemberMission.builder()
                .member(member)
                .mission(mission)
                .status(MissionStatus.CHALLENGING)
                .build();
    }

    public static MemberMissionResponseDTO.ChallengeMissionResDTO toMemberMissionResponseDTO(MemberMission memberMission) {
        return MemberMissionResponseDTO.ChallengeMissionResDTO.builder()
                .memberMissionId(memberMission.getId())
                .memberName(memberMission.getMember().getName())
                .missionSpec(memberMission.getMission().getMissionSpec())
                .status(memberMission.getStatus())
                .reward(memberMission.getMission().getReward())
                .createdAt(memberMission.getCreatedAt())
                .build();
    }
}