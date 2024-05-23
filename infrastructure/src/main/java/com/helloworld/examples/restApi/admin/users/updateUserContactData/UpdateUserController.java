package com.helloworld.examples.restApi.admin.users.updateUserContactData;

import com.helloworld.examples.port.in.users.updateUserContactData.UpdateUserContactDataUseCase;
import com.helloworld.examples.restApi.admin.users.updateUserContactData.models.UpdateUserRequest;
import com.helloworld.examples.restApi.admin.users.updateUserContactData.models.UpdateUserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("restapi/users/")
@RestController
@RequiredArgsConstructor
public class UpdateUserController {
    private final UpdateUserContactDataUseCase useCase;

    @PostMapping(path = "/updateContactData")
    UpdateUserResponse updateContactData(@RequestBody UpdateUserRequest request) throws Exception {
        var output = useCase.updateUserContactData(request.toApplicationModel());
        return UpdateUserResponse.fromApplicationModel(output);
    }
}
