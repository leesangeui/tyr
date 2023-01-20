package com.midgard.tyr.controller;

import com.midgard.tyr.dto.TokenInfo;
import com.midgard.tyr.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * description    :
 * packageName    : com.midgard.tyr.controller
 * fileName       : LoginController
 * author         : sangeui.lee
 * date           : 2022-12-26
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-12-26        sangeui.lee       최초 생성
 */
@RestController
@RequestMapping(value = "/tyr/api")
public class LoginController {

    @Bean
    public LoginService loginService() {
        //return  new LoginService();
        return null;
    };

    @RequestMapping("/login")
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");

        return modelAndView;
    }

    @RequestMapping("/userAuthentication")
    public ModelAndView userAuthentication(Authentication authentication, @RequestParam LinkedHashMap<String , String> paramMap) {

        String userName = paramMap.get("userName");
        String userPassword = paramMap.get("userPassword");

        //TokenInfo tokenInfo = loginService.userAuthentication(userName,userPassword);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");





        //SecurityUser securityUser = (SecurityUser) authentication.getPrincipal();
        //map.addAttribute("user", securityUser);

        return modelAndView;
    }

    @RequestMapping("/accessDenied")
    public String accessDenied() {
        return "accessDenied";
    }

    @RequestMapping("/member")
    public String member() {
        return "member";
    }

    @RequestMapping("/manager")
    public String manager() {
        return "manager";
    }

    @RequestMapping("/admin")
    public String admin() {
        return "admin";
    }
}
