package umc.test.apiPayload.exception.handler;

import umc.test.apiPayload.code.BaseErrorCode;
import umc.test.apiPayload.exception.GeneralException;

public class TempHandler extends GeneralException {

    public TempHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
