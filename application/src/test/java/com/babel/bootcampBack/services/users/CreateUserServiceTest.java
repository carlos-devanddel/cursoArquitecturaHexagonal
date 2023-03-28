package com.babel.bootcampBack.services.users;

import com.babel.bootcampBack.enums.Role;
import com.babel.bootcampBack.exceptions.InsufficientPrivilegesException;
import com.babel.bootcampBack.models.User;
import com.babel.bootcampBack.port.in.users.create.models.CreateUserInput;
import com.babel.bootcampBack.port.out.users.create.CreateUserRepository;
import com.babel.bootcampBack.services.users.create.CreateUserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class CreateUserServiceTest {
	CreateUserService sut;
	private CreateUserRepository userRepositoryMock;
	private CreateUserInput input;

	@BeforeEach
	void setUp() {
		userRepositoryMock = Mockito.mock(CreateUserRepository.class);
		sut = new CreateUserService(userRepositoryMock);
	}

	@Test
	void createUser_should_throwInsuficientPriveleges_when_userCreatorIsNotAdmin() {
		input = CreateUserInput.builder().who(User.builder().role(Role.NORMAL).build()).build();

		Assertions.assertThrows(InsufficientPrivilegesException.class, () -> sut.createUser(input));
	}
}