package umc.test.apiPayload.exception.handler;

import umc.test.apiPayload.code.BaseErrorCode;
import umc.test.apiPayload.exception.GeneralException;

public class RegionHandler extends GeneralException {
    public RegionHandler(BaseErrorCode code) {
        super(code);
    }
}
