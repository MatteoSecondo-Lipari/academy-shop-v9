package com.lipari.academy.payload;

import java.util.Set;

import com.lipari.academy.model.CustomerDTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class SignupRequest {

	@NotBlank
	@Size(min = 4, max = 20)
	private String username;

	@NotBlank
	@Size(max = 50)
	@Email
	private String email;

	private Set<String> role;

	@NotBlank
	@Size(min = 8, max = 16)
	private String password;
	
	private CustomerDTO customer;
}
