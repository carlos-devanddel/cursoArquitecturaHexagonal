package com.helloworld.examples.frontapi.admin.users.create;

import com.helloworld.examples.UsersFrontAPI;
import com.helloworld.examples.frontapi.admin.users.create.models.CreateUserRequest;
import com.helloworld.examples.frontapi.admin.users.create.models.CreateUserResponse;
import com.helloworld.examples.port.in.users.create.CreateUserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RequiredArgsConstructor
@UsersFrontAPI
public class CreateUserPresenter {
	private final CreateUserUseCase useCase;
	@PostMapping(path="/create")
	CreateUserResponse createUser(@RequestBody CreateUserRequest request) throws Exception{
		var output = useCase.createUser(request.toApplicationModel());
		return CreateUserResponse.fromApplicationModel(output);
	}
}
