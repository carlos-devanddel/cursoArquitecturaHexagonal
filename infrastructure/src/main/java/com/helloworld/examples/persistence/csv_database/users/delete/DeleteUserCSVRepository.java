package com.helloworld.examples.persistence.csv_database.users.delete;

import com.helloworld.examples.port.out.users.delete.DeleteUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static com.helloworld.examples.persistence.csv_database.configuration.UserFilesConfig.directoryPath;

@Repository
@RequiredArgsConstructor
public class DeleteUserCSVRepository implements DeleteUserRepository {


    @Override
    public void deleteUser(Long userId) {
        if (!Files.exists(Paths.get(directoryPath + "/" + userId + ".csv"))) {
            throw new RuntimeException("User not found");
        }
        try {
            Files.delete(Paths.get(directoryPath + "/" + userId + ".csv"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
