package com.helloworld.examples.port.in.users.delete.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class DeleteUserOutput {
    private boolean success;
}
