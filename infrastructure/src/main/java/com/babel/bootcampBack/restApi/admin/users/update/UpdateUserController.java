package com.babel.bootcampBack.restApi.admin.users.update;

import com.babel.bootcampBack.port.in.users.update.UpdateUserUseCase;
import com.babel.bootcampBack.port.in.users.update.models.UpdateUserOutput;
import com.babel.bootcampBack.restApi.admin.users.update.models.UpdateUserRequest;
import com.babel.bootcampBack.restApi.admin.users.update.models.UpdateUserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/users/")
@RequiredArgsConstructor
public class UpdateUserController {

	private final UpdateUserUseCase useCase;

	@PostMapping("/updateContactData")
	public UpdateUserResponse updateContactData(@RequestBody UpdateUserRequest request){
		UpdateUserOutput output = useCase.updateUserContactData(request.toApplicationModel());
		return UpdateUserResponse.fromApplicationModel(output);
	}


}
