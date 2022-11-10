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
@AllArgsConstructor
@NoArgsConstructor
public class Feedback {

	@Id
	private Integer feedbackId;
	
	private String feedback;
	
	@Size(min = 0,max = 5,message = "value in between 0 - 5")
	private Integer rating;
	
	@NotNull(message = "submitDate is mandatory")
	private LocalDate submitDate;
}
