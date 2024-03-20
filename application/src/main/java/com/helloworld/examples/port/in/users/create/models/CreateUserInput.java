package com.helloworld.examples.port.in.users.create.models;

import com.helloworld.examples.models.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class CreateUserInput {

	User who;
	User newUserData;

	public  void validate() {
		if(!newUserData.getEmail().contains("@"))
			throw new RuntimeException("Invalid email");
	}
}
