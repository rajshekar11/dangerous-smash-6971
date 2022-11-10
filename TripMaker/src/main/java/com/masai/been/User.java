package com.masai.been;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

	@Id
	private Integer userId;
	@NotNull(message = "userType is mandatory")
	private String userType;
	@NotNull(message = "password is mandatory")
	private String password;
}
