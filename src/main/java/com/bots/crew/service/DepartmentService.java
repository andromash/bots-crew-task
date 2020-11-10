package com.bots.crew.service;

import com.bots.crew.model.Department;
import com.bots.crew.model.Head;
import java.util.List;

public interface DepartmentService {

    Department add(Department department);

    Department findByName(String name);

    double getAverageSalary(String name);

    Head getHeadOfDepartment(String name);

    int getNumberOfEmployees(String name);

    List<Department> provideGlobalSearch(String part);
}
