package com.eunoia.travelschdule.domain.user.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {

    @GetMapping("/auth/success")
    public String loginSuccessPage(@RequestParam(value = "accessToken", required = false) String accessToken) {
        return "redirect:/login/success?token=" + accessToken;
    }
}
