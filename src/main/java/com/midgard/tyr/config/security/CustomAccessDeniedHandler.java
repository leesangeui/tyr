package com.midgard.tyr.config.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * description    :
 * packageName    : com.midgard.tyr.config.security
 * fileName       : CustomAccessDeniedHandler
 * author         : sangeui.lee
 * date           : 2022-12-28
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-12-28        sangeui.lee       최초 생성
 */
@Slf4j
@Component
public class CustomAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        response.setContentType("application/json;charset=UTF-8");
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        response.getWriter().println("{ \"message\" : \"" + ErrorCode.ROLE_NOT_EXISTS.getDescription()
                + "\", \"code\" : \"" +  ErrorCode.ROLE_NOT_EXISTS.getCode()
                + "\", \"status\" : " + ErrorCode.ROLE_NOT_EXISTS.getStatus()
                + ", \"errors\" : [ ] }");
    }

}