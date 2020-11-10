package com.bots.crew.service.impl;

import com.bots.crew.model.Department;
import com.bots.crew.model.Head;
import com.bots.crew.repository.DepartmentRepository;
import com.bots.crew.service.DepartmentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
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
    public List<Department> provideGlobalSearch(String part) {
        return departmentRepository.findDepartmentByNameContains(part);
    }
}
