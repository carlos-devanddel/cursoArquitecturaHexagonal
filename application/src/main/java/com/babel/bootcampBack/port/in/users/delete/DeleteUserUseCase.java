package com.babel.bootcampBack.port.in.users.delete;

import com.babel.bootcampBack.port.in.users.delete.models.CreateUserInput;
import com.babel.bootcampBack.port.in.users.delete.models.CreateUserOutput;

public interface DeleteUserUseCase {
	CreateUserOutput deleteUser(CreateUserInput input);
}
