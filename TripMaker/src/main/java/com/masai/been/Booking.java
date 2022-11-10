package com.masai.been;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Booking {

	@Id
	private Integer bookingId;
	
	@NotNull(message = "bookingType is mandatory")
	private String bookingType;
	
	@Size(min = 1,max = 100,message = "use maximum 100 characters")
	private String description;
	
	@NotNull(message = "bookingTitle is mandatory")
	private String bookingTitle;
	
	@NotNull(message = "bookingDate is mandatory")
	private LocalDate bookingDate;
}
