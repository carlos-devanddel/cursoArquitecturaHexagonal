package com.helloworld.examples.frontapi.admin.users.create.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.helloworld.examples.port.in.users.create.models.CreateUserOutput;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
@AllArgsConstructor
public class CreateUserResponse {
    @JsonProperty("userId")
    Long userId;

    public static CreateUserResponse fromApplicationModel(CreateUserOutput output) {
        return CreateUserResponse.builder().userId(output.getNewUser().getUserId()).build();
    }
}
