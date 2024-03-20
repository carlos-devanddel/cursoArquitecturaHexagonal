package com.helloworld.examples.services.users.create;

import com.helloworld.examples.enums.Role;
import com.helloworld.examples.exceptions.InsufficientPrivilegesException;
import com.helloworld.examples.models.User;
import com.helloworld.examples.port.in.users.create.CreateUserUseCase;
import com.helloworld.examples.port.in.users.create.models.CreateUserInput;
import com.helloworld.examples.port.in.users.create.models.CreateUserOutput;
import com.helloworld.examples.port.out.users.create.CreateUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateUserService implements CreateUserUseCase {
    private final CreateUserRepository userRepository;

    @Override
    public CreateUserOutput createUser(CreateUserInput input) throws Exception {
        input.validate();
        User newUser = input.getNewUserData();
        if (!Role.ADMINISTRATOR.equals(input.getWho().getRole())) throw new InsufficientPrivilegesException();

        Long identifier = userRepository.createUser(input.getNewUserData());
        newUser.setUserId(identifier);
        return CreateUserOutput.builder().newUser(newUser).build();
    }


}
