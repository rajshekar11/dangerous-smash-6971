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
	
	@NotEmpty
	@Size(min = 5, max = 7)
	@Pattern(regexp = "^[A-Z][a-z]*")
	private String customerName;
	@NotEmpty
	@Size(min = 5, max = 15)
	@Pattern(regexp = "^[A-Z][a-z]*")
	private String customerPassword;
	@NotEmpty
	@Size(min = 4, max = 15)
	@Pattern(regexp = "^[A-Z][a-z]*")
	private String address;
	
	@Column(unique = true,columnDefinition = "integer default 0")
	private String mobileNo;
	
	@Email(message = "Please Enter Correct Email Id.")
	private String email;

	@ManyToOne(cascade = CascadeType.ALL)
	private User user;

}
