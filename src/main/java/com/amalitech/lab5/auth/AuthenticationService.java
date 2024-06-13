package com.amalitech.lab5.auth;

import com.amalitech.lab5.auth.dto.JwtAuthenticationResponse;
import com.amalitech.lab5.auth.dto.SignUpRequest;
import com.amalitech.lab5.auth.dto.SigninRequest;

public interface  AuthenticationService {
    JwtAuthenticationResponse signup(SignUpRequest request);

    JwtAuthenticationResponse signin(SigninRequest request);

//    private static final String AUTH_TOKEN_HEADER_NAME = "X-API-KEY";
//    private static final String AUTH_TOKEN = "Baeldung";
//
//    public static Authentication getAuthentication(HttpServletRequest request) {
//        String apiKey = request.getHeader(AUTH_TOKEN_HEADER_NAME);
//        if (apiKey == null || !apiKey.equals(AUTH_TOKEN)) {
//            throw new BadCredentialsException("Invalid API Key");
//        }
//
//       return new ApiKeyAuthentication(apiKey,AuthorityUtils.NO_AUTHORITIES);
//    }
}