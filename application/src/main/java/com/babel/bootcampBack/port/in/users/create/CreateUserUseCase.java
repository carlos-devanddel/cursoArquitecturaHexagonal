package com.babel.bootcampBack.port.in.users.create;

import com.babel.bootcampBack.port.in.users.create.models.CreateUserInput;
import com.babel.bootcampBack.port.in.users.create.models.CreateUserOutput;

public interface CreateUserUseCase {
	CreateUserOutput createUser(CreateUserInput input);
}
