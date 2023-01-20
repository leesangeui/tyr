package com.midgard.tyr.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * description    :
 * packageName    : com.midgard.tyr.config.security
 * fileName       : SecurityConfig
 * author         : sangeui.lee
 * date           : 2022-12-27
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-12-27        sangeui.lee       최초 생성
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .httpBasic().disable()
                 // rest api 이므로 기본설정 사용안한다는 의미.
                .csrf().disable() // rest api 이므로 csrf 보안이 필요없으므로 disable 처리
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) // jwt token으로 인증방식을 이용, 세션이 피료없으므로 생성안함.
                .and()
                .authorizeRequests() // 다음 request에 대한 사용권한 체크
                .mvcMatchers("/tyr/api/*").permitAll()
                //.mvcMatchers("/tyr/api/*/").authenticated()
                //.mvcMatchers("/tyr/login/*").permitAll()
                .anyRequest().permitAll()
                .and()
                .exceptionHandling().accessDeniedHandler(new CustomAccessDeniedHandler()) // 권한에 대한 예외처리 핸들링
                .and()
                .exceptionHandling().authenticationEntryPoint(new CustomAuthenticationEntryPoint()) // 인증에 대한 예외처리 핸들링
                .and()
                .addFilterBefore(new JwtAuthenticationFilter(jwtTokenProvider), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().mvcMatchers("/static/*", "templates/*");
    }
}
