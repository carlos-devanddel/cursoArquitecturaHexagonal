package com.helloworld.examples.persistence.h2.transformers;

import com.helloworld.examples.models.User;
import com.helloworld.examples.persistence.h2.models.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserEntityTransformer {

    public User toDomainModel(UserEntity entity) {
        return User.builder()
                .userId(entity.getId())
                .email(entity.getMail())
                .name(entity.getName())
                .phoneNumber(entity.getPhone())
                .build();


    }

}
