package com.masai.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Report {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer reportId;
	@NotEmpty
	private String reportName;
	@NotEmpty
	private String reportType;
	
//	@OneToMany(cascade = CascadeType.ALL)
//	private Admin admin;
}
