package com.bots.crew.service;

import com.bots.crew.model.Degree;
import com.bots.crew.model.Department;
import com.bots.crew.model.Head;
import com.bots.crew.model.Lector;
import java.math.BigInteger;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InjectDataService {
    private final DegreeService degreeService;
    private final DepartmentService departmentService;
    private final HeadService headService;
    private final LectorService lectorService;

    @Autowired
    public InjectDataService(DegreeService degreeService, DepartmentService departmentService,
                             HeadService headService, LectorService lectorService) {
        this.degreeService = degreeService;
        this.departmentService = departmentService;
        this.headService = headService;
        this.lectorService = lectorService;
    }

    @PostConstruct
    public void addData() {
        Degree assistant = degreeService.add(new Degree("assistant"));
        Degree associateProfessor = degreeService.add(new Degree("associate professor"));
        Degree professor = degreeService.add(new Degree("professor"));

        Lector johnDoe = lectorService.add(new Lector("John", "Doe", assistant,
                BigInteger.valueOf(10000)));
        Lector janeDoe = lectorService.add(new Lector("Jane", "Doe", associateProfessor,
                BigInteger.valueOf(15000)));
        Lector markSmith = lectorService.add(new Lector("Mark", "Smith", professor,
                BigInteger.valueOf(30000)));

        Head head = new Head();
        head.setName("Bob");
        head.setSurname("Robyn");
        head.setDegree(professor);
        head.setSalary(BigInteger.valueOf(40000));
        headService.add(head);

        Department department = new Department();
        department.setHead(head);
        department.setLectors(List.of(johnDoe, janeDoe, markSmith));
        department.setName("IT");
        departmentService.add(department);
    }
}
