package umc.test.apiPayload.exception.handler;

import umc.test.apiPayload.code.status.ErrorStatus;

public class InvalidPageHandler extends RuntimeException{
    public InvalidPageHandler (ErrorStatus errorStatus) {super(errorStatus.getMessage());}
}
