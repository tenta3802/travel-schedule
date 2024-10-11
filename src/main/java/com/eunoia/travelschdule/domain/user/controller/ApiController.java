package com.eunoia.travelschdule.domain.user.controller;

import com.eunoia.travelschdule.domain.user.application.UserService;
import com.eunoia.travelschdule.domain.user.domain.User;
import com.eunoia.travelschdule.domain.user.security.PrincipalDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ApiController {

    private final UserService userService;

    @GetMapping("/api/user/info")
    public ResponseEntity<User> getUserInfo(@AuthenticationPrincipal PrincipalDetails principalDetails) {
        return ResponseEntity.ok(userService.findUserByName(principalDetails.getUsername()));
    }
}
