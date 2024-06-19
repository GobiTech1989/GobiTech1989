package com.gobi.rohit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gobi.rohit.dto.LoginDTO;
import com.gobi.rohit.dto.UserDTO;
import com.gobi.rohit.entity.Users;
import com.gobi.rohit.service.AuthService;
import com.gobi.rohit.utils.JwtUtils;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RequestMapping("/auth")
@RestController
@AllArgsConstructor(onConstructor_ = @Autowired)
public class AuthController {

	private final JwtUtils jwtUtils;
    private final AuthService authService;
    
    @PostMapping("/signup")
    public ResponseEntity<UserDTO> register(@Valid @RequestBody UserDTO userDTO) {
    	UserDTO registeredUser = authService.signup(userDTO);
        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginDTO> authenticate(@Valid @RequestBody LoginDTO loginDTO) {
    	Users authenticatedUser = authService.authenticate(loginDTO);
        String jwtToken = jwtUtils.generateToken(authenticatedUser);
        LoginDTO loginResponse = LoginDTO.builder().authToken(jwtToken).expiresIn(jwtUtils.getExpirationTime()).build();
        return ResponseEntity.ok(loginResponse);
    }
}
