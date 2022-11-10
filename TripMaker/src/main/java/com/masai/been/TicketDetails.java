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
public class TicketDetails {

	@Id
	private String ticketId;
	
	@NotEmpty(message = "status is mandatory")
	@NotNull(message = "status is mandatory")
	@NotBlank(message = "status is mandatory")
	private String status;
}
