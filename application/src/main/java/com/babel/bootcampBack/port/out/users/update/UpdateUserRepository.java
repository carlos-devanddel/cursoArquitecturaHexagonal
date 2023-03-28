package com.babel.bootcampBack.port.out.users.update;

import com.babel.bootcampBack.models.User;
import com.babel.bootcampBack.port.in.users.update.models.UpdateUserOutput;

import java.util.Optional;

public interface UpdateUserRepository {

	Optional<User> getUserById(String uid);
	boolean updateContactData(User userToChange);
}
