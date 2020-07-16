package com.kopivad.quizzes.controller;

import com.kopivad.quizzes.dto.AuthenticationRequestForm;
import com.kopivad.quizzes.dto.AuthenticationResponseForm;
import com.kopivad.quizzes.service.ApiClientService;
import com.kopivad.quizzes.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final ApiClientService clientService;

    @PostMapping(value = "api/auth")
    public ResponseEntity<AuthenticationResponseForm> createAuthenticationToken(@RequestBody AuthenticationRequestForm authenticationRequestForm) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequestForm.getUsername(), authenticationRequestForm.getPassword()));
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }
        UserDetails userDetails = clientService.loadUserByUsername(authenticationRequestForm.getUsername());
        String jwt = jwtService.generateToken(userDetails);
        return ResponseEntity.ok(new AuthenticationResponseForm(jwt));
    }
}
