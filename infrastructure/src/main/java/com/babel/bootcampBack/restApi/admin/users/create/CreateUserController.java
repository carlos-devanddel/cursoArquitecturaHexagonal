package com.babel.bootcampBack.restApi.admin.users.create;

import com.babel.bootcampBack.port.in.users.create.CreateUserUseCase;
import com.babel.bootcampBack.restApi.admin.users.create.models.CreateUserRequest;
import com.babel.bootcampBack.restApi.admin.users.create.models.CreateUserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
@RequestMapping("api/users/")
@RequiredArgsConstructor
public class CreateUserController {
	private final CreateUserUseCase useCase;

	@PostMapping(path="/create")
	CreateUserResponse createUser(@RequestBody CreateUserRequest request){
		var output = useCase.createUser(request.toApplicationModel());
		return CreateUserResponse.fromApplicationModel(output);

	}
}
