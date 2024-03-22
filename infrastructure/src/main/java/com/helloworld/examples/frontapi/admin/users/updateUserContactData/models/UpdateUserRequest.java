package com.helloworld.examples.frontapi.admin.users.updateUserContactData.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.helloworld.examples.enums.Role;
import com.helloworld.examples.models.User;
import com.helloworld.examples.port.in.users.updateUserContactData.models.UpdateUserContactDataInput;

public class UpdateUserRequest {
    @JsonProperty("who")
    private String who;
    @JsonProperty("whoId")
    private Long whoId;

    @JsonProperty("userToUpdateId")
    private Long userToUpdateId;

    @JsonProperty("newPhone")
    private String newPhone;
    @JsonProperty("newMail")
    private String newMail;

    public UpdateUserContactDataInput toApplicationModel() {
        return UpdateUserContactDataInput.builder()
                .userToChange(User.builder().userId(userToUpdateId).phoneNumber(newPhone).email(newMail).build())
                .who(User.builder().role(Role.valueOf(who)).userId(whoId).name(who).build())
                .build();
    }
}
