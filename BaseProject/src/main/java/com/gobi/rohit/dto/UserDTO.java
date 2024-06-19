package com.gobi.rohit.dto;

import java.io.Serializable;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern.Flag;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO implements Serializable {

	private static final long serialVersionUID = 5548547806833657028L;
	
	private Integer id;
	
	@NotBlank(message = "The First Name is Required")
    private String firstName;
	
	@NotBlank(message = "The Last Name is Required")
    private String lastName;
	
    @NotBlank(message = "The User Name is Required")
    private String userFullName;
    
    @Email(message = "The email address is invalid.", flags = { Flag.CASE_INSENSITIVE })
    @NotBlank(message = "Email is Required")
    private String email;
    
    @NotBlank(message = "The Phone Number is Required")
    private String phoneNumber;
    
    @NotBlank(message = "The Password is Required")
    private String password;
    
    @NotEmpty(message = "The status is required.")
    private String status;
    
    @NotEmpty(message = "The roles is required.")
    private String roles;

}
