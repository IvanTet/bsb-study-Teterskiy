package com.example.bsbstudyteterski.controller;

import com.example.bsbstudyteterski.security.jwt.JwtAuthentication;
import com.example.bsbstudyteterski.security.jwt.JwtRequest;
import com.example.bsbstudyteterski.security.jwt.JwtResponse;
import com.example.bsbstudyteterski.security.jwt.RefreshJwtRequest;
import com.example.bsbstudyteterski.service.AuthService;
import com.example.bsbstudyteterski.service.UserService;
import jakarta.security.auth.message.AuthException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class UserAuthorisationController {

    private final UserService userService;

    private final AuthService authService;

    public UserAuthorisationController(UserService userService, AuthService authService) {
        this.userService = userService;
        this.authService = authService;
    }

    @PreAuthorize("hasAuthority('user')")
    @GetMapping("/user")
    public ResponseEntity<String> helloUser() {
        final JwtAuthentication authInfo = authService.getAuthInfo();
        return ResponseEntity.ok("Hello user " + authInfo.getPrincipal() + "!");
    }

    @PostMapping("/user/login")
    public ResponseEntity<JwtResponse> login(@RequestBody JwtRequest authRequest) throws AuthException {
        final JwtResponse token = authService.login(authRequest);
        return ResponseEntity.ok(token);
    }

    @PostMapping("/user/token")
    public ResponseEntity<JwtResponse> getNewAccessToken(@RequestBody RefreshJwtRequest request) throws AuthException {
        final JwtResponse token = authService.getAccessToken(request.getRefreshToken());
        return ResponseEntity.ok(token);
    }

    @PostMapping("/user/refresh")
    public ResponseEntity<JwtResponse> getNewRefreshToken(@RequestBody RefreshJwtRequest request) throws AuthException {
        final JwtResponse token = authService.refresh(request.getRefreshToken());
        return ResponseEntity.ok(token);
    }
}
