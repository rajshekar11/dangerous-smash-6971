package com.tripmaker.model;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Yedhu Nanthan.S
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer customerId;
	
	@NotEmpty(message = "Name is mandatory")
	@NotNull(message = "Name is mandatory")
	@NotBlank(message = "Name is mandatory")
	@Size(min = 3,message = "Size should be greater than 3")
	@Pattern(regexp="^[A-Z][a-z]*",message = "only characters are allowed")
	private String customerName;
	
	@NotNull(message = "Password is mandatory")
	@Size(min = 8,max = 10,message = "minimum 8 characters and maximum 10 characters")
	private String customerPassword;
	
	@NotNull(message = "address is mandatory")
	@NotBlank(message = "address is mandatory")
	private String address;
	
	@Size(min = 10,max = 10,message = "please enter valid 10 digit mobile number")
	private String mobileNo;
	
	@Email(message = "enter a valid email")
	@NotNull(message = "Email is mandatory")
	private String email;
	
//	@ManyToOne(cascade = CascadeType.ALL)
//	private Set<FeedBack> reports = new HashSet<>();
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "customersList")
	private User user;

}
