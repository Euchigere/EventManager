package dev.euchigere.eventsmanager.service;

import dev.euchigere.eventsmanager.dto.DepartmentDTO;
import dev.euchigere.eventsmanager.dto.ServiceResponse;

import java.util.List;

public interface DepartmentService {
    ServiceResponse<DepartmentDTO> getCurrentUserDepartment(Long departmentId);

    ServiceResponse<List<DepartmentDTO>> getAllDepartments();

    void createDepartment(String deptName);
}
