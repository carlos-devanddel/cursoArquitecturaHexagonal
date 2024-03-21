package com.helloworld.examples.services.users.delete;

import com.helloworld.examples.enums.Role;
import com.helloworld.examples.exceptions.InsufficientPrivilegesException;
import com.helloworld.examples.port.in.users.delete.DeleteUserUseCase;
import com.helloworld.examples.port.in.users.delete.models.DeleteUserInput;
import com.helloworld.examples.port.in.users.delete.models.DeleteUserOutput;
import com.helloworld.examples.port.out.users.delete.DeleteUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteUserService implements DeleteUserUseCase {
    private final DeleteUserRepository userRepository;

    @Override
    public DeleteUserOutput deleteUser(DeleteUserInput input) throws InsufficientPrivilegesException {
        if (!Role.ADMINISTRATOR.equals(input.getWho().getRole())) throw new InsufficientPrivilegesException();

        try {
            userRepository.deleteUser(input.getUserToDelete());
        } catch (Exception e) {
            return DeleteUserOutput.builder().success(false).build();
        }
        return DeleteUserOutput.builder().success(true).build();
    }
}
