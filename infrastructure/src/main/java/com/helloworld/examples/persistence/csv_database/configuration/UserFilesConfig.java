package com.helloworld.examples.persistence.csv_database.configuration;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Configuration
public class UserFilesConfig {
    public static Path directoryPath;

    @PostConstruct
    static void init() {
        try {
            directoryPath = Files.createTempDirectory("");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
