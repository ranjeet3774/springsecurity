package com.ranjeecode.spring.security.controller;

import com.ranjeecode.spring.security.enity.JwtRequest;
import com.ranjeecode.spring.security.enity.JwtResponse;
import com.ranjeecode.spring.security.jwtsecurity.JwtUtil;
import com.ranjeecode.spring.security.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
public class JwtController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired

    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @RequestMapping(value = "/generateToken", method = RequestMethod.POST)
    public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception {

        try
        {
            this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(),jwtRequest.getPassword()));
        }catch(UsernameNotFoundException e){
            e.printStackTrace();
            throw new Exception("Bad Credential Provided");

        }

        UserDetails userDetails = this.customUserDetailsService.loadUserByUsername(jwtRequest.getUsername());
        String token =this.jwtUtil.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }
}
