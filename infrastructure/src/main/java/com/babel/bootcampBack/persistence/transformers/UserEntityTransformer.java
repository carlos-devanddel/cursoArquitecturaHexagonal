package com.babel.bootcampBack.persistence.transformers;

import com.babel.bootcampBack.models.User;
import com.babel.bootcampBack.persistence.models.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserEntityTransformer {

	public User toDomainModel(UserEntity entity){
		return User.builder()
				.userId(entity.getId())
				.email(entity.getMail())
				.name(entity.getName())
				.phoneNumber(entity.getPhone())
				   .build();


	}

}
