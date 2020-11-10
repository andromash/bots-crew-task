package com.bots.crew.service.impl;

import com.bots.crew.model.Degree;
import com.bots.crew.model.Department;
import com.bots.crew.model.Head;
import com.bots.crew.repository.DepartmentRepository;
import com.bots.crew.service.DegreeService;
import com.bots.crew.service.DepartmentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final DegreeService degreeService;

    @Autowired
    public DepartmentServiceImpl(DepartmentRepository departmentRepository,
                                 DegreeService degreeService) {
        this.departmentRepository = departmentRepository;
        this.degreeService = degreeService;
    }

    @Override
    public Department add(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public Department findByName(String name) {
        return departmentRepository.findByName(name);
    }

    @Override
    public double getAverageSalary(String name) {
        return departmentRepository.getAverageSalary(name);
    }

    @Override
    public Head getHeadOfDepartment(String name) {
        return departmentRepository.findByName(name).getHead();
    }

    @Override
    public int getNumberOfEmployees(String name) {
        return departmentRepository.getNumberOfEmployees(name);
    }

    @Override
    public String showStatistics(String name) {
        List<Degree> degrees = degreeService.getAll();
        StringBuilder result = new StringBuilder();
        for (Degree degree : degrees) {
            result.append(degree.getName())
                    .append(" - ")
                    .append(departmentRepository.getNumberOfDegree(name, degree))
                    .append("\n");
        }
        return result.toString();
    }

    @Override
    public List<Department> provideGlobalSearch(String part) {
        return departmentRepository.findDepartmentByNameContains(part);
    }
}
