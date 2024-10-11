package com.eunoia.travelschdule.domain.user.controller.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/login")
public class CustomLoginController {

    @GetMapping
    public String login() {
        return "login/login";
    }

    // 카카오 OAuth 로그인 성공 시 콜백
    @GetMapping("/success")
    public String kakaoCallback(@RequestParam(value = "token") String token, Model model) {
        model.addAttribute("token", token);
        return "/login/login-success";
    }
}
