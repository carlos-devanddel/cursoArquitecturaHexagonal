package com.babel.bootcampBack.persistence.repositories.users.delete;

import com.babel.bootcampBack.models.User;
import com.babel.bootcampBack.port.out.users.delete.DeleteUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class DeleteUserDB2Repository implements DeleteUserRepository {

	private final JdbcTemplate jdbcTemplate;

	@Override
	public Long deleteUser(User newUserData) {
		Long newId = jdbcTemplate.queryForObject("SELECT MAX(ID)+1 FROM USUARIO", Long.class);
		jdbcTemplate.update(
				String.format("INSERT INTO USUARIO(ID, NOMBRE, APELLIDOS, TELEFONO, EMAIL) VALUES (%d, %s,%s,%s,%s)", newId, newUserData.getName(),
							  newUserData.getSurname(), newUserData.getPhoneNumber(), newUserData.getEmail()));
		return newId;
	}
}
