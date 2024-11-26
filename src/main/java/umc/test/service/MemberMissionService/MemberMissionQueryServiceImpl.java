package umc.test.service.MemberMissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import umc.test.apiPayload.code.status.ErrorStatus;
import umc.test.apiPayload.exception.handler.MemberHandler;
import umc.test.domain.Member;
import umc.test.domain.mapping.MemberMission;
import umc.test.repository.MemberRepository.MemberMissionRepository;
import umc.test.repository.MemberRepository.MemberRepository;
import umc.test.validation.validator.CheckPageValidator;

@Service
@RequiredArgsConstructor
@Validated
public class MemberMissionQueryServiceImpl implements MemberMissionQueryService {
    private final MemberMissionRepository memberMissionRepository;
    private final MemberRepository memberRepository;

    @Override
    @Transactional(readOnly = true)
    public Page<MemberMission> getMyMissionList(Long memberId, Integer page) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));

        return memberMissionRepository.findAllByMemberOrderByCreatedAtDesc(
                member,
                PageRequest.of(CheckPageValidator.convertToPageable(page), 10));
    }
}
