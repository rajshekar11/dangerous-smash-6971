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
public class Report {

	@Id
	private Integer reportId;
	
	@NotNull(message = "reportName is mandatory")
	@NotBlank(message = "reportName is mandatory")
	@NotEmpty(message = "reportName is mandatory")
	private String reportName;
	
	@NotNull(message = "reportType is mandatory")
	@NotBlank(message = "reportType is mandatory")
	@NotEmpty(message = "reportType is mandatory")
	private String reportType;
}
