package com.babel.bootcampBack.persistence.models;

import lombok.Data;

@Data
public class UserEntity {
	private Long id;
	private String name;
	private String surname;
	private String phone;
	private String mail;



}
