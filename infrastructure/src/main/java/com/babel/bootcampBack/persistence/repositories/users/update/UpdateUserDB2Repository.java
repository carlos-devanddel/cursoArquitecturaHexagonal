package com.babel.bootcampBack.persistence.repositories.users.update;

import com.babel.bootcampBack.models.User;
import com.babel.bootcampBack.persistence.mappers.cruds.UsuarioMapper;
import com.babel.bootcampBack.persistence.mappers.usecase.UpdateUserMapper;
import com.babel.bootcampBack.persistence.models.UserEntity;
import com.babel.bootcampBack.persistence.transformers.UserEntityTransformer;
import com.babel.bootcampBack.port.out.users.update.UpdateUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UpdateUserDB2Repository implements UpdateUserRepository {

	private final UsuarioMapper usuarioMapper;
	private final UpdateUserMapper updateUserMapper;

	private final UserEntityTransformer userEntityTransformer;

	@Override
	public Optional<User> getUserById(String uid) {
		UserEntity userEntity = usuarioMapper.getUserById(uid);
		if(userEntity == null){
			return Optional.empty();
		}
		return Optional.of(userEntityTransformer.toDomainModel(userEntity));
	}

	@Override
	public boolean updateContactData(User userToChange) {
		try{
			updateUserMapper.updateUserData(userToChange.getUserId(), userToChange.getPhoneNumber(), userToChange.getEmail());
		} catch	(Exception e){
			return false;
		}
		return true;
	}
}
