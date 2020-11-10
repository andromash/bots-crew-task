package com.bots.crew.repository;

import com.bots.crew.model.Department;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    Department findByName(String name);

    @Query("SELECT AVG(l.salary) FROM Lector l WHERE l.id IN (?1)")
    double getAverageSalary(List<Long> ids);

    @Query("SELECT COUNT (l.id) FROM Lector l INNER JOIN Department d WHERE d.name = ?1")
    int getNumberOfEmployees(String name);
}
