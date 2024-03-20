package com.helloworld.examples.frontapi.admin.users.delete.models;

import com.helloworld.examples.port.in.users.create.models.CreateUserInput;
import com.helloworld.examples.port.in.users.delete.models.DeleteUserInput;

public class DeleteUserRequest {
	public DeleteUserInput toApplicationModel() {
		return DeleteUserInput.builder().build();
	}
}
