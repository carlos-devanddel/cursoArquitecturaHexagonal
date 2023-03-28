package com.babel.bootcampBack.services.users.delete;

import com.babel.bootcampBack.port.in.users.delete.DeleteUserUseCase;
import com.babel.bootcampBack.port.in.users.delete.models.CreateUserInput;
import com.babel.bootcampBack.port.in.users.delete.models.CreateUserOutput;
import com.babel.bootcampBack.port.out.users.create.CreateUserRepository;
import com.babel.bootcampBack.port.out.users.delete.DeleteUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteUserService implements DeleteUserUseCase {
	private final DeleteUserRepository userRepository;

	@Override
	public CreateUserOutput deleteUser(CreateUserInput input) {
		return null;
	}
}
