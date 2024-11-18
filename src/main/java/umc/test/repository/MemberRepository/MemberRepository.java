package umc.test.repository.MemberRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.test.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
}