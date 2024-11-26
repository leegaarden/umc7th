package umc.test.repository.MemberRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.test.domain.Member;
import umc.test.domain.enums.MissionStatus;
import umc.test.domain.mapping.MemberMission;

import java.util.List;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {
    boolean existsByMissionIdAndStatus(Long missionId, MissionStatus status);

    // 내가 진행 중인 미션 조회
    Page<MemberMission> findAllByMemberOrderByCreatedAtDesc(Member member, Pageable pageable);
}