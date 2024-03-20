package com.helloworld.examples.frontapi.admin.users.delete;

import com.helloworld.examples.frontapi.admin.users.delete.models.DeleteUserRequest;
import com.helloworld.examples.frontapi.admin.users.delete.models.DeleteUserResponse;
import com.helloworld.examples.port.in.users.delete.DeleteUserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("frontapi/users/")
@RestController
@RequiredArgsConstructor
public class DeleteUserPresenter {
    private final DeleteUserUseCase useCase;

    @PostMapping(path = "/delete")
    DeleteUserResponse createUser(@RequestBody DeleteUserRequest request) throws Exception {
        var output = useCase.deleteUser(request.toApplicationModel());
        return DeleteUserResponse.fromApplicationModel(output);
    }
}
