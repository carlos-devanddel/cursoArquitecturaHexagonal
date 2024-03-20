package com.helloworld.examples.port.in.users.delete.models;

import com.helloworld.examples.models.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@AllArgsConstructor
@Getter
public class DeleteUserInput {
    User who;
    Long userToDelete;
}
