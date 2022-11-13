package com.tripmaker.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurrentAdmin {

	@Id
	private Integer userId;
	private String UserType;
	private LocalDateTime localDateTime;
	@Column(unique = true)
	private String uuid;
}
