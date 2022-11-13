package com.tripmaker.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminDTO {

	@NotEmpty(message = "Name is mandatory")
	@NotNull(message = "Name is mandatory")
	@NotBlank(message = "Name is mandatory")
	@Size(min = 3,message = "Size should be greater than 3")
	private String adminName;
	
	@Email(message = "enter a valid email")
	@NotNull(message = "Email is mandatory")
	private String email;

	@NotNull(message = "Password is mandatory")
	@Size(min = 8,max = 10,message = "minimum 8 characters and maximum 10 characters")
	private String password;

	@Size(min = 10,max = 10,message = "please enter valid 10 digit mobile number")
	private String mobial;
}
