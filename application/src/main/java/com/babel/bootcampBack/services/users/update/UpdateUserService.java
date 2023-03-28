package com.babel.bootcampBack.services.users.update;

import com.babel.bootcampBack.enums.Role;
import com.babel.bootcampBack.exceptions.InsufficientPrivilegesException;
import com.babel.bootcampBack.exceptions.UserNotFoundException;
import com.babel.bootcampBack.models.User;
import com.babel.bootcampBack.port.in.users.update.UpdateUserUseCase;
import com.babel.bootcampBack.port.in.users.update.models.UpdateUserInput;
import com.babel.bootcampBack.port.in.users.update.models.UpdateUserOutput;
import com.babel.bootcampBack.port.out.users.update.UpdateUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UpdateUserService implements UpdateUserUseCase {

	private final UpdateUserRepository updateUserRepository;

	@Override
	public UpdateUserOutput updateUserContactData(UpdateUserInput input) {
		User changerUser = updateUserRepository.getUserById(input.getUidUserRequestor()).orElseThrow(UserNotFoundException::new);
		User userToChange = updateUserRepository.getUserById(input.getUidUserToChange()).orElseThrow(UserNotFoundException::new);
		if(Role.NORMAL.equals(changerUser.getRole())){
			if(!input.getUidUserRequestor().equals(input.getUidUserToChange())) {
				throw new InsufficientPrivilegesException();
			}
		}
		if(input.getNewPhone() != null){
			userToChange.setPhoneNumber(input.getNewPhone());
		}
		if(input.getNewEmail() != null){
			userToChange.setEmail(input.getNewEmail());
		}
		boolean result = updateUserRepository.updateContactData(userToChange);
		return  UpdateUserOutput.builder().result(result).build();
	}
}
