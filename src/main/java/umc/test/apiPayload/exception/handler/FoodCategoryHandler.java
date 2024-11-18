package umc.test.apiPayload.exception.handler;

import umc.test.apiPayload.code.BaseErrorCode;
import umc.test.apiPayload.exception.GeneralException;

public class FoodCategoryHandler extends GeneralException {
    public FoodCategoryHandler(BaseErrorCode code) {
        super(code);
    }
}
