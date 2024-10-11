package com.eunoia.travelschdule.global.error;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {

    ILLEGAL_REGISTRATION_ID("Registration Id가 일치하지 않습니다", HttpStatus.BAD_REQUEST),

    TOKEN_EXPIRED("토큰이 만료되었습니다.", HttpStatus.UNAUTHORIZED),
    INVALID_TOKEN("올바르지 않은 토큰입니다.", HttpStatus.UNAUTHORIZED),
    INVALID_JWT_SIGNATURE("잘못된 JWT 시그니처입니다.", HttpStatus.UNAUTHORIZED),

    USER_NOT_FOUND("사용자 정보가 존재하지 않습니다", HttpStatus.NOT_FOUND);

    private final String message;
    private final HttpStatus status;

    ErrorCode(String message, HttpStatus status) {
        this.message = message;
        this.status = status;
    }
}
