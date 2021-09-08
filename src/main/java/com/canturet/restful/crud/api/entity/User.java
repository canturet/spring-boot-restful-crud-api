package com.canturet.restful.crud.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue()
	private Long id;
	@NotNull
	@Size(min = 2, message = "First name should have atleast 2 characters")
	@Column(name = "first_name")
	private String firstName;
	@NotNull
	@Size(min = 2, message = "Last name should have atleast 2 characters")
	@Column(name = "last_name")
	private String lastName;
	@NotBlank
	@Email(message = "Not a valid email adress")
	@Column(name = "email")
	private String email;

}
