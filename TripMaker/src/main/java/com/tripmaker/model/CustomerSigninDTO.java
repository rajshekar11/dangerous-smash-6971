package com.tripmaker.model;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class CustomerSigninDTO {
	@NotNull(message = "Name cannot be null")
	private String customerName;
	@Email(message="Enter your Email properly")
	@NotNull(message = "Email is mandatory")
	private String email;
	private String address;
	@Column(unique = true)
	@Size(max = 10,min = 10)
	@NotNull(message = "Mobile is mandatory")
	private String mobile;
	@NotNull(message = "Password is mandatory")
	private String password;

}
