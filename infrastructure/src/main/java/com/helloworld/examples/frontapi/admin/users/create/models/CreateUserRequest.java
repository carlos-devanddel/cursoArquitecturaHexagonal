package com.helloworld.examples.frontapi.admin.users.create.models;

import com.helloworld.examples.port.in.users.create.models.CreateUserInput;

public class CreateUserRequest {
	public CreateUserInput toApplicationModel() {
		return CreateUserInput.builder().build();
	}
}
