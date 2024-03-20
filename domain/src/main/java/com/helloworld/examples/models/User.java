package com.helloworld.examples.models;

import com.helloworld.examples.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class User {

	private Long userId;
	private String name;
	private String surname;
	private String email;
	private String phoneNumber;
	private Role role;

}
