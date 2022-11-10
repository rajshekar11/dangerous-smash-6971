package com.masai.been;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Min;
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
public class Bus {

	@Id
	private Integer busId;
	
	@NotNull(message = "busType is mandatory")
	@NotBlank(message = "busType is mandatory")
	@NotEmpty(message = "busType is mandatory")
	private String busType;
	
	@NotNull(message = "busNumber is mandatory")
	@NotBlank(message = "busNumber is mandatory")
	@NotEmpty(message = "busNumber is mandatory")
	private String busNumber;
	
	@Min(value = 25, message = "minimum number of seats is 25")
	private Integer capacity;
}
