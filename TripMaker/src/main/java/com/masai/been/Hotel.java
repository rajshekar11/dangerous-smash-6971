package com.masai.been;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Hotel {

	@Id
	private Integer hotelId;
	
	@NotEmpty(message = "hotelName is mandatory")
	@NotNull(message = "hotelName is mandatory")
	@NotBlank(message = "hotelName is mandatory")
	private String hotelName;
	
	@NotNull(message = "hotelType is mandatory")
	private String hotelType;
	
	@Size(min = 1,max = 100,message = "use maximum 100 characters")
	private String hotelDescription;
	
	@NotNull(message = "address is mandatory")
	private String address;
	
	@Min(value = 500,message = "minimum price is 500")
	private Double rent;
	
	@NotEmpty(message = "status is mandatory")
	@NotNull(message = "status is mandatory")
	@NotBlank(message = "status is mandatory")
	private String status;
}
