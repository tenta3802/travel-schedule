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

    @GetMapping("/auth/success")
    public String loginSuccessPage(@RequestParam(value = "accessToken", required = false) String accessToken, Model model) {
        model.addAttribute("accessToken", accessToken);
        return "login-success";
    }
}
