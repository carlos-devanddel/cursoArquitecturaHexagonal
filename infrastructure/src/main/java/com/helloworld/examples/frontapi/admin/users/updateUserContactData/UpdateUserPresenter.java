package com.helloworld.examples.frontapi.admin.users.updateUserContactData;

import com.helloworld.examples.frontapi.admin.users.updateUserContactData.models.UpdateUserRequest;
import com.helloworld.examples.frontapi.admin.users.updateUserContactData.models.UpdateUserResponse;
import com.helloworld.examples.port.in.users.updateUserContactData.UpdateUserContactDataUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("frontapi/users/")
@RestController
@RequiredArgsConstructor
public class UpdateUserPresenter {
    private final UpdateUserContactDataUseCase useCase;

    @PostMapping(path = "/updateContactData")
    UpdateUserResponse updateContactData(@RequestBody UpdateUserRequest request) throws Exception {
        var output = useCase.updateUserContactData(request.toApplicationModel());
        return UpdateUserResponse.fromApplicationModel(output);
    }
}
