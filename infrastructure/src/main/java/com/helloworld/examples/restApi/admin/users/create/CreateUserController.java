package com.helloworld.examples.restApi.admin.users.create;

import com.helloworld.examples.port.in.users.create.CreateUserUseCase;
import com.helloworld.examples.restApi.admin.users.create.models.CreateUserRequest;
import com.helloworld.examples.restApi.admin.users.create.models.CreateUserResponse;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("restapi/users")
@RestController
@Controller
@RequiredArgsConstructor
public class CreateUserController {

    private final CreateUserUseCase useCase;

    @PostConstruct
    void init() {
        System.out.println("CreateUserController has been created");
    }

    @PostMapping(path = "/create")
    CreateUserResponse createUser(@RequestBody CreateUserRequest request) throws Exception {
        var output = useCase.createUser(request.toApplicationModel());
        return CreateUserResponse.fromApplicationModel(output);
    }
}
