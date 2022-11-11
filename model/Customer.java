package com.tripmaker.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer customerId;
	
	@NotNull(message = "Customer name is mandatory")
	@NotEmpty(message = "Customer name is mandatory")
	@Size(min = 5, max = 15, message = "User Type should be of 5-7 charecters")
	@Pattern(regexp = "^[A-Z][a-z]*", message = "Only alphabets are allowed")
	private String customerName;
	
	@NotNull(message = "Customer pasword is mandatory")
	@NotEmpty(message = "Customer pasword is mandatory")
	@Size(min = 5, max = 15, message = "Customer pasword should be of 5-15 charecters")
	@Pattern(regexp = "^[A-Z][a-z]*")
	private String customerPassword;
	
	@NotNull(message = "Customer address is mandatory")
	@NotEmpty(message = "Customer address is mandatory")
	@Size(min = 4, max = 15, message = "Customer address should be of 5-15 charecters")
	@Pattern(regexp = "^[A-Z][a-z]*", message = "Only alphabets are allowed")
	private String address;
	
	@NotNull(message = "Customer mobile no. is mandatory")
	@NotEmpty(message = "Customer mobile no. is mandatory")
	@Column(unique = true,columnDefinition = "integer default 0")
	private String mobileNo;

	@NotNull(message = "Customer email is mandatory")
	@NotEmpty(message = "Customer email is mandatory")
	@Email(message = "Please Enter Correct Email Id.")
	private String email;

	@ManyToOne(cascade = CascadeType.ALL)
	private User user;

}
