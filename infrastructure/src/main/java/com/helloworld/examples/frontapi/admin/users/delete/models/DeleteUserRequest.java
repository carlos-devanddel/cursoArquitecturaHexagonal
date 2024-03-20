package com.helloworld.examples.frontapi.admin.users.delete.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.helloworld.examples.enums.Role;
import com.helloworld.examples.models.User;
import com.helloworld.examples.port.in.users.delete.models.DeleteUserInput;

public class DeleteUserRequest {
    @JsonProperty("who")
    private String who;
    @JsonProperty("whoId")
    private Long whoId;

    @JsonProperty("userToDeleteId")
    private Long userToDeleteId;


    public DeleteUserInput toApplicationModel() {
        return DeleteUserInput.builder()
                .userToDelete(userToDeleteId)
                .who(User.builder().role(Role.valueOf(who)).userId(whoId).name(who).build())
                .build();
    }
}
