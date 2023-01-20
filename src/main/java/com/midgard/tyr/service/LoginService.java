package com.midgard.tyr.service;

import com.midgard.tyr.dto.TokenInfo;
import org.springframework.stereotype.Service;

/**
 * description    :
 * packageName    : com.midgard.tyr.service
 * fileName       : LoginServiceImpl
 * author         : sangeui.lee
 * date           : 2023-01-06
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-01-06        sangeui.lee       최초 생성
 */

@Service
public interface LoginService {

    public TokenInfo userAuthentication(String userName, String userPassword);

}
