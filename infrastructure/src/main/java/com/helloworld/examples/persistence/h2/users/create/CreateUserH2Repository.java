package com.helloworld.examples.persistence.h2.users.create;

import com.helloworld.examples.models.User;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CreateUserH2Repository implements com.helloworld.examples.port.out.users.create.CreateUserRepository {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public Long createUser(User newUserData) {
        Long newId = Optional.ofNullable(jdbcTemplate.queryForObject("SELECT MAX(ID)+1 FROM USUARIO", Long.class))
                .orElse(1L);
        String insert = "INSERT INTO USUARIO(ID, NAME, SURNAME, PHONE, MAIL) VALUES (?,?,?,?,?)";
        jdbcTemplate.update(insert, newId, newUserData.getName(), newUserData.getSurname(), newUserData.getPhoneNumber(), newUserData.getEmail());
        return newId;
    }
}
