package com.helloworld.examples.restApi.admin.users.delete;

import com.helloworld.examples.port.in.users.delete.DeleteUserUseCase;
import com.helloworld.examples.restApi.admin.users.delete.models.DeleteUserRequest;
import com.helloworld.examples.restApi.admin.users.delete.models.DeleteUserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("restapi/users/")
@RestController
@RequiredArgsConstructor
public class DeleteUserController {
    private final DeleteUserUseCase useCase;

    @PostMapping(path = "/delete")
    DeleteUserResponse deleteUser(@RequestBody DeleteUserRequest request) throws Exception {
        var output = useCase.deleteUser(request.toApplicationModel());
        return DeleteUserResponse.fromApplicationModel(output);
    }
}
