package com.helloworld.examples.port.in.users.create.models;

import com.helloworld.examples.models.User;
import lombok.AllArgsConstructor;
import lombok.Builder;

@AllArgsConstructor
@Builder
public class CreateUserOutput {
	User newUser;
}
