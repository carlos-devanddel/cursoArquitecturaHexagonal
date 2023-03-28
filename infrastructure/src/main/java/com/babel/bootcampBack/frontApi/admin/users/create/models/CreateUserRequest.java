package com.babel.bootcampBack.frontApi.admin.users.create.models;

import com.babel.bootcampBack.port.in.users.create.models.CreateUserInput;

public class CreateUserRequest {
	public CreateUserInput toApplicationModel() {
		return CreateUserInput.builder().build();
	}
}
