package com.helloworld.examples.restApi.admin.users.create.models;

import com.helloworld.examples.port.in.users.create.models.CreateUserOutput;

public class CreateUserResponse {
	public static CreateUserResponse fromApplicationModel(CreateUserOutput output) {
		return new CreateUserResponse();
	}
}
