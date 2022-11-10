package com.masai.been;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Travels {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int travelId;
	
	@NotEmpty(message = "travelName is mandatory")
	@NotNull(message = "travelName is mandatory")
	@NotBlank(message = "travelName is mandatory")
	@Size(min = 3,message = "Size should be greater than 3")
	@Pattern(regexp="^[A-Z][a-z]*",message = "only characters are allowed")
	private String travelName;
	
	@NotEmpty(message = "agentName is mandatory")
	@NotNull(message = "agentName is mandatory")
	@NotBlank(message = "agentName is mandatory")
	@Size(min = 3,message = "Size should be greater than 3")
	@Pattern(regexp="^[A-Z][a-z]*",message = "only characters are allowed")	
	private String agentName;
	
	@NotEmpty(message = "address is mandatory")
	@NotNull(message = "address is mandatory")
	@NotBlank(message = "address is mandatory")
	@Size(min = 5,message = "Size should be greater than 5")
	@Pattern(regexp="^[A-Z][a-z]*",message = "only characters are allowed")
	private String address;
	
	@NotNull(message = "contact is mandatory")
	@Size(min = 10,max = 10,message = "please enter valid 10 digit mobile number")
	private String contact;
}
