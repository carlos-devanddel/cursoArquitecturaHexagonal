package com.helloworld.examples.persistence.h2.repositories.users.update;

import com.helloworld.examples.models.User;
import com.helloworld.examples.port.out.users.updateUserContactData.UpdateUserContactDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UpdateUserH2Repository implements UpdateUserContactDataRepository {

    private final JdbcTemplate jdbcTemplate;


    @Override
    public void updateUserContactData(User userToChange) {
        String sql = "UPDATE USUARIO SET PHONE = ?, MAIL = ? WHERE ID = ?";
        int rowsUpdated = jdbcTemplate.update(sql, userToChange.getPhoneNumber(), userToChange.getEmail(), userToChange.getUserId());
        if (rowsUpdated != 1) {
            throw new RuntimeException();
        }
    }
}
