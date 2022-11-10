package com.masai.been;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Package {

	@Id
	private Integer packageId;
	
	@NotEmpty(message = "packageName is mandatory")
	@NotNull(message = "packageName is mandatory")
	@NotBlank(message = "packageName is mandatory")
	private String packageName;
	
	@NotEmpty(message = "packageDescription is mandatory")
	@NotNull(message = "packageDescription is mandatory")
	@NotBlank(message = "packageDescription is mandatory")
	private String packageDescription;
	
	@NotEmpty(message = "packageType is mandatory")
	@NotNull(message = "packageType is mandatory")
	@NotBlank(message = "packageType is mandatory")
	private String packageType;
	
	@NotNull(message = "packageCost is mandatory")
	private Double packageCost;
//	private PaymentDetails payment;
}
