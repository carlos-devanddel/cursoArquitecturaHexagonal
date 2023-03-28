package com.babel.bootcampBack.persistence.repositories.users.create;

import com.babel.bootcampBack.models.User;
import com.babel.bootcampBack.port.out.users.create.CreateUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CreateUserDB2Repository implements CreateUserRepository {

	private final JdbcTemplate jdbcTemplate;

	@Override
	public Long createUser(User newUserData) {
		Long newId = jdbcTemplate.queryForObject("SELECT MAX(ID)+1 FROM USUARIO", Long.class);
		jdbcTemplate.update(
				String.format("INSERT INTO USUARIO(ID, NOMBRE, APELLIDOS, TELEFONO, EMAIL) VALUES (%d, %s,%s,%s,%s)", newId, newUserData.getName(),
							  newUserData.getSurname(), newUserData.getPhoneNumber(), newUserData.getEmail()));
		return newId;
	}
}
