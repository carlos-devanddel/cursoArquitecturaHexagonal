package com.babel.bootcampBack.services.users.create;

import com.babel.bootcampBack.enums.Role;
import com.babel.bootcampBack.exceptions.InsufficientPrivilegesException;
import com.babel.bootcampBack.models.User;
import com.babel.bootcampBack.port.in.users.create.CreateUserUseCase;
import com.babel.bootcampBack.port.in.users.create.models.CreateUserInput;
import com.babel.bootcampBack.port.in.users.create.models.CreateUserOutput;
import com.babel.bootcampBack.port.out.users.create.CreateUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateUserService implements CreateUserUseCase {
	private final CreateUserRepository userRepository;

	@Override
	public CreateUserOutput createUser(CreateUserInput input) {
		User newUser = input.getNewUserData();
		if(!Role.ADMINISTRATOR.equals(input.getWho().getRole()))
			throw new InsufficientPrivilegesException();

		Long identifier = userRepository.createUser(input.getNewUserData());
		newUser.setUserId(identifier);
		return CreateUserOutput.builder().newUser(newUser).build();
	}
}
