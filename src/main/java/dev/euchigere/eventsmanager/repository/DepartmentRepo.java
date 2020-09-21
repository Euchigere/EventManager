package dev.euchigere.eventsmanager.repository;

import dev.euchigere.eventsmanager.models.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface DepartmentRepo extends JpaRepository<Department, Long> {
    Optional<Department> findDepartmentById(Long id);

    List<Department> findDepartmentByNameLike(String name);

    @Override
    List<Department> findAll();
}
