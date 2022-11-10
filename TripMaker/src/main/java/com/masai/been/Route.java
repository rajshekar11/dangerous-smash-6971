package com.masai.been;

import java.time.LocalDate;
import java.time.LocalDateTime;

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
public class Route {

	@Id
	private String routeId;
	
	@NotNull(message = "routeFrom is mandatory")
	@NotBlank(message = "routeFrom is mandatory")
	@NotEmpty(message = "routeFrom is mandatory")
	private String routeFrom;
	
	@NotNull(message = "routeTo is mandatory")
	@NotBlank(message = "routeTo is mandatory")
	@NotEmpty(message = "routeTo is mandatory")
	private String routeTo;
	
	@NotNull(message = "departureTime is mandatory")
	@NotBlank(message = "departureTime is mandatory")
	@NotEmpty(message = "departureTime is mandatory")
	private LocalDateTime departureTime;
	
	@NotNull(message = "arrivalTime is mandatory")
	private LocalDateTime arrivalTime;
	
	@NotNull(message = "date of journey is mandatory")
	@NotBlank(message = "date of journey is mandatory")
	@NotEmpty(message = "date of journey is mandatory")
	private LocalDate doj;
	
	@NotNull(message = "pickupPoint is mandatory")
	@NotBlank(message = "pickupPoint is mandatory")
	@NotEmpty(message = "pickupPoint is mandatory")
	private String pickupPoint;
	
	@Min(value = 20,message = "minimum price is 20 ")
	private Double fare;
}
