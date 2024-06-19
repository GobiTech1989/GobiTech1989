package com.gobi.rohit.service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.gobi.rohit.dto.LoginDTO;
import com.gobi.rohit.dto.UserDTO;
import com.gobi.rohit.entity.Users;
import com.gobi.rohit.repository.UserRepository;
import com.gobi.rohit.utils.ObjectMapperUtils;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor_ = @Autowired)
public class AuthService {

	private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    
    public UserDTO signup(UserDTO userDTO) {
    	
    	if (Objects.nonNull(userDTO)) {
    		String pwd = userDTO.getUserFullName().toUpperCase() + userDTO.getPassword();
    		String encodePwd = passwordEncoder.encode(pwd);
    		userDTO.setPassword(encodePwd);
    	}
    	Users users = ObjectMapperUtils.map(userDTO, Users.class);
    	users = userRepository.save(users);
    	users.setPassword(null);
    	userDTO = ObjectMapperUtils.map(users, UserDTO.class);
        return userDTO;
    }

    public Users authenticate(LoginDTO loginDTO) {
    	String pwd = loginDTO.getUserName().toUpperCase() + loginDTO.getPassword();
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDTO.getUserName(), pwd));
        return userRepository.findByUserName(loginDTO.getUserName()).orElseThrow(() -> new UsernameNotFoundException("User Name not found "+ loginDTO.getUserName()));
    }
}
