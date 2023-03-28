package com.babel.bootcampBack.port.out.users.create;

import com.babel.bootcampBack.models.User;

public interface CreateUserRepository {
	Long createUser(User newUserData);
}
