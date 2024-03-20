package com.helloworld.examples.restApi.admin.users.create.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.helloworld.examples.models.User;
import com.helloworld.examples.port.in.users.create.models.CreateUserInput;

public class CreateUserRequest {

    @JsonProperty("name")
    private String name;
    @JsonProperty("surname")
    private String surname;
    @JsonProperty("phone")
    private String phone;
    @JsonProperty("email")
    private String email;

    public CreateUserInput toApplicationModel() {
        var newUser = User.builder().name(name).surname(surname).phoneNumber(phone).email(email).build();
        return CreateUserInput.builder().newUserData(newUser).build();
    }
}
