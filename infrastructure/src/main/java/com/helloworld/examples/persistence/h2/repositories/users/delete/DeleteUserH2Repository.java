package com.helloworld.examples.persistence.h2.repositories.users.delete;

import com.helloworld.examples.port.out.users.delete.DeleteUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class DeleteUserH2Repository implements DeleteUserRepository {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public void deleteUser(Long userId) {
        int rowsUpdated = jdbcTemplate.update("DELETE FROM USUARIO WHERE ID = ? ", userId);
        if (rowsUpdated < 1) {
            throw new RuntimeException("User not found");
        }
    }
}
