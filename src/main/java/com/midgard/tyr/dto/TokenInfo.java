package com.midgard.tyr.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * description    :
 * packageName    : com.midgard.tyr.dto
 * fileName       : TokenInfo
 * author         : sangeui.lee
 * date           : 2022-12-28
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-12-28        sangeui.lee       최초 생성
 */
@Builder
@Data
@AllArgsConstructor
public class TokenInfo {

    private String grantType;
    private String accessToken;
    private String refreshToken;
}