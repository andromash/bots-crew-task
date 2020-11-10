package com.bots.crew.service.impl;

import com.bots.crew.model.Department;
import com.bots.crew.model.Head;
import com.bots.crew.model.Lector;
import com.bots.crew.repository.DepartmentRepository;
import com.bots.crew.service.DepartmentService;
import java.util.List;
import java.util.stream.Collectors;
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
        List<Long> ids = departmentRepository.findByName(name).getLectors().stream()
                .map(Lector::getId)
                .collect(Collectors.toList());
        return departmentRepository.getAverageSalary(ids);
    }

    @Override
    public Head getHeadOfDepartment(String name) {
        return departmentRepository.findByName(name).getHead();
    }

    @Override
    public int numberOfEmployees(String name) {
        return departmentRepository.getNumberOfEmployees(name);
    }
}
