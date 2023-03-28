package com.babel.bootcampBack.port.in.users.create.models;

import com.babel.bootcampBack.models.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class CreateUserInput {

	User who;
	User newUserData;
}
