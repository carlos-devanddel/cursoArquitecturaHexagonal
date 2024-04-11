package com.helloworld.examples.persistence.csv_database.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class UserEntity {
    private Long id;
    private String name;
    private String surname;
    private String phone;
    private String mail;

    public String toCsv() {
        return id + "," + name + "," + surname + "," + phone + "," + mail;
    }
}
