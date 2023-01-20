package com.midgard.tyr.config.security;

import java.io.Serializable;

/**
 * description    :
 * packageName    : com.midgard.tyr.config
 * fileName       : Role
 * author         : sangeui.lee
 * date           : 2022-12-26
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-12-26        sangeui.lee       최초 생성
 */
public enum Role implements Serializable {
    ROLE_ADMIN, ROLE_MANAGER, ROLE_MEMBER
}
