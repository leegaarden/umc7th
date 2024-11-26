package umc.test.apiPayload.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import umc.test.apiPayload.code.status.ErrorStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class MemberMissionHandler extends RuntimeException {
    public MemberMissionHandler(ErrorStatus errorStatus) {
        super(errorStatus.getMessage());
    }
}