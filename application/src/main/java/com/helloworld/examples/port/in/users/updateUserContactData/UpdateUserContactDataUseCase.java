package com.helloworld.examples.port.in.users.updateUserContactData;

import com.helloworld.examples.exceptions.InsufficientPrivilegesException;
import com.helloworld.examples.port.in.users.updateUserContactData.models.UpdateUserContactDataInput;
import com.helloworld.examples.port.in.users.updateUserContactData.models.UpdateUserContactDataOutput;

public interface UpdateUserContactDataUseCase {

    UpdateUserContactDataOutput updateUserContactData(UpdateUserContactDataInput input) throws InsufficientPrivilegesException;
}
