package com.babel.bootcampBack.restApi.admin.users.delete.models;

import com.babel.bootcampBack.port.in.users.create.models.CreateUserOutput;

public class CreateUserResponse {
	public static CreateUserResponse fromApplicationModel(CreateUserOutput output) {
		return new CreateUserResponse();
	}
}
