package com.tripmaker.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Yedhu Nanthan.S
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Report {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer reportId;
	
	@NotNull(message = "reportName is mandatory")
	@NotBlank(message = "reportName is mandatory")
	@NotEmpty(message = "reportName is mandatory")
	private String reportName;
	
	@NotNull(message = "reportType is mandatory")
	@NotBlank(message = "reportType is mandatory")
	@NotEmpty(message = "reportType is mandatory")
	private String reportType;
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	private Admin admin;
}
