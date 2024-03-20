package com.helloworld.examples.port.out.users.create;

import com.helloworld.examples.models.User;

public interface CreateUserRepository {
	Long createUser(User newUserData);
}
