package com.bots.crew.repository;

import com.bots.crew.model.Department;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    Department findByName(String name);

    @Query("SELECT AVG(l.salary) FROM Lector l WHERE ?1 IN (SELECT d.name FROM Department d)")
    double getAverageSalary(String name);

    @Query("SELECT COUNT (l.id) FROM Lector l WHERE ?1 IN (SELECT d.name FROM Department d)")
    int getNumberOfEmployees(String name);

    List<Department> findDepartmentByNameContains(String part2);
}
