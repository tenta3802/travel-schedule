package com.eunoia.travelschdule.domain.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CustomLoginController {

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/login/success")
    public String kakaoCallback(@RequestParam(value = "token") String token, Model model) {
        model.addAttribute("accessToken", token);
        return "/login-success";
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }


}
