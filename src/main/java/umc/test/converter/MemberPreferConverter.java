package umc.test.converter;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import umc.test.domain.FoodCategory;
import umc.test.domain.mapping.MemberPrefer;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class MemberPreferConverter {

    private final MemberPrefer memberPrefer;

    public static List<MemberPrefer> toMemberPreferList(List<FoodCategory> foodCategoryList){

        return foodCategoryList.stream()
                .map(foodCategory ->
                        MemberPrefer.builder()
                                .foodCategory(foodCategory)
                                .build()
                ).collect(Collectors.toList());
    }

}
