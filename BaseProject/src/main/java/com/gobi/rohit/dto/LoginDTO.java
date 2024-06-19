package com.gobi.rohit.dto;

import java.io.Serializable;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class LoginDTO implements Serializable {
	
	private static final long serialVersionUID = 7510389578264602697L;
	
	@NotBlank(message = "The user name is Required")
	private String userName;
	
	@NotBlank(message = "The password is Required")
	private String password;
	
	private String authToken;
	private long expiresIn;

}
