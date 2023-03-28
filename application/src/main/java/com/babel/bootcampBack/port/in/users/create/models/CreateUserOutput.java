package com.babel.bootcampBack.port.in.users.create.models;

import com.babel.bootcampBack.models.User;
import lombok.AllArgsConstructor;
import lombok.Builder;

@AllArgsConstructor
@Builder
public class CreateUserOutput {
	User newUser;
}
