package com.helloworld.examples.port.in.users.create;

import com.helloworld.examples.exceptions.InsufficientPrivilegesException;
import com.helloworld.examples.port.in.users.create.models.CreateUserInput;
import com.helloworld.examples.port.in.users.create.models.CreateUserOutput;

public interface CreateUserUseCase {
	CreateUserOutput createUser(CreateUserInput input) throws InsufficientPrivilegesException;
}
