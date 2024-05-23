package com.helloworld.examples.restApi.admin.users.delete.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.helloworld.examples.port.in.users.delete.models.DeleteUserOutput;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
@AllArgsConstructor
public class DeleteUserResponse {
    @JsonProperty("success")
    boolean success;

    public static DeleteUserResponse fromApplicationModel(DeleteUserOutput output) {
        return DeleteUserResponse.builder().success(output.isSuccess()).build();
    }
}
