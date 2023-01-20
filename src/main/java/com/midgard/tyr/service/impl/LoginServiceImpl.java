package com.midgard.tyr.service.impl;

import com.midgard.tyr.config.security.JwtTokenProvider;
import com.midgard.tyr.dto.TokenInfo;
import com.midgard.tyr.service.LoginService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;

/**
 * description    :
 * packageName    : com.midgard.tyr.service.impl
 * fileName       : LoginServiceImpl
 * author         : sangeui.lee
 * date           : 2023-01-06
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-01-06        sangeui.lee       최초 생성
 */
public class LoginServiceImpl implements LoginService {

    private  AuthenticationManagerBuilder authenticationManagerBuilder;
    private  JwtTokenProvider jwtTokenProvider;

    @Override
    public TokenInfo userAuthentication(String userName, String userPassword) {

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userName, userPassword);

        // JPA UserLogin Service 구현 DB User 정보 체크 (암호화로직 추가)

        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);

        // 3. 인증 정보를 기반으로 JWT 토큰 생성
        TokenInfo tokenInfo = jwtTokenProvider.generateToken(authentication);

        return tokenInfo;
    }
}
