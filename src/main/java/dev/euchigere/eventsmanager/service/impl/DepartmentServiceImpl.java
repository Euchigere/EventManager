package dev.euchigere.eventsmanager.service.impl;

import dev.euchigere.eventsmanager.dto.DepartmentDTO;
import dev.euchigere.eventsmanager.dto.ServiceResponse;
import dev.euchigere.eventsmanager.models.Department;
import dev.euchigere.eventsmanager.repository.DepartmentRepo;
import dev.euchigere.eventsmanager.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    DepartmentRepo deptRepo;

    public ServiceResponse<DepartmentDTO> getCurrentUserDepartment(Long departmentId) {
        Department department = deptRepo.findDepartmentById(departmentId).orElse(null);
        ServiceResponse<DepartmentDTO> response = new ServiceResponse<>();

        if (department == null) {
           response.setStatus(false);
           response.setMessage("No such department with id in data base");
           return response;
        }

        DepartmentDTO departmentDTO = new DepartmentDTO();
        departmentDTO.setId(department.getId());
        departmentDTO.setEvents(department.getEvents());
        departmentDTO.setName(department.getName());

        response.setData(departmentDTO);
        response.setStatus(true);
        return response;
    }

    public ServiceResponse<List<DepartmentDTO>> getAllDepartments() {
        List<Department> departments = new ArrayList<>();
        departments.addAll(deptRepo.findAll());
        List<DepartmentDTO> departmentDTOs = new ArrayList<>();

        for (Department dept : departments) {
            DepartmentDTO deptDTO = new DepartmentDTO();
            deptDTO.setId(dept.getId());
            deptDTO.setName(dept.getName());
            departmentDTOs.add(deptDTO);
        }
        ServiceResponse<List<DepartmentDTO>> response = new ServiceResponse<>();
        response.setStatus(true);
        response.setData(departmentDTOs);

        return response;
    }

    public void createDepartment(String deptName) {
        List<Department> departments = deptRepo.findDepartmentByNameLike(deptName);
        if (!departments.isEmpty()) {
            return;
        }
        Department department = new Department();
        department.setName(deptName);
        deptRepo.save(department);
    }
}
