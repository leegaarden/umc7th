package umc.test.converter;

import org.springframework.stereotype.Component;
import umc.test.domain.Member;
import umc.test.domain.Mission;
import umc.test.domain.enums.MissionStatus;
import umc.test.domain.mapping.MemberMission;
import umc.test.web.dto.memberMission.MemberMissionRequestDTO;
import umc.test.web.dto.memberMission.MemberMissionResponseDTO;
import org.springframework.data.domain.Page;
import java.util.List;
import java.util.stream.Collectors;

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

    // 미션 조회 응답
    public static MemberMissionResponseDTO.MemberMissionPreViewDTO toMemberMissionPreViewDTO(MemberMission memberMission) {
        return MemberMissionResponseDTO.MemberMissionPreViewDTO.builder()
                .storeName(memberMission.getMission().getStore().getName())
                .missionSpec(memberMission.getMission().getMissionSpec())
                .status(memberMission.getStatus())
                .reward(memberMission.getMission().getReward())
                .deadline(memberMission.getMission().getDeadline())
                .createdAt(memberMission.getCreatedAt())
                .build();
    }

    // 미션 목록 조회 응답
    public static MemberMissionResponseDTO.MemberMissionPreViewListDTO toMemberMissionPreViewListDTO(Page<MemberMission> memberMissionList) {
        List<MemberMissionResponseDTO.MemberMissionPreViewDTO> memberMissionPreViewDTOList = memberMissionList.stream()
                .map(MemberMissionConverter::toMemberMissionPreViewDTO)
                .collect(Collectors.toList());

        return MemberMissionResponseDTO.MemberMissionPreViewListDTO.builder()
                .memberMissionList(memberMissionPreViewDTOList)
                .listSize(memberMissionPreViewDTOList.size())
                .totalPage(memberMissionList.getTotalPages())
                .totalElements(memberMissionList.getTotalElements())
                .isFirst(memberMissionList.isFirst())
                .isLast(memberMissionList.isLast())
                .build();
    }
}