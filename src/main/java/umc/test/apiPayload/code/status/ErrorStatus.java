package umc.test.apiPayload.code.status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import umc.test.apiPayload.code.BaseErrorCode;
import umc.test.apiPayload.code.ErrorReasonDTO;

@Getter
@AllArgsConstructor
public enum ErrorStatus implements BaseErrorCode {

    // 가장 일반적인 응답
    _INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "COMMON500", "서버 에러, 관리자에게 문의 바랍니다."),
    _BAD_REQUEST(HttpStatus.BAD_REQUEST,"COMMON400","잘못된 요청입니다."),
    _UNAUTHORIZED(HttpStatus.UNAUTHORIZED,"COMMON401","인증이 필요합니다."),
    _FORBIDDEN(HttpStatus.FORBIDDEN, "COMMON403", "금지된 요청입니다."),

    // 멤버 관려 에러
    MEMBER_NOT_FOUND(HttpStatus.BAD_REQUEST, "MEMBER4001", "사용자가 없습니다."),
    NICKNAME_NOT_EXIST(HttpStatus.BAD_REQUEST, "MEMBER4002", "닉네임은 필수 입니다."),
    FOOD_CATEGORY_NOT_FOUND(HttpStatus.NOT_FOUND, "MEMBER4003", "찾을 수 없는 카테고리입니다."),
    INVALID_GENDER_VALUE(HttpStatus.BAD_REQUEST, "MEMBER4004", "잘못된 성별 코드입니다."),

    // 리전 관련
    REGION_NOT_FOUND(HttpStatus.NOT_FOUND, "REGION4001", "리전을 찾을 수 없습니다."),

    // 가게 관련
    STORE_NOT_FOUND(HttpStatus.BAD_REQUEST, "STORE4001", "해당 가게를 찾을 수 없습니다."),

    // 미션 관련
    MISSION_NOT_FOUND(HttpStatus.BAD_REQUEST, "MISSION4001", "해당 미션은 존재하지 않습니다.");

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    @Override
    public ErrorReasonDTO getReason() {
        return ErrorReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .build();
    }

    @Override
    public ErrorReasonDTO getReasonHttpStatus() {
        return ErrorReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .httpStatus(httpStatus)
                .build()
                ;
    }
}