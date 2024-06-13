package com.amalitech.lab5.user;

import com.amalitech.lab5.auth.AuthenticationService;
import com.amalitech.lab5.auth.dto.JwtAuthenticationResponse;
import com.amalitech.lab5.auth.dto.SignUpRequest;
import com.amalitech.lab5.auth.dto.SigninRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class UserController {
    private final AuthenticationService authenticationService;

    @PostMapping("/signup")
    public ResponseEntity<JwtAuthenticationResponse> signup(@RequestBody SignUpRequest request) {
        return ResponseEntity.ok(authenticationService.signup(request));
    }

    @PostMapping("/signin")
    public ResponseEntity<JwtAuthenticationResponse> signin(@RequestBody SigninRequest request) {
        return ResponseEntity.ok(authenticationService.signin(request));
    }
    @PostMapping("reset")
    public void  forgetPassword(){

    }

    @PostMapping("change-password")
    public  void changePassword(){

    }

}
