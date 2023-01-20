package com.midgard.tyr.config.security;

/**
 * description    :
 * packageName    : com.midgard.tyr.config.security
 * fileName       : ErrorCode
 * author         : sangeui.lee
 * date           : 2022-12-28
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-12-28        sangeui.lee       최초 생성
 */
public enum ErrorCode {

    INVALID_INPUT_VALUE(400, "COMMON-001", "유효성 검증에 실패한 경우"),
    INTERNAL_SERVER_ERROR(500, "COMMON-002", "서버에서 처리할 수 없는 경우"),

    INVALID_TOKEN(400,"ACCOUNT-001", "토큰이 유효하지 않은 경우"),
    EXPIRED_TOKEN(401,"ACCOUNT-002", "토큰이 만료된 경우"),
    ROLE_NOT_EXISTS(403, "ACCOUNT-003", "권한이 부족한 경우"),
    TOKEN_NOT_EXISTS(403, "ACCOUNT-004", "해당 key의 인증 토큰이 존재하지 않는 경우");


    private final int status;
    private final String code;
    private final String description;

    ErrorCode(int status, String code, String description) {
        this.status = status;
        this.code = code;
        this.description = description;
    }

    public int getStatus() {
        return status;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

}
