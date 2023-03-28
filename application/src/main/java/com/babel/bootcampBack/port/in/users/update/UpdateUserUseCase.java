package com.babel.bootcampBack.port.in.users.update;

import com.babel.bootcampBack.port.in.users.update.models.UpdateUserInput;
import com.babel.bootcampBack.port.in.users.update.models.UpdateUserOutput;

public interface UpdateUserUseCase {

	UpdateUserOutput updateUserContactData(UpdateUserInput input);
}
