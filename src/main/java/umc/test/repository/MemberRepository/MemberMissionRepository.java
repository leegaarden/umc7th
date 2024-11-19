package umc.test.repository.MemberRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.test.domain.enums.MissionStatus;
import umc.test.domain.mapping.MemberMission;

import java.util.List;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {
    boolean existsByMissionIdAndStatus(Long missionId, MissionStatus status);
}