package com.helloworld.examples.frontapi.admin.users.delete.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.helloworld.examples.port.in.users.delete.models.DeleteUserOutput;


public class DeleteUserResponse {
	@JsonProperty("success")
	boolean success;
	public static DeleteUserResponse fromApplicationModel(DeleteUserOutput output) {
		return new DeleteUserResponse();
	}
}
