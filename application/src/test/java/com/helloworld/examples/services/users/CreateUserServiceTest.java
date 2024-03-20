package com.helloworld.examples.services.users;

import com.helloworld.examples.enums.Role;
import com.helloworld.examples.exceptions.InsufficientPrivilegesException;
import com.helloworld.examples.exceptions.InvalidParameterException;
import com.helloworld.examples.models.User;
import com.helloworld.examples.port.in.users.create.models.CreateUserInput;
import com.helloworld.examples.port.out.users.create.CreateUserRepository;
import com.helloworld.examples.services.users.create.CreateUserService;
import lombok.SneakyThrows;
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
        User newUserData = User.builder().name("carlos").email("carlos@devanddel.com").build();

        input = CreateUserInput.builder()
                .who(User.builder().role(Role.ADMINISTRATOR).build())
                .newUserData(newUserData)
                .build();

        userRepositoryMock = Mockito.mock(CreateUserRepository.class);
        sut = new CreateUserService(userRepositoryMock);
    }

    @Test
    void createUser_should_throwInsuficientPriveleges_when_userCreatorIsNotAdmin() {
        input.setWho(User.builder().role(Role.NORMAL).build());

        Assertions.assertThrows(InsufficientPrivilegesException.class, () -> sut.createUser(input));
    }

    @Test
    void createUser_should_throwInvalidParameter_when_userHasInvalidEmail() {
        input.getNewUserData().setEmail("carlosdevanddel.com");

        Assertions.assertThrows(InvalidParameterException.class, () -> sut.createUser(input));
    }

    @Test
    @SneakyThrows
    void createUser_should_insert_when_ableTo() {
        sut.createUser(input);

        Mockito.verify(userRepositoryMock).createUser(input.getNewUserData());
    }
}