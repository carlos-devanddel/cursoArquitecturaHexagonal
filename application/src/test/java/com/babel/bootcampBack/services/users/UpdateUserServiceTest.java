package com.babel.bootcampBack.services.users;

import com.babel.bootcampBack.enums.Role;
import com.babel.bootcampBack.exceptions.InsufficientPrivilegesException;
import com.babel.bootcampBack.exceptions.UserNotFoundException;
import com.babel.bootcampBack.models.User;
import com.babel.bootcampBack.port.in.users.update.models.UpdateUserInput;
import com.babel.bootcampBack.port.out.users.update.UpdateUserRepository;
import com.babel.bootcampBack.services.users.update.UpdateUserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;

class UpdateUserServiceTest {

	UpdateUserService sut;
	private UpdateUserRepository updateRepoMock;

	@BeforeEach
	void setUp() {
		updateRepoMock = Mockito.mock(UpdateUserRepository.class);
		sut = new UpdateUserService(updateRepoMock);
	}

	@Test
	void updateUserContactData_shouldThrow_UserNotFoundException_when_userToChangeDoesntExists() {
		UpdateUserInput input = UpdateUserInput.builder().uidUserRequestor("requestor").uidUserToChange("carlos").newPhone("66633366").build();
		Mockito.when(updateRepoMock.getUserById("carlos")).thenReturn(Optional.empty());

		Assertions.assertThrows(UserNotFoundException.class, () -> sut.updateUserContactData(input));
	}

	@Test
	void updateUserContactData_shouldThrow_UserNotFoundException_when_userRequestorDoesntExists() {
		UpdateUserInput input = UpdateUserInput.builder().uidUserRequestor("requestor").uidUserToChange("notfounduser").newPhone("66633366").build();
		Mockito.when(updateRepoMock.getUserById("requestor")).thenReturn(Optional.empty());

		Assertions.assertThrows(UserNotFoundException.class, () -> sut.updateUserContactData(input));
	}

	@Test
	void updateUserContactData_shouldThrow_InsfficentPrivileges_whenUserNormalTryToChangeOtherUser() {
		UpdateUserInput input = UpdateUserInput.builder().uidUserRequestor("requestor").uidUserToChange("differentUser").newPhone("66633366").build();
		Mockito.when(updateRepoMock.getUserById("requestor")).thenReturn(Optional.of(User.builder().role(Role.NORMAL).build()));

		Assertions.assertThrows(InsufficientPrivilegesException.class, () -> sut.updateUserContactData(input));
	}

	@Test
	void updateUserContactData_shouldChangeUserData_when_possible() {
		UpdateUserInput input = UpdateUserInput.builder().uidUserRequestor("requestor").uidUserToChange("Javier").newPhone("66633366").build();

		sut.updateUserContactData(input);


		Mockito.verify(updateRepoMock, times(1)).updateContactData(any());

	}
}