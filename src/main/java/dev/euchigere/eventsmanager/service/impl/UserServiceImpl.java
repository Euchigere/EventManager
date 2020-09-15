package dev.euchigere.eventsmanager.service.impl;

import dev.euchigere.eventsmanager.dto.ServiceResponse;
import dev.euchigere.eventsmanager.dto.UserDTO;
import dev.euchigere.eventsmanager.models.Department;
import dev.euchigere.eventsmanager.models.User;
import dev.euchigere.eventsmanager.repository.DepartmentRepo;
import dev.euchigere.eventsmanager.repository.UserRepo;
import dev.euchigere.eventsmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepo userRepo;
    @Autowired
    DepartmentRepo deptRepo;

    public ServiceResponse<UserDTO> authenticateUser(String email, String password) {
        User user = userRepo.findUserByEmailAndPassword(email, password).orElse(null);
        ServiceResponse<UserDTO> response = new ServiceResponse<>();
        if (user == null) {
            response.setStatus(false);
            response.setMessage("Invalid Email and or Password");
            return response;
        }
        UserDTO userDTO = new UserDTO();
        userDTO.setDepartment(user.getDepartment());
        userDTO.setContact(user.getContact());
        userDTO.setDob(user.getDob());
        userDTO.setEmail(user.getEmail());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setGender(user.getGender());
        userDTO.setId(user.getId());
        userDTO.setRank(user.getRank());
        userDTO.setRole(user.getRole());

        response.setStatus(true);
        response.setData(userDTO);
        return response;
    }

    public ServiceResponse<User> validateUser(User user) {
        User u = userRepo.findUserByEmail(user.getEmail()).orElse(null);
        ServiceResponse<User> response = new ServiceResponse<>();
        if (u == null) {
            response.setStatus(false);
            response.setMessage("Invalid details, Unknown user");
            response.setData(user);
            return response;
        }
        u.setFirstName(user.getFirstName());
        u.setLastName(user.getLastName());
        u.setContact(user.getContact());
        u.setDob(user.getDob());
        u.setGender(user.getGender());
        u.setPassword(user.getPassword());

        response.setStatus(true);
        response.setMessage("Sign up successful!\nkindly login with email and password");

        userRepo.save(u);
        return response;
    }

    public void createUser(String email, Long departmentId, String role) {
        Department department = deptRepo.findDepartmentById(departmentId).orElse(null);
        if (department == null) {
            return;
        }
        User user = new User();
        user.setDepartment(department);
        user.setRole(role);
        user.setEmail(email);
        userRepo.save(user);
    }
}
