package com.babel.bootcampBack.port.out.users.delete;

import com.babel.bootcampBack.models.User;

public interface DeleteUserRepository {
	Long deleteUser(User newUserData);
}
