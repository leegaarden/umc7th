package umc.test.service.MemberService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.test.apiPayload.exception.handler.FoodCategoryHandler;
import umc.test.converter.MemberConverter;
import umc.test.converter.MemberPreferConverter;
import umc.test.domain.FoodCategory;
import umc.test.domain.Member;
import umc.test.domain.mapping.MemberPrefer;
import umc.test.repository.FoodCategoryRepository.FoodCategoryRepository;
import umc.test.repository.MemberRepository.MemberRepository;
import umc.test.web.dto.member.MemberRequestDTO;
import umc.test.apiPayload.code.status.ErrorStatus;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberCommandServiceImpl implements MemberCommandService{

    private final MemberRepository memberRepository;

    private final FoodCategoryRepository foodCategoryRepository;

    @Override
    @Transactional
    public Member joinMember(MemberRequestDTO.JoinDto request) {
        // 1. preferCategory null 체크 추가
        if (request.getPreferCategory() == null || request.getPreferCategory().isEmpty()) {
            throw new IllegalArgumentException("선호 카테고리는 필수입니다.");
        }

        Member newMember = MemberConverter.toMember(request);

        // 2. 예외 처리 개선
        List<FoodCategory> foodCategoryList = request.getPreferCategory()
                .stream()
                .map(category -> foodCategoryRepository.findById(category)
                        .orElseThrow(() -> new FoodCategoryHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND)))
                .collect(Collectors.toList());

        List<MemberPrefer> memberPreferList = MemberPreferConverter.toMemberPreferList(foodCategoryList);
        memberPreferList.forEach(memberPrefer -> memberPrefer.setMember(newMember));

        return memberRepository.save(newMember);
    }
}