package com.helloworld.examples.port.in.users.delete.models;

import com.helloworld.examples.models.User;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
@AllArgsConstructor
public class DeleteUserInput {

	User who;
	Long userToDelete;
}
