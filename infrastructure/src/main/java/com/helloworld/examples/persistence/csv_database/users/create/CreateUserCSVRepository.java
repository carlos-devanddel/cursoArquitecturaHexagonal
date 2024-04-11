package com.helloworld.examples.persistence.csv_database.users.create;

import com.helloworld.examples.models.User;
import com.helloworld.examples.persistence.csv_database.models.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import static com.helloworld.examples.persistence.csv_database.configuration.UserFilesConfig.directoryPath;

@Repository
@RequiredArgsConstructor
public class CreateUserCSVRepository implements com.helloworld.examples.port.out.users.create.CreateUserRepository {

    public Long getMaxId() {
        try (Stream<Path> paths = Files.walk(directoryPath)) {
            return paths.filter(Files::isRegularFile)
                    .map(Path::getFileName)
                    .map(Path::toString)
                    .map(s -> s.split("\\.")[0])
                    .map(Long::parseLong)
                    .max(Long::compareTo)
                    .orElse(0L);
        } catch (IOException e) {
            return 0L;
        }
    }

    @Override
    public Long createUser(User newUserData) {
        Long id = getMaxId() + 1;
        generateFile(id);
        UserEntity userEntity = UserEntity.builder()
                .id(id)
                .name(newUserData.getName())
                .surname(newUserData.getSurname())
                .phone(newUserData.getPhoneNumber())
                .mail(newUserData.getEmail())
                .build();
        printUserData(userEntity, directoryPath.toString() + "/" + id + ".csv");

        return id;
    }

    private void generateFile(Long id) {
        try {
            Files.createFile(Paths.get(directoryPath.toString() + "/" + id + ".csv"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void printUserData(UserEntity userEntity, String filename) {
        try (FileWriter writer = new FileWriter(filename, true)) {
            writer.append(userEntity.toCsv());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
