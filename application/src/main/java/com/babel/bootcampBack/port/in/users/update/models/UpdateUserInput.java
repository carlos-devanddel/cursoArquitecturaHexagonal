package com.babel.bootcampBack.port.in.users.update.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class UpdateUserInput {
	private String uidUserRequestor;
	private String uidUserToChange;
	private String newPhone;
	private String newEmail;

}
