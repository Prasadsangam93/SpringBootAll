package com.eidiko.controller;

import com.eidiko.authReq.AuthRequest;
import com.eidiko.userservice.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private JwtService jwtService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @PostMapping("/authenticate")
    public String generateToken(@RequestBody AuthRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        if(authentication.isAuthenticated()) {
            return jwtService.generateToken(authRequest.getUsername());
        }else {
            throw new UsernameNotFoundException("Invalid User");
        }
    }
}
