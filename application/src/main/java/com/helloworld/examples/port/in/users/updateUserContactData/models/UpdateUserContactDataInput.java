package com.helloworld.examples.port.in.users.updateUserContactData.models;

import com.helloworld.examples.models.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class UpdateUserContactDataInput {

    private User who;
    private User userToChange;

}
