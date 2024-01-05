package com.jobclub.authentication.user.auth;

import com.jobclub.authentication.user.auth.AuthenticationResponse.AuthenticationRequest;
import com.jobclub.authentication.user.auth.AuthenticationResponse.AuthenticationService;
import com.jobclub.authentication.user.config.SecurityConfiguration;
import lombok.RequiredArgsConstructor;
import com.jobclub.authentication.user.auth.AuthenticationResponse.AuthenticationResponse;
import com.jobclub.authentication.user.auth.AuthenticationResponse.RegisterRequest;
import io.jsonwebtoken.io.IOException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

 private static final Logger LOGGER
         = LoggerFactory.getLogger(AuthenticationController.class);
    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request
    ) {
     LOGGER.info("******** coming to register******");

     return ResponseEntity.ok(authenticationService.register(request));
    }
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ) {
        LOGGER.info("******** coming to authentication ****** request: "+request);
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }

}
