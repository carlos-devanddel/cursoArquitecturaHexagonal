package com.helloworld.examples.port.out.users.update_contact_data;

import com.helloworld.examples.models.User;

public interface UpdateContactDataRepository {

    User getUserById(Long id);

    boolean updateUser(User user);
}
