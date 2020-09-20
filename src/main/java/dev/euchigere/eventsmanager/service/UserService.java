package dev.euchigere.eventsmanager.service;

import dev.euchigere.eventsmanager.dto.ServiceResponse;
import dev.euchigere.eventsmanager.dto.UserDTO;
import dev.euchigere.eventsmanager.models.User;

public interface UserService {
    ServiceResponse<UserDTO> authenticateUser(String email, String password);

    ServiceResponse<User> validateUser(User user);

    void createUser(String email, Long departmentId, String role);
}
