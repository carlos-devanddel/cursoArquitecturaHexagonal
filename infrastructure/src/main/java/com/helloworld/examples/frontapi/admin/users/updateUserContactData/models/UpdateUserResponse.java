package com.helloworld.examples.frontapi.admin.users.updateUserContactData.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.helloworld.examples.port.in.users.updateUserContactData.models.UpdateUserContactDataOutput;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
@AllArgsConstructor
public class UpdateUserResponse {
    @JsonProperty("success")
    boolean success;

    public static UpdateUserResponse fromApplicationModel(UpdateUserContactDataOutput output) {
        return UpdateUserResponse.builder().success(output.isSuccess()).build();
    }
}
