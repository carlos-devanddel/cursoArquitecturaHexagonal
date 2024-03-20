package com.helloworld.examples.port.in.users.delete;

import com.helloworld.examples.exceptions.InsufficientPrivilegesException;
import com.helloworld.examples.port.in.users.delete.models.DeleteUserInput;
import com.helloworld.examples.port.in.users.delete.models.DeleteUserOutput;

public interface DeleteUserUseCase {
    DeleteUserOutput deleteUser(DeleteUserInput input) throws InsufficientPrivilegesException;
}
