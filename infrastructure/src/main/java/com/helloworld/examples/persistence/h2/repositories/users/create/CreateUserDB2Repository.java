package com.helloworld.examples.persistence.h2.repositories.users.create;

import com.helloworld.examples.models.User;
import com.helloworld.examples.port.out.users.create.CreateUserRepository;
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
        String insert = "INSERT INTO USUARIO(ID, NOMBRE, APELLIDOS, TELEFONO, EMAIL) VALUES (?,?,?,?,?)";
        jdbcTemplate.update(insert, newId, newUserData.getName(), newUserData.getSurname(), newUserData.getPhoneNumber(), newUserData.getEmail());
        return newId;
    }
}
